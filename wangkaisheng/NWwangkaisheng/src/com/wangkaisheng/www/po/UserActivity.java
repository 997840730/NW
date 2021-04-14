package com.wangkaisheng.www.po;

/**
 * @author Administrator
 */
public class UserActivity {
    @AnnotationUser("u_c_id")
    private int u_c_id;
    @AnnotationUser("uid")
    private int uid;
    @AnnotationUser("cid")
    private int cid;

    public UserActivity() {
    }

    public int getU_c_id() {
        return u_c_id;
    }

    public void setU_c_id(int u_c_id) {
        this.u_c_id = u_c_id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
