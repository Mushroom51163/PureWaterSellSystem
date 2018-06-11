package com.purewatersellsystem.service;

import com.purewatersellsystem.entity.Product;
import com.purewatersellsystem.entity.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarketService {
    Result<List<Product>> findProducts();

    Result<Product> findProductByName(String productName);

    Result deleteProduct(String id);

    Result<Product> findProductById(String productId);

    Result updateProductById(String productName, String productPrice, String productDesc, String productPic, Integer isDiscount, String discountRate,String productId);
    Result addProduct(String productName,String productPrice,String productDesc,String productPic,Integer isDiscount,String discountRate);

    Result<String> countProduct(String productName);


}
