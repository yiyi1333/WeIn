package cn.edu.zjut.Until;

import cn.edu.zjut.ejb.PictureUploadRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.Hashtable;

public class PicUploadUtils {

    private static PictureUploadRemote lookupRemoteStatelessEjbBean() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
//        jndiProperties.put(Context.PROVIDER_URL, "http://www.zhangyuxiang.icu:8080");
        final Context context = new InitialContext(jndiProperties);
        final String appName = "";
        final String moduleName = "ejbserver";
        final String distinctName = "";
        final String beanName = "PictureUpload";
        final String viewClassName = PictureUploadRemote.class.getName();
        final String namespace = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        System.out.println(namespace);
        return (PictureUploadRemote) context.lookup(namespace);
    }

    public static String upload(byte[] buffers) {
        String path = null;
        try {
            PictureUploadRemote usBean = lookupRemoteStatelessEjbBean();
            path = usBean.uploadToOSS(buffers);
        } catch (NamingException | IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}
