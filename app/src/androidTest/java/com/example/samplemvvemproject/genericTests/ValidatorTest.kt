package com.example.samplemvvemproject.genericTests

import com.example.samplemvvemproject.utils.validator.Validator
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ValidatorTest {

    @Test
    fun testValidEmail() {
        val validEmails = listOf(
            "name.doe@example.com",
            "some_name@company.net",
            "info1234@domain.co"
        )

        for (email in validEmails) {
            assertTrue("$email should be a valid email", Validator.isValidEmail(email))
        }
    }

    @Test
    fun testInvalidEmail() {
        val invalidEmails = listOf(
            "name.doe@example",
            "some_name@",
            "info1234@domain",
            "invalidemail",
            "john.doe@example..com"
        )

        for (email in invalidEmails) {
            assertFalse("$email should be an invalid email", Validator.isValidEmail(email))
        }
    }

    @Test
    fun testValidPhoneNumber() {
        val validPhoneNumbers = listOf(
            "+1 (555) 123-4567",
            "123-456-7890",
            "+91 9876543210",
            "5555555555",
            "+92 3329595789"
        )

        for (phoneNumber in validPhoneNumbers) {
            assertTrue("$phoneNumber should be a valid phone number", Validator.isValidPhoneNumber(phoneNumber))
        }
    }

    @Test
    fun testInvalidPhoneNumber() {
        val invalidPhoneNumbers = listOf(
            "123-456",
            "9876543210",
            "invalidphone",
            "+1 (555) 123-4567x",
            "123 456 7890"
        )

        for (phoneNumber in invalidPhoneNumbers) {
            assertFalse("$phoneNumber should be an invalid phone number", Validator.isValidPhoneNumber(phoneNumber))
        }
    }
}
