package BOJ16197

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

data class Coin(val x:Int, val y:Int)

lateinit var map:ArrayList<String>
val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf( 0,-1, 0, 1)

fun Queue<Coin>.addCoin(next:Coin, cur:Coin) = this.add(if(map[next.x][next.y] == '#') cur else next)
fun isDropped(n:Int, m:Int, p:Coin) = p.run { (x < 0 || y < 0 || x >= n || y >= m) }

/**
 * o : 동전
 * . : 빈 칸
 * # : 벽
 * 동전이 이동하려는 칸이 벽(#)이면, 동전은 이동하지 않는다.
 * 동전이 이동하려는 방향에 칸이 없으면 동전은 보드 바깥으로 떨어진다.
 * 그 외의 경우에는 이동하려는 방향으로 한 칸 이동한다.이동하려는 칸에 동전이 있는 경우에도 한 칸 이동한다.
 */
fun bfs(n:Int, m:Int, coin:ArrayList<Coin>):Int{
    val coin1q = LinkedList<Coin>()
    val coin2q = LinkedList<Coin>()
    val cntQ = LinkedList<Int>()

    coin1q.add(coin[0])
    coin2q.add(coin[1])
    cntQ.add(1)

    while(!coin1q.isEmpty() && !coin2q.isEmpty()){
        val coin1 = coin1q.poll()
        val coin2 = coin2q.poll()
        val cnt = cntQ.poll()

        if(cnt > 10) return -1

        for (i in 0 until 4){
            val next_coin1 = Coin(coin1.x + dx[i], coin1.y + dy[i])
            val next_coin2 = Coin(coin2.x + dx[i], coin2.y + dy[i])

            val coin1Dropped = isDropped(n,m, next_coin1) // 범위 밖이면 떨어진 것
            val coin2Dropped = isDropped(n,m, next_coin2)

            if(coin1Dropped xor coin2Dropped){ // 코인 하나만 떨어진 경우
                return cnt
            } else { // 둘 다 떨어졌거나, 둘 다 안떨어진 경우
                // 둘 다 안 떨어진 경우
                if(!coin1Dropped && !coin2Dropped){
                    coin1q.addCoin(next_coin1, coin1)
                    coin2q.addCoin(next_coin2, coin2)
                    cntQ.add(cnt + 1)
                }
                // 둘 다 떨어진 경우는 더 이상 진행 불가
            }
        }
    }

    return -1
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val coin:ArrayList<Coin> = arrayListOf()
    map = arrayListOf()

    repeat(n){
        st = StringTokenizer(readLine())
        map.add(st.nextToken())

        repeat(m) { m ->
            if (map.last()[m] == 'o') {
                coin.add(Coin(map.size-1, m))
            }
        }
    }

    println(bfs(n,m,coin))
}
