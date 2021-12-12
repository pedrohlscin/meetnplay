package com.example.apsProject.model;

public class Adm {

    private String name;
    private String code;

    public Adm(String name) {
        this.name = name;
        this.code = "ADM";
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
