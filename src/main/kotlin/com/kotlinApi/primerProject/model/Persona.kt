package com.kotlinApi.primerProject.model

import java.time.LocalDate
import java.util.*;
import javax.persistence.*

@Entity
@Table(name = "persona")
data class Persona (
        val dni:Long,
        val nombre:String,
        val apellido:String,
        val fechaNac:LocalDate?
) {

//    val persona = Persona(38628166,"Dario", "Flores", null);
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long = 0


}
