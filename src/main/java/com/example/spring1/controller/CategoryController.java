package com.example.spring1.controller;

import com.example.spring1.dto.CategoryDTO;
import com.example.spring1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public List<CategoryDTO> getAll() {
        return service.getAll();
    }

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return service.save(dto);
    }

    // Обновление категории по id
    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
        dto.setId(id);
        return service.update(dto);
    }

    // Удаление категории по id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
