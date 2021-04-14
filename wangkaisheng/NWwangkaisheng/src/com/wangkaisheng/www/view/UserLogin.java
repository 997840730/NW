package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Impl.UserloginImpl;
import com.wangkaisheng.www.controller.Userlogin;
import com.wangkaisheng.www.po.User;

import javax.swing.*;

/**
 * @author Administrator
 */
public class UserLogin {
    public UserLogin(User user){
        JFrame frame = new JFrame("欢迎您");
        JButton submit = new JButton("登录");
        JButton back = new JButton("返回");
        JLabel infoLab = new JLabel("用户登录系统");
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

        if(user!=null){
            nameText.setText(user.getUsername());
            passText.setText(user.getPassword());
        }


        regist.addActionListener(actionEvent -> {
            frame.dispose();
            new UserRegist();
        });

        submit.addActionListener(e -> {
            String username = nameText.getText();
            String password = new String(passText.getPassword());
            if(username==null||"".equals(username)||"".equals(password)){
                infoLab.setText("账号或密码不能为空");
                return;
            }
            Userlogin userlogin = new UserloginImpl();
            User user1 = new User();
            user1.setUsername(username);
            user1.setPassword(password);
            if(userlogin.isUser(user1)){
                infoLab.setText("登录成功，欢迎光临");
                frame.dispose();
                new HomePage(user1);
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
