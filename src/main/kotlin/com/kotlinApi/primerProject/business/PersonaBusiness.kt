package com.kotlinApi.primerProject.business

import com.kotlinApi.primerProject.dao.PersonaRepository
import com.kotlinApi.primerProject.exception.BusinessException
import com.kotlinApi.primerProject.exception.NotFoundException
import com.kotlinApi.primerProject.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonaBusiness: IPersonaBusiness {

    @Autowired
    val personaRepository: PersonaRepository? = null

    @Throws(BusinessException::class) // Nos dice las excepciones que nos puede devolver este metodo
    override fun list(): List<Persona> {
        try {
            return this.personaRepository!!.findAll()
        } catch (e:Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class, NotFoundException::class)
    override fun load(idPersona: Long): Persona {
        val op: Optional<Persona>
        try {
            op = this.personaRepository!!.findById(idPersona)
        } catch (e: Exception){
            throw BusinessException(e.message)
        }

        if (!op.isPresent){
            throw NotFoundException("No se encontro la persona con id $idPersona")
        }

        return op.get()
    }


    @Throws(BusinessException::class, NotFoundException::class)
    override fun save(persona: Persona): Persona {

        try {
            return personaRepository!!.save(persona)
        } catch (e: Exception){
            throw BusinessException(e.message)
        }
    }

    @Throws(BusinessException::class)
    override fun remove(idPersona: Long) {
        val op: Optional<Persona>
        try {
            op = this.personaRepository!!.findById(idPersona)
        } catch (e: Exception){
            throw BusinessException(e.message)
        }

        if (!op.isPresent){
            throw NotFoundException("No se encontro la persona con id $idPersona")
        } else {
            try {
                personaRepository!!.deleteById(idPersona)
            } catch (e: Exception){
                throw BusinessException(e.message)
            }
        }
    }
}