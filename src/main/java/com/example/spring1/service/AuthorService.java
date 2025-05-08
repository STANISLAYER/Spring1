package com.example.spring1.service;

import com.example.spring1.dto.AuthorDTO;
import com.example.spring1.entity.Author;
import com.example.spring1.mapper.AuthorMapper;
import com.example.spring1.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    public List<AuthorDTO> getAllAuthors() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public AuthorDTO saveAuthor(AuthorDTO dto) {
        Author author = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(author));
    }
    public AuthorDTO updateAuthor(AuthorDTO dto) {
        Author author = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(author));
    }

    public void deleteAuthor(Long id) {
        repository.deleteById(id);
    }

}
