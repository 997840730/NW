package com.wangkaisheng.www.controller;

import com.wangkaisheng.www.po.Allpo.AllNotice;
import com.wangkaisheng.www.po.Notice;

public interface Adminnotice {
    AllNotice findAllNotice();

    boolean cancelNotice(Notice notice);
}
