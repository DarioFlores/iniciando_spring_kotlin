package com.kotlinApi.primerProject.business

import com.kotlinApi.primerProject.model.Persona

interface IPersonaBusiness {

    fun list(): List<Persona>
    fun load(idPersona: Long): Persona
    fun save(persona: Persona): Persona
    fun remove(idPersona: Long)
}