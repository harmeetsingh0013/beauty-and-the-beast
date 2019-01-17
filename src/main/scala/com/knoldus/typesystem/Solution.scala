package com.knoldus.typesystem

import cats.{Functor, Id}
import cats.implicits._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Solution extends App {

    def stringLength: String => Int = _.length

    def genericLengthOfString[F[_]](string: F[String])(implicit f: Functor[F]): F[Int] = {
        f.map(string)(stringLength)
    }

    genericLengthOfString[Option](Some("Singh"))
    genericLengthOfString[Future](Future.successful("Knoldus"))

    // How can we pass normal string value rather than any wrapped one ???
    genericLengthOfString[Id]("Harmeet")

    // Another syntax of creating generic method
    def genericLengthOfStringNew[F[_]: Functor](string: F[String]): F[Int] = {
        string.map(stringLength)
    }

    genericLengthOfStringNew[Id]("Harmeet")
    genericLengthOfStringNew[Option](Some("Singh"))
    genericLengthOfStringNew[Future](Future.successful("Knoldus"))
}
