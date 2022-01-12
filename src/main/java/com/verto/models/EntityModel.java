package com.verto.models;

public class EntityModel {
    private String id;
    private String memberOf;
    private Boolean isGroup;
    private String languageKeyId;
    private String languageKey;
    private String translationKeyId;
    private String translationKey;
    private String translationValueId;
    private String translationValue;

    public EntityModel(String id, String memberOf, Boolean isGroup, String languageKeyId, String languageKey, String translationKeyId, String translationKey, String translationValueId, String translationValue) {
        this.id = id;
        this.memberOf = memberOf;
        this.isGroup = isGroup;
        this.languageKeyId = languageKeyId;
        this.languageKey = languageKey;
        this.translationKeyId = translationKeyId;
        this.translationKey = translationKey;
        this.translationValueId = translationValueId;
        this.translationValue = translationValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }

    public Boolean getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(Boolean isGroup) {
        this.isGroup = isGroup;
    }

    public String getLanguageKeyId() {
        return languageKeyId;
    }

    public void setLanguageKeyId(String languageKeyId) {
        this.languageKeyId = languageKeyId;
    }

    public String getTranslationKeyId() {
        return translationKeyId;
    }

    public void setTranslationKeyId(String translationKeyId) {
        this.translationKeyId = translationKeyId;
    }

    public String getTranslationValueId() {
        return translationValueId;
    }

    public void setTranslationValueId(String translationValueId) {
        this.translationValueId = translationValueId;
    }

    public String getLanguageKey() {
        return languageKey;
    }

    public void setLanguageKey(String languageKey) {
        this.languageKey = languageKey;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public void setTranslationKey(String translationKey) {
        this.translationKey = translationKey;
    }

    public String getTranslationValue() {
        return translationValue;
    }

    public void setTranslationValue(String translationValue) {
        this.translationValue = translationValue;
    }
}
