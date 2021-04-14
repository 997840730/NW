package com.wangkaisheng.www.service;

import com.wangkaisheng.www.po.*;
import com.wangkaisheng.www.po.Allpo.*;

import java.util.List;

/**
 * @author Administrator
 */
public interface Service {

    boolean regist(User user);

    boolean updateUser(User user);

    boolean cancelUser(User user);



    AllNotice findAllNotice();

    AllActivity findAllActivity();

    AllActivity findActivity(Activity activity);

    Activity getAllActivity(AllActivity allActivity,Activity activity);

    boolean attendActivity(User user, Activity activity);

    boolean cancelActivity(User user, Activity activity);

    boolean isActivity(User user, Activity activity);

    boolean organizerregist(Organizer organizer);

    Organizer isOrganizer(Organizer organizer1);

    boolean OrganizerModify(Organizer organizer);

    boolean addactivity(Activity activity);

    AllActivity findMyActivity(Organizer organizer);

    AllActivity findActivityed(Activity activity);

    AllUser findUser(Activity activity);

    boolean overActivity(Activity activity);

    AllActivity findMyActivitying(Organizer organizer);

    AllActivity findActivitying(Activity activity);

    boolean cancelActivitying(Activity activity);

    AllUser findUsering(Activity activity);

    boolean adoptUser(User user,Activity activity);

    AllActivity findAllActivitying();

    boolean adoptActivitying(Activity activity);

    AllOrganizer findAllOrganizer();

    AllOrganizer findOrganizer(Organizer organizer);

    Organizer getAllOrganizer(AllOrganizer allOrganizer, Organizer organizer);

    boolean attendOrganizer(Organizer organizer);

    boolean cancelNotice(Notice notice);

    boolean addNotice(Notice notice);

    Pictures findPictures(Activity activity);

    Pictures clonePicture(List<Picture> pictureList);

    boolean addPicture(Pictures pictures);

    boolean findActivityBy(Activity activity);
}
