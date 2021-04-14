package com.wangkaisheng.www.dao.Impl;

import com.wangkaisheng.www.dao.UserDao;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.User;
import com.wangkaisheng.www.po.UserActivity;
import com.wangkaisheng.www.util.BaseUtils;
import com.wangkaisheng.www.util.Impl.BaseUtilesImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class UserDaoImpl implements UserDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();
    @Override
    public boolean isUser(User user) {
        StringBuilder sql = new StringBuilder("select * from user where username = ?");
        List<String> list = new LinkedList<>();
        list.add(user.getUsername());
        if(user.getPassword()!=null&&!"".equals(user.getPassword())){
            sql.append(" and password = ?");
            list.add(user.getPassword());
        }
        List<User> query = baseUtils.query(sql.toString(), list.toArray(), User.class);
        if (query.isEmpty()){
            return false;
        }else {
            user.setUserId(query.get(0).getUserId());
            user.setName(query.get(0).getName());
            user.setAge(query.get(0).getAge());
            user.setGender(query.get(0).getGender());
            user.setPhone(query.get(0).getPhone());
            return true;
        }
    }

    @Override
    public boolean regist(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,0)";
        List<Object> list = new LinkedList<>();
        list.add(user.getUsername());
        list.add(user.getPassword());
        list.add(user.getName());
        list.add(user.getGender());
        list.add(user.getAge());
        list.add(user.getPhone());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),User.class);
    }

    @Override
    public boolean updateUser(User user) {
        String sql = "update user set password= ? ,name= ?,gender = ?,age = ? ,phone=?, alltime=?  where id= ?";
        List<Object> list = new LinkedList<>();
        list.add(user.getPassword());
        list.add(user.getName());
        list.add(user.getGender());
        list.add(user.getAge());
        list.add(user.getPhone());
        list.add(user.getTime());
        list.add(user.getUserId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),User.class);
    }

    @Override
    public boolean cancelUser(User user) {
        String sql = "delete from user where id = ?";
        List<Object> list = new LinkedList<>();
        list.add(user.getUserId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),User.class);
    }

    @Override
    public List<UserActivity> findUser(Activity activity) {
        String sql = "select * from user_activity where cid = ?";
        List<Object> list = new LinkedList<>();
        list.add(activity.getActivity_id());
        return baseUtils.query(sql, list.toArray(), UserActivity.class);
    }

    @Override
    public User findUserById(UserActivity i) {
        String sql = "select * from user where id = ?";
        List<Object> list = new LinkedList<>();
        list.add(i.getUid());
        return baseUtils.query(sql, list.toArray(), User.class).get(0);
    }

    @Override
    public List<UserActivity> findUsering(Activity activity) {
        String sql = "select * from timeactivity where cid = ?";
        List<Object> list = new LinkedList<>();
        list.add(activity.getActivity_id());
        return baseUtils.query(sql, list.toArray(), UserActivity.class);
    }

    @Override
    public User findUserByusername(User user) {
        String sql = "select * from user where username = ?";
        List<Object> list = new LinkedList<>();
        list.add(user.getUsername());
        return baseUtils.query(sql, list.toArray(), User.class).get(0);
    }

}
