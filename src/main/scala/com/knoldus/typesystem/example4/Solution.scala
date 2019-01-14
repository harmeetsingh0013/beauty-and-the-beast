package com.knoldus.typesystem.example4

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
    mapFunctor[String].map(Map("Key" -> 4))(_ + 8)

    // Question: Do we have any other Solution???
    // Answer: Type Lambda
    def mapFunctorTypeLambda[X]: Functor[ ({ type Alias[A] = Map[X, A]})#Alias ] =
        new Functor[ ({ type Alias[A] = Map[X, A]})#Alias ] {
        override def map[A, B](x : Map[X, A])(f : A => B) : Map[X, B] = x.map{
            case (key, value) => (key, f(value))
        }
    }
    println("Map Functor: " + mapFunctorTypeLambda[String].map(Map("Key" -> 4))(_ + 10))


    // Questions: Do we have any other way or Clean syntax for achive same thing
    // Answer: Yes, Kind Projector Plugin
        def mapFunctorKindProjector[X] = new Functor[Map[X, ?]] {
        override def map[A, B](x : Map[X, A])(f : A => B) : Map[X, B] = x.map{
            case (key, value) => (key, f(value))
        }
    }
    println("Map Functor: " + mapFunctorKindProjector[String].map(Map("Key" -> 4))(_ + 10))
}
