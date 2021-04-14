package com.wangkaisheng.www.po.Allpo;


import com.wangkaisheng.www.po.Activity;

import java.util.List;

/**
 * @author Administrator
 */
public class AllActivity {
    private List<Activity> activities;

    public AllActivity(List<Activity> activities) {
        this.activities = activities;
    }

    public AllActivity() {
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
