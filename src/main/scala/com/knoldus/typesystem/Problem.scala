package com.knoldus.typesystem

object Problem extends App {

    trait Fruit
    class Apple extends Fruit
    class NorthIndiaApple extends Apple
    class SouthIndiaApple extends Apple

    class Orange extends Fruit
    class NorthIndiaOrange extends Orange
    class SouthIndiaOrange extends Orange

    class Box[+T] {
       /* def wrapTheFruit(a: T): Box[T] = {
            // pack the fruit in box
            ???
        }*/
    }


}
