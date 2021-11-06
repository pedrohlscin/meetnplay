package com.example.apsProject.model;

public class Adm {

    private String admName;
    private String code;

    public Adm(String admName) {
        this.admName = admName;
        this.code = "ADM";
    }

    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
