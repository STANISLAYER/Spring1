package com.example.spring1.mapper;

import com.example.spring1.dto.AuthorDTO;
import com.example.spring1.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDTO toDTO(Author author);
    Author toEntity(AuthorDTO dto);
}
