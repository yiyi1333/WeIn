package cn.edu.zjut.action;

import cn.edu.zjut.Until.PicUploadUtils;
import cn.edu.zjut.Until.PictureUploadBean;

import java.io.File;
import java.io.FileInputStream;

public class UploadImageAction {
    private File imageFile;
    private String imagePath;

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    public String Upload() {
//        System.out.println(imageFile);
        System.out.println(imageFile);
        PictureUploadBean pictureUploadBean = new PictureUploadBean();
        try {
            FileInputStream fin = new FileInputStream(imageFile);
            byte[] bytes = new byte[(int) imageFile.length()];
            fin.read(bytes);
            fin.close();
            imagePath = PicUploadUtils.upload(bytes);
//            imagePath = pictureUploadBean.uploadToOSS(bytes);
            System.out.println("imageURL: " + imagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }
}
