package com.knoldus.typesystem.example4

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Problem extends App {

    trait Functor[A, F[_]] {
        def map[B](x: F[A])(f: A => B): F[B]
    }

    def optionFunctor[A]: Functor[A, Option] = new Functor[A, Option] {
        override def map[B](x : Option[A])(f : A => B) : Option[B] = x.map(f)
    }

    println("Option Functor: " + optionFunctor.map(Some(9))(_ + 20))

    def futureFunctor[A]: Functor[A, Future] = new Functor[A, Future] {
        override def map[B](x : Future[A])(f : A => B) : Future[B] = x.map(f)
    }

    println("Future Functor: " + futureFunctor.map(Future.successful(3))(_ + 5))

   /* def mapFunctor[X, A]: Functor[A, Map] = new Functor[A, Map] {
        override def map[B](x : Map[X, A])(f : A => B) : Map[X, B] = x.map(f)
    }*/

    Thread.sleep(5000)
}
