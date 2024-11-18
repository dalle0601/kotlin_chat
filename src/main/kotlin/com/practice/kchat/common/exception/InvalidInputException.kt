package com.practice.kchat.common.exception

import java.lang.RuntimeException

class InvalidInputException (
        val fieldname: String = "",
        message: String = "Invalid Input"
) : RuntimeException(message)