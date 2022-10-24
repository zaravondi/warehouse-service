package com.project.warehouseservice.service;

import com.project.warehouseservice.contracts.ProductCreateRequest;
import com.project.warehouseservice.contracts.ProductUpdateRequest;
import com.project.warehouseservice.model.Product;
import com.project.warehouseservice.model.dto.ProductDTO;
import com.project.warehouseservice.model.mapper.ProductMapper;
import com.project.warehouseservice.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ProductService {
    private static final Logger logger= LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LocationService locationService;

    @Autowired
    private ProductCategoryService productCategoryService;


    public Long addProduct(ProductCreateRequest request) {
            Product product=new Product();
            product.setProductCategory(productCategoryService.retrieveProductCategoryById(request.getProductCategoryId()));
            product.setProductName(request.getProductName());
            product.setPrice(request.getPrice());
            product.setLocation(locationService.retrieveLocationById(request.getLocationId()));
            product.setQuantity(request.getQuantity());
            return productRepository.saveAndFlush(product).getId();

    }

    public ResponseEntity<String> deleteProduct(Long productId) {

        try{
            Optional<Product> productOptional =productRepository.findById(productId);
            if(productOptional.isPresent()){
                productRepository.deleteById(productId);
            }
            else{
                logger.error("Given product id could not find database" +productId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);            }
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok().build();    }
    public ProductDTO retrieveProductById(Long productId){
        ProductDTO productDTO =new ProductDTO();
        try{
            Optional<Product> productOptional =productRepository.findById(productId);
            if(productOptional.isPresent()){
               return ProductMapper.toDTO(productOptional.get());
            }
            else{
                throw new Exception("Given id product not found");
            }
        }
        catch (Exception e){
             logger.error(e.getMessage());
        }
    return productDTO;
    }
    public List<ProductDTO> retrieveAll(){
        return productRepository.findAll().stream().map(p-> ProductMapper.toDTO(p)).collect(Collectors.toList());

    }

    public ResponseEntity<String> updateProduct(ProductUpdateRequest request) {

        try{
            Optional<Product> productOptional =productRepository.findById(request.getProductId());
            if(productOptional.isPresent()){
                Product product= productOptional.get();
                product.setProductCategory(productCategoryService.retrieveProductCategoryById(request.getProductCategoryId()));
                product.setProductName(request.getProductName());
                product.setPrice(request.getPrice());
                product.setLocation(locationService.retrieveLocationById(request.getLocationId()));
                product.setQuantity(request.getQuantity());
                productRepository.save(product);
            }
            else{
                logger.error("Given product id could not find database" +request.getProductId());
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);            }
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok().build();    }

    public List<ProductDTO> searchProduct(String productName) {
        List<Product> products= productRepository.findByProductNameContainingIgnoreCase(productName);
        List<ProductDTO> productDTOS= products.stream().map(p->ProductMapper.toDTO(p)).collect(Collectors.toList());
        Collections.sort(productDTOS);
        return productDTOS;
    }
}
