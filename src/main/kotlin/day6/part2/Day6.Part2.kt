package day6.part2

class Day6Part2 {

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

var firstRound = true

fun main() {
    val Day6Part2 = Day6Part2()

    var loops = 0;
    val map = Day6Part2.readFilesAsLinesUsingUseLines2("/Day6.txt")
    var isOut: String

    if (map != null) {
        for (y in 0..map.size - 1) {
            for (x in map[y]!!.indices) {
                if (map[y]!![x] == '.') {
                    map[y]!![x] = '0'
                }
                val newMap = map.map{ it!!.clone()}.toTypedArray()
//                    println("Run wiht $y and $x")
                do {
                    isOut = guardMove(newMap)
                } while (isOut == "RUN")
                if (map[y]!![x] == '0') {
                    map[y]!![x] = '.'
                }
                if (isOut == "LOOP") {
                    println("loop")
                    firstRound = true
                    loops++
                }
            }
        }
    }

    println("Loops: " + loops)
}

private fun guardMove(map1: Array<CharArray>): String {
    for (y in 0..map1.size - 1) {
        for (x in map1[y].indices) {
            val guard = map1[y][x]
            when (guard) {
                '^' -> return guardMoveUp(map1, y, x)
                '>' -> return guardMoveRight( map1, y, x)
                'v' -> return guardMoveDown(map1, y, x)
                '<' -> return guardMoveLeft(map1, y, x)
            }

        }
    }
    return "RUN"
}

private fun guardMoveUp(map1: Array<CharArray>, y: Int, x: Int): String {
    if (y == 0) {
        return "OUT"
    }
    if (map1[y - 1][x] == '0') {
        if (firstRound) {
            map1[y][x] = '>'
            firstRound = false
            return "RUN"
        } else {
            return "LOOP"
        }
    }
    if (!firstRound && map1[y - 1][x] == 'X' && map1[y - 2][x] == 'X') {
        return "LOOP"
    }
    if (map1[y - 1][x] == '.' || map1[y - 1][x] == 'X') {
        map1[y][x] = 'X'
        map1[y - 1][x] = '^'
    }
    if (map1[y - 1][x] == '#') {
        map1[y][x] = '>'
    }
    return "RUN"
}

private fun guardMoveRight(map1: Array<CharArray>, y: Int, x: Int): String {
    if (x == map1[y].size - 1) {
        return "OUT"
    }
    if (map1[y][x + 1] == '0') {
        if (firstRound) {
            map1[y][x] = 'v'
            firstRound = false
            return "RUN"
        } else {
            return "LOOP"
        }
    }
    if (!firstRound && map1[y][x + 1] == 'X' && map1[y][x + 2] == 'X') {
        return "LOOP"
    }
    if (map1[y][x + 1] == '.' || map1[y][x + 1] == 'X') {
        map1[y][x] = 'X'
        map1[y][x + 1] = '>'
    }
    if (map1[y][x + 1] == '#') {
        map1[y][x] = 'v'
    }
    return "RUN"
}

private fun guardMoveDown(map1: Array<CharArray>, y: Int, x: Int): String {
    if (y == map1.size - 1) {
        return "OUT"
    }
    if (map1[y + 1][x] == '0') {
        if (firstRound) {
            map1[y][x] = '<'
            firstRound = false
            return "RUN"
        } else {
            return "LOOP"
        }
    }
    if (!firstRound && map1[y + 1][x] == 'X' && map1[y + 2][x] == 'X') {
        return "LOOP"
    }
    if (map1[y + 1][x] == '.' || map1[y + 1][x] == 'X') {
        map1[y][x] = 'X'
        map1[y + 1][x] = 'v'
    }
    if (map1[y + 1][x] == '#') {
        map1[y][x] = '<'
    }
    return "RUN"
}

private fun guardMoveLeft(newMap: Array<CharArray>, y: Int, x: Int): String {
    if (x == 0) {
        return "OUT"
    }
    if (newMap[y][x - 1] == '0') {
        if (firstRound) {
            newMap[y][x] = '^'
            firstRound = false
            return "RUN"
        } else {
            return "LOOP"
        }
    }
    if (!firstRound && newMap[y][x - 1] == 'X' && newMap[y][x - 2] == 'X') {
        return "LOOP"
    }
    if (newMap[y][x - 1] == '.' || newMap[y][x - 1] == 'X') {
        newMap[y][x] = 'X'
        newMap[y][x - 1] = '<'
    }
    if (newMap[y][x - 1] == '#') {
        newMap[y][x] = '^'
    }
    return "RUN"
}