package day2.part2

class Day2Part2 {

    private val boolList = ArrayList<Boolean>()

    fun readFileAsLinesUsingUseLines(fileName: String): Unit? =
        this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.useLines { it1 ->
            it1.forEach { line ->
                val split = line.split(" ")
                val toIntArray = split.map { it.toInt() }.toCollection(ArrayList())
                val ergList = createErgs(toIntArray)
                val isSafe = ergList.all { it in 1..3 } || ergList.all {it in -1 downTo -3}
                if (!isSafe) {
                    for (i in toIntArray.indices) {
                        val toList = toIntArray.toCollection(ArrayList())
                        toList.removeAt(i)
                        val createErgs = createErgs(toList)
                        if (createErgs.all {it in 1 .. 3} || createErgs.all { it in -1 downTo -3}) {
                            boolList.add(true)
                            break;
                        }
                    }
                } else {
                    boolList.add(true)
                }
            }
        }

    private fun createErgs(toList: ArrayList<Int>): ArrayList<Int> {
        val ergList2 = ArrayList<Int>()
        for (i in toList.indices) {
            if (i == toList.lastIndex) {
                continue
            } else {

                val i1 = toList[i]
                val i2 = toList[i + 1]
                ergList2.add(i1 - i2)
            }
        }
        return ergList2
    }

    fun getBoolList(): ArrayList<Boolean> {
        return boolList;
    }

}

fun main() {
    val day2Part2 = Day2Part2()
    day2Part2.readFileAsLinesUsingUseLines("/ReportsDay2.txt")
    val count = day2Part2.getBoolList().count { it }
    println(count)
}