package org.example.service.impl;

import org.example.dto.CategoryDTO;
import org.example.entity.Category;
import org.example.exception.ResourceNotFoundException;
import org.example.payload.ApiResponse;
import org.example.repository.CategoryRepository;
import org.example.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private static final String RESOURCE_NAME = "Category";
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        categories.stream().forEach(category -> {
            categoryDTOs.add(modelMapper.map(category, CategoryDTO.class));
        });
        return new ResponseEntity<>(categoryDTOs,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDTO> findOne(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(RESOURCE_NAME,"id",id));
        return new ResponseEntity<>(modelMapper.map(category,CategoryDTO.class),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDTO> save(CategoryDTO categoryDTO) {
        Category category = null;
        if(categoryDTO.getCategoryId()!=0){
             category = categoryRepository.findById(categoryDTO.getCategoryId())
                     .orElseThrow(()->new ResourceNotFoundException(RESOURCE_NAME,"id",categoryDTO.getCategoryId()));
        }
        category = modelMapper.map(categoryDTO,Category.class);
        category = categoryRepository.save(category);
        return new ResponseEntity<>(modelMapper.map(category,CategoryDTO.class),
                categoryDTO.getCategoryId()==0?HttpStatus.CREATED:HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> delete(long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(RESOURCE_NAME,"id",id));
        categoryRepository.delete(category);
        ApiResponse apiResponse = new ApiResponse(Boolean.TRUE,"You successfully deleted category");
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
