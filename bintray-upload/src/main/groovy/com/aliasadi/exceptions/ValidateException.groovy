package com.aliasadi.exceptions

/**
 * Created by Ali Asadi on 05/09/2019.
 */
class ValidateException extends IllegalStateException {

    ValidateException(String error) {
        super("Have you created the uploadToBintray closure? $error")
    }
}