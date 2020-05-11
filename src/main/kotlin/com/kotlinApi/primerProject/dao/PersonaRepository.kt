package com.kotlinApi.primerProject.dao

import com.kotlinApi.primerProject.model.Persona
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonaRepository: JpaRepository<Persona,Long> {
}