fun main(){
    val n = readln().toUInt()
    var sum: UInt = 0u
    var cnt = 0

    for (i in UIntRange(1u, n)){
        cnt++
        sum += i
        if(sum > n || (n - sum) <= i) break
    }

    println(cnt)
}