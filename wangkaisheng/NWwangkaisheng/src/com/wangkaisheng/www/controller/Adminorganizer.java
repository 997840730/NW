package com.wangkaisheng.www.controller;

import com.wangkaisheng.www.po.Allpo.AllOrganizer;
import com.wangkaisheng.www.po.Organizer;

/**
 * @author Administrator
 */
public interface Adminorganizer {
    AllOrganizer findAllOrganizer();

    AllOrganizer findOrganizer(Organizer organizer);

    Organizer getAllOrganizer(AllOrganizer allOrganizer, Organizer organizer);
}
