package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Adminorganizer;
import com.wangkaisheng.www.po.Allpo.AllOrganizer;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

public class AdminorganizerImpl implements Adminorganizer {
    private Service service = new ServiceImpl();
    @Override
    public AllOrganizer findAllOrganizer() {
        return service.findAllOrganizer();
    }

    @Override
    public AllOrganizer findOrganizer(Organizer organizer) {
        return service.findOrganizer(organizer);
    }

    @Override
    public Organizer getAllOrganizer(AllOrganizer allOrganizer, Organizer organizer) {
        return service.getAllOrganizer(allOrganizer,organizer);
    }
}
