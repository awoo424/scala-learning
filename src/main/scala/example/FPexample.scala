package example

class FPexample {
  // High-Order functions
  // pass anonymous functions to map or filter
  val numbers = (1 to 10).toList
  val doubles = numbers.map(_ * 2)
  val lessThanFive = numbers.filter(_ < 5)
  println(s"doubles = ${doubles}")
  println(s"lessThanFive = ${lessThanFive}")

  // NO null values
  // use Option/Some/None

  // When the given string converts to an integer,
  // return the integer wrapped in a Some wrapper, such as Some(1).
  // When the string can’t be converted to an integer, return a None value.
  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }
  val a = toInt("1")
  val b = toInt("foo")
  println(s"a is ${a}.")
  println(s"b is ${b}.")

  // As a consumer of toInt
  // #1: use a match expression
  toInt("10") match {
    case Some(i) => println(i)
    case None => println("That didn't work.")
  }

  // #2: use a for-expression
  val y = for {
    a <- toInt("100")
    b <- toInt("200")
    c <- toInt("100")
  } yield a + b + c
  println(s"y is ${y}.")

  // Optional args in class
  class Address (
                  var street1: String,
                  var street2: Option[String],
                  var city: String,
                  var state: String,
                  var zip: String
                )
  val santa1 = new Address(
    "1 Main Street",
    None,
    "North Pole",
    "Alaska",
    "99705"
  )
  val santa2 = new Address(
    "123 Main Street",
    Some("Apt. 2B"),
    "Talkeetna",
    "Alaska",
    "99676"
  )
  println(santa1.street2)
  println(santa2.street2)
}

