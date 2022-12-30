package main.kotlin.BOJ11659

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

val num = Array<Int>(100_001){0}
val sum = Array(100_001){0}
val sb = java.lang.StringBuilder()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    val n = st.nextInt()
    val m = st.nextInt()

    st = StringTokenizer(readLine())
    repeat(n){
        num[it+1] = st.nextInt()
        sum[it+1] = (sum[it] + num[it+1])
    }

    repeat(m){
        st = StringTokenizer(readLine()).apply {
            sb.append(-sum[nextInt()-1]+sum[nextInt()]).append("\n")
        }
    }

    print(sb.toString())
}

fun StringTokenizer.nextInt() = this.nextToken().toInt()
