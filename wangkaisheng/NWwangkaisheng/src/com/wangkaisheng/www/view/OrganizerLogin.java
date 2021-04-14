package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Impl.OrganizerloginImpl;
import com.wangkaisheng.www.controller.Organizerlogin;
import com.wangkaisheng.www.po.Organizer;

import javax.swing.*;

/**
 * @author Administrator
 * @主办方登录界面
 */
public class OrganizerLogin {
    private final Organizerlogin organizerlogin = new OrganizerloginImpl();
    public OrganizerLogin(Organizer organizer){
        JFrame frame = new JFrame("欢迎您");
        JButton submit = new JButton("登录");
        JButton back = new JButton("返回");
        JLabel infoLab = new JLabel("主办方登录系统");
        JTextField nameText = new JTextField();
        JPasswordField passText = new JPasswordField();
        final JButton regist = new JButton("注册");
        final JLabel usernameLab = new JLabel("账  号：");
        final JLabel passLab = new JLabel("密  码：");
        frame.setLayout(null);
        usernameLab.setBounds(5,5,60,20);
        passLab.setBounds(5,30,60,20);
        infoLab.setBounds(5,65,220,30);
        nameText.setBounds(65,5,100,20);
        passText.setBounds(65,30,100,20);
        submit.setBounds(170,5,60,20);
        back.setBounds(170,30,60,20);
        regist.setBounds(170,65,60,20);
        frame.add(usernameLab);
        frame.add(passLab);
        frame.add(infoLab);
        frame.add(nameText);
        frame.add(passText);
        frame.add(submit);
        frame.add(back);
        frame.add(regist);
        frame.setSize(280,130);
        frame.setLocation(400,300);
        frame.setVisible(true);

        if(organizer!=null){
            nameText.setText(organizer.getUsername());
            passText.setText(organizer.getPassword());
        }


        regist.addActionListener(actionEvent -> {
            frame.dispose();
            new OrganizerRegist();
        });

        submit.addActionListener(e -> {
            String username = nameText.getText();
            String password = new String(passText.getPassword());
            if(username==null||"".equals(username)||"".equals(password)){
                infoLab.setText("账号或密码不能为空");
                return;
            }
            Organizer organizer1 = new Organizer();
            organizer1.setUsername(username);
            organizer1.setPassword(password);
            Organizer organizer2 = organizerlogin.isOrganizer(organizer1);
            if(organizer2!=null){
                infoLab.setText("登录成功，欢迎光临");
                frame.dispose();
                new HomePage(organizer2);
            }else{
                infoLab.setText("账号或密码错误");
            }
        });

        back.addActionListener(actionEvent -> {
            frame.dispose();
            new FirstPage();
        });

    }
}
