package com.LeagueSocial.Resources.Exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

    private String fieldMesage;
    private String mesasge;

    public FieldMessage(){}

    public FieldMessage(String fieldMesage, String mesasge) {
        this.fieldMesage = fieldMesage;
        this.mesasge = mesasge;
    }

    public String getFieldMesage() {
        return fieldMesage;
    }

    public void setFieldMesage(String fieldMesage) {
        this.fieldMesage = fieldMesage;
    }

    public String getMesasge() {
        return mesasge;
    }

    public void setMesasge(String mesasge) {
        this.mesasge = mesasge;
    }
}
