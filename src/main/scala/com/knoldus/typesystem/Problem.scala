package com.knoldus.typesystem

object Problem extends App {

    // Require method perform Addition on Float
    def sumFloat(a: Float, b: Float) : Float = a + b

    sumFloat(3.2f, 3.2f)

    // Require methods perform addition on any number
    def sumAnyVal(a: AnyVal, b: AnyVal):AnyVal = (a, b) match {
        case (a: Int, b: Int) => a + b
        case (a: Float, b: Float) => a + b
        case (a: Double, b: Double) => a + b
        case _ => 0
    }

    sumAnyVal(1, 2)
    sumAnyVal(1.2f, 2.3f)
    sumAnyVal(1.0, 2.3)

    // Require method perform additions on numbers and on String as well.
    def sumAny(a: Any, b: Any):Any = (a, b) match {
        case (a: Int, b: Int) => a + b
        case (a: Double, b: Double) => a + b
        case (a: String, b: String) => a + b
        case _ => "match error"
    }

    sumAny(1, 2)
    sumAny(2.0, 4.3)
    sumAny("One", "Two")


    sumAny(new AnyRef, new AnyRef)
    
    // Question: What are the problems we are facing during sumAnyVal and sumAny methods???
}
