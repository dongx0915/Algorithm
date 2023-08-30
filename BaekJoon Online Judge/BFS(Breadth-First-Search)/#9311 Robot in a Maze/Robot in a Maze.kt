private lateinit var map: ArrayList<StringBuilder>

private val dx = arrayListOf(-1, 0, 1, 0)
private val dy = arrayListOf( 0,-1, 0, 1)

fun Triple<Int, Int, Int>.isOutRagne(r:Int, c:Int) = first < 0 || first >= r || second < 0 || second >= c
fun ArrayList<StringBuilder>.get(next: Triple<Int, Int, Int>) = this[next.first][next.second]
fun ArrayList<StringBuilder>.set(next: Triple<Int, Int, Int>, ch:Char) = this[next.first].set(next.second, ch)

fun bfs(x:Int, y:Int, r:Int, c:Int): Int {
    val q: ArrayDeque<Triple<Int, Int, Int>> = ArrayDeque()
    q.addLast(Triple(x, y, 0))

    while(q.isNotEmpty()){
        val cur = q.removeFirst()

        for (i in 0 until 4){
            val next = Triple(cur.first + dx[i],cur.second + dy[i], cur.third + 1)

            if(next.isOutRagne(r, c)) continue
            if(map.get(next) == 'G') return next.third
            if(map.get(next) != '0' && map.get(next) != 'O') continue

            q.addLast(next)
            map.set(next, '-')
        }
    }

    return -1
}

fun solve(r:Int, c:Int){
    for (i in 0 until r){
        for (j in 0 until c){
            if(map[i][j] == 'S'){
                val path = bfs(i, j, r, c)
                println(
                    if(path != -1) "Shortest Path: $path"
                    else "No Exit"
                )
                return
            }
        }
    }
}

fun main(){
    val n = readln().toInt()

    repeat(n){
        val (r, c) = readln().split(" ").map { it.toInt() }
        map = arrayListOf()

        repeat(r){
            map.add(StringBuilder(readln()))
        }
        solve(r, c)
    }
}