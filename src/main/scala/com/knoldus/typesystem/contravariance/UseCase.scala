package com.knoldus.typesystem.contravariance

/*
https://stackoverflow.com/questions/8634628/scala-contravariance-real-life-example
 */
object UseCase extends App {

    trait Fruits

    class Apple extends Fruits

    case class KashmiriApple() extends Apple

    class Orange extends Fruits

    class Box[-T](fruit: T) {
        def containsSameFruits(ffruits: T): Boolean = {
            if(fruit != null) true else false
        }

        override def toString : String = s"[Fruit : $fruit]"
    }

    def wrapTheApplesBox(box: Box[Apple], apple: Apple): Option[Box[Apple]] = {
        if(box.containsSameFruits(apple)) {
            Some(box)
        } else {
            None
        }
    }

    def packTheBoxOfApple(apple: Apple): Box[Apple] = new Box(apple)

//    def packTheBoxOfOrange(orange: Orange): Box[Fruits] = new Box[Orange](orange)

    val box1 : Box[Apple] = packTheBoxOfApple(new Apple)
    val box2 : Box[Apple] = packTheBoxOfApple(KashmiriApple())

    println(s"Wrap The Box 1: ${wrapTheApplesBox(box1, new Apple)}")
    println(s"Wrap The Box 2: ${wrapTheApplesBox(box2, KashmiriApple())}")

//    val box3 : Box[Fruits] = packTheBoxOfOrange(new Orange)
//    println(s"Wrap The Box 2: ${wrapTheApplesBox(box3, KashmiriApple())}")
}
