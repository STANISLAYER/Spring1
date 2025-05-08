package com.example.spring1.service;

import com.example.spring1.dto.BookDTO;
import com.example.spring1.entity.Author;
import com.example.spring1.entity.Book;
import com.example.spring1.entity.Category;
import com.example.spring1.entity.Publisher;
import com.example.spring1.mapper.BookMapper;
import com.example.spring1.repository.AuthorRepository;
import com.example.spring1.repository.BookRepository;
import com.example.spring1.repository.CategoryRepository;
import com.example.spring1.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository repository;
    private final BookMapper mapper;

    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;

    public List<BookDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    public BookDTO save(BookDTO dto) {
        Book book = mapper.toEntity(dto);

        if (dto.getAuthorId() == null) {
            throw new IllegalArgumentException("Поле authorId обязательно для книги.");
        }
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("Автор не найден: " + dto.getAuthorId()));

        List<Category> categories = categoryRepository.findAllById(dto.getCategoryIds());

        book.setAuthor(author);
        book.setCategories(categories);

        if (dto.getPublisherId() != null) {
            publisherRepository.findById(dto.getPublisherId()).ifPresentOrElse(
                    book::setPublisher,
                    () -> book.setPublisher(null)
            );
        } else {
            book.setPublisher(null);
        }



        return mapper.toDTO(repository.save(book));
    }

    public BookDTO update(BookDTO dto) {
        return save(dto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
