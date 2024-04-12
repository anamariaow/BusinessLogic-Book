package com.example.bookcrud.repositories;

import com.example.bookcrud.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    @Query("SELECT COUNT(l.id) FROM Libro l WHERE l.statoLibroEnum = PRESTATO")
    Integer countLibriInPrestito();
}
