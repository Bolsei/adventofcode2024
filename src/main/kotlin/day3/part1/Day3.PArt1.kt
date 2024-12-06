package day3.part1

class Day3Part1 {

    fun readFilesAsLinesUsingUseLines(fileName: String): String? =
        this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.readText()
}

fun main() {
    val day3Part1 = Day3Part1()
    val text = day3Part1.readFilesAsLinesUsingUseLines("/Day3.txt")
    val reg = Regex("\\d+")
    val regex = Regex("mul\\(\\d+,\\d+\\)")
    var sumAll = 0
    text?.let { regex.findAll(it) }?.forEach {
        val findAll = reg.findAll(it.value)
        val firstNumber = findAll.first().value.toInt()
        val secondNumber = findAll.last().value.toInt()
        val erg = firstNumber * secondNumber
        sumAll += erg
    }
    println(sumAll)
}