package com.example.spring1.controller;

import com.example.spring1.dto.BookDTO;
import com.example.spring1.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService service;

    @GetMapping
    public List<BookDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public BookDTO create(@RequestBody BookDTO dto) {
        return service.save(dto);
    }
    @PutMapping("/{id}")
    public BookDTO update(@PathVariable Long id, @RequestBody BookDTO dto) {
        dto.setId(id);
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
