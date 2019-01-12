package com.knoldus.typesystem.example4

object Solution extends App {

    trait Functor[A, F[_]] {
        def map[B](x: F[A])(f: A => B): F[B]
    }

    // The Solution of the Functor using Map is:
    def mapFunctor[X, A] = {
        type Alias[A] = Map[X, A]
        new Functor[A, Alias] {
            override def map[B](x : Alias[A])(f : A => B) : Alias[B] = x.map{
                case (key, value) => (key, f(value))
            }
        }
    }

    // How we can call the mapFunctor function?

//    mapFunctor[String, Int].map(Map("Key" -> 4))(_ + 8)

    // Question: Do we have any other Solution???
    // Answer: Type Lambda
    def mapFunctorTypeLambda[X, A]: Functor[A, ({ type Alias[A] = Map[X, A]})#Alias ] =
        new Functor[A, ({ type Alias[A] = Map[X, A]})#Alias] {
            override def map[B](x : Map[X, A])(f : A => B) : Map[X, B] = x.map{
                case (key, value) => (key, f(value))
            }
        }

    println("Map Functor: " + mapFunctorTypeLambda[String, Int].map(Map("Key" -> 4))(_ + 10))


    // Questions: Do we have any other way or Clean syntax for achive same thing
    // Answer: Yes, Kind Projector Plugin
    def mapFunctorKindProjector[X, A]: Functor[A, Map[X, ?]] = new Functor[A, Map[X, ?]] {
        override def map[B](x : Map[X, A])(f : A => B) : Map[X, B] = x.map{
            case (key, value) => (key, f(value))
        }
    }

    println("Map Functor: " + mapFunctorKindProjector[String, Int].map(Map("Key" -> 4))(_ + 10))
}
