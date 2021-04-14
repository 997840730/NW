package com.wangkaisheng.www.dao;


import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.Pictures;
import com.wangkaisheng.www.po.Picture;

public interface PictureDao {
    boolean addPicture(Picture picture);

    Pictures findActivityPictures(Activity activity);

    boolean cancelPicture(Picture picture);

    boolean update(Activity activity, int temp);
}
