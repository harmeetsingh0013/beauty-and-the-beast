package com.knoldus.typesystem

object Solution extends App {

    trait Functor [F[_]] {
        def map[A, B](x: F[A])(f: A => B): F[B]
    }

    // The Solution of the Functor using Map is:
    def mapFunctor[X] = {
        type Alias[A] = Map[X, A]
        new Functor[Alias] {
            override def map[A, B](x : Alias[A])(f : A => B) : Alias[B] = x.map{
                case (key, value) => (key, f(value))
            }
        }
    }

    // How we can call the mapFunctor function?
//    mapFunctor[String].map(Map("Key" -> 4))(_ + 8)

    trait NewFunctor [F[_], A] {
        def map[B](f: A => B): F[B]
    }

    case class ReadableMapFunctor[X, A](x: Map[X, A]) {
        def mapFunctor = {
            type Alias[A] = Map[X, A]
            new NewFunctor[Alias, A] {
                override def map[B](f : A => B) : Map[X, B] = x.map{
                    case (key, value) => (key, f(value))
                }
            }
        }
    }

    ReadableMapFunctor(Map("Key" -> 4)).mapFunctor.map(_ + 8)

    // Question: Do we have any other Solution???
}
