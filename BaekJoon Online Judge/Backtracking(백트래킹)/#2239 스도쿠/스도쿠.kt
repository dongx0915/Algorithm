import kotlin.system.exitProcess

/**
 * 중복이 있는지 체크하는 메소드
 */
fun checkOverlap(map:Array<StringBuilder>, x:Int, y:Int):Boolean {
    for (i in 0 until 9){
        if(map[x][i] == map[x][y]) if(i != y) return false
        if(map[i][y] == map[x][y]) if(i != x) return false
    }

    val startX = getPosit(x)
    val startY = getPosit(y)

    for (i in startX until  startX + 3){
        for (j in startY until startY + 3){
            if(i == x && j == y) continue
            if(map[i][j] == map[x][y]) return false
        }
    }

    return true
}

fun getPosit(p:Int):Int {
    return when(p){
        in 0 until 3 -> 0
        in 3 until 6 -> 3
        in 6 until 9 -> 6
        else -> -1
    }
}

fun allCheck(map:Array<StringBuilder>):Boolean{
    for (i in 0 until 9){
        for (j in 0 until 9){
            if(!checkOverlap(map, i,j)) return false
        }
    }
    return true
}

fun solve(map:Array<StringBuilder>, zero:ArrayList<Pair<Int,Int>>, now:Int){
    if(zero.size == now){
        if(allCheck(map)){
            map.forEach {
                println(it)
            }
            exitProcess(0)
        }
        else return
    }

    val cur = zero[now]
    for (i in 1 .. 9){
        map[cur.first][cur.second] = (i+48).toChar()

        val overlap = checkOverlap(map, cur.first, cur.second)
        if(overlap){ // 중복이 안되었으면
            solve(map, zero, now+1)
        }
    }
    map[cur.first][cur.second] = '0'
}

fun main(){
    val map = Array(9){StringBuilder()}
    val zero = arrayListOf<Pair<Int,Int>>()

    repeat(9){
        map[it].append(readln())
        map[it].forEachIndexed{idx, c->
            if(c == '0') zero.add(Pair(it, idx))
        }
    }

    solve(map, zero, 0)
}