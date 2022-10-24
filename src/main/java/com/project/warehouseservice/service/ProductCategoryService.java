package com.project.warehouseservice.service;

import com.project.warehouseservice.contracts.ProductCategoryRequest;
import com.project.warehouseservice.model.ProductCategory;
import com.project.warehouseservice.model.dto.ProductCategoryDTO;
import com.project.warehouseservice.model.mapper.ProductCategoryMapper;
import com.project.warehouseservice.repository.ProductCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService {
    private static final Logger logger= LoggerFactory.getLogger(ProductCategoryService.class);

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    public Long addProductCategory(String categoryName) {
        ProductCategory productCategory= new ProductCategory();
        productCategory.setCategoryName(categoryName);
        return productCategoryRepository.saveAndFlush(productCategory).getId();

    }

    public ResponseEntity<String> updateProductCategory(ProductCategoryRequest request) {
        try{
            Optional<ProductCategory> productCategoryOptional =productCategoryRepository.findById(request.getProductCategoryId());
            if(productCategoryOptional.isPresent()){
                ProductCategory productCategory= productCategoryOptional.get();
                productCategory.setCategoryName(request.getCategoryName());
                productCategoryRepository.save(productCategory);
            }
            else{
                logger.error("Given product category id could not find database" +request.getProductCategoryId());
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<String>  deleteProductCategory(Long productCategoryId) {
        try{
            Optional<ProductCategory> productCategoryOptional =productCategoryRepository.findById(productCategoryId);
            if(productCategoryOptional.isPresent()){
                productCategoryRepository.deleteById(productCategoryId);
            }
            else{
                logger.error("Given product category id could not find database" + productCategoryId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
    public  ProductCategory  retrieveProductCategoryById(Long productCategoryId){
        return productCategoryRepository.findById(productCategoryId).orElseThrow(()-> null);
    }
    public List<ProductCategoryDTO> retrieveAllProductCategory() {
        return productCategoryRepository.findAll().stream().map(p-> ProductCategoryMapper.toDTO(p)).collect(Collectors.toList());
    }
}
