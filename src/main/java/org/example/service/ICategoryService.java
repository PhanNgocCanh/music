package org.example.service;

import org.example.dto.CategoryDTO;
import org.example.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICategoryService {
    ResponseEntity<List<CategoryDTO>> findAll();
    ResponseEntity<CategoryDTO> findOne(long id);
    ResponseEntity<CategoryDTO> save(CategoryDTO categoryDTO);
    ResponseEntity<ApiResponse> delete(long id);
}
