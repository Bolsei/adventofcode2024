package day6.part1

class Day6Part1 {

    fun readFilesAsLinesUsingUseLines2(fileName: String): Array<CharArray?>? =
        this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.useLines { it1 ->
            val arrayNulls = arrayOfNulls<CharArray>(130)
            var counter = 0
            it1.forEach { line ->
                arrayNulls[counter] = line.toCharArray()
                counter++
            }
            return arrayNulls
        }
}

fun main() {
    val Day6Part1 = Day6Part1()

    var allX = 0;
    val map = Day6Part1.readFilesAsLinesUsingUseLines2("/Day6.txt")
    if (map != null) {
        var isOut: Boolean
        do {
            isOut = guardMove(map)
        } while (!isOut)

    }
    if (map != null) {
        for (element in map) {
            if (element != null) {
                val string = String(element)
                println(string)
            }
            allX += element?.count { it == 'X' }!!
        }
    }
    println("allX Counter: $allX")
}

private fun guardMove(map: Array<CharArray?>): Boolean {
    for (y in 0..map.size - 1) {
        for (x in map[y]!!.indices) {
            val guard = map[y]!![x]
            when (guard) {
                '^' -> return guardMoveUp(map, y, x)
                '>' -> return guardMoveRight(map, y, x)
                'v' -> return guardMoveDown(map, y, x)
                '<' -> return guardMoveLeft(map, y, x)
            }

        }
    }
    return true;
}

private fun guardMoveUp(map: Array<CharArray?>, y: Int, x: Int): Boolean {
    if (y == 0) {
        return true
    }
    if (map[y - 1]!![x] == '.' || map[y - 1]!![x] == 'X') {
        map[y]!![x] = 'X'
        map[y - 1]!![x] = '^'
    }
    if (map[y - 1]!![x] == '#') {
        map[y]!![x] = '>'
    }
    return false
}

private fun guardMoveRight(map: Array<CharArray?>, y: Int, x: Int): Boolean {
    if (x == map[y]!!.size - 1) {
        return true
    }
    if (map[y]!![x + 1] == '.' || map[y]!![x + 1] == 'X') {
        map[y]!![x] = 'X'
        map[y]!![x + 1] = '>'
    }
    if (map[y]!![x + 1] == '#') {
        map[y]!![x] = 'v'
    }
    return false
}

private fun guardMoveDown(map: Array<CharArray?>, y: Int, x: Int): Boolean {
    if (y == map.size - 1) {
        return true
    }
    if (map[y + 1]!![x] == '.' || map[y + 1]!![x] == 'X') {
        map[y]!![x] = 'X'
        map[y + 1]!![x] = 'v'
    }
    if (map[y + 1]!![x] == '#') {
        map[y]!![x] = '<'
    }
    return false
}

private fun guardMoveLeft(map: Array<CharArray?>, y: Int, x: Int): Boolean {
    if (x == 0) {
        return true
    }
    if (map[y]!![x - 1] == '.' || map[y]!![x - 1] == 'X') {
        map[y]!![x] = 'X'
        map[y]!![x - 1] = '<'
    }
    if (map[y]!![x - 1] == '#') {
        map[y]!![x] = '^'
    }
    return false
}