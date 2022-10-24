package com.project.warehouseservice.controller;

import com.project.warehouseservice.contracts.ProductCreateRequest;
import com.project.warehouseservice.contracts.ProductUpdateRequest;
import com.project.warehouseservice.model.dto.ProductDTO;
import com.project.warehouseservice.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add")
    @Operation(summary = "add product from database")
    public ResponseEntity<Long> addProduct(@RequestBody @Valid ProductCreateRequest request){
        return new ResponseEntity<>(productService.addProduct(request), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    @Operation(summary = "delete product by id from database")
    public ResponseEntity<String> deleteProduct(@RequestParam("productId") Long productId ){
        return productService.deleteProduct(productId);

    }

    @PutMapping(value = "/update")
    @Operation(summary = "update product from database")
    public ResponseEntity<String> updateProduct(@RequestBody @Valid ProductUpdateRequest request ){
        return productService.updateProduct(request);
    }

    @GetMapping(value = "/retrieveById")
    @Operation(summary = "retrieve product with given id")
    public ResponseEntity<ProductDTO> retrieveProductById(@RequestParam("productId") Long productId){
        return new ResponseEntity<>(productService.retrieveProductById(productId), HttpStatus.OK);
    }

    @GetMapping(value = "/retrieve")
    @Operation(summary = "retrieve all product  from database")
    public ResponseEntity<List<ProductDTO>> retrieveAllProduct(){
        return new ResponseEntity<>(productService.retrieveAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/search/{productName}")
    @Operation(summary = "retrieve all product  from database")
    public ResponseEntity<List<ProductDTO>> searchProduct(@PathVariable("productName") String productName){
        return new ResponseEntity<>(productService.searchProduct(productName), HttpStatus.OK);
    }
    
}
