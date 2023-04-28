package org.example.controller.api;

import io.swagger.annotations.Api;
import org.example.dto.CategoryDTO;
import org.example.payload.ApiResponse;
import org.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> home() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("id") long id) {
        return categoryService.findOne(id);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
        return categoryService.save(categoryDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable("id") long id,
                                                      @RequestBody CategoryDTO categoryDTO) {
        categoryDTO.setCategoryId(id);
        return categoryService.save(categoryDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("id") long id){
        return categoryService.delete(id);
    }
}
