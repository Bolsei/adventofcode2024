package day5.part1

import day5.Day5
import kotlin.math.abs


fun main() {
    val day5Part1 = Day5()

    var allRulesSave = false
    var result = 0
    val rules = day5Part1.createRules("/Day5-Rules.txt")
    val updateOrders = day5Part1.getUpdateOrders("/Day5-UpdateOrder.txt")

    for (updateOrder in updateOrders) {
        if (rules != null) {
            for (rule in rules) {
                val indexOfFirstRule = updateOrder.indexOf(rule.first)
                val indexOfSecondRule = updateOrder.indexOf(rule.second)
                if (indexOfFirstRule == -1 || indexOfSecondRule == -1) {
                    continue
                }
                allRulesSave = indexOfFirstRule < indexOfSecondRule
                if (!allRulesSave) {
                    break
                }
            }
            if (allRulesSave) {
                val split = updateOrder.split(",")
                val abs = abs(split.size / 2)
                result += split[abs].toInt()

            }
        }
    }
    println(result)
}