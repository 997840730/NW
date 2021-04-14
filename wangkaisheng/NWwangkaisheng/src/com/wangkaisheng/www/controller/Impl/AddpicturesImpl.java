package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Addpictures;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.po.TimePictures;

import java.util.LinkedList;
import java.util.List;


/**
 * @author Administrator
 */
public class AddpicturesImpl implements Addpictures {

    @Override
    public boolean addpicture(Organizer organizer, String absolutePath) {
        try {
            TimePictures timePictures= null;
            List<String> stringList =null;
            if (organizer.getTimePictures()==null){
                timePictures = new TimePictures();;
                stringList = new LinkedList<>();

            }else {
                timePictures = organizer.getTimePictures();
                stringList = timePictures.getPictures();
            }
            stringList.add(absolutePath);
            timePictures.setPictures(stringList);
            organizer.setTimePictures(timePictures);
        }catch (Exception e){
            System.out.println(e.getCause());
        }
        return true;
    }
}
