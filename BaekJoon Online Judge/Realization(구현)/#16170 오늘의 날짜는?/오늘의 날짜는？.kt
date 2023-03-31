import java.util.Calendar

fun main(){
    val cal = Calendar.getInstance()
    println(cal.get(Calendar.YEAR))
    println(String.format("%02d", cal.get(Calendar.MONTH)+1))
    println(String.format("%02d", cal.get(Calendar.DAY_OF_MONTH)))
}