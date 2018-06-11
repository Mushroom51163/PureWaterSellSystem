package com.purewatersellsystem.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
    public static BufferedImage getInputStream(String addr){
        try {
            String imgPath = addr;
            BufferedImage image = ImageIO.read(new FileInputStream(imgPath));
            return image;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println();
            System.out.println("获取图片异常:java.awt.image.BufferedImage");
            System.out.println("请检查图片路径是否正确，或者该地址是否为一个图片");
        }
        return null;
    }
}
