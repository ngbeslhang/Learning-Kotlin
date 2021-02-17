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

    // continue and break are the same as the ones in Python.
    // You can give loops a specific label, which is in the format `name@`. Here's an example:
    outerloop@ for (n in 2..100) {
        for (d in 2 until n) {
            if (n % d == 0) continue@outerloop // Works the same way for break too
        }
    }

    next()
}

// Functions can be declared the following ways:

fun hello(name: String): String {
    // Asks for a param called name, must return a String type
    return "Hello, ${name}!"
}

// One-liner function
fun square(n: Int) = n * n

// Just remember to use lowerCamelCase

fun next() {
    // Functions are called the same way as in Python
    val greeting = hello("Adam")

    // Not returning anything in a function does NOT implicitly return null; you must do so explicitly
    // Functions that don't have any returns or empty returns return type Unit, which stands for
    // "this function **never** returns any information", those that sometimes does need to return null
    // in cases where it doesn't have any information to return

    println(hello("quak"))
    third()
}

// In Kotlin, you can overload functions, i.e. there can be multiple declarations of functions with the same
// name as long as the parameters lists of each functions are distinguishably different. We'll take square
// as an example of this

fun square(n: Double) = n * n

fun third() {
    // https://stackoverflow.com/questions/45165143/get-type-of-a-variable-in-kotlin
    println(square(1)::class.qualifiedName) // should return Int
    println(square(3.21)::class.qualifiedName) // should return Double

    fourth()
}

// Similar to `*args` in Python, you can use `vararg` in Kotlin
// Unlike in Python, you can declare your normal, positional parameters *after* vararg (aka variadic parameter)
// but there can only be at most one variadic param per function.

// The type of the vararg will be:
// - XArray if X is primitive type
// - Array<X> if X is not a primitive type

fun add(vararg n: Int) {
    var total : Int = 0
    for ((i, v) in n.withIndex()) {
        total += v
        if (i == (n.size - 1)) print("${v} = ") else print("${v} + ")
    }
    print("${total}\n")
}

// Overloaded with Double and returns with a String instead
fun add(vararg n: Double): String {
    var total : Double = 0.0
    var str : String = ""
    for ((i, v) in n.withIndex()) {
        total += v
        if (i == (n.size - 1)) str += "${v} = " else str += "${v} + "
    }
    str += "${total}" // Intentionally omitted `\n` to showcase println(add(10.2,11.0)) etc.

    return str
}

// Unfortunately, **kwargs is not a thing in Kotlin, but you can define optional params with default values
// A param with default value must still have its type specified explicitly
fun profile(name: String, age: Int, regYear: Int = 2021) {
    println("Name: ${name}")
    println("Age: ${age}")
    println("Registration Year: ${regYear}")
}

// Unlike in Python, where the default value of a param is evaluated once only when the function was defined,
// Kotlin evaluates a param's default value *every time* the function is invoked/called, which means you can do this:
fun tricky(x: Int, num: MutableList<Int> = mutableListOf()) {
    // num will always get an empty list every time it's called, whereas in Python
    // the same list (with existing elements) will be reused all the time
    num.add(x)
    println(num)
}

// Due to the confusion possible from the situation above, you should only set up a default value initializer as
// - a constant
// - a function call that always produce a new obj with the same value

fun fourth() {
    add(1,3,2,10,40,20,50,60)
    add(1,2,3,4,5,6,7,8,9)
    println(add(10.2,11.0))

    // Like in Python, the named arguments can be reordered at will at the call site
    profile("Gak", 19)
    profile(age = 20, name = "Tan")
    profile(regYear = 2010, name = "Tan", age = 28)

    tricky(1)
    tricky(2)

    // You can call a variadic function with one array (BUT NOT A LIST OR ANY OTHER ITERABLES) that contains all the
    // variadic argument by *spreading* it with `*` operator
    val num = listOf(1,4,2,1,5,6)
    add(*num.toIntArray())

    // Kotlin's array system was inherited from Java, i.e.:
    // - primitive types got their own array types
    // - any other types use the generic Array type to which you can convert with `.toTypedArray()`

    // You CANNOT spread a map into a function call and expect the values in the map to be passed to params
    // named by the keys since the params' names must be known at compile time. If you need runtime-defined
    // param names, you function must either:
    // - take a map as param type, or
    // - take `varg kwargs: Pair<String, X>, where X is the "LCM" of the param types, in the worst case `Any?`
    //    - be prepared to have to typecast the param values, and note that you'll lose type safety
    //    - such function can be called like `foo("bar" to 42, "test" to "hello`, since `to` is an infix func that
    //      creates a Pair

    fifth()
}

// Kotlin's object model is substantially different from Python's. Most importantly, classes are NOT
// dynamically modifiable at runtime (there are exceptions to this, but the norm is to not try to do it)
// There is a way to dynamically inspect classes & objs at runtime with a feature called *reflection*, but it should be
// judiciously used.

// All properties (attributes) & functions that might ever be needed on a class must be declared either:
// - directly in the class body or
// - as extension functions
// ...which means you need to think carefully through your class design

// A class without any properties or functions of its own can be declared this way
class Nada // Yes, that's it; also class names should use UpperCamelCase just like in Python

fun fifth() {
    // an instance is created as if the class is called as a function, but this is just syntactic sugar
    // because unlike Python, classes in Kotlin aren't really functions
    val obj = Nada()
}

/* Every class that doesn't explicitly declare a parent class inherits from Any, which is the root of the
 * class hierarchy, which also means that every class automatically has the following functions:
 * - toString() returns a string representation of the object, similar to `__str__()` in Python
 * - equals() checks if this obj is equal to some other object x of any class, which can be overwritten
 * - hashCode() returns an integer that can be used by hash tables & for shortcutting complex quality comparisons
 *     - objects that are equal according to equals() must have the same hash code
 */