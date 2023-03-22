fun main(){
    val gradeMap = hashMapOf(
        "A+" to 4.5, "A0" to 4.0,
        "B+" to 3.5, "B0" to 3.0,
        "C+" to 2.5, "C0" to 2.0,
        "D+" to 1.5, "D0" to 1.0,
        "F" to 0.0, "P" to 0.0
    )
    var sumOfCredit = 0.0
    var sumOfGrade  = 0.0
    repeat(20){
        var (name, credit, grade) = readln().split(" ")
        if(grade == "P") credit = "${0.0}"

        sumOfCredit += credit.toDouble()
        sumOfGrade  += (gradeMap[grade] ?: 0.0) * credit.toDouble()
    }

    println(sumOfGrade / sumOfCredit)
}