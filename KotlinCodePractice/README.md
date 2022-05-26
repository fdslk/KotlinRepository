# Kotlin 101 practice
## How to create a kotlin project IntelliJ IDEA
* click **File** -> **New** -> **Kotlin**, IDEA will help to create kotlin project with JVM
* You also can use REPL (Read-Eval-Print-Loop) interactive shell to practice the basic kotlin syntax
## Kotlin basic syntax
* Kotlin is very similar to java language, but also there is several difficulties between them.
  * using ```fun``` to define a function
  * no semicolons in the end of a line
  * using parentheses for function arguments
  * using curly brace to define function block
* Syntax
  * operator ```var``` and ```val```, var is for mutable definition, val is for immutable definition.
  * define variable type: ```var rocks: Int = 1```, type is behind the variable and divided by colon.
  * nullability
    * using operator ```?``` to define a nullable variable
    * using operator ```!!``` to make a not-null announcement
  * list
    * listOf is immutable
    * mutableListOf is mutable
  * array: create array by build-in function ```arrayOf```
  * loop
    * do/ while
    * foreach
    * repeat
      ```kotlin
        repeat(2) {
           println("A fish is swimming")
        }
      ```
  * function
    * without return value
    ```kotlin
    fun feedTheFish() {
       println("test")
    }
    ```
    * with return value
    ```kotlin
    fun feedTheFishWithValue(): String {
       val test = "test string"
       return test 
    }
    ```
    * default value of parameter
    ```kotlin
    fun functionWithDefaultValueArgument(speed: String = "test speed") {
        println("test argument value $speed")
    }
    ```
    * lambdas
    ```var lambdas = { inputValue: Int -> inputValue / 2}```
    * higher-order-functions: passing a lambda to another function
      * return value
        ```kotlin
        fun returnValue(x: Int, y: Int, operate: (Int, Int) -> Int): Int {
          return operate(x, y)
        }
        ```
        * you pass a lambdas, function or just a simple value as an input to a function
        * lambdas
        ```kotlin
        var sum = {(x: Int, y: Int) -> x + y}
        returnValue(1, 2, sum)
        ```
        * regular function
        ```kotlin
        fun sum(x: Int, y:Int): Int {
          return x + y
        }
        
        returnValue(1, 2, ::sum)
        ```
        * simple value
      * return function
        ```kotlin
        fun operate(): (Int, Int) -> Int {
            return sum //::sum '**sum**' is defined as a regular function, the former is a lambda expression
        }
        ```
    * OO related knowledge
      * class
        * no needs to create getter and setter, they are created automatically.
        * no needs to create an individual constructor method, rather than defining a constructor with class directly
        ```kotlin
        class MyClass(arg1: String, arg2: String) {
            var arg1Internal1: String = arg1
            var arg1Internal2: String = arg2
        }
        ```
        * providing init block in class constructor, you can write some logic in the init block
        * providing secondary constructor in class
        ```kotlin
        class MyClass(arg1: String, arg2: String) {
            var arg1Internal1: String = arg1
            var arg1Internal2: String = arg2
            
            constructor(arg: Int): this() {
                //your logic
            }   
        }
        ```
      * subclass
        * by default kotlin cannot be subclassed, otherwise adding operator ```open``` before your class, the same as the property and member
      * inheritance
        * if the setter is defined as following block, it will throw ```Exception in thread "main" java.lang.StackOverflowError```
        ```kotlin
        override var shape: String
                     get() = towerTankShape
                     set(value) {
                        shape = value
                    }
        ```