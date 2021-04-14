package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Homepage;
import com.wangkaisheng.www.po.Allpo.AllNotice;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

/**
 * @author Administrator
 */
public class HomepageImpl implements Homepage {
    private final Service service = new ServiceImpl();
    @Override
    public AllNotice findAllNotice() {
        return service.findAllNotice();
    }
}
