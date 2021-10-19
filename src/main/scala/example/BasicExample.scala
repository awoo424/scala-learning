package example

class BasicExample {
  val ages = Seq(42, 75, 29, 64)
  println(s"The oldest person is ${ages.max}")

  val x = 1 + 1 // infer type, mutable
  val y: Int = 2 + 3 // explicitly state type
  var z = 2 + 3 // mutable
  println(s"x is ${x}")
  println(s"y is ${y}")
  println(s"z is ${z}")

  // Functions
  val add = (x: Int, y: Int) => x + y
  println(s"Result of add(1, 2) is ${add(1, 2)}")
  val getTheAnswer = () => "I don't require arguments"
  println(getTheAnswer())

  // Methods
  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println(s"Result of addThenMultiply(1, 2) is ${addThenMultiply(1, 2)(3)}") // 9

  // Create filters
  def isDivisibleBy(k: Int): Int => Boolean = i => i % k == 0
  def isEven = isDivisibleBy(2)
  println(s"Result of filter is ${List(1,2,3).filter(isEven)}")

  // Classes
  class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit =
      println(prefix + name + suffix)
  }

  val greeter = new Greeter("Hello, ", "!")
  greeter.greet("Scala developer") // Hello, Scala developer!

  // Case classes (immutable)
  case class Point(x: Int, y: Int)
  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)
  if (point == anotherPoint) {
    println(point + " and " + anotherPoint + " are the same.")
  } else {
    println(point + " and " + anotherPoint + " are different.")
  }

  // Objects = singletons of their classes
  object IdFactory {
    private var counter = 0
    def create(): Int = {
      counter += 1
      counter
    }
  }
  val newId: Int = IdFactory.create()
  println(s"newId = ${newId}") // 1

  // Traits
  trait TraitGreeter {
    def greet(name: String): Unit =
      println("Hello, " + name + "!")
  }

  class DefaultGreeter extends TraitGreeter
  class CustomizableGreeter(prefix: String, postfix: String) extends TraitGreeter {
    override def greet(name: String): Unit = {
      println(prefix + name + postfix)
    }
  }
  val exampleGreeter = new DefaultGreeter()
  exampleGreeter.greet("Scala developer") // Hello, Scala developer!

  val customGreeter = new CustomizableGreeter("How are you, ", "?")
  customGreeter.greet("Scala developer") // How are you, Scala developer?
}
