package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.AddactivityInterface;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.Pictures;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.po.Picture;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class AddactivityInterfaceImpl implements AddactivityInterface {
    private Service service = new ServiceImpl();
    @Override
    public boolean addactivity(Organizer organizer,Activity activity) {
        boolean flag = false;
        if(service.addactivity(activity)){
            if(organizer.getTimePictures()!=null){
                if(service.findActivityBy(activity)){
                    List<Picture> pictureList = new LinkedList<>();
                    Picture picture;
                    for (String temp:organizer.getTimePictures().getPictures()){
                        picture = new Picture();
                        picture.setFilename(temp);
                        picture.setNid(activity.getActivity_id());
                        pictureList.add(picture);
                    }
                    Pictures pictures =  service.clonePicture(pictureList);
                    if(service.addPicture(pictures)){
                        organizer.setTimePictures(null);
                    }else {
                        flag=true;
                    }
                }else {
                    flag = true;
                }
            }else {
                flag=true;
            }
        }else {
            flag=false;
        }
        return flag;
    }
}
