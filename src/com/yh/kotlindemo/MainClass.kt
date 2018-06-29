package com.yh.kotlindemo

import java.io.File

fun main(args: Array<String>) {

    println("1 + 3 = ${sum(1, 3)}")

    printSum(-1, 8)

    println("max of 34 and 54 is ${max(34, 54)}")

    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")

    val calculator = Calculator()
    val b = (Calculator::sum)(calculator, 2, 3)
    println(b)

    val a: Int = 10000
    print(a == a) //打印 'true'
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a
    println(boxedA === anotherBoxedA) //注意这里打印的是 'false'

    val c: Int = 10000
    print(c == c) // Prints 'true'
    val boxedB: Int? = c
    val anotherBoxedB: Int? = c
    println(boxedB == anotherBoxedB) // Prints 'true'


    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"} ")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))


    val items = listOf("apple", "banana", "kiwi")
    for (item in items.listIterator()) {
        println(item)
    }

    for (i: Int in 1..100 step 4) {
        print("$i ")
    };println()

    for (i: Int in 188 downTo 6 step 4) {
        print("$i ")
    };println()

    val x = 10
    val y = 9
    if (x in 1..y + 1) println("$x in range")


    val items2 = setOf("apple", "banana", "kiwi")
    when {
        "orange" in items2 -> println("juicy")
        "kiwi" in items2 -> println("kiwi is fine too")
    }


    val fruits = listOf("banana", "avocado", "apple", "kiwi")
    fruits
            .filter { it.startsWith("a") }
//            .filter { !it.endsWith("e") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }

    val map: HashMap<String, String> = hashMapOf("a" to "1", "b" to "2", "c" to "3")
    for ((k, v) in map) {
        println("$k -> $v")
    }
    println(map["a"])
    map["a"] = "4"
    println(map["a"])

    for (i in 1..100 step 3) {
        // 闭区间: 包括100
        print("$i ")
    };println()

    for (i in 1 until 100/*1..99*/ step 3) {
        // 半开区间: 不包括100
        print("$i ")
    };println()

    val str: String by lazy {
        //延迟加载
        "adf"
    }

    println("Convert this to camelcase".spcaceToCamelCase())

    println(User.toString())

    //如果不为空则...
    var files = File("/work/test").listFiles()
    println(files?.size)

    //如果不为空则...否则...
    files = File("/work/test/??").listFiles()
    println(files?.size ?: "empty")

}

object User {
    val name = "clistery"
    override fun toString(): String {
        return "User{name=$name}"
    }
}

private fun String.spcaceToCamelCase(): String {
    return convertToUpper().filter { it != ' ' }
}

private fun String.convertToUpper(): String {
    val sb = StringBuilder(this)
    var convert = false
    sb.forEachIndexed { index, it ->
        if (convert) {
            sb[index] = sb[index].toUpperCase()
            convert = false
        } else {
            convert = it == ' '
        }
    }
    return sb.toString()
}

fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${sum(a, b)}")
}

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    // 直接使用 x*y 会产生错误因为它们中有可能会有空值
    if (x != null && y != null) {
        // x 和 y 将会在空值检测后自动转换为非空值
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // obj 将会在这个分支中自动转换为 String 类型
        return obj.length
    }

    // obj 在种类检查外仍然是 Any 类型
    return null
}
