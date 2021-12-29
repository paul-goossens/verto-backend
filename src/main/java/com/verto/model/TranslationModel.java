package com.verto.model;

public class TranslationModel {
    private Integer id;
    private String value;
    private Integer labelId;
    private Integer languageId;

    public TranslationModel(Integer id, String value, Integer labelId, Integer languageId) {
        this.id = id;
        this.value = value;
        this.labelId = labelId;
        this.languageId = languageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }
}
