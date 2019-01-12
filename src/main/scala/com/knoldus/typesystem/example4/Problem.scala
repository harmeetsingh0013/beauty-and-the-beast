package com.knoldus.typesystem.example4

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Problem extends App {

    trait Functor [F[_]] {
        def map[A, B](x: F[A])(f: A => B): F[B]
    }
    def optionFunctor[A]: Functor[Option] = new Functor[Option] {
        override def map[A, B](x : Option[A])(f : A => B) : Option[B] = x.map(f)
    }

    println("Option Functor: " + optionFunctor.map(Some(9))(_ + 20))

    def futureFunctor[A]: Functor[Future] = new Functor[Future] {
        override def map[A, B](x : Future[A])(f : A => B) : Future[B] = x.map(f)
    }

    val result = futureFunctor.map(Future.successful(3))(_ + 5)
    Thread.sleep(1000)

    println("Future Functor: " + result)

/*    def mapFunctor[X, A]: Functor[Map] = new Functor[Map] {
        override def map[A, B](x : Map[X, A])(f : A => B) : Map[X, B] = x.map(f)
    }*/


}
