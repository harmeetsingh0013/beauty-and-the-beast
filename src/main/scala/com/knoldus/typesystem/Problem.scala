package com.knoldus.typesystem

object Problem extends App {

    trait Employee
    class SecretAgents extends Employee
    class OfficeAgents extends Employee

    class SecretAgentsGrade1 extends SecretAgents
    class SecretAgentsGrade2 extends SecretAgents

    class Confidentials

    def confidentials(secretAgents: SecretAgents) : Confidentials = {
        if(secretAgents.isInstanceOf[SecretAgentsGrade1]) {
            new Confidentials
        } else {
            throw new RuntimeException
        }
    }

    val secretAgentsGrade1 = new SecretAgentsGrade1
    val secretAgentsGrade2 = new SecretAgentsGrade2

    confidentials(secretAgentsGrade1)
//    confidentials(secretAgentsGrade2)
}
