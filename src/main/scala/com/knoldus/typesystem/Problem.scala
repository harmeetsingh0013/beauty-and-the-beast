package com.knoldus.typesystem

import cats.Functor
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Problem extends App {

    def lengthOfString(string: String): Int = string.length

    // Performing the same operation, but outer wrapper is change
    def lengthOfOptionString(option: Option[String]): Option[Int] = option.map(_.length)

    // Performing the same operation, but outer wrapper is change
    def lengthOfFutureString(future: Future[String]): Future[Int] = future.map(_.length)

    lengthOfString("Harmeet")
    lengthOfOptionString(Some("Singh"))
    lengthOfFutureString(Future.successful("Knoldus"))

    // Let's create generic method for above operations

//        def genericLengthOfString[T](string: T)(implicit f: Functor[T]) = {}



    /**
      *
      * --- Pass String
      * def genericLengthOfString[String](string: String)(implicit f: Functor[String])  {
      *
      * }
      *
      * --- Pass Option[String]
      * def genericLengthOfString[Option[String]](string: Option[String])(implicit f: Functor[Option[String]]) = {
      *
      * }
      *
      * --- Pass Future[String]
      * def genericLengthOfString[Future[String]](string: Future[String])(implicit f: Functor[Future[String]]) = {
      *
      * }
      */
}
