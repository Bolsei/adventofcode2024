package day1.part1

import java.io.File
import kotlin.math.abs

var firstList = arrayListOf<Int>()
var secondList = arrayListOf<Int>()

fun main() {
    readFileAsLinesUsingUseLines("numberlists.txt")
    var sumDistance = 0
    for (i in firstList.indices) {
        println(i)
        val distance = firstList[i] - secondList[i]
        var absDistance = abs(distance)
        sumDistance += absDistance
    }
    println("Sum $sumDistance")
}

fun readFileAsLinesUsingUseLines(fileName: String): Unit

        = File(fileName).useLines { it1 ->
            it1.forEach { line ->
                val split = line.split("   ")
                firstList.add(split[0].toInt())
                secondList.add(split[1].toInt())
                firstList.sort()
                secondList.sort()
            }
}