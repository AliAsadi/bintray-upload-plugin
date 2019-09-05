package com.aliasadi.util

import com.aliasadi.exceptions.ValidateException
import com.aliasadi.extension.UploadExtension

class Validator {

    static void validate(UploadExtension uploadExtension) throws ValidateException {
        def requirementVars = uploadExtension.getRequirementObjects()
        def errorMessage = new StringBuilder()

        uploadExtension.updateGitUrl()

        for (Map.Entry<String, Object> entry : requirementVars.entrySet()) {
            if (entry.value == null) errorMessage.append('Missing ').append(entry.key).append(". ")
        }

        if (errorMessage) throw new ValidateException(errorMessage.toString())
    }


}