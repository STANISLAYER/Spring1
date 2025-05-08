package com.example.spring1.controller;

import com.example.spring1.dto.AuthorDTO;
import com.example.spring1.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService service;

    // READ
    @GetMapping
    public List<AuthorDTO> getAll() {
        return service.getAllAuthors();
    }

    @PostMapping
    // CREATE
    public AuthorDTO create(@RequestBody AuthorDTO dto) {
        return service.saveAuthor(dto);
    }
    // UPDATE
    @PutMapping("/{id}")
    public AuthorDTO update(@PathVariable Long id, @RequestBody AuthorDTO dto) {
        dto.setId(id);
        return service.updateAuthor(dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAuthor(id);
    }
}
