package main.kotlin.Baekjoon.Gold.BOJ2636

import java.util.*

class Cheeze(var x_:Int, var y_: Int)

var col = 0
var row = 0
var dx = intArrayOf(-1, 0, 1, 0)
var dy = intArrayOf( 0,-1, 0, 1)

lateinit var map: Array<Array<Int>>
lateinit var cheezeQ:Queue<Cheeze>
lateinit var meltQ:Queue<Cheeze>

fun isInRange(x:Int, y:Int):Boolean = !(col <= x || x < 0 || row <= y || y < 0)

fun initArea(x:Int, y:Int):Unit {
    if(!isInRange(x, y) || map[x][y] != 0) return
    map[x][y] = -1

    for (i in 0 until 4) initArea(x + dx[i], y + dy[i])
}

fun isMelt(cur:Cheeze):Boolean{
    for (i in 0 until 4){
        var nextX = cur.x_ + dx[i]
        var nextY = cur.y_ + dy[i]

        if(!isInRange(nextX, nextY)) continue
        if(map[nextX][nextY] == -1){
            meltQ.offer(cur)
            return true
        }
    }
    return false
}

fun bfs(restCheeze:Int):Int {
    var restCheeze = restCheeze
    var size = cheezeQ.size

    while(size-- != 0){
        var cur:Cheeze = cheezeQ.poll()

        if(!isMelt(cur)) cheezeQ.offer(cur)
    }

    while(!meltQ.isEmpty()){
        var melt:Cheeze = meltQ.poll()
        map[melt.x_][melt.y_] = 0
        initArea(melt.x_, melt.y_)

        restCheeze--
    }

    return restCheeze
}

fun main(){
    var sc:Scanner = Scanner(System.`in`)

    col = sc.nextInt()
    row = sc.nextInt()

    map = Array(col){ Array(row){0} }
    cheezeQ = LinkedList()
    meltQ = LinkedList()

    var cheezeCnt = 0
    for(i in 0 until col){
        for (j in 0 until  row){
            map[i][j] = sc.nextInt()

            if(map[i][j] == 1){
                cheezeCnt++
                cheezeQ.offer(Cheeze(i,j))
            }
        }
    }

    initArea(0,0)

    var time = 0
    var prevCheeze = 0

    while(!cheezeQ.isEmpty()){
        prevCheeze = cheezeCnt
        cheezeCnt = bfs(cheezeCnt)
        time++
    }

    println(time)
    println(prevCheeze)
}
