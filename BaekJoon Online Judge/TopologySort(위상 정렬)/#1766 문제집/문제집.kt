import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun topologySort(problems:Array<ArrayList<Int>>, di:Array<Int>): String{
    val q = PriorityQueue<Int>().apply {
        for (i in di.indices) if(di[i] == 0) add(i)
    }
    val sj = StringJoiner(" ")

    while(!q.isEmpty()){
        val cur = q.poll()
        sj.add("${cur+1}")

        for (next in problems[cur]){
            if(--di[next] == 0) q.add(next)
        }
    }

    return sj.toString()
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val problems = Array<ArrayList<Int>>(n){ arrayListOf() }
    val di = Array(n){0}

    repeat(m){
        st = StringTokenizer(readLine())
        val n1 = st.nextInt()-1
        val n2 = st.nextInt()-1

        problems[n1].add(n2)
        di[n2]++
    }

    println(topologySort(problems, di))
}

fun StringTokenizer.nextInt() = this.nextToken().toInt()