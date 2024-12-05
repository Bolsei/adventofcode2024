package day2.part1


import java.io.File

val boolList = ArrayList<Boolean>()


fun main() {
    readFileAsLinesUsingUseLines("/ReportsDay2.txt")
    val count = boolList.count { it }
    println(count)
}

fun readFileAsLinesUsingUseLines(fileName: String): Unit
        = File(fileName).useLines { it1 ->
    it1.forEach { line ->
        println(line)
        val split = line.split(" ")
        val toIntArray = split.map { it.toInt() }.toIntArray()
        val ergList = ArrayList<Int>()

        for (i in toIntArray.indices) {
            if (i == toIntArray.lastIndex) {
                continue
            } else {

                val i1 = toIntArray[i]
                val i2 = toIntArray[i + 1]
                ergList.add(i1 -i2)


            }
        }
        boolList.add(ergList.all { it in 1..3 })
        boolList.add(ergList.all { it in -1 downTo -3 })

    }
}