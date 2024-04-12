package com.example.bookcrud.entities;

import com.example.bookcrud.entities.enums.StatoLibroEnum;
import jakarta.persistence.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private String autore;
    private Integer annoPubblicazione;
    @Enumerated(EnumType.STRING)
    private StatoLibroEnum statoLibroEnum;

    public Libro(Long id, String titolo, String autore, Integer annoPubblicazione, StatoLibroEnum statoLibroEnum) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.statoLibroEnum = statoLibroEnum;
    }

    public Libro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public StatoLibroEnum getStatoLibroEnum() {
        return statoLibroEnum;
    }

    public void setStatoLibroEnum(StatoLibroEnum statoLibroEnum) {
        this.statoLibroEnum = statoLibroEnum;
    }
}
