import java.io.BufferedReader
import java.io.InputStreamReader

val vowel = hashSetOf<Char>('a', 'e', 'i', 'o', 'u')

fun getVowelCnt(str:String): Int{
    var cnt = 0
    str.forEach { if(vowel.contains(it.lowercaseChar())) cnt++ }
    return cnt
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    while(true){
        val str = readLine()
        if(str == "#") break
        println(getVowelCnt(str))
    }
}