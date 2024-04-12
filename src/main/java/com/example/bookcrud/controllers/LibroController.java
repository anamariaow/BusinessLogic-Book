package com.example.bookcrud.controllers;

import com.example.bookcrud.entities.Libro;
import com.example.bookcrud.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @PostMapping("/create")
    public ResponseEntity<Libro> postLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok().body(libroService.create(libro));
    }

    @GetMapping("/listalibri")
    public ResponseEntity<List<Libro>> getLibroList() {
        return ResponseEntity.ok().body(libroService.libroList());
    }

    @GetMapping("libri/{id}")
    public ResponseEntity<Libro> getLibro(@PathVariable Long id) {
        Optional<Libro> libroOptional = libroService.getLibro(id);
        if (libroOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(libroOptional.get());
    }

    @PutMapping("updatelibro/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        Optional<Libro> libroOptional = libroService.updateLibro(libro, id);
        if (libroOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(libroOptional.get());
    }

    @GetMapping("/prestalibro/{id}")
    public ResponseEntity<Libro> prestaLibro(@PathVariable Long id) {
        Optional<Libro> libroPrestato = libroService.prestaLibro(id);
        if (libroPrestato.isPresent()) {
            return ResponseEntity.ok(libroPrestato.get());
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/restituiscilibro/{id}")
    public ResponseEntity<Libro> restituisciLibro(@PathVariable Long id) {
        Optional<Libro> libroRestituito = libroService.restituisciLibro(id);
        if (libroRestituito.isPresent()) {
            return ResponseEntity.ok(libroRestituito.get());
        } else {
            return ResponseEntity.ok().build();
        }
    }
}
