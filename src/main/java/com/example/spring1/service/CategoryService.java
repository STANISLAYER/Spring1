package com.example.spring1.service;

import com.example.spring1.dto.CategoryDTO;
import com.example.spring1.entity.Category;
import com.example.spring1.mapper.CategoryMapper;
import com.example.spring1.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    public List<CategoryDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO save(CategoryDTO dto) {
        Category category = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(category));
    }


    public CategoryDTO update(CategoryDTO dto) {
        Category category = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(category));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
