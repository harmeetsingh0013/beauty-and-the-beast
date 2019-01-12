package com.knoldus.typesystem.example2

object Problem extends App {

    trait Food
    trait FastFood extends Food
    trait HealthyFood extends Food

    class Burger extends FastFood
    class Noodles extends FastFood

    class Vegetables extends HealthyFood
    class Fruits extends HealthyFood

    case class Box(food: Food)

    class Store {
        def orderYourHealthyFood(food: String): Box = food match {
            case "Vegetables" => Box(new Vegetables)
            case "Fruits" => Box(new Fruits)
        }

        // What, if Noodles are Out Of Order???
        // OR
        // From Now onwards, I will be only working on burgers
        def orderYourFastFood(fastFood: String): Box = fastFood match {
            case "Burger" => Box(new Burger)
            //        case "Noodles" => Box(new Noodles) // Out of order
            case _ => throw new RuntimeException
        }
    }

    val store = new Store
    store.orderYourHealthyFood("Vegetables")
    store.orderYourHealthyFood("Fruits")

    store.orderYourFastFood("Burger")
    //store.orderYourFastFood("Noodles")

}
