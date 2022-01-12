package com.verto.models;

public class EntityModel {
    private String id;
    private String memberOf;
    private Boolean isGroup;
    private LanguageModel language;
    private TranslationModel translation;

    public EntityModel(String id, String memberOf, Boolean isGroup, LanguageModel language, TranslationModel translation) {
        this.id = id;
        this.memberOf = memberOf;
        this.isGroup = isGroup;
        this.language = language;
        this.translation = translation;
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

    public LanguageModel getLanguage() {
        return language;
    }

    public void setLanguage(LanguageModel language) {
        this.language = language;
    }

    public TranslationModel getTranslation() {
        return translation;
    }

    public void setTranslation(TranslationModel translation) {
        this.translation = translation;
    }

}
