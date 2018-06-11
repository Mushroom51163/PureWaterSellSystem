package com.purewatersellsystem.util;

import org.apache.commons.codec.binary.Base64;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MyUtil {
    /**
     * 利用UUID算法生成一个主键值
     *
     * @return 主键值
     */
    public static String createId() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        return id.replace("-", "").replaceAll("[a-zA-Z]","").substring(0,8);
    }

    /**
     * 密码加密处理（MD5）
     *
     * @param src 原密码
     * @return 加密后的内容
     */
    public static String md5(String src) {
        try {//采用MD5处理
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] output = md.digest(src.getBytes());//加密处理
            //将加密结果output利用Base64转成字符串输出
            String ret = Base64.encodeBase64String(output);
            return ret;
        } catch (Exception e) {
            throw new RuntimeException("密码加密失败", e);
        }
    }

    //得到当前时间
    public static String getDate() {
        DateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        String time = df.format(Calendar.getInstance().getTime());
        return time;
    }

    //根据现在的时间推算可用预约时间
    public static String[] getAppDate() {
        List<String> l = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        if (9 - hour >= 2) {
            c.set(Calendar.HOUR_OF_DAY, 9);
            l.add(df.format(c.getTimeInMillis()));
        }
        if (12 - hour >= 2) {
            c.set(Calendar.HOUR_OF_DAY, 12);
            l.add(df.format(c.getTimeInMillis()));
        }
        if (15 - hour >= 2) {
            c.set(Calendar.HOUR_OF_DAY, 15);
            l.add(df.format(c.getTimeInMillis()));
        }
        if (18 - hour >= 2) {
            c.set(Calendar.HOUR_OF_DAY, 18);
            l.add(df.format(c.getTimeInMillis()));
        }
        c.set(Calendar.DATE, day + 1);
        c.set(Calendar.HOUR_OF_DAY, 9);
        l.add(df.format(c.getTimeInMillis()));
        c.set(Calendar.HOUR_OF_DAY, 12);
        l.add(df.format(c.getTimeInMillis()));
        c.set(Calendar.HOUR_OF_DAY, 15);
        l.add(df.format(c.getTimeInMillis()));
        c.set(Calendar.HOUR_OF_DAY, 18);
        l.add(df.format(c.getTimeInMillis()));
        String[] str = new String[l.size()];
        l.toArray(str);
        return str;
    }

    //生成六位验证码
    public static String GenerateCode() {
        String dict = "1234567890QWERTYUIOPASDFGHJKLZXCVBNM";
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            sb.append(dict.charAt(r.nextInt(dict.length() - 1)));
        }
        return sb.toString();
    }

    /**
     * @param recipients 收件人邮箱
     *                   title 邮件标题
     * @param context    邮件内容
     *                   addresser 发件人邮箱
     *                   password  密码(qq邮箱使用授权码)
     *                   smtpServer 主机名
     *                   port 端口号
     * @throws AddressException
     * @throws MessagingException
     */
    public static void sendEmail(String recipients, String context) throws AddressException, MessagingException {
        String title = "iDrink验证码";
        String addresser = "wangl_1995@foxmail.com";
        String password = "okogiycvlyqwbjba";
        String smtpServer = "smtp.qq.com";
        String port = "587";
        Properties properties = new Properties();
        properties.put("mail.transport.protocol", "smtp");// 连接协议
        properties.put("mail.smtp.host", smtpServer);// 主机名
        properties.put("mail.smjtp.port", port);// 端口号
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress(addresser));
        // 设置收件人地址
        message.setRecipients(MimeMessage.RecipientType.TO, new
                InternetAddress[]{new InternetAddress(recipients)});
        // 设置邮件标题
        message.setSubject(title);
        // 设置邮件内容
        message.setText(context);
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect(addresser, password);// 密码为刚才得到的授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
    }

    //发送验证码邮件
    public static String sendVerifyCode(String receiver, String message) throws Exception {
        String code = GenerateCode();
        sendEmail(receiver, message + "：" + code);
        return code;
    }


    public static void main(String[] args) {
//        System.out.println(md5("123456"));
        //ICy5YqxZB1uWSwcVLSNLcA==
//        System.out.println(md5("123"));
//        for (int i = 0; i < 30; i++) {
//            System.out.println(createId());
//        }
//        System.out.println(getDate().split("-")[2].split(" ")[0]);  //获取当日日期
        //
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        DateFormat df1 = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
//        try {
//            System.out.println(df1.format(df.parse("2018-04-18 00:00:00").getTime()));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        //%-1-% or %-2-% or %-3-%       一季度
        //%-4-% or %-5-% or %-6-%       二季度
        //%-7-% or %-8-% or %-9-%       三季度
        //%-10-% or %-11-% or %-12-%    四季度
        //%2018-%                       年度
        //System.out.println(Arrays.toString(getAppDate()));
        //System.out.println("%-%-"+MyUtil.getDate().split("-")[2].split(" ")[0]+"%");
        StringBuffer sb = new StringBuffer();
        String s = getDate().split("-")[1];
        for (int i = 1; i <= Integer.parseInt(s); i++) {
            sb.append(i);
            if(i!=Integer.parseInt(s)){
                sb.append(",");
            }
        }
        System.out.println(sb);
    }

}