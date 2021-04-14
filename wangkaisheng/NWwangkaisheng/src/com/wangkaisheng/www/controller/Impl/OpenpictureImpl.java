package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Openpicture;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.Pictures;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

public class OpenpictureImpl implements Openpicture {
    private final Service service= new ServiceImpl();
    @Override
    public Pictures findPictures(Activity activity) {
        return service.findPictures(activity);
    }
}
