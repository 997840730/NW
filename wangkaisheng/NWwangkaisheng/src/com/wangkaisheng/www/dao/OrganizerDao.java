package com.wangkaisheng.www.dao;


import com.wangkaisheng.www.po.Allpo.AllOrganizer;
import com.wangkaisheng.www.po.Organizer;

public interface OrganizerDao {
    Organizer organizerLogin(Organizer organizerlogin);

    boolean organizerRegisrt(Organizer organizer);

    boolean isOrganizer(Organizer organizer);

    boolean isOrganizering(Organizer organizer);

    boolean OrganizerModify(Organizer organizer);

    AllOrganizer findAllOrganizer();

    AllOrganizer findOrganizer(Organizer organizer);

    boolean attendOrganizer(Organizer organizer);

    boolean cancelOrganizer(Organizer organizer);
}
