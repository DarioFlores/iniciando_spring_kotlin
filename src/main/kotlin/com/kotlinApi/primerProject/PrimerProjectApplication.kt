package com.kotlinApi.primerProject

import com.kotlinApi.primerProject.dao.PersonaRepository
import com.kotlinApi.primerProject.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@SpringBootApplication
class PrimerProjectApplication: CommandLineRunner{

	@Autowired
	val personaRepository: PersonaRepository? = null

	override fun run(vararg args: String?) {
		val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val persona1 = Persona(38628166, "Dario", "Flores", LocalDate.parse("22-02-1995", formatter))

		personaRepository!!.save(persona1)
	}
}

fun main(args: Array<String>) {
	runApplication<PrimerProjectApplication>(*args)
}
