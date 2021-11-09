package com.recantogeek.recantogeekv2.mapper;

import com.recantogeek.recantogeekv2.dto.NewProductDTO;
import com.recantogeek.recantogeekv2.dto.OneProductDTO;
import com.recantogeek.recantogeekv2.dto.ProductsListDTO;
import com.recantogeek.recantogeekv2.dto.UpdateProductDTO;
import com.recantogeek.recantogeekv2.models.ProductModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductsListDTO productListToDTO(ProductModel productModel);

    OneProductDTO oneProductToDTO(ProductModel productModel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdBy", expression = "java(productModel.formatDate())")
    @Mapping(target = "installments", expression = "java(productModel.calcInstallment())")
    ProductModel toObj(NewProductDTO newProductDTO);

    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "installments", ignore = true)
    ProductModel toUpdateObj(UpdateProductDTO updateProductDTO);


}
