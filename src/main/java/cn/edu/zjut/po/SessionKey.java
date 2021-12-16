package cn.edu.zjut.po;

public class SessionKey {
    private String session_key;
    private String openid;

    @Override
    public String toString() {
        return "SessionKey{" +
                "session_key='" + session_key + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public SessionKey() {
    }

    public SessionKey(String session_key, String openid) {
        this.session_key = session_key;
        this.openid = openid;
    }
}
