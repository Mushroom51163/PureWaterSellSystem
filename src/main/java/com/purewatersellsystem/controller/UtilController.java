package com.purewatersellsystem.controller;

import com.purewatersellsystem.entity.Result;
import com.purewatersellsystem.service.VerifyCodeService;
import com.purewatersellsystem.util.MyUtil;
import me.chyxion.xls.TableToXls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UtilController {

    @Resource
    private VerifyCodeService verifyCodeService;



    @RequestMapping("/getExcelTest")
    public void getExcelTest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            StringBuilder table = new StringBuilder();
            table.append(request.getParameter("table"));
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=excel.xls");
            response.getOutputStream().write(TableToXls.process(table));
        }catch (Exception e){
            //error("获取导出Excel内部异常",ErrorCode.UNKNOWN_EXCEPTION,e);
            //ResponseHelper.printOut(response,false,"获取导出Excel内部异常",e);
            e.printStackTrace();
        }
    }
    //获取月份
    @RequestMapping("/getMonth")
    @ResponseBody
    public Result<String> getMonth(){
        StringBuffer sb = new StringBuffer();
        String s = MyUtil.getDate().split("-")[1];
        for (int i = 1; i <= Integer.parseInt(s); i++) {
            sb.append(i);
            if(i!=Integer.parseInt(s)){
                sb.append(",");
            }
        }
        Result r = new Result();
        r.setData(sb.toString());
        r.setStatus(1);
        r.setMsg("succeed");
        return r;
    }
    //派送员工作量查询页面
    @RequestMapping("/expresserWorkCount")
    public String expresserWorkCount(){
        return "ExpresserWorkCount";
    }
    //水站信息
    @RequestMapping("/waterStationInfo")
    public String waterStationInfo(){
        return "waterStationInfo";
    }
    //测试页
    @RequestMapping("/testCookie")
    public String testCookie(){
        return "testCookie";
    }
    //购物车
    @RequestMapping("/shoppingCart")
    public String shoppingCart(){
        return "shoppingCart";
    }
    //查询派送中订单
    @RequestMapping("/goToFindUndone")
    public String goToFindUndone(){
        return "findUndoneOrder";
    }
    //查询派送员
    @RequestMapping("/goToFindExpById")
    public String goToFindExpById(){
        return "findExpById";
    }
    //查询订单
    @RequestMapping("/orderQuery")
    public String orderQuery(){
        return "listOrderForAdmin";
    }
    //总站销量查询
    @RequestMapping("/salesVolumeQuery")
    public String salesVolumeQuery(){
        return "salesVolumeQuery";
    }
    //分站销量查询
    @RequestMapping("/salesVolumeQueryForBranch")
    public String salesVolumeQueryForBranch(){
        return "salesVolumeQueryForBranch";
    }
    //水站分配订单
    @RequestMapping("/handOutOrder")
    public String handOutOrder(){
        return "handOutOrder";
    }
    //跳转到修改派送员页面
    @RequestMapping("/modExpresser")
    public String modExpresser(){
        return "modExpresser";
    }
    //跳转到增加派送员页面
    @RequestMapping("/listExpresser")
    public String listExpresser(){
        return "listExpresser";
    }
    //跳转到列出派送员页面
    @RequestMapping("/addExpresser")
    public String addExpresser(){
        return "addExpresser";
    }
    //跳转到为总站列出用户
    @RequestMapping("/listUserForAdmin")
    public String listUserForBranchStation(){
        return "listUserForAdmin";
    }

    //跳转到编辑水站页面
    @RequestMapping("/modWaterStation")
    public String modWaterStation(){
        return "modWaterStation";
    }
    //跳转到查看水站
    @RequestMapping("/listWaterstation")
    public String listWaterstation(){
        return "listWaterstation";
    }
    //跳转到水站销量
    @RequestMapping("/waterstationSalesValume")
    public String waterstationSalesValume(){
        return "waterstationSalesValume";
    }

    //跳转到添加水站
    @RequestMapping("/addWaterstation")
    public String addWaterstation(){
        return "addWaterstation";
    }
    // /跳转到商城
    @RequestMapping("/home")
    public String index() {
        return "index";
    }

    //用户检查
    @RequestMapping("/")
    public String hello() {
        return "check";
    }

    //用户欢迎页
    @RequestMapping("/user")
    public String helloForUser() {
        return "welcome";
    }
    //列出商品
    @RequestMapping("/listProducts")
    public String listProducts(){
        return "listProducts";
    }
    //添加商品
    @RequestMapping("/addProducts")
    public String addProducts(){
        return "addProducts";
    }
    //修改商品
    @RequestMapping("/modProducts")
    public String modProducts(){
        return "modProducts";
    }

    //水站管理
    @RequestMapping("/waterstationmanage")
    public String waterstationmanage(){
        return "addWaterstation";
    }
    //活动发布
    @RequestMapping("/activitypublish")
    public String activitypublish(){
        return "activitypublish";
    }
    //总站管理员欢迎页
    @RequestMapping("/admin")
    public String helloForAdmin() {
        return "admin";
    }
    //分站管理员欢迎页
    @RequestMapping("/branch")
    public String helloForBranch(){
        return "branchadmin";
    }
    //派送员欢迎页
    @RequestMapping("/expresser")
    public String helloforexp() {
        return "expresser";
    }

    //发送注册验证码
    @RequestMapping("/getVerifyCodeForRegister")
    @ResponseBody
    public Result<String> sendVerifyCodeForRegister(String email) {
        return verifyCodeService.sendVerifyCode(email, "您注册iDrink的验证码是");
    }

    //发送修改地址的验证码
    @RequestMapping("/getVerifyCodeForChangeAddr")
    @ResponseBody
    public Result<String> sendVerifyCodeForChangeAddr(String email) {
        return verifyCodeService.sendVerifyCode(email, "您修改地址的验证码是");
    }

    //发送修改密码验证码
    @RequestMapping("/getVerifyCodeForChangePwd")
    @ResponseBody
    public Result<String> sendVerifyCodeForChangePwd(String email) {
        return verifyCodeService.sendVerifyCode(email, "您修改密码的验证码是");
    }
}
