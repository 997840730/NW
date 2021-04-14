package com.wangkaisheng.www.po;

public class Timeactivity {
    @AnnotationUser("u_c_id")
    private int tau_id;
    @AnnotationUser("uid")
    private int uid;
    @AnnotationUser("cid")
    private int aid;

    public int getTau_id() {
        return tau_id;
    }

    public void setTau_id(int tau_id) {
        this.tau_id = tau_id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }
}
