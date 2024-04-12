package com.example.bookcrud.services;

import com.example.bookcrud.entities.Libro;
import com.example.bookcrud.entities.enums.StatoLibroEnum;
import com.example.bookcrud.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public Libro create(Libro libro){
        return libroRepository.save(libro);
    }

    public List<Libro> libroList() {
        return libroRepository.findAll();
    }

    public Optional<Libro> getLibro(Long id) {
        return libroRepository.findById(id);
    }

    public Optional<Libro> updateLibro(Libro libro, Long id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()) {
            libroOptional.get().setTitolo(libro.getTitolo());
            libroOptional.get().setAutore(libro.getAutore());
            Libro libroUpdate = libroRepository.save(libroOptional.get());
            return Optional.of(libroUpdate);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Libro> deleteLibro(Long id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()) {
            libroRepository.delete(libroOptional.get());
        } else {
            return Optional.empty();
        }
        return libroOptional;
    }

    public Optional<Libro> prestaLibro(Long id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        //dobbiamo controllare che il libro da prestare sia disponibile e che sia minore di 2
        if (libroOptional.isPresent()) {
            if (libroOptional.get().getStatoLibroEnum().equals(StatoLibroEnum.DISPONIBILE)
                    && libroRepository.countLibriInPrestito() <= 2) {
                libroOptional.get().setStatoLibroEnum(StatoLibroEnum.PRESTATO);
                Libro libroSaved = libroRepository.save(libroOptional.get());
                return Optional.of(libroSaved);
            }
        }
        return Optional.empty();
    }

    public Optional<Libro> restituisciLibro(Long id) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        // Controlliamo che il libro da restituire sia prestato
        if (libroOptional.isPresent()) {
            if (libroOptional.get().getStatoLibroEnum().equals(StatoLibroEnum.PRESTATO)) {
                libroOptional.get().setStatoLibroEnum(StatoLibroEnum.DISPONIBILE);
                Libro libroSaved = libroRepository.save(libroOptional.get());
                return Optional.of(libroSaved);
            }
        }
        return Optional.empty();
    }

}
