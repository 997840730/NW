package com.wangkaisheng.www.dao;


import com.wangkaisheng.www.po.Allpo.AllNotice;
import com.wangkaisheng.www.po.Notice;

/**
 * @author Administrator
 */
public interface NoticeDao {
    AllNotice getAllNotice();

    boolean cancelNotice(Notice notice);

    boolean addNotice(Notice notice);
}
