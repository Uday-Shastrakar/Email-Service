package com.email.email.service

import com.email.email.api.sendOtpCommandDto
import jakarta.mail.internet.MimeMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

const val SUBJECT = "Verification Code"
const val FROM = "nirmitrsawlekar@gmail.com"

@Service
class EmailService(@Autowired val javaMailSender: JavaMailSender) {

    fun sendOtp(dto: sendOtpCommandDto){
        val (email,otp) = dto
    }

    private fun sendEmail(email:String){
        val message: MimeMessage = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(message,true,"UTF-8")

        helper.setFrom(FROM)
        helper.setTo(email)
        helper.setSubject(SUBJECT)
        javaMailSender.send(message)
    }
}