package com.project.warehouseservice.model.mapper;

import com.project.warehouseservice.model.Product;
import com.project.warehouseservice.model.dto.ProductDTO;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    public static ProductDTO toDTO(Product product){

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.createTypeMap(Product.class,ProductDTO.class).addMappings(mapper->{
                    mapper.map(src -> src.getId(),ProductDTO::setId);
                    mapper.map(src-> src.getQuantity(),ProductDTO::setQuantity);
                    mapper.map(src-> src.getProductName(),ProductDTO::setProductName);
                    mapper.map(src-> src.getPrice(),ProductDTO::setPrice);
            mapper.map(src-> product.getLocation().getAddress(),ProductDTO::setLocationName);
            mapper.map(src->src.getProductCategory().getCategoryName(),ProductDTO::setProductCategoryName);
                });
        return modelMapper.map(product,ProductDTO.class);
    }
}
