package cn.edu.zjut.test;


import cn.edu.zjut.Until.GetPostUntil;
import cn.edu.zjut.po.SessionKey;
import cn.edu.zjut.service.WechatDecryptDataService;
import org.json.JSONObject;


import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.util.List;

public class test {
    public static void main(String[] args) {
        String encryptedData = "7GOvMUag5C6vd1rUUD0lS9TbvZN6Gmqzy+05SsTjoJO9dLfx5c+3fQPCxlyE16SjRQ9jLgDXoL/DkTx7b2QKl0ozswGOVYavaASgBx52yrWI+PixSqPJe5zJ7ZvBx5OTgxljmzvC19dHfu984HcXNvxuWV9gY5zOgrZpphBKGf779VmyF0eUJzYsI2rEgzQGwYG6UJQIDgbvmde2AWhDQw==";
        String session_key =  "VWG8n1wBOucJoF5Qd\\/uz7g==";
        String iv = "Crbimq1+ZgOZGElqFkfeDg==";
        WechatDecryptDataService wechatDecryptDataService = new WechatDecryptDataService();
        try {
            wechatDecryptDataService.decodeUserInfo(encryptedData, iv, session_key);
        } catch (InvalidAlgorithmParameterException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
