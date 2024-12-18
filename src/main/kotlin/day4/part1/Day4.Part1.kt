package day4.part1

class Day4Part1 {

    fun readFilesAsLinesUsingUseLines2(fileName: String): Array<CharArray?>? =
        this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.useLines {
            it1 ->
            val arrayNulls = arrayOfNulls<CharArray>(140)
            var counter = 0
            it1.forEach{ line ->
                arrayNulls[counter] = line.toCharArray()
                counter++
            }
            return arrayNulls
        }
}

fun main() {
    val day4Part1 = Day4Part1()

    var xmasCounter = 0;
    val lines2 = day4Part1.readFilesAsLinesUsingUseLines2("/Day4.txt")
    if (lines2 != null) {
        for (i in 0 .. 139) {
            val lineSize = lines2[i]!!.size -1
            for (j in 0 ..lineSize) {

                if ( lines2[i]!![j]  == 'X' ) {
                    if (j + 1 <= lineSize && i - 1 >= 0 && lines2[i - 1]!![j + 1] == 'M') {
                        if (j + 2 <= lineSize && i - 2 >= 0 && lines2[i - 2]!![j + 2] == 'A') {
                            if (j + 3 <= lineSize && i - 3 >= 0 && lines2[i - 3]!![j + 3] == 'S') {
                                xmasCounter++
                            }
                        }
                    }
                    if (j - 1 >= 0 && i + 1 <= 139 && lines2[i + 1]!![j - 1] == 'M') {
                        if (j - 2 >= 0 && i + 2 <= 139 && lines2[i + 2]!![j - 2] == 'A') {
                            if (j - 3 >= 0 && i + 3 <= 139 && lines2[i + 3]!![j - 3] == 'S') {
                                xmasCounter++
                            }
                        }
                    }
                    if (j - 1 >= 0 && i - 1 >= 0 && lines2[i - 1]!![j - 1] == 'M') {
                        if (j - 2 >= 0 && i - 2 >= 0 && lines2[i - 2]!![j - 2] == 'A') {
                            if (j - 3 >= 0 && i - 3 >= 0 && lines2[i - 3]!![j - 3] == 'S') {
                                xmasCounter++
                            }
                        }
                    }
                    if (j + 1 <= lineSize && i + 1 <= 139 && lines2[i + 1]!![j + 1] == 'M') {
                        if (j + 2 <= lineSize && i + 2 <= 139 && lines2[i + 2]!![j + 2] == 'A') {
                            if (j + 3 <= lineSize && i + 3 <= 139 && lines2[i + 3]!![j + 3] == 'S') {
                                xmasCounter++
                            }
                        }
                    }
                    if (j + 1 <= lineSize && lines2[i]!![j+1] == 'M') {
                        if (j + 2 <= lineSize && lines2[i]!![j+2] == 'A') {
                            if (j + 3 <= lineSize && lines2[i]!![j+3] == 'S') {
                                xmasCounter++
                            }
                        }
                    }
                    if (j - 1 >= 0 && lines2[i]!![j-1] == 'M') {
                        if (j - 2 >= 0 && lines2[i]!![j-2] == 'A') {
                            if (j - 3 >= 0 && lines2[i]!![j-3] == 'S') {
                                xmasCounter++
                            }
                        }
                    }
                    if (i + 1 <= 139 && lines2[i + 1]!![j] == 'M') {
                        if (i + 2 <= 139 && lines2[i + 2]!![j] == 'A') {
                            if (i + 3 <= 139 && lines2[i + 3]!![j] == 'S') {
                                xmasCounter++
                            }
                        }
                    }
                    if (i - 1 >= 0 && lines2[i - 1]!![j] == 'M') {
                        if (i - 2 >= 0 && lines2[i - 2]!![j] == 'A') {
                            if (i - 3 >= 0 && lines2[i - 3]!![j] == 'S') {
                                xmasCounter++
                            }

                        }
                    }
                }
            }
        }
    }
    println("Xmas Counter: " + xmasCounter)
}