package com.knoldus.typesystem

/**
  * LISKOV SUBSTITUTION PRINCIPLE:
  * If B <:(sub type) of A, then everything action we are performing with A type, should also able to do with
  * type B.
  *  --- OR
  * If we could be able to place B on all the places where the action performed by A with success,
  * we can say that B <:(sub type) of A
  */
object WhyContraVariance extends App {

    abstract class Vehicle

    class FourWheeler extends Vehicle

    class Car extends FourWheeler {
        def goodEngine : String = "Good Engine"
    }

    case class Mustang() extends Car {
        def powerfulEngine : String = "Powerful Engine"
    }

    case class Ferrari() extends Car {
        def superbEngine : String = "Superb Engine"
    }

    // Contra-Variance Type
    abstract class Washing[-T] {
        def startWashing(vehicle: T) : Boolean
    }

    def washYourCar(wash : Washing[Car], car: Car) : Boolean = {
        wash.startWashing(car)
    }

    /******************************* EXPLANATION ********************************/
    // Why "Contra-Variance allows only Super-Type not Sub Type"

    val fourWheeler = new Washing[FourWheeler] {
        override def startWashing(vehicle : FourWheeler) : Boolean = {
            // perform some business logic
            true
        }
    }

    val carWashing = new Washing[Car] {
        override def startWashing(vehicle : Car) : Boolean = {
            // perform some business logic
            true
        }
    }

    val mustangWashing = new Washing[Mustang] {
        override def startWashing(vehicle : Mustang) : Boolean = {
            // perform some business logic
            true
        }
    }

    /***** ACTIONS *****/
    washYourCar(carWashing, new Car) // No problem because we are passing Washing[Car] type

//    washYourCar(mustangWashing, new Car) // Not possible, because we breaking the LISKOV SUBSTITUTION PRINCIPLE

    washYourCar(fourWheeler, new Car) // No problem with that, because it follows LISKOV SUBSTITUTION PRINCIPLE


    /**
      * Question: Now, if contra-variance allows us to pass sub class, is it make sense we are calling with
      * washYourVehicle(mustangWashing, Ferrari()) ?
      *
      * Answer: Mustang and Ferrari are siblings, there is no relations with that, if it allows, it could be the chances of
      * runtime exceptions or un-defined behaviour
      *
      */
}
