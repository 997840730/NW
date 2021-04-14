package com.wangkaisheng.www.dao.Impl;

import com.wangkaisheng.www.dao.ActivityDao;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;
import com.wangkaisheng.www.po.Allpo.AllUser;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.po.Timeactivity;
import com.wangkaisheng.www.po.User;
import com.wangkaisheng.www.util.BaseUtils;
import com.wangkaisheng.www.util.Impl.BaseUtilesImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class ActivityDaoImpl implements ActivityDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();
    @Override
    public AllActivity findAllActivity() {
        String sql = "select * from activity";
        List<Activity> list =  baseUtils.query(sql,null, Activity.class);
        return new AllActivity(list);
    }

    @Override
    public AllActivity findActivity(Activity activity) {
        String sql = "select * from activity where activity_name like '%"+activity.getActivity_name()+"%'";
        List<Activity> list =  baseUtils.query(sql,null, Activity.class);
        return new AllActivity(list);
    }

    @Override
    public boolean attendActivity(User user, Activity activity) {
        String sql = "insert into timeactivity values(null,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(user.getUserId());
        list.add(activity.getActivity_id());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(), Timeactivity.class);
    }

    @Override
    public boolean isAttend(User user, Activity activity) {
        String sql = "select * from timeactivity where uid = ? and cid = ? ";
        List<Object> list = new LinkedList<>();
        list.add(user.getUserId());
        list.add(activity.getActivity_id());
        List<Activity> temp =  baseUtils.query(sql,list.toArray(), Activity.class);
        return !temp.isEmpty();
    }

    @Override
    public boolean canaelActivity(User user, Activity activity) {
        String sql = "delete from timeactivity where uid = ? and cid = ?";
        List<Object> list = new LinkedList<>();
        list.add(user.getUserId());
        list.add(activity.getActivity_id());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),User.class);
    }

    @Override
    public boolean isActivity(User user, Activity activity) {
        String sql = "select * from user_activity where uid = ? and cid = ? ";
        List<Object> list = new LinkedList<>();
        list.add(user.getUserId());
        list.add(activity.getActivity_id());
        List<Activity> temp =  baseUtils.query(sql,list.toArray(), Activity.class);
        return !temp.isEmpty();
    }

    @Override
    public boolean addactivity(Activity activity) {
        String sql = "insert into activitying values(null,?,?,?,?,?,?,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(activity.getActivity_name());
        list.add(activity.getActivity_content());
        list.add(activity.getActivity_date());
        list.add(activity.getActivity_address());
        list.add(activity.getActivity_organizer());
        list.add(activity.getActivity_person());
        list.add(activity.getActivity_phone());
        list.add(activity.getActivity_oid());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(), Activity.class);
    }

    @Override
    public AllActivity findMyActivity(Organizer organizer) {
        String sql = "select * from activity where activity_oid = ?";
        List<Object> list = new LinkedList<>();
        list.add(organizer.getId());
        List<Activity> query =  baseUtils.query(sql,list.toArray(), Activity.class);
        return new AllActivity(query);
    }

    @Override
    public AllActivity findActivityed(Activity activity) {
        String sql = "select * from activity where activity_name like '%"+activity.getActivity_name()+"%' and activity_oid = ?";
        List<Object> list = new LinkedList<>();
        list.add(activity.getActivity_oid());
        List<Activity> query =  baseUtils.query(sql,list.toArray(), Activity.class);
        return new AllActivity(query);
    }

    @Override
    public boolean overlActivity(Activity activity) {
        String sql = "delete from activity where activity_id = ?";
        List<Object> list = new LinkedList<>();
        list.add(activity.getActivity_id());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Activity.class);
    }

    @Override
    public AllActivity findMyActivitying(Organizer organizer) {
        StringBuilder sql = new StringBuilder("select * from activitying ");
        List<Object> list = new LinkedList<>();
        if(organizer!=null){
            list.add(organizer.getId());
            sql.append(" where activity_oid = ?");
        }
        List<Activity> query =  baseUtils.query(sql.toString(),list.toArray(),Activity.class);
        return new AllActivity(query);
    }

    @Override
    public AllActivity findActivitying(Activity activity) {
        StringBuilder sql =new StringBuilder( "select * from activitying where activity_name like '%"+activity.getActivity_name()+"%' ");
        List<Object> list = new LinkedList<>();
        if(activity.getActivity_oid()!=0){
            sql.append(" and activity_oid = ?");
            list.add(activity.getActivity_oid());
        }
        List<Activity> query =  baseUtils.query(sql.toString(),list.toArray(), Activity.class);
        return new AllActivity(query);
    }

    @Override
    public boolean canaelActivitying(Activity activity) {
        String sql = "delete from activitying where activity_id = ?";
        List<Object> list = new LinkedList<>();
        list.add(activity.getActivity_id());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Activity.class);
    }

    @Override
    public boolean adoptUser(User user1, Activity activity) {
        String sql = "insert into user_activity values(null,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(user1.getUserId());
        list.add(activity.getActivity_id());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(), Timeactivity.class);
    }

    @Override
    public boolean adoptactivity(Activity activity) {
        String sql = "insert into activity values(null,?,?,?,?,?,?,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(activity.getActivity_name());
        list.add(activity.getActivity_content());
        list.add(activity.getActivity_date());
        list.add(activity.getActivity_address());
        list.add(activity.getActivity_organizer());
        list.add(activity.getActivity_person());
        list.add(activity.getActivity_phone());
        list.add(activity.getActivity_oid());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(), Activity.class);
    }

    @Override
    public boolean findActivityBy(Activity activity) {
        String sql = "select * from activitying where activity_name = ? and activity_oid = ?";
        List<Object> list = new LinkedList<>();
        list.add(activity.getActivity_name());
        list.add(activity.getActivity_oid());
        List<Activity> query = baseUtils.query(sql,list.toArray(),Activity.class);
        if(query.isEmpty()){
            return false;
        }else {
            activity.setActivity_id(query.get(0).getActivity_id());
            return true;
        }
    }
}
