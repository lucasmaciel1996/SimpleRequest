package com.example.simplerequestbio.models;

public class Biometria {
    private String renach;
    private String cpf;
    private String biometria;

    @Override
    public String toString() {
        return "Biometria{" +
                "renach='" + renach + '\'' +
                ", cpf='" + cpf + '\'' +
                ", biometria='" + biometria + '\'' +
                '}';
    }

    public String getRenach() {
        return renach;
    }

    public void setRenach(String renach) {
        this.renach = renach;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBiometria() {
        return biometria;
    }

    public void setBiometria(String biometria) {
        this.biometria = biometria;
    }
}
