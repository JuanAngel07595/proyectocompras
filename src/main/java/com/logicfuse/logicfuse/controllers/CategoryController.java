package com.logicfuse.logicfuse.controllers;


import com.logicfuse.logicfuse.dto.ResponseDTO;
import com.logicfuse.logicfuse.models.CategoryModel;
import com.logicfuse.logicfuse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/category")
public class CategoryController {

    @Autowired

    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllCategories() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> saveCategory(@RequestBody CategoryModel categoryModel) {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.saveCategory(categoryModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> updateCategory(@PathVariable Integer categoria_id, @RequestBody CategoryModel categoryModel) {
        categoryModel.setCategoria_id(categoria_id);
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.updateCategory(categoryModel));
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer categoria_id) {
        categoryService.deleteCategory(categoria_id);
    }
}
