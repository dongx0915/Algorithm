import java.util.*
import kotlin.math.max

var n = 0
val result = Array(2){0}
val leftDiagonal    = Array(21){false}
val rightDiagonal   = Array(21){false}
lateinit var map: Array<Array<Int>>

fun solve(x:Int, y:Int, bishopCnt:Int, color:Int){
    var i = x; var j = y;
    if (j >= n){
        i++
        j = if(j % 2 == 0) 1 else 0 // 이전 j가 짝수 였으면 이제 홀수 차례
    }

    if(i >= n){
        result[color] = max(result[color], bishopCnt)
        return
    }

    /**
     * 안되는 경우를 먼저 체크하고 return하는 경우와 왜 다른건지
     */
    if(map[i][j] == 1 && !leftDiagonal[i+j] && !rightDiagonal[i-j+n]) {
        leftDiagonal[i+j]    = true
        rightDiagonal[i-j+n] = true

        solve(i,j+2, bishopCnt + 1, color)

        leftDiagonal[i+j]    = false
        rightDiagonal[i-j+n] = false
    }

    solve(i,j+2, bishopCnt, color)
}

fun main(){
    n = readln().toInt()
    map = Array(n){ Array(n){ 0 } }

    repeat(n){ i ->
        val st = StringTokenizer(readln())
        repeat(n){ j ->
            map[i][j] = st.nextToken().toInt()
        }
    }

    solve(0,0,0, 0) // 검은색
    solve(0,1,0, 1) // 흰색

    println(result[0] + result[1])
}