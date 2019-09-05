package com.aliasadi.exceptions

class ValidateException extends IllegalStateException {

    ValidateException(String error) {
        super("Have you created the uploadToBintray closure? $error")
    }
}