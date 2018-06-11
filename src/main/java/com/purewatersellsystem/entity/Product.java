package com.purewatersellsystem.entity;

//产品表实体类
public class Product {
    //产品ID
    private String productId;
    //产品名
    private String productName;
    //产品价格
    private String productPrice;
    //产品描述
    private String productDesc;
    //产品图片
    private String productPic;
    //是否打折
    private Integer isDiscount;
    //折扣率
    private String discountRate;

    public Product() {
    }

    public Product(String productId, String productName, String productPrice, String productDesc, String productPic, Integer isDiscount, String discountRate) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.productPic = productPic;
        this.isDiscount = isDiscount;
        this.discountRate = discountRate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductPic() {
        return productPic;
    }

    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }

    public Integer getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Integer isDiscount) {
        this.isDiscount = isDiscount;
    }

    public String getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(String discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPic='" + productPic + '\'' +
                ", isDiscount=" + isDiscount +
                ", discountRate='" + discountRate + '\'' +
                '}';
    }
}
