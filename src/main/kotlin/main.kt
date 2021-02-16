/*
 * You can alternatively declare main() as:
 *
 * fun main(args: Array<String>) {}
 *
 * ...if you want to accept arguments from CLI.
 */

fun main() {
    // You *can* end a statement with semicolon, but that's optional
    println("Hello, world!") // Your typical Hello, World program

    // To declare a variable:
    var name = "Debian"
    var number = 12

    // You can NOT change the type of a variable once it's declared with one
    // In fact, you can NOT add different types together; it won't automatically convert types.
    // println(number + name) // THIS PRODUCES AN ERROR
    print(number)
    print(" " + name)

    // You can create immutable/read-only variables in the following way
    val cant_change = "HAH"

    /* If you have a value that's:
     * - truly constant
     * - either a string or a primitive type
     * - known at compile-time
     * ... then you can declare an actual constant as:
     *
     * const val name = value
     *
     * ...but it can only be declared at:
     * - the top level of a file
     * - inside an object declaration (object name {}), BUT NOT INSIDE A CLASS DECLARATION
     *     - An object is kinda like class, but there's always ONLY ONE INSTANCE OF THAT OBJECT INSTEAD
     */

    // You can explicitly specify the type in the following way:
    val num2 : Int = 123
    val hai : String
    hai = "Hello"

    // The variable name convention is similar to Java; lowerCamelCase instead of snake_case
    // You can have a var name with spaces by enclosing it in backticks
    var `This is a valid var name or identifier` = 1

    /* Here's the following primitive types.
     *
     * Integer types:
     * - Long (64 bits), from -9223372036854775808 to 9223372036854775807
     * - Int (32 bits), from -2147483648 to 2147483647
     * - Short (16 bits), from -32768 to 32767
     * - Byte (8 bits), from -128 to 127
     *     - Due to bad design decision inherited from Java, if you want to get the usual 0 - 255 byte value:
     *         - Keep the value as-if if the value is positive
     *         - Add 256 if the value is negative
     *
     * Floating-point types:
     * - Double (64 bits), up to 16-17 significant digits
     * - Float (32 bits), up to 6-7 significant digits
     *
     * If you need larger precision, or in other situations where you must have exact results, use non-primitive
     * type BigDecimal.
     *
     * Other types:
     * - Char (16 bits), UTF-16 code unit, can only be represented with single quotes
     * - Boolean (8 bits), `true` or `false`
     * - String, i.e. an **im**mutable sequence of Chars, can only be represented with double quotes
     *     - You can do string interpolation in the following format:
     *         - "$varname is ${num1 - num2}" (Curly brackets = expressions)
     *         - You need to escape the $ if you want a literal $
     * - ByteArray, similar to Python 2 `str`, is a fixed-size but otherwise mutable byte array
     */

    var num3 = 0

    if (num3 == 0) {
        println("hello")
    } else if (num3 == 1) {
        println("Hello")
    } else {
        println("REEEEEEEEEE")
    }

    // Curly braces around conditions can be omitted if the body is a one liner
    // Generally discouraged unless the body goes on the same line as the condition
    if (num3 == 2) println("Hello World Again")

    // An if-else statement is also an expression in Kotlin, meaning that a ternary conditional looks like this:
    val result = if (num3 == 1) "quak" else "womp womp"

    /* ???:
     * - ==, equals
     *     - Classes can override equals() and hashCode() to define what it means.
     * - !=, not equal
     * - &&, logical AND
     * - ||, logical OR
     * - !, logical NOT
     *
     * There's no automatic conversion to boolean, which means any checks for zero, empty, or null MUST BE EXPLICITLY
     * done with == or !=
     */

    // when expression is a control flow that lets you compare one expression against many kinds of expressions in a
    // compact way, which makes it somewhat similar to switch-case expression but not quite
    when (num3) {
        0 -> println("lol")
        in 1..9 -> println("HA")
        else -> println("ohno")
    }

    // Arrays in Kotlin has a constant length, so one normally uses lists, just like the ones in Python
    val ree = listOf("Allo", "Boring", "Calling") // Produces a List<String> type

    // What's called a dict in Python is called a map in Kotlin
    val hallo = mapOf( // Produces a Map<String, Int> type
        "a" to 1, // to is an infix function, which is a one param member/extension function for use as infix operator,
        "b" to 2, // which basically creates a Pair type with a key and value.
        "c" to 3
    )

    // Set is similar to Python's as well.
    val set = setOf(1, 2, 3) // Produces a Set<Int> type

    // ALL of the collections above are immutable, if you want mutable collections, use mutableListOf(), mutableMapOf()
    // and/or mutableSetOf() instead.

    println(hallo.size)
    println(hai.length) // .size does NOT work for String, you need to use .length due to legacy Java reasons

    // If you want to create an empty collection, you need to either:
    // - declare the collection type explicitly
    // - supply the element type(s) to the function that constructs the collections
    val intsOnly: List<Int> = listOf()
    val emptyMap = mapOf<String, String>() // The types inside the angle brackets <> are called generic type parameters.

    // You can use Any (element type) if you really need a mixed-type collection, but it's way easier to create a data
    // class with all the elements you need.

    // for loops in Kotlin is very similar to Python's, in that it iterates over anything that is iterable:
    // - anything that has an iterator() function which provides an Iterator object
    // - anything that is itself an Iterator
    // You can create a range with .. operator, but unlike Python's range(), it *includes its endpoint*.
    for (x in 0..10) print(x)

    // To exclude the last value of ^, replace .. with `until` instead.
    // You can also control the increments with `step`, whose value MUST BE POSITIVE
    for (x in 0 until 10 step 2) print(x)

    // To count downwards, use the inclusive (as in it includes the starting point) `downTo`
    for (x in 10 downTo 0 step 2) print(x)

    // You can use all of the expressions above to the right of `in` outside of the loops to generate ranges, i.e. one
    // type of iterables
    val range = (10 downTo 0 step 5) // add .toList() in the end of this expr to turn it into a list

    // If you want the index of the current element while iterating:
    for ((index, value) in range.toList().withIndex()) println("$index: $value")

    // As for maps...
    for (entry in hallo) println("${entry.key}: ${entry.value}")
    for ((key, value) in hallo) println("$key: $value")
    for (key in hallo.keys) println(key)
    for (value in hallo.values) print(value)

    // while loop is similar to the one in Python, but the condition must be an actual boolean expression, since Kotlin
    // does not have any concepts of truthy and falsy values.
    var x = 0
    while (x < 19) {
        println(x)
        x++
    }

    
}