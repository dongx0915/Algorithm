import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val peopleCnt = this.readLine().toInt()
    val point = mutableMapOf<Int, Int>()
    val cardMeasures = MutableList<MutableList<Int>>(peopleCnt) { mutableListOf() }
    val cards = this.readLine().split(" ").map {
        point[it.toInt()] = 0
        it.toInt()
    }

    /**
     * 루트 N까지만 나누어지는지 확인해보면 됨
     * 만약 j가 약수인 경우 N / j도 약수가 됨
     */
    repeat(peopleCnt) {
        val myCard = cards[it]
        for (j in 1 .. myCard) {
            if (j * j > myCard) break
            if (myCard % j == 0) { // 내 카드의 약수를 리스트로 관리
                cardMeasures[it].add(j)
            }
            if (j * j != myCard && myCard % j == 0) cardMeasures[it].add(myCard / j)
        }
    }

    // 현재 카드의 약수가 카드 리스트에 들어있는지 확인
    cards.forEachIndexed { idx, card ->
        cardMeasures[idx].forEach { measure ->
            // 현재 카드의 약수가 카드 리스트에 있는지 확인
            if (point[measure] != null) {
                point[card] = point[card]?.minus(1) ?: -1
                point[measure] = point[measure]?.plus(1) ?: 1
            }
        }
    }

    println(point.values.toString().replace(",", "").removeSurrounding("[", "]"))
}