package com.knoldus.typesystem

/**
  * LISKOV SUBSTITUTION PRINCIPLE:
  * If B <:(sub type) of A, then everything action we are performing with A type, should also able to do with
  * type B.
  *  --- OR
  * If we could be able to place B on all the places where the action performed by A with success,
  * we can say that B <:(sub type) of A
  */
object  WhyCovariance extends App {

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

    abstract class CarAgency[+T] {
        def purchaseCar(dollars: Double): T
    }

    def purchaseNewCar(agency: CarAgency[Car], dollars: Double) : Car = {
        agency.purchaseCar(dollars)
    }

    /******************************* EXPLANATION ********************************/
    // Why "Co-Variance allows only Sub-Type not Sub Type"

    val carAgency = new CarAgency[Car] {
        override def purchaseCar(dollars : Double) : Car = {
            // perform some business logic
            new Car
        }
    }

    val fourWheelerAgency = new CarAgency[FourWheeler] {
        override def purchaseCar(dollars : Double) : FourWheeler = {
            // perform some business logic
            new FourWheeler
        }
    }

    val mustangAgency = new CarAgency[Mustang] {
        override def purchaseCar(dollars : Double) : Mustang = {
            // perform some business logic
            Mustang()
        }
    }

    val ferrariAgency = new CarAgency[Ferrari] {
        override def purchaseCar(dollars : Double) : Ferrari = {
            // perform some business logic
            Ferrari()
        }
    }

    /***** ACTIONS *****/
    purchaseNewCar(carAgency, 5000) // No problem because we are passing CarAgency[Car] type

//    purchaseNewCar(fourWheelerAgency, 5000) // Not possible, because we breaking the LISKOV SUBSTITUTION PRINCIPLE

    purchaseNewCar(mustangAgency, 60000) // No problem with that, because it follows LISKOV SUBSTITUTION PRINCIPLE

    purchaseNewCar(ferrariAgency, 60000) // No problem with that, because it follows LISKOV SUBSTITUTION PRINCIPLE
}
