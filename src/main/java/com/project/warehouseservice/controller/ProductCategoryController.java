package com.project.warehouseservice.controller;

import com.project.warehouseservice.contracts.ProductCategoryCreateRequest;
import com.project.warehouseservice.model.dto.ProductCategoryDTO;
import com.project.warehouseservice.service.ProductCategoryService;
import com.project.warehouseservice.contracts.ProductCategoryRequest;
import com.project.warehouseservice.model.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "/api/product-category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @PostMapping(value = "/add")
    @Operation(summary = "add product category from database")
    public ResponseEntity<Long> addProductCategory(@RequestBody @Valid ProductCategoryCreateRequest request){
        return new ResponseEntity<>(productCategoryService.addProductCategory(request.getCategoryName()), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    @Operation(summary = "update product category from database")
    public ResponseEntity<String> updateProductCategory(@RequestBody @Valid ProductCategoryRequest request ){
        return productCategoryService.updateProductCategory(request);
    }

    @DeleteMapping(value = "/delete")
    @Operation(summary = "delete product category from database")
    public ResponseEntity<String> deleteProductCategory(@RequestParam("productCategoryId")  @NotNull Long productCategoryId ){
        return  productCategoryService.deleteProductCategory(productCategoryId);
    }

    @GetMapping(value = "/retrieve")
    @Operation(summary = "retrieve all product category from database")
    public ResponseEntity<List<ProductCategoryDTO>> retrieveAllProductCategory(){
        return new ResponseEntity<>(productCategoryService.retrieveAllProductCategory(), HttpStatus.OK);
    }
}
