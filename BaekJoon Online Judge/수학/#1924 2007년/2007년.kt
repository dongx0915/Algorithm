import java.util.*

val day31 = arrayListOf<Int>(1,3,5,7,8,10,12)

fun getDayInMonth(mon:Int): Int{
    if(mon == 2) return 28
    return if(day31.contains(mon)) 31 else 30
}

fun main() = with(Scanner(System.`in`)){
    val days = arrayOf( "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT")

    val mon = nextInt()
    var day = nextInt()

    for (i in 1 until mon) day += getDayInMonth(i)
    println(days[day % 7])
}