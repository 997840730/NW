package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.OrganizerinformationInterface;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

/**
 * @author Administrator
 */
public class OrganizerInformationInterfaceImpl implements OrganizerinformationInterface {
    private final Service service = new ServiceImpl();
    @Override
    public boolean OrganizerModify(Organizer organizer) {
        return service.OrganizerModify(organizer);
    }
}
