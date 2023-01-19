import kotlin.math.pow

fun main() {
    listOf('1','2','3','4','5','6','7','8','9','A','B','C','D','E','F').let { list ->
        var num = 0
        readln().apply {
            forEachIndexed { idx, it ->
                val pow = 16.0.pow((this.length - idx - 1).toDouble()).toInt()
                num += pow * (list.indexOf(it)+1)
            }
        }
        println(num)
    }
}