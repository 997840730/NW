package com.wangkaisheng.www.po.Allpo;

import com.wangkaisheng.www.po.Organizer;

import java.util.List;

/**
 * @author Administrator
 */
public class AllOrganizer {
    private List<Organizer> organizerList;

    public List<Organizer> getOrganizerList() {
        return organizerList;
    }

    public void setOrganizerList(List<Organizer> organizerList) {
        this.organizerList = organizerList;
    }

    public AllOrganizer() {
    }

    public AllOrganizer(List<Organizer> organizerList) {
        this.organizerList = organizerList;
    }
}
