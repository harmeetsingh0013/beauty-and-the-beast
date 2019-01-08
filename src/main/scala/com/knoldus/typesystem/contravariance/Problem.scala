package com.knoldus.typesystem.contravariance

object Problem extends App {

    trait Fruits

    class Apple extends Fruits{
        override def equals(obj : Any) : Boolean = obj match {
            case _ : Apple => true
            case _ => false
        }
    }

    case class KashmiriApple() extends Apple

    class Orange extends Fruits

    case class Box(fruit: Fruits) {
        def containsSameFruits(ffruits: Fruits): Boolean = {
            if(fruit != null && fruit.equals(ffruits)) true else false
        }
    }

    // I am not sure, why this returns None
    // -- The Box is Empty OR
    // -- The Fruits is not Apple
    def wrapTheApplesBox(box: Box, apple: Apple): Option[Box] = {
        if(box.containsSameFruits(apple)){
            Some(box)
        } else {
            None
        }
    }

    // At the time of startup I purchased on only machinery for Apples
    def packTheBoxOfApple(apple: Apple): Box = Box(apple)

    // After some time, for expanding the business purchase another machinery for Oranges
    def packTheBoxOfOrange(orange: Orange): Box = Box(orange)

    val box1: Box = packTheBoxOfApple(new Apple)
    val box2: Box = packTheBoxOfApple(KashmiriApple())

    println(s"Wrap The Box 1: ${wrapTheApplesBox(box1, new Apple)}")
    println(s"Wrap The Box 2: ${wrapTheApplesBox(box2, KashmiriApple())}")

    val box3 = packTheBoxOfOrange(new Orange)
    println(s"Wrap The Box 2: ${wrapTheApplesBox(box3, KashmiriApple())}")
}
