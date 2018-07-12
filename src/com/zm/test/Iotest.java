package com.zm.test;
import java.io.*;

import org.junit.Test;
public class Iotest{
    
	@Test
	public static void main(String[] args)throws Exception{
        File file = new File("D:\\goods_pic.jpg");
        if(!file.exists())
            throw new RuntimeException("文件不存在..");
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        int len = 0;
        //存储路径需要精确到3.jpg，这个相当与是重命名了1.jpg并复制
        FileOutputStream fos = new FileOutputStream("D:\\迅雷下载\\goods_pic_2.jpg");
        while((len=fis.read(b))!=-1){
            fos.write(b,0,len);
        }
        fos.close();
        fis.close();
    }
}