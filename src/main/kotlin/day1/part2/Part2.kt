package day1.part2

import java.io.File

var firstList = arrayListOf<Int>()
var secondList = arrayListOf<Int>()

fun main() {
    readFileAsLinesUsingUseLines("numberlists.txt")
    var sumDistance = 0
    for (item in firstList) {
        val count = secondList.count { it == item }
        val i = count * item
        sumDistance += i

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