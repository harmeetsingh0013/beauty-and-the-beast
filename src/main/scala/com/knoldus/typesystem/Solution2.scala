package com.knoldus.typesystem

object Solution2 extends App {

    trait Functor [F[_]] {
        def map[A, B](x: F[A])(f: A => B): F[B]
    }

    // Answer: Yes, Kind Projector Plugin
    def mapFunctorKindProjector[X] = new Functor[Map[X, ?]] {
        override def map[A, B](x : Map[X, A])(f : A => B) : Map[X, B] = x.map{
            case (key, value) => (key, f(value))
        }
    }
    println("Map Functor: " + mapFunctorKindProjector[String].map(Map("Key" -> 4))(_ + 10))
}
