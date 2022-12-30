package main.kotlin.BOJ15663

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

val list = arrayListOf<Int>()
val hashSet = HashSet<String>()
lateinit var visit:Array<Boolean>
val sb = StringBuilder()

fun solve(n:Int, m:Int, s:String, select:Int){
    if(select == m){
        if(!hashSet.contains(s)){
            hashSet.add(s)
            sb.append(s).append("\n")
        }
        return
    }

    for (i in list.indices){
        if(!visit[i]){
            visit[i] = true
            solve(n, m, "$s${list[i]} ", select + 1)
            visit[i] = false
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    // 해시 셋으로 중복 판별
    var st = StringTokenizer(readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    visit = Array(n){false}

    st = StringTokenizer(readLine())

    repeat(n){ list.add(st.nextToken().toInt()) }
    list.sort()

    solve(n, m, "", 0)
    print(sb.toString())
}
