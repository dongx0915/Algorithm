import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

class Point(val x_:Int, val y_:Int){
    fun isOutRange() = (x_ < 0 || x_ >= 3 || y_ < 0 || y_ >= 3)
    fun getIndex() = x_ * 3 + y_
}

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf( 0,-1, 0, 1)
val hash = hashSetOf<String>()
const val FINAL_STATE = "123456780"

fun bfs(map: Array<Array<Int>>, zero:Point): Int{
    val stateQ  = LinkedList<StringBuilder>().apply { add(StringBuilder(map.toArrayString())) }
    val zeroQ   = LinkedList<Point>().apply { add(zero) }
    val cntQ    = LinkedList<Int>().apply { add(0) }

    hash.add(map.toArrayString()) // 초기값 저장

    while(!zeroQ.isEmpty()){
        val curState = stateQ.poll()
        val cur = zeroQ.poll()
        val cnt = cntQ.poll()

        if(curState.toString() == FINAL_STATE) return cnt

        for (i in 0 until 4){
            val next = Point(cur.x_ + dx[i], cur.y_ + dy[i])
            if(next.isOutRange()) continue

            val nextState = StringBuilder(curState)
            nextState[cur.getIndex()] = nextState[next.getIndex()]
            nextState[next.getIndex()] = '0'

            if(hash.contains(nextState.toString())) continue

            hash.add(nextState.toString())
            stateQ.add(nextState)
            zeroQ.add(next)
            cntQ.add(cnt + 1)
        }
    }

    return -1
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val map = Array(3){Array(3){0}}
    lateinit var zero:Point

    repeat(3){ i->
        val st = StringTokenizer(readLine())
        repeat(3){ j->
            map[i][j] = st.nextToken().toInt()
            if(map[i][j] == 0) zero = Point(i,j)
        }
    }

    println(bfs(map, zero))
}

fun Array<Array<Int>>.toArrayString(): String{
    return StringJoiner("").apply { this@toArrayString.forEach { it.forEach { e -> add("$e")} } }.toString()
}