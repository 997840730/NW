package com.wangkaisheng.www.controller.Impl;

import com.wangkaisheng.www.controller.Adminnotice;
import com.wangkaisheng.www.po.Allpo.AllNotice;
import com.wangkaisheng.www.po.Notice;
import com.wangkaisheng.www.service.Impl.ServiceImpl;
import com.wangkaisheng.www.service.Service;

/**
 * @author Administrator
 */
public class AdminnoticeImpl  implements Adminnotice {
    private final Service service = new ServiceImpl();
    @Override
    public AllNotice findAllNotice() {
        return service.findAllNotice();
    }

    @Override
    public boolean cancelNotice(Notice notice) {
        return service.cancelNotice(notice);
    }
}
