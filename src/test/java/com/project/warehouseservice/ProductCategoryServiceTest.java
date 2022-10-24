package com.project.warehouseservice;

import com.project.warehouseservice.contracts.ProductCategoryRequest;
import com.project.warehouseservice.model.ProductCategory;

import com.project.warehouseservice.repository.ProductCategoryRepository;
import com.project.warehouseservice.service.ProductCategoryService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
class ProductCategoryServiceTest {
/*
    @Autowired
    private ProductCategoryService productCategoryService;

    @MockBean
    private ProductCategoryRepository productCategoryRepository;
    private String productCategoryName="Household Appliances";

    private ProductCategory generateProductCategoryObject(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName(productCategoryName);
        productCategory.setId(1L);
        return productCategory;
    }

    @Test
    public void addProductCategoryTest(){

        when(productCategoryRepository.saveAndFlush(any(ProductCategory.class))).thenReturn(generateProductCategoryObject());
        assertEquals(1L,productCategoryService.addProductCategory(productCategoryName).longValue());

    }

    @Test
    public void updateProductCategoryTest(){
        ProductCategoryRequest request= new ProductCategoryRequest();
        request.setProductCategoryId(1L);
        request.setCategoryName("SAMPLE");
        when(productCategoryRepository.findById(request.getProductCategoryId())).thenReturn(Optional.of(generateProductCategoryObject()));
        when(productCategoryRepository.save(any(ProductCategory.class))).thenReturn(generateProductCategoryObject());
        assertEquals(HttpStatus.OK,productCategoryService.updateProductCategory(request).getStatusCode());

    }

    @Test
    public void deleteProductCategoryTest()  {
        Long categoryId=1L;
        when(productCategoryRepository.findById(categoryId)).thenReturn(Optional.of(generateProductCategoryObject()));
        assertEquals(HttpStatus.OK,productCategoryService.deleteProductCategory(categoryId).getStatusCode());

    }

    @Test
    public void getProductCategoryTest()  {
        when(productCategoryRepository.findAll()).thenReturn(Stream.of(new ProductCategory(productCategoryName)).collect(Collectors.toList()));
        assertEquals(1,productCategoryService.retrieveAllProductCategory().size());
    }

*/


}
