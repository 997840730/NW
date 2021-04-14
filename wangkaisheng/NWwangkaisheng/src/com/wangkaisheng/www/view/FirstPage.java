package com.wangkaisheng.www.view;

import javax.swing.*;

/**
 * @author Administrator
 */
public class FirstPage {
    private final JFrame frame = new JFrame("用户登录");
    private final JButton OrganizerLogin = new JButton("主办方登录");
    private final JButton AdminLogin = new JButton("管理员");
    private final JButton UserLogin = new JButton("用户登录");
    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        //设置布局为 null
        UserLogin.setBounds(30,30,100,25);
        panel.add(UserLogin);
        OrganizerLogin.setBounds(160,30,100,25);
        panel.add(OrganizerLogin);
        AdminLogin.setBounds(300,30,100,25);
        panel.add(AdminLogin);
    }

    public FirstPage() {
        //设置窗体的位置及大小
        final JPanel panel = new JPanel();
        frame.setSize(450, 130);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);
        //设置窗体可见

        UserLogin.addActionListener(actionEvent -> {
            frame.dispose();
            new UserLogin(null);
        });

        OrganizerLogin.addActionListener(actionEvent -> {
            frame.dispose();
            new OrganizerLogin(null);
        });

        AdminLogin.addActionListener(actionEvent -> {
            frame.dispose();
            new AdminLogin();
        });
    }
}
