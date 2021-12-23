package cn.edu.zjut.Until;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;

import javax.ejb.Stateless;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Stateless(name = "PictureUpload")
public class PictureUploadBean {
    public PictureUploadBean() {
    }

    public String uploadToOSS(byte[] buffer) throws IOException {
        FileOutputStream os = new FileOutputStream("pic.png");
        os.write(buffer);
// yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
// 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tN4GzA5oPUWnUDd2eiR";
        String accessKeySecret = "PuHZfvbmpsykUjyW5GLnNe5MQF1fVQ";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 创建PutObjectRequest对象。
// 依次填写Bucket名称（例如examplebucket）、Object完整路径（例如exampledir/exampleobject.txt）和本地文件的完整路径。Object完整路径中不能包含Bucket名称。
// 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件。
        String name = System.currentTimeMillis() + ".png";
        PutObjectRequest putObjectRequest = new PutObjectRequest("typora-zyx", "WeIn/" + name, new File("pic.png"));

// 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
// ObjectMetadata metadata = new ObjectMetadata();
// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
// metadata.setObjectAcl(CannedAccessControlList.Private);
// putObjectRequest.setMetadata(metadata);

// 上传文件。
        ossClient.putObject(putObjectRequest);

// 关闭OSSClient。
        ossClient.shutdown();
        return "https://typora-zyx.oss-cn-hangzhou.aliyuncs.com/WeIn/" + name;
    }
}
