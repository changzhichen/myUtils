package com.czc.utils;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Objects;

/**
 * 照片相关的方法
 * @author changzhichen
 * @date 2020-04-19 21:16
 */
public class ImageUtil {

    public static void main(String[] args) {
        System.out.println(getImageSuffix(".jpg") + convertFileToBase64("/Users/changzhichen/aaa.jpg"));
    }

    /**
     * 本地文件（图片、excel等）转换成Base64字符串
     * 如果想在web端显示图片，需要在base64字符串前，加修饰：getImageSuffix(fileSuffix)，否则不能显示照片
     * 如：<img src="getImageSuffix(fileSuffix) + base64 "/>
     *
     * @author changzhichen
     * @date 2020-04-19 21:22
     * @param imgPath 文件地址
     * @return java.lang.String Base64编码后的值
     **/
    public static String convertFileToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(new File(imgPath));
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            in.close();
            data = bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组进行Base64编码，得到Base64编码的字符串
        BASE64Encoder encoder = new BASE64Encoder();
        String base64Str = encoder.encode(data).replaceAll("\r|\n", "");
        return base64Str;
    }

    /**
     * 根据文件名，获取用于显示base64的前缀
     *
     * @author changzhichen
     * @date 2020-04-19 21:38
     * @param fileSuffix 文件后缀名，如：.jpeg/.jpg/.JPG/.Jpg/.png/.gif
     * @return java.lang.String
     **/
    public static String getImageSuffix(String fileSuffix) {
        if (StringUtils.isBlank(fileSuffix)) {
            return "";
        }
        String result = "unknown";
        switch (fileSuffix.toLowerCase()) {
            case ".gif":
                result = "data:image/gif;base64,";
                break;
            case ".png":
                result = "data:image/png;base64,";
                break;
            case ".jpeg":
            case ".jpg":
                result = "data:image/jpeg;base64,";
                break;
        }
        return result;
    }

    /**
     * 将byte[]转换成Base64字符串
     *
     * @author changzhichen
     * @date 2020-04-19 21:54
     * @param data byte[] 数组
     * @return java.lang.String 转为base64的字符串
     **/
    public static String convertBypeToBase64(byte[] data) {
        // 对字节数组进行Base64编码，得到Base64编码的字符串
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * 将base64字符串，生成文件
     *
     * @author changzhichen
     * @date 2020-04-19 21:55
     * @param fileBase64String base64字符串
     * @param filePath 文件要保存的目录
     * @param fileName 文件名
     * @return java.io.File
     **/
    public static File convertBase64ToFile(String fileBase64String, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file;
        try {
            File dir = new File(filePath);
            boolean isExist = dir.exists();
            //判断文件目录是否存在
            if (!isExist) {
                dir.mkdirs();
            }

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bfile = decoder.decodeBuffer(fileBase64String);

            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
    /**
     * 本地文件转base64字符串
     *
     * @author changzhichen
     * @date 2020-04-19 21:57
     * @param imgPath 本地文件
     * @return java.lang.String base64字符串
     **/
    private String imageToBase64(String imgPath) {
        byte[] data = null;
        // 读取图片字节数组
        try {
            InputStream in = new FileInputStream(imgPath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        // 返回Base64编码过的字节数组字符串
        return encoder.encode(Objects.requireNonNull(data));
    }

    /**
     * 下载网络照片
     *
     * @param urlPath 文件网络地址
     * @param fileSuffixName 要保存成的文件后缀名，如：jpg/jpeg/gif/png
     * @return java.lang.String base64字符串
     * @author changzhichen
     * @date 2020-04-19 21:59
     **/
    public static String encodeImageToBase64(String urlPath, String fileSuffixName) {
        ByteArrayOutputStream outputStream;
        try {
            URL url = new URL(urlPath);
            BufferedImage bufferedImage = ImageIO.read(url);
            outputStream = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, fileSuffixName, outputStream);
        } catch (IOException e) {
            return "下载照片失败";
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(outputStream.toByteArray());
    }

}
