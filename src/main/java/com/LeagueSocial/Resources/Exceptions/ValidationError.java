package com.LeagueSocial.Resources.Exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void AddError(String fieldname  , String message) {
        errors.add(new FieldMessage(fieldname, message));
    }

}
