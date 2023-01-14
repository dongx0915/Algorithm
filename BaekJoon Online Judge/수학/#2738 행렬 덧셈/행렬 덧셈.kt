import java.util.*

fun main() = with(Scanner(System.`in`)){
    val n = nextInt()
    val m = nextInt()
    val matrixA = Array(n){ Array(m){0} }

    repeat(n){ n->
        repeat(m){ m->
            matrixA[n][m] = nextInt()
        }
    }

    repeat(n){ n->
        repeat(m){ m->
            print("${matrixA[n][m] + nextInt()} ")
        }
        println()
    }
}
