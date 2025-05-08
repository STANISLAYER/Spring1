package com.example.spring1.mapper;

import com.example.spring1.dto.BookDTO;
import com.example.spring1.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "publisher.id", target = "publisherId")
    @Mapping(target = "categoryIds", expression = "java(book.getCategories() != null ? book.getCategories().stream().map(c -> c.getId()).toList() : null)")
    BookDTO toDTO(Book book);

    @Mapping(target = "author", ignore = true)
    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "categories", ignore = true)
    Book toEntity(BookDTO dto);
}
