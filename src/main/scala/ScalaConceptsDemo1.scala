import scala.io.StdIn.readInt

@main def scalaConceptsDemo1() =
    /*
      Scala Introduction
        Compile : scalac hello.scala
        Run : scala hello
        Executable files path : /target/scala-3.3.1/classes/hello

        SBT command - on project directory
            - sbt compile
            - sbt package
            - sbt run  (to build and run)
            - sbt (this will open REPL)
    */

    println("---- Variables and Data Types----")

    // Variables : val and var
    // val are immutable variables
    val x: Int = 1  // Explicit
    val y = 3   // Implicit

    // x = 4    // this will give error

    println(s"x: ${x}")
    println(s"y: ${y}")

    // var are mutable
    var z: Int = 1
    z = 2
    println(s"z: ${z}")

    z = 34
    println(s"z: ${z}")

    // Data Types
    val b: Byte = 1
    val i: Int = 1
    val l: Long = 1
    val s: Short = 1
    val d: Double = 2.0
    val f: Float = 3.0
    val fname = "Bill"   // String
    val lname = "Clinton"
    val c = 'a'         // Char
    val bb: Boolean = true

    // multi-line string
    val multilineString =
        """
          This is a
          multiline string in
          scala
        """
    println(multilineString)

    // String interpolation
    println(s"First name is ${fname} and last name is ${lname}")

    println("\n---- Control structures ----")
    // User input
    //    print("Please enter number: ")
    //    val number : Int = readInt()

    // Conditions
    val number = 5
    if (number > 0) then
        println(s"${number} is positive")
    else if (number == 0) then
        println(s"${number} is zero")
    else
        println(s"${number} is negative")

    // Scala control structures can be used as expressions
    val val1 = 4
    val val2 = 5

    val min = if val1 < val2 then val1 else val2
    println(s"Min of ${val1} and ${val2} is : ${min}")

    // Loops
    // The code i <- ints is referred to as a generator,
    // and the code that follows the do keyword is the body of the loop.
    val listOfIntegers = List(1, 2, 3, 4, 5)
    print("listOfIntegers: ")
    for (i <- listOfIntegers) do
        print(s"${i} ")
    println("")

    print("Numbers from 4 to 8: ")
    for (i <- 4 to 8) do
        print(s"${i} ")
    println("")

    println("Pattern:")
    for (i <- 1 to 4) do
        for (j <- 1 to i) do
            print("*")
        println("")
    println("")

    // For expressions
    //  When you use the yield keyword instead of do, you create for expressions which are used to calculate and yield results.

    // creates a new list, where the value of each element in the new list is twice the value of the elements in the original list:
    val multiplyByTwo = for (i <- listOfIntegers) yield (i * 2)
    println(s"List of integers multiplied by 2: $multiplyByTwo")

    val names = List("harry", "hagrid", "ron", "hermoine", "tom")
    val capitalizedNames = for (n <- names) yield n.capitalize
    println(s"Capitalized names: ${capitalizedNames}")

    // match expressions
    // use is like a Java switch statement:
    val no = 2
    no match
        case 1 => println("one")
        case 2 => println("two")
        case 3 => println("three")

    // match as an expression
    val result = no match
        case 1 => "one"
        case 2 => "two"
        case 3 => "three"
        case _ => "other"

    println(s"result is : ${result}")

    // While loop
    print("While loop: ")
    var count = 0
    while (count < 7) do
        print(s"${count} ")
        count += 1
    println(""
    )
    // Exception handling
    // try/catch/finally
    try
        println("Inside try block")
        val abcd = Integer.parseInt("test123")
    catch
        case ex: Exception =>
            println(s"Exception: ${ex}")
    finally
        println("Finally block")

    // Scala methods
    println("---- Methods ----")
    // def methodName(param1: Type1, param2: Type2): ReturnType =
    // We use the Unit return type to indicate "no return value." This is a "void" function.

    def sum(x: Int, y: Int): Int = (x + y)

    val newsum = sum(5, 6)
    println(s"sum of 5 and 6: ${newsum}")

    // multiline method
    def sumModulo(x: Int, y: Int): Int =
        var sm = x + y
        sm = sm % 10
        sm

    val summodulo = sumModulo(5, 6)
    println(s"sum of 5 and 6 modulo 10: ${summodulo}")

    // Scala Domain Modelling
    // Scala supports both functional programming (FP) and object-oriented programming (OOP),
    // as well as a fusion of the two paradigms.

    // When writing code in an OOP style, your two main tools for data encapsulation are traits and classes.

    /*
    Traits
      - Scala traits can be used as simple interfaces, but they can also contain abstract and concrete methods and fields,
          and they can have parameters, just like classes.
      - They provide a great way for you to organize behaviors into small, modular units. Later, when you want to
        create concrete implementations of attributes and behaviors, classes and objects can extend traits,
        mixing in as many traits as needed to achieve the desired behavior.

    Classes
        - Scala classes are used in OOP-style programming. Here’s an example of a class that models a “Dog”
        - In OOP fields are typically mutable, so name is declared as var parameters:



     */

    println("---- Classes and Traits ----")
    val dog = Dog("Tommy")
    println(s"Dog name: ${dog.getName()}")
    println(s"Dog habitat: ${dog.getHabitat()}")
    dog.startRunning()
    dog.stopRunning()

    /*
        First class functions
            - Lambdas (anonymous functions)
            - Higher-order functions (HOFs)
            - Immutable collections in the standard library

        Lambdas
            - Lambdas, also known as anonymous functions, are a big part of keeping your code concise but readable.

        HOF
            - The map method of the List class is a typical example of a higher-order function—a function that
                takes a function as parameter.

        Immutable collections:
            - When you work with immutable collections like List, Vector, and the immutable Map and Set classes,
            it’s important to know that these functions don’t mutate the collection they’re called on; instead,
            they return a new collection with the updated data.
            - As a result, it’s also common to chain them together in a “fluent” style to solve problems.

    */
    println("---- Lambdas, HOFs and Immutable collections ----")
    val mylist = List(1, 2, 3, 4, 5)
    val doubleMyList = mylist.map(i => (i * 2))      // List(2, 4, 6, 8, 10)
    val filteredList = mylist.filter(i => i>2)

    println(s"doubleMyList: ${doubleMyList}")
    println(s"filteredList: ${filteredList}")

    // Filter and map
    val myCustomList = mylist.filter(i => i>2)
            .filter(i => i<5)
            .map(i => i*3)
    println(s"myCustomList: ${myCustomList}")

    /*
        Singleton objects
            - the object keyword creates a Singleton object. Put another way, an object defines a class that has exactly one instance.
            - Objects have several uses:
                - They are used to create collections of utility methods.
                - A companion object is an object that has the same name as the class it shares a file with.
                    In this situation, that class is also called a companion class.
                - They’re used to implement traits to create modules
            - Because an object is a Singleton, its methods can be accessed like static methods in a Java class.
            - For example, this StringUtils object contains a small collection of string-related methods:
    */
    println("---- Singleton objects ----")
    val myString = "   345lkjdf  "
    val myString2 = ""
    println(s"String: ${myString}")
    println(s"Left trim: ${StringUtils.leftTrim(myString)}")
    println(s"Right trim: ${StringUtils.rightTrim(myString)}")
    println(s"myString2 is : ${ if StringUtils.isNullOrEmpty(myString2) then "blank" else "not blank"}")

    /*
        Collections
            List
                - List class, which is an immutable, linked-list class.
                - Methods: all functional methods, meaning that they don’t mutate the collection they’re called on, but
                    instead return a new collection with the updated elements.
                        - head
                        - tail
                        - isEmpty
                        - filter
            Tuples
                - The Scala tuple is a type that lets you easily put a collection of different types in the same
                    container.
                - Tuples are nice for those times when you want to put a collection of heterogeneous types in a
                    little collection-like structure.
    */
    println("---- List and Tuple ----")
    val tempList = List(2, 4, 6, 8)
    println(s"tempList: ${tempList}")
    println(s"tempList head: ${tempList.head}")
    println(s"tempList tail: ${tempList.tail}")
    println(s"tempList isEmpty: ${tempList.isEmpty}")
    println(s"tempList size: ${tempList.size}")


    val tempList2 = (10 to 18).toList   // Range to list
    val tempTempList = List.range(5, 9)

    // Use the flatten method to convert a list of lists into a single list
    val lol = List(List(1,2), List(3,4))
    println(s"List of lists: ${lol}")
    println(s"List of lists flattened: ${lol.flatten}")

    println(s"tempList2: ${tempList2}")
    println(s"tempTempList: ${tempTempList}")

    // Tuple of int, string and bool
    val tup = (10, "unicommerce", true)
    println(s"Tuple elements: ${tup(0)}, ${tup(1)}, ${tup(2)}")

    // Extracting from tuple elements
    val (v1, v2, v3) = tup
    println(s"v1, v2, v3: ${v1}, ${v2}, ${v3}")