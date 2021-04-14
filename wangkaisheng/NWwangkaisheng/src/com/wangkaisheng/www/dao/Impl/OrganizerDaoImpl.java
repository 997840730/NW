package com.wangkaisheng.www.dao.Impl;


import com.wangkaisheng.www.dao.OrganizerDao;
import com.wangkaisheng.www.po.Allpo.AllOrganizer;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.po.User;
import com.wangkaisheng.www.util.BaseUtils;
import com.wangkaisheng.www.util.Impl.BaseUtilesImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class OrganizerDaoImpl implements OrganizerDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();
    @Override
    public Organizer organizerLogin(Organizer organizerlogin) {
        String sql = "select * from organizer where organizername = ? and password = ? ";
        List<String> list = new LinkedList<>();
        list.add(organizerlogin.getUsername());
        list.add(organizerlogin.getPassword());
        List<Organizer> query = baseUtils.query(sql, list.toArray(), Organizer.class);
        if(query.isEmpty()){
            return null;
        }else {
            return query.get(0);
        }
    }

    @Override
    public boolean organizerRegisrt(Organizer organizer) {
        String sql = "insert into organizering values(null,?,?,?,?,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(organizer.getUsername());
        list.add(organizer.getPassword());
        list.add(organizer.getName());
        list.add(organizer.getPerson());
        list.add(organizer.getPhone());
        list.add(organizer.getIntroduction());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Organizer.class);
    }

    @Override
    public boolean isOrganizer(Organizer organizer) {
        String sql = "select * from organizer where organizername = ?";
        List<String> list = new LinkedList<>();
        list.add(organizer.getUsername());
        List<Organizer> query = baseUtils.query(sql, list.toArray(),Organizer.class);
        if(query.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean isOrganizering(Organizer organizer) {
        String sql = "select * from organizering where organizername = ?";
        List<String> list = new LinkedList<>();
        list.add(organizer.getUsername());
        List<Organizer> query = baseUtils.query(sql, list.toArray(),Organizer.class);
        if(query.isEmpty()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean OrganizerModify(Organizer organizer) {
        String sql = "update organizer set password= ? ,associationname = ?,personname = ? ,phone=? ,introduction=? where organizer_id= ?";
        List<Object> list = new LinkedList<>();
        list.add(organizer.getPassword());
        list.add(organizer.getName());
        list.add(organizer.getPerson());
        list.add(organizer.getPhone());
        list.add(organizer.getIntroduction());
        list.add(organizer.getId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(), User.class);
    }

    @Override
    public AllOrganizer findAllOrganizer() {
        return new AllOrganizer(baseUtils.query("select * from organizering",null,Organizer.class));
    }

    @Override
    public AllOrganizer findOrganizer(Organizer organizer) {
        String sql = "select * from organizering where associationname like '%"+organizer.getName()+"%'";
        return new AllOrganizer(baseUtils.query(sql,null,Organizer.class));
    }

    @Override
    public boolean attendOrganizer(Organizer organizer) {
        String sql = "delete from organizering where organizer_id = ?";
        List<Object> list = new LinkedList<>();
        list.add(organizer.getId());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Organizer.class);
    }

    @Override
    public boolean cancelOrganizer(Organizer organizer) {
        String sql = "insert into organizer values(null,?,?,?,?,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(organizer.getUsername());
        list.add(organizer.getPassword());
        list.add(organizer.getName());
        list.add(organizer.getPerson());
        list.add(organizer.getPhone());
        list.add(organizer.getIntroduction());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Organizer.class);
    }
}
