package cn.edu.zjut.test;

import cn.edu.zjut.Until.PictureUploadBean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class pictest {

    private static final String FILE = "pic.png";

    public static void main(String[] args) throws IOException {
        File f = new File(FILE);
        // work only for 2GB file, because array index can only up to Integer.MAX
        byte[] buffer = new byte[(int) f.length()];
        FileInputStream is = new FileInputStream(FILE);
        is.read(buffer);
        is.close();
        PictureUploadBean pictureUploadBean = new PictureUploadBean();
        String path = pictureUploadBean.uploadToOSS(buffer);
        System.out.println(path);
    }
}
