package day5

class Day5 {

    fun createRules(fileName: String): ArrayList<Rules>? =
        this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.useLines { it1 ->
            val rules = arrayListOf<Rules>()
            it1.forEach { line ->
                val split = line.split("|")
                rules.add(Rules(split[0], split[1]))
            }
            return rules
        }

    fun getUpdateOrders(fileName: String): ArrayList<String> {
        val updateOrders = arrayListOf<String>()
        this::class.java.getResourceAsStream(fileName)?.bufferedReader()?.useLines { it1 ->
            it1.forEach { line ->
                updateOrders.add(line)
            }
        }
        return updateOrders
    }

}