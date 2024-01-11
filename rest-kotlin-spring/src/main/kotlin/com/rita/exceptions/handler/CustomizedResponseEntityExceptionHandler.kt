package com.rita.exceptions.handler

import com.rita.exceptions.ExceptionsResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.util.Date

// @ControllerAdvice : concentra um tratamento global do controler
@ControllerAdvice
@RestController
class CustomizedResponseEntityExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(Exception::class)
    fun handleAllException(ex: Exception, request: WebRequest): ResponseEntity<ExceptionsResponse>{
        val exceptionsResponse = ExceptionsResponse(
            // data
            Date(),
            // mensagem
            ex.message,
            // nao precisamos de descricao
            request.getDescription(false)
        )

        return ResponseEntity<ExceptionsResponse>(exceptionsResponse, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(com.rita.exceptions.ResourceNotfoundException::class)
    fun ResourceNotfoundException(ex: Exception, request: WebRequest): ResponseEntity<ExceptionsResponse>{
        val exceptionsResponse = ExceptionsResponse(
            Date(),
            ex.message,
            request.getDescription(false)
        )

        return ResponseEntity<ExceptionsResponse>(exceptionsResponse, HttpStatus.BAD_REQUEST)
    }
}