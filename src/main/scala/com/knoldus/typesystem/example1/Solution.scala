package com.knoldus.typesystem.example1

object Solution extends App {

    // Create an abstractions which contains action declaration
    trait Adder[T] {
        def sum(a: T, b: T): T
    }

    // Create an public interface(not java interface) by whom, we perform our action
    def sum[T](a: T, b: T)(implicit adder: Adder[T]): T = adder.sum(a, b)

    // provide an implementation of abstraction, to whom you require
    // -- Int implementation
    implicit val integer = new Adder[Int] {
        override def sum(a: Int, b: Int): Int = a + b
    }

    sum(2, 4)

    // -- String implementation
    implicit val stringAdder = new Adder[String] {
        override def sum(a : String, b : String) : String = a + b
    }

    sum("One", "Two")

    // -- List[Int] implementation
    implicit val listAdder = new Adder[List[Int]] {
        override def sum(a : List[Int], b : List[Int]) : List[Int] =
            (a zip b).map { case (x, y) => x + y}
    }
    sum(List(1, 3, 4, 5), List(3, 3, 4, 5))
}
