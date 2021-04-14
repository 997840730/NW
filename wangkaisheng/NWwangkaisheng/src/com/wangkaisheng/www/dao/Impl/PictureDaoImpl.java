package com.wangkaisheng.www.dao.Impl;

import com.wangkaisheng.www.dao.PictureDao;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.Pictures;
import com.wangkaisheng.www.po.Picture;
import com.wangkaisheng.www.util.BaseUtils;
import com.wangkaisheng.www.util.Impl.BaseUtilesImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class PictureDaoImpl implements PictureDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();
    @Override
    public boolean addPicture(Picture picture) {
        String sql = "insert into picture values(null,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(picture.getNid());
        list.add(picture.getFilename());
        System.out.println(picture);
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(), Picture.class);
    }

    @Override
    public Pictures findActivityPictures(Activity activity) {
        String sql = "select * from picture where nid =  ?";
        List<Object> list = new LinkedList<>();
        list.add(activity.getActivity_id());
        List<Picture> query = baseUtils.query(sql, list.toArray(), Picture.class);
        return new Pictures(query);
    }

    @Override
    public boolean cancelPicture(Picture picture) {
        String sql = "delete from picture where filename = ? and nid = ?";
        List<Object> list = new LinkedList<>();
        list.add(picture.getFilename());
        list.add(picture.getNid());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Picture.class);
    }

    @Override
    public boolean update(Activity activity, int temp) {
        String sql = "update picture set picture_id =? where nid= ?";
        List<Object> list = new LinkedList<>();
        list.add(activity.getActivity_id());
        list.add(temp);
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(), Picture.class);
    }
}
