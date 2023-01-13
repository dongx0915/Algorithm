import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

data class Bead(val color:Char, val x_:Int, val y_:Int){
    fun isDropped() = x_ == -1
    fun renewPosit(): Bead{
        map[x_][y_] = color
        return this
    }
    fun erasePosit(){ if(x_ != -1 && y_ != -1) map[x_][y_] = '.' }
}
enum class Direction{ LEFT, RIGHT, UP, DOWN }

var n = 0; var m = 0
val map = arrayListOf<StringBuilder>()
val redQ = LinkedList<Bead>()
val blueQ = LinkedList<Bead>()
val direction = arrayOf(Direction.LEFT, Direction.RIGHT, Direction.UP, Direction.DOWN)

fun moveLeft(bead:Bead): Bead {
    for (i in bead.y_-1 downTo 0){
        val next = map[bead.x_][i]
        if(next == 'O') return bead.copy(x_ = -1, y_ = -1)
        if(next == '#' || next == 'R' || next == 'B') return bead.copy(x_ = bead.x_, y_ = i+1).renewPosit()
    }
    return bead.copy(x_ = -1, y_ = -1)
}

fun moveRight(bead:Bead):Bead{
    for(i in bead.y_+1 until m){
        val next = map[bead.x_][i]
        if(next == 'O') return bead.copy(x_ = -1, y_ = -1)
        if(next == '#' || next == 'R' || next == 'B') return bead.copy(x_ = bead.x_, y_= i-1).renewPosit()
    }
    return bead.copy(x_ = -1, y_ = -1)
}

fun moveUp(bead:Bead):Bead{
    for(i in bead.x_-1 downTo 0){
        val next = map[i][bead.y_]
        if(next == 'O') return bead.copy(x_ = -1, y_ = -1)
        if(next == '#' || next == 'R' || next == 'B') return bead.copy(x_ = i+1, y_ = bead.y_).renewPosit()
    }
    return bead.copy(x_ = -1, y_ = -1)
}

fun moveDown(bead:Bead): Bead{
    for(i in bead.x_+1 until n){
        val next = map[i][bead.y_]
        if(next == 'O') return bead.copy(x_ = -1, y_ = -1)
        if(next == '#' || next == 'R' || next == 'B') return bead.copy(x_ = i-1, y_ = bead.y_).renewPosit()
    }
    return bead.copy(x_ = -1, y_ = -1)
}

/**
 * 빨간 구슬을 빼내야 함
 * 파란 구슬이 빠지면 실패, 동시에 빠져도 실패
 * 빨간 구슬과 파란 구슬은 같은 칸에 있을 수 없음
 */
fun bfs():Int {
    val cntQ = LinkedList<Int>().apply { add(0) }

    while(!redQ.isEmpty() && !blueQ.isEmpty()){
        val curRed = redQ.poll()
        val curBlue = blueQ.poll()
        val cnt = cntQ.poll()
        if(cnt >= 10) return 0

        curRed.erasePosit()
        curBlue.erasePosit()

        direction.forEach {
            val (first, second) = when(it){
                Direction.LEFT -> {
                    if(curRed.y_ < curBlue.y_) Pair(moveLeft(curRed), moveLeft(curBlue))
                    else Pair(moveLeft(curBlue), moveLeft(curRed))
                }
                Direction.RIGHT -> {
                    if(curRed.y_ > curBlue.y_) Pair(moveRight(curRed) ,moveRight(curBlue))
                    else Pair(moveRight(curBlue), moveRight(curRed))
                }
                Direction.UP -> {
                    if(curRed.x_ < curBlue.x_) Pair(moveUp(curRed), moveUp(curBlue))
                    else Pair(moveUp(curBlue), moveUp(curRed))
                }
                Direction.DOWN -> {
                    if(curRed.x_ > curBlue.x_) Pair(moveDown(curRed), moveDown(curBlue))
                    else Pair(moveDown(curBlue), moveDown(curRed))
                }
            }
            first.erasePosit()
            second.erasePosit()

            val (red, blue) = if(first.color == 'R') Pair(first, second) else Pair(second, first)

            // if(blue.isDropped() && red.isDropped()) return -1
            if(!blue.isDropped()){ // 파란 구슬이 떨어지지 않은 경우
                if(red.isDropped()) return 1
                else {
                    redQ.add(red)
                    blueQ.add(blue)
                    cntQ.add(cnt + 1)
                }
            }
        }
    }

    return 0
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val st = StringTokenizer(readLine())
    n = st.nextToken().toInt()
    m = st.nextToken().toInt()

    repeat(n){ n->
        val str = StringBuilder(readLine())
        str.forEachIndexed { idx, c ->
            if(c == 'R') {
                redQ.add(Bead('R', n, idx))
                str[idx] = '.'
            }
            else if(c == 'B') {
                blueQ.add(Bead('B',n, idx))
                str[idx] = '.'
            }
        }
        map.add(str)
    }

    println(bfs())
}