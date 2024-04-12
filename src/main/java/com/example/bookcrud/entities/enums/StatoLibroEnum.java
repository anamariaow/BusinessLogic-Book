package com.example.bookcrud.entities.enums;

public enum StatoLibroEnum {
    DISPONIBILE("Disponibile"),
    PRESTATO("Prestato");
    private String descrizione;

    StatoLibroEnum(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
