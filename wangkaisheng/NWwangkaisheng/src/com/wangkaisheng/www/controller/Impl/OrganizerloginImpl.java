package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Organizerlogin;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

/**
 * @author Administrator
 */
public class OrganizerloginImpl  implements Organizerlogin {
    private final Service service = new ServiceImpl();
    @Override
    public Organizer isOrganizer(Organizer organizer1) {
        return service.isOrganizer(organizer1);
    }
}
