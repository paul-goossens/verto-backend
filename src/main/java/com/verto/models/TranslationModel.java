package com.verto.models;

public class TranslationModel {
    private String keyId;
    private String key;
    private String valueId;
    private String value;

    public TranslationModel(String keyId, String key, String valueId, String value) {
        this.keyId = keyId;
        this.key = key;
        this.valueId = valueId;
        this.value = value;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
