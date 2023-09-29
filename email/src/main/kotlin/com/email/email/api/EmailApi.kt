package com.email.email.api

import com.email.email.service.EmailService
import com.fasterxml.jackson.core.util.RequestPayload
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/email-service")
class EmailApi(@Autowired private val service:EmailService) {

    @PostMapping("send-otp")
    fun sendEmail(@RequestBody payload: sendOtpCommandDto){
        service.sendOtp(payload)
    }

}

data class sendOtpCommandDto(
    val email:String,
    val otp:String,
)