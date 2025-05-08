package com.example.spring1.dto;

import lombok.Data;
import java.util.List;

@Data
public class LibraryDTO {
    private Long id;
    private String name;
    private List<String> bookTitles;
}
