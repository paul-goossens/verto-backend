package com.verto.models;

public class TranslationModel {
    private String guid;
    private String key;
    private String value;
    private Boolean isGroup;
    private String languageGuid;

    public TranslationModel(String guid, String key, String value, Boolean isGroup, String languageGuid) {
        this.guid = guid;
        this.key = key;
        this.value = value;
        this.isGroup = isGroup;
        this.languageGuid = languageGuid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getIsGroup() {
        return this.isGroup;
    }

    public void setIsGroup(Boolean isGroup) {
        this.isGroup = isGroup;
    }

    public String getLanguageGuid() {
        return languageGuid;
    }

    public void setLanguageGuid(String languageGuid) {
        this.languageGuid = languageGuid;
    }
}
