package test

import java.util.*
import kotlin.collections.ArrayList
import kotlin.text.StringBuilder

var visit:Array<Boolean>?=null
val sb:StringBuilder = StringBuilder()

fun permutation(n:Int, m:Int, start:Int, select:ArrayList<Int>){
    if(select.size == m){
        val sj = StringJoiner(" ")
        select.forEach { sj.add("$it")}
        sb.append(sj).append("\n")
        return
    }

    for (i in start..n){
        visit?.let { visit ->
            if(!visit[i]){ // i가 선택되지 않은 경우
                visit[i] = true
                select.add(i)

                permutation(n,m,i,select)

                visit[i] = false
                select.remove(i)
            }
        }
    }
}

fun main(){
    val sc = Scanner(System.`in`)

    val n:Int = sc.nextInt()
    val m:Int = sc.nextInt()

    visit = Array<Boolean>(n+1){ false }
    permutation(n, m, 1, arrayListOf())
    print(sb.toString())
}
