package com.purewatersellsystem.mapper;

import com.purewatersellsystem.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {
    @Select("select * from market")
    List<Product> findAllProduct();

    @Select("select * from market where productName=#{productName}")
    Product findProductByName(@Param("productName") String productName);

    @Delete("delete from market where productId=#{productId}")
    Integer deleteProduct(@Param("productId") String productId);

    @Select("select * from market where productId=#{productId}")
    Product findProductById(@Param("productId") String productId);

    @Update("update market set productName=#{productName},productPrice=#{productPrice},productDesc=#{productDesc},productPic=#{productPic},isDiscount=#{isDiscount},discountRate=#{discountRate} where productId=#{productId}")
    Integer updateProductById(@Param("productName") String productName, @Param("productPrice") String productPrice, @Param("productDesc") String productDesc, @Param("productPic") String productPic, @Param("isDiscount") Integer isDiscount, @Param("discountRate") String discountRate,@Param("productId") String productId);

    @Insert("insert into market values (#{productId},#{productName},#{productPrice},#{productDesc},#{productPic},#{isDiscount},#{discountRate})")
    Integer addProduct(Product product);

    @Select("select count(*) from `order` where productId=#{productId} and doneTime like #{time}")
    String countProduct(@Param("productId") String productId,@Param("time") String time);
}