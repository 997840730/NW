package com.wangkaisheng.www.po;

import java.util.List;

/**
 * @author Administrator
 */
public class TimePictures {
    private int aid;
    private List<String> pictures;

    public TimePictures() {
    }

    public TimePictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
}
