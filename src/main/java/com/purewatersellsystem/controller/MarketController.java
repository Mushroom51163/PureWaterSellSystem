package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Product;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.MarketService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
//商城
@Controller
public class MarketController {

    @Resource
    private MarketService marketService;

    //跳转到商城页面
    @RequestMapping("/market")
    public String goToMarket() {
        return "market";
    }

    //查找所有商品
    @RequestMapping("/findAllProducts")
    @ResponseBody
    public Result<List<Product>> getProducts() {

        return marketService.findProducts();
    }

    //按照商品名查找商品
    @RequestMapping("/findProductByName")
    @ResponseBody
    public Result<Product> getProductByName(String productName) {
        return marketService.findProductByName(productName);
    }

    //跳转页面到商品详情
    @RequestMapping("/marketitem")
    public String getItemPage() {
        return "marketitem";
    }

    //跳转到结算页面
    @RequestMapping("/downorder")
    public String goToOrder() {
        return "downorder";
    }

    //删除商品
    @RequestMapping("/deleteProductById")
    @ResponseBody
    public Result deleteProductById(String id){
        return marketService.deleteProduct(id);
    }

    //按照商品名查找商品
    @RequestMapping("/findProductById")
    @ResponseBody
    public Result<Product> getProductById(String productId) {
        return marketService.findProductById(productId);
    }

    //按照商品ID修改商品
    @RequestMapping("updateProductById")
    @ResponseBody
    public Result updateProductById(String productName, String productPrice, String productDesc, String productPic, Integer isDiscount, String discountRate,String productId){
        return marketService.updateProductById(productName,productPrice,productDesc, productPic, isDiscount, discountRate,productId);
    }

    //新增商品
    @RequestMapping("/addProduct")
    @ResponseBody
    public Result addProduct(String productName,String productPrice,String productDesc,String productPic,Integer isDiscount,String discountRate) {
        return marketService.addProduct(productName,productPrice,productDesc,productPic,isDiscount,discountRate);
    }
    //获取商品销量
    @RequestMapping("/countProduct")
    @ResponseBody
    public Result<String> countProduct(String productName) {
        return marketService.countProduct(productName);
    }
}
