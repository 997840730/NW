package com.wangkaisheng.www.service.Impl;


import com.wangkaisheng.www.dao.*;
import com.wangkaisheng.www.dao.Impl.*;
import com.wangkaisheng.www.po.*;
import com.wangkaisheng.www.po.Allpo.*;
import com.wangkaisheng.www.service.Service;
import com.wangkaisheng.www.util.CopyFile;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class ServiceImpl implements Service {
    private final UserDao userDao =new UserDaoImpl();
    private final NoticeDao noticeDao = new NoticeDaoImpl();
    private final ActivityDao activityDao = new ActivityDaoImpl();
    private final OrganizerDao organizerDao = new OrganizerDaoImpl();
    private final PictureDao pictureDao = new PictureDaoImpl();
    private final CopyFile copyFile = new CopyFile();
    @Override
    public boolean regist(User user) {
        if(userDao.isUser(user)){
            return false;
        }else {
            return userDao.regist(user);
        }
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean cancelUser(User user) {
        return userDao.cancelUser(user);
    }

    @Override
    public AllNotice findAllNotice() {
        return noticeDao.getAllNotice();
    }

    @Override
    public AllActivity findAllActivity() {
        return activityDao.findAllActivity();
    }

    @Override
    public AllActivity findActivity(Activity activity) {
        return activityDao.findActivity(activity);
    }

    @Override
    public Activity getAllActivity(AllActivity allActivity,Activity activity) {
        for (Activity activity1:allActivity.getActivities()){
            if(activity.getActivity_id()==activity1.getActivity_id()){
                return activity1;
            }
        }
        return null;
    }

    @Override
    public boolean attendActivity(User user, Activity activity) {
        if(activityDao.isAttend(user,activity)||activityDao.isActivity(user,activity)){
            return false;
        }else{
            return activityDao.attendActivity(user,activity);
        }
    }

    @Override
    public boolean cancelActivity(User user, Activity activity) {
        if(activityDao.isAttend(user,activity)){
            return activityDao.canaelActivity(user,activity);
        }else{
            return false;
        }
    }

    @Override
    public boolean isActivity(User user, Activity activity) {
        return activityDao.isActivity(user,activity);
    }

    @Override
    public boolean organizerregist(Organizer organizer) {
        if(organizerDao.isOrganizer(organizer)||organizerDao.isOrganizering(organizer)){
            return false;
        }else {
            return organizerDao.organizerRegisrt(organizer);
        }
    }

    @Override
    public Organizer isOrganizer(Organizer organizer) {
        return organizerDao.organizerLogin(organizer);
    }

    @Override
    public boolean OrganizerModify(Organizer organizer) {
        return organizerDao.OrganizerModify(organizer);
    }

    @Override
    public boolean addactivity(Activity activity) {
        return activityDao.addactivity(activity);
    }

    @Override
    public AllActivity findMyActivity(Organizer organizer) {
        return activityDao.findMyActivity(organizer);
    }

    @Override
    public AllActivity findActivityed(Activity activity) {
        return activityDao.findActivityed(activity);
    }

    @Override
    public AllUser findUser(Activity activity) {
        List<UserActivity> userActivity= userDao.findUser(activity);
        List<User> list = new LinkedList<>();
        User user;
        for (UserActivity i:userActivity) {
             user = userDao.findUserById(i);
             list.add(user);
        }
        return new AllUser(list);
    }

    @Override
    public boolean overActivity(Activity activity) {
        return activityDao.overlActivity(activity);
    }

    @Override
    public AllActivity findMyActivitying(Organizer organizer) {
        return activityDao.findMyActivitying(organizer);
    }

    @Override
    public AllActivity findActivitying(Activity activity) {
        return activityDao.findActivitying(activity);
    }

    @Override
    public boolean cancelActivitying(Activity activity) {
        return activityDao.canaelActivitying(activity);
    }

    @Override
    public AllUser findUsering(Activity activity) {
        List<UserActivity> userActivity= userDao.findUsering(activity);
        List<User> list = new LinkedList<>();
        User user;
        for (UserActivity i:userActivity) {
            user = userDao.findUserById(i);
            list.add(user);
        }
        return new AllUser(list);
    }

    @Override
    public boolean adoptUser(User user, Activity activity) {
        User user1 = userDao.findUserByusername(user);
        if(activityDao.canaelActivity(user1,activity)){
            return activityDao.adoptUser(user1,activity);
        }else {
            return false;
        }
    }

    @Override
    public AllActivity findAllActivitying() {
        return activityDao.findMyActivitying(null);
    }

    @Override
    public boolean adoptActivitying(Activity activity) {
        if(activityDao.canaelActivitying(activity)){
            if(activityDao.adoptactivity(activity)){
                int temp = activity.getActivity_id();
                if(activityDao.findActivityBy(activity)){
                    return pictureDao.update(activity,temp);
                }else {
                        return false;
                }
            }else {
                return false;
            }
        }else {
            return false;
        }
    }

    @Override
    public AllOrganizer findAllOrganizer() {
        return organizerDao.findAllOrganizer();
    }

    @Override
    public AllOrganizer findOrganizer(Organizer organizer) {
        return organizerDao.findOrganizer(organizer);
    }

    @Override
    public Organizer getAllOrganizer(AllOrganizer allOrganizer, Organizer organizer) {
        for(Organizer organizer1:allOrganizer.getOrganizerList()){
            if(organizer.getUsername().equals(organizer1.getUsername())){
                return organizer1;
            }
        }
        return null;
    }

    @Override
    public boolean attendOrganizer(Organizer organizer) {
        if(organizerDao.cancelOrganizer(organizer)){
            return organizerDao.attendOrganizer(organizer);
        }else {
            return false;
        }
    }

    @Override
    public boolean cancelNotice(Notice notice) {
        return noticeDao.cancelNotice(notice);
    }

    @Override
    public boolean addNotice(Notice notice) {
        return noticeDao.addNotice(notice);
    }

    @Override
    public Pictures findPictures(Activity activity) {
        return pictureDao.findActivityPictures(activity);
    }

    @Override
    public Pictures clonePicture(List<Picture> pictureList) {
        for (Picture picture:pictureList){
            try {
                String images = copyFile.copy(picture.getFilename(), "images");
                picture.setFilename(images);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new Pictures(pictureList);
    }

    @Override
    public boolean addPicture(Pictures pictures) {
        for (Picture p: pictures.getPictures()) {
            if(pictureDao.addPicture(p)){
                System.out.println("success");
            }
        }
        return true;
    }

    @Override
    public boolean findActivityBy(Activity activity) {
        return activityDao.findActivityBy(activity);
    }
}
