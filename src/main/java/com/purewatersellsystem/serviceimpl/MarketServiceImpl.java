package com.purewatersellsystem.serviceimpl;

import com.purewatersellsystem.entity.Product;
import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.entity.WaterStation;
import com.purewatersellsystem.mapper.InventoryMapper;
import com.purewatersellsystem.mapper.ProductMapper;
import com.purewatersellsystem.mapper.WaterStationMapper;
import com.purewatersellsystem.service.MarketService;
import com.purewatersellsystem.util.MyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MarketServiceImpl implements MarketService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private InventoryMapper inventoryMapper;
    @Resource
    private WaterStationMapper waterStationMapper;

    @Override
    public Result<List<Product>> findProducts() {
        Result<List<Product>> r = new Result<List<Product>>();
        r.setMsg("查找成功");
        r.setStatus(1);
        r.setData(productMapper.findAllProduct());
        return r;
    }

    @Override
    public Result<Product> findProductByName(String productName) {
        Result<Product> r = new Result<Product>();
        Product p = productMapper.findProductByName(productName);
        r.setData(p);
        r.setStatus(1);
        r.setMsg("查找商品详细信息成功");
        return r;
    }

    @Override
    public Result deleteProduct(String id) {
        Integer i = productMapper.deleteProduct(id);
        Result r = new Result();
        if(i==1){
            r.setStatus(1);
            r.setMsg("删除商品成功");
        }else{
            r.setStatus(0);
            r.setMsg("删除商品失败");
        }
        return r;
    }

    @Override
    public Result<Product> findProductById(String productId) {
        Result<Product> r = new Result<Product>();
        Product p = productMapper.findProductById(productId);
        r.setData(p);
        r.setStatus(1);
        r.setMsg("查找商品详细信息成功");
        return r;
    }

    @Override
    public Result updateProductById(String productName, String productPrice, String productDesc, String productPic, Integer isDiscount, String discountRate,String productId) {
        productMapper.updateProductById(productName,productPrice,productDesc, productPic, isDiscount, discountRate,productId);
        Result r = new Result();
        r.setMsg("修改成功");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result addProduct(String productName,String productPrice,String productDesc,String productPic,Integer isDiscount,String discountRate) {
        String id = MyUtil.createId();
        productMapper.addProduct(new Product(id,productName,productPrice,productDesc,productPic,isDiscount,discountRate));
        List<WaterStation> ws = waterStationMapper.findAllWaterStation();
        for (int i = 0; i < ws.size(); i++) {
            inventoryMapper.newProductAdded(ws.get(i).getStationId(),id,"0");
        }
        Result r = new Result();
        r.setMsg("增加商品成功");
        r.setStatus(1);
        return r;
    }

    @Override
    public Result<String> countProduct(String productName) {
        Result<String> r = new Result<>();
        r.setMsg("查找成功");
        r.setStatus(1);
        r.setData(productMapper.countProduct(productMapper.findProductByName(productName).getProductId(),MyUtil.getDate().split("-")[0]+"-"+MyUtil.getDate().split("-")[1]+"%"));
        return r;
    }
}
