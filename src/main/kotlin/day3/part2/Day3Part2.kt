package day3.part2

class Day3Part2 {

    fun readFilesAsLinesUsingUseLines(fileName: String): String? =
        this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.readText()

    fun getStartAndEndOfSubstring(str: String, sub: String): Pair<Int, Int> {
        val start = str.indexOf(sub)
        return when (start != -1) {
            true -> Pair(start, start + sub.length -1)
            false -> Pair(-1, -1)
        }
    }
}

fun main() {
    val day3Part2 = Day3Part2()
    val text = day3Part2.readFilesAsLinesUsingUseLines("/Day3.txt")

    if (text != null) {
        var textNew = text.toString()
        do {
            val dont = day3Part2.getStartAndEndOfSubstring(textNew, "don't()")
            val doit = day3Part2.getStartAndEndOfSubstring(textNew, "do()")
            textNew = if (doit.first == -1 && doit.second == -1) {
                textNew.removeRange(dont.first, textNew.lastIndex)
            } else if (doit.first < dont.first) {
                textNew.removeRange(doit.first, doit.second + 1)
            } else {
                textNew.removeRange(dont.first, doit.second + 1)
            }
        }while(textNew.contains("don't()"))

        val reg = Regex("\\d+")
        val regex = Regex("mul\\(\\d+,\\d+\\)")
        var sumAll = 0
        textNew.let { regex.findAll(it) }.forEach {
            val findAll = reg.findAll(it.value)
            val firstNumber = findAll.first().value.toInt()
            val secondNumber = findAll.last().value.toInt()
            val erg = firstNumber * secondNumber
            sumAll += erg
        }
        println(sumAll)
    }

}