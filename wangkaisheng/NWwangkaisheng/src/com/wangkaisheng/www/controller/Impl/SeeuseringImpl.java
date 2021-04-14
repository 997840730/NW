package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Seeusering;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllUser;
import com.wangkaisheng.www.po.User;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;


/**
 * @author Administrator
 */
public class SeeuseringImpl implements Seeusering {
    private final Service service = new ServiceImpl();
    @Override
    public AllUser findUser(Activity activity) {
        return service.findUsering(activity);
    }

    @Override
    public boolean adoptUser(User user,Activity activity) {
        return service.adoptUser(user,activity);
    }
}
