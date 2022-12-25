package BOJ15657

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

lateinit var list: ArrayList<Int>
val sb = StringBuilder()

fun solve(n:Int, m:Int, s:String, prev:Int, select:Int){
    if(select == m){
        sb.append(s).append("\n")
        return
    }

    for (i in list){
        if(prev <= i)
            solve(n, m, "$s$i ", i,select + 1)
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readLine())
    list = arrayListOf<Int>().apply {
        while(st.hasMoreTokens())
            this.add(st.nextToken().toInt())
        sort()
    }

    solve(n,m,"", 0, 0)
    print(sb.toString())
}
