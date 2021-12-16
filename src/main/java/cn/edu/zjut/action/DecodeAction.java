package cn.edu.zjut.action;

import cn.edu.zjut.po.DecodeResult;
import cn.edu.zjut.service.WechatDecryptDataService;

public class DecodeAction {
    private String appid;
    private String appsecret;
    private String code;
    private String encryptedData;
    private String iv;
    private WechatDecryptDataService wechatDecryptDataService;
    private DecodeResult decodeResult;
    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public WechatDecryptDataService getWechatDecryptDataService() {
        return wechatDecryptDataService;
    }

    public void setWechatDecryptDataService(WechatDecryptDataService wechatDecryptDataService) {
        this.wechatDecryptDataService = wechatDecryptDataService;
    }

    public DecodeResult getDecodeResult() {
        return decodeResult;
    }

    public void setDecodeResult(DecodeResult decodeResult) {
        this.decodeResult = decodeResult;
    }

    public String Decode(){
        System.out.println("\niv:" + iv);
        System.out.println("\nencryptedData:" + encryptedData);
        decodeResult = wechatDecryptDataService.decode(appid, appsecret, code, encryptedData, iv);
        return "success";
    }
}
