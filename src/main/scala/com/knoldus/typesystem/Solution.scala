package com.knoldus.typesystem

object Solution extends App {

    trait Employee
    class SecretAgents extends Employee
    class OfficeAgents extends Employee

    class SecretAgentsGrade1 extends SecretAgents
    class SecretAgentsGrade2 extends SecretAgents

    class Confidentials

    def confidentials[T >: SecretAgentsGrade1 <: SecretAgents](secretAgents: T) : Confidentials = {
        new Confidentials
    }

    val secretAgentsGrade1 = new SecretAgentsGrade1
    val secretAgentsGrade2 = new SecretAgentsGrade2

    confidentials[SecretAgentsGrade1](secretAgentsGrade1)
//    confidentials[SecretAgentsGrade2](secretAgentsGrade2)

}
