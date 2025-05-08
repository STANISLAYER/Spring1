package com.example.spring1.mapper;

import com.example.spring1.dto.CategoryDTO;
import com.example.spring1.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category toEntity(CategoryDTO dto);
}
