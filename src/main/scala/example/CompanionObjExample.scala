package example

class CompanionObjExample {
  // a companion object and its class can access each other’s private members (fields and methods)
  class Person {
    var name: Option[String] = None
    var age: Option[Int] = None
    override def toString = s"$name, $age"
  }

  object Person {

    // a one-arg constructor
    def apply(name: Option[String]): Person = {
      var p = new Person
      p.name = name
      p
    }

    // a two-arg constructor
    def apply(name: Option[String], age: Option[Int]): Person = {
      var p = new Person
      p.name = name
      p.age = age
      p
    }

    // de-construct object instances (= extractor)
    def unapply(p: Person): String = s"${p.name}, ${p.age}"
  }

  // The apply method in the companion object acts as a Factory Method,
  // which allows you to create new class instances without using the new keyword.

  val p1 = Person(Some("Fred"))
  val p2 = Person(None)

  val p3 = Person(Some("Wilma"), Some(33))
  val p4 = Person(Some("Wilma"), None)

  println(Person.unapply(p1))
  println(Person.unapply(p3))
}
