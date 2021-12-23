package cn.edu.zjut.action;

import java.io.File;

public class UploadImageAction {
    private File imageFile;

    public File getImageFile() {
        return imageFile;
    }

    public void setImageFile(File imageFile) {
        this.imageFile = imageFile;
    }

    public String Upload(){
        System.out.println(imageFile);
        return "success";
    }
}
