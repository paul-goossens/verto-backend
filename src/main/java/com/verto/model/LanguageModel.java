package com.verto.model;

public class LanguageModel {
    private String guid;
    private String value;

    public LanguageModel(String guid, String value) {
        this.guid = guid;
        this.value = value;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
