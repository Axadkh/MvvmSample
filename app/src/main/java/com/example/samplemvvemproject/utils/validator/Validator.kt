package com.example.samplemvvemproject.utils.validator

object Validator {
    private val emailRegex = Regex("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+\$")
    //private val phoneNumberRegex = Regex("^\\+\\d{1,3}\\s?\\(\\d{1,4}\\)\\s?\\d{1,4}-\\d{1,9}\$")
    private val phoneNumberRegex = Regex("^(\\+\\d{1,3}\\s?)?(\\(\\d{1,4}\\))?\\s?\\d{1,4}-\\d{1,9}\$")

        fun isValidEmail(email: String): Boolean {
            return email.matches(emailRegex)
        }

        fun isValidPhoneNumber(phoneNumber: String): Boolean {
            return phoneNumber.matches(phoneNumberRegex)
        }


}