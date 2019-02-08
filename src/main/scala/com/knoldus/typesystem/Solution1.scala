package com.knoldus.typesystem

object Solution1 extends App {

    trait Fruit
    class Apple extends Fruit
    class NorthIndiaApple extends Apple
    class SouthIndiaApple extends Apple

    class Orange extends Fruit
    class NorthIndiaOrange extends Orange
    class SouthIndiaOrange extends Orange

    class Box[+T]() {
        def wrapTheFruit[U >: T <: Fruit](a: U): Box[U] = {
            // pack the fruit in box
            new Box[U]
        }
    }

    new Box[Fruit].wrapTheFruit(new Apple)
    new Box[Fruit].wrapTheFruit(new NorthIndiaApple)
    new Box[Fruit].wrapTheFruit(new Orange)
    new Box[Fruit].wrapTheFruit(new NorthIndiaOrange)

//    new Box[Fruit].wrapTheFruit(new AnyRef)

}
