package com.wangkaisheng.www.dao;

import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllUser;
import com.wangkaisheng.www.po.User;
import com.wangkaisheng.www.po.UserActivity;

import java.util.List;

public interface UserDao {
    boolean isUser(User user);

    boolean regist(User user);

    boolean updateUser(User user);

    boolean cancelUser(User user);

    List<UserActivity> findUser(Activity activity);

    User findUserById(UserActivity i);

    List<UserActivity> findUsering(Activity activity);

    User findUserByusername(User user);
}
