package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Organizerregist;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

/**
 * @author Administrator
 */
public class OrganizerregistImpl implements Organizerregist {
    private final Service service = new ServiceImpl();
    @Override
    public boolean regist(Organizer organizer) {
        return service.organizerregist(organizer);
    }
}
