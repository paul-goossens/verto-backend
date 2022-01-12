package com.verto.models;

public class LanguageModel {
    private String keyId;
    private String key;

    public LanguageModel(String keyId, String key) {
        this.keyId = keyId;
        this.key = key;
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
}
