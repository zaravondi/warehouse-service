package com.project.warehouseservice.model.mapper;

import com.project.warehouseservice.model.ProductCategory;
import com.project.warehouseservice.model.dto.ProductCategoryDTO;
import org.modelmapper.ModelMapper;

public class ProductCategoryMapper {

    public static ProductCategoryDTO toDTO(ProductCategory productCategory){

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(productCategory,ProductCategoryDTO.class);
    }
}
