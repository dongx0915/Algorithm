import kotlin.math.pow

val triple = Array<Int>(100+1){0}

fun solve(target:Int){
    for (i in 2..100){
        for(j in i+1..100){
            for(k in j+1..100){
                if(triple[i] + triple[j] + triple[k] == triple[target]){
                    println("Cube = ${target}, Triple = ($i,$j,$k)")
                }
            }
        }
    }
}

fun main(){
    for (i in 2..100){
        triple[i] = i.toDouble().pow(3.0).toInt()
    }

    for(i in 1..100){ solve(i) }
}