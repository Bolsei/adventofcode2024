package day5.part2

import day5.Day5
import day5.Rules
import kotlin.math.abs

fun main() {
    val day5Part2 = Day5()

    var allRulesSave = false
    var result = 0
    val rules = day5Part2.createRules("/Day5-Rules.txt")
    val updateOrders = day5Part2.getUpdateOrders("/Day5-UpdateOrder.txt")

    for (updateOrder in updateOrders) {
        val split = updateOrder.split(",").toMutableList()
        if (rules != null) {
            allRulesSave = checkRules(rules, split, allRulesSave, updateOrder, 1)
            if (allRulesSave) {
                val abs = abs(split.size / 2)
                result += split[abs].toInt()

            }
        }
    }
    println(result)
}

private fun checkRules(
    rules: ArrayList<Rules>,
    split: MutableList<String>,
    allRulesSave: Boolean,
    updateOrder: String,
    run: Int
): Boolean {
    var allRulesSave1: Boolean
    for (rule in rules) {
        val indexOfFirstRule = split.indexOf(rule.first)
        val indexOfSecondRule = split.indexOf(rule.second)
        if (indexOfFirstRule == -1 || indexOfSecondRule == -1) {
            continue
        }
        allRulesSave1 = indexOfFirstRule < indexOfSecondRule
        if (!allRulesSave1) {
            split[indexOfFirstRule] = rule.second
            split[indexOfSecondRule] = rule.first
            return checkRules(rules, split, allRulesSave, updateOrder, 2)
        }
    }
    return run == 2
}