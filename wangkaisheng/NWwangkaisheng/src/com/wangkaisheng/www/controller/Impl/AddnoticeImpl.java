package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Addnotice;
import com.wangkaisheng.www.po.Notice;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

public class AddnoticeImpl implements Addnotice {
    private final Service service = new ServiceImpl();
    @Override
    public boolean addNotice(Notice notice) {
        return service.addNotice(notice);
    }
}
