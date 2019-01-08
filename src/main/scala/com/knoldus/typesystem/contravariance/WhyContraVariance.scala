package com.knoldus.typesystem.contravariance

object WhyContraVariance {

    abstract class Vehicle
    class Car extends Vehicle
    case class ACar() extends Car {
        def powerfulEngine : String = "Powerful Engine"
    }
    case class BCar() extends Car {
        def powerfulSuspensions : String = "Powerful Suspensions"
    }

    class Washing[-T] {
        def startWashing(vehicle: T) : Boolean = ???
    }

    def washYourVehicle(wash : Washing[Car], car: Car) = {
        wash.startWashing(car)
    }

    /*

    ==  val carWashing = new Washing[Car]

        -- My Expectations:
            class Washing[Car] {
                def startWashing(vehicle: Car) : Boolean = {
                    // now I can use all Car methods
                }
            }

    ==  val aCarWashing = new Washing[ACar]
            class Washing[ACar] {
                def startWashing(vehicle: ACar) : Boolean = {
                    // now I can use all ACar methods which is powerfulEngine
                }
            }

    ==  val bCarWashing = new Washing[BCar]
            class Washing[BCar] {
                def startWashing(vehicle: BCar) : Boolean = {
                    // now I can use all ACar methods which is powerfulSuspensions
                }
            }


     Question: Now, if contra-variance allows us to pass sub class, is it make sense
     we are calling washYourVehicle(bCarWashing, ACar())

     */
}
