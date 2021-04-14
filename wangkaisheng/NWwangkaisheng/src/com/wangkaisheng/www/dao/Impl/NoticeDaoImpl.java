package com.wangkaisheng.www.dao.Impl;


import com.wangkaisheng.www.dao.NoticeDao;
import com.wangkaisheng.www.po.Allpo.AllNotice;
import com.wangkaisheng.www.po.Notice;
import com.wangkaisheng.www.util.BaseUtils;
import com.wangkaisheng.www.util.Impl.BaseUtilesImpl;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class NoticeDaoImpl implements NoticeDao {
    private final BaseUtils baseUtils = new BaseUtilesImpl();
    @Override
    public AllNotice getAllNotice() {
        String sql = "select * from notice";
        List<Notice> query = baseUtils.query(sql,null, Notice.class);
        return new AllNotice(query);
    }

    @Override
    public boolean cancelNotice(Notice notice) {
        String sql = "delete from notice where notice_title = ? and notice_content = ?";
        List<Object> list = new LinkedList<>();
        list.add(notice.getNotice_title());
        list.add(notice.getNotice_content());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Notice.class);
    }

    @Override
    public boolean addNotice(Notice notice) {
        String sql = "insert into notice values(null,?,?,?)";
        List<Object> list = new LinkedList<>();
        list.add(notice.getNotice_title());
        list.add(notice.getNotice_content());
        notice.setNotice_date(new Date(new java.util.Date().getTime()));
        list.add(notice.getNotice_date());
        return baseUtils.addAndcancelAndmodify(sql,list.toArray(),Notice.class);
    }
}
