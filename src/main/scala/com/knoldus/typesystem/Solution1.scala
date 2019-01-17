package com.knoldus.typesystem

object Solution1 extends App {

    trait Functor [F[_]] {
        def map[A, B](x: F[A])(f: A => B): F[B]
    }

    // Answer: Type Lambda
    def mapFunctorTypeLambda[X]: Functor[ ({ type Alias[A] = Map[X, A]})#Alias ] =
        new Functor[ ({ type Alias[A] = Map[X, A]})#Alias ] {
            override def map[A, B](x : Map[X, A])(f : A => B) : Map[X, B] = x.map{
                case (key, value) => (key, f(value))
            }
        }
    println("Map Functor: " + mapFunctorTypeLambda[String].map(Map("Key" -> 4))(_ + 10))
}
