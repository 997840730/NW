package com.wangkaisheng.www.view;


import com.wangkaisheng.www.controller.Impl.UserregistImpl;
import com.wangkaisheng.www.controller.Userregist;
import com.wangkaisheng.www.po.User;

import javax.swing.*;
import java.awt.*;

/**
 * @author Administrator
 */
public class UserRegist {
    private User user;

    private final JFrame frame = new JFrame("欢迎");

    /**创建一个性别单选框**/
    private final JRadioButton JR1 = new JRadioButton("男");
    private final JRadioButton JR2 = new JRadioButton("女");
    private final ButtonGroup group = new ButtonGroup();
    /**创建一个年龄下拉列表**/
    private final JComboBox<Integer> ageBox = new JComboBox<Integer>();
    /** 创建NameLabel**/
    private final JLabel nameLabel = new JLabel("名称:");
    /** 获取名称 **/
    private final JTextField nameText = new JTextField();
    /** 创建UserJLabel **/
    private final JLabel userLabel = new JLabel("账号:");
    /** 获取账号 **/
    private final JTextField userText = new JTextField();
    /** 创建PassJLabel **/
    private final JLabel passLabel = new JLabel("密码:");
    /** 密码框隐藏 **/
    private final JPasswordField passText = new JPasswordField(20);
    /**创建电话获取框**/
    private final JLabel phone = new JLabel("电话");
    private final JTextField phoneText = new JTextField();
    /** 创建注册按钮 **/
    private final JButton registerButton = new JButton("注册");
    /** 创建重置按钮 **/
    private final JButton reset = new JButton("重置");
    /** 创建返回按钮 **/
    private final JButton back = new JButton("返回");
    /** 设置标签名 **/
    private final JLabel infoLab = new JLabel("用户注册系统");

    private final Userregist userregist = new UserregistImpl();

    private void placeComponents(JPanel panel) {
        //设置布局为 null
        panel.setLayout(null);
        //设置年龄下拉框
        ageBox.addItem(18);
        ageBox.addItem(19);
        ageBox.addItem(20);
        ageBox.addItem(21);
        ageBox.addItem(22);
        ageBox.addItem(23);
        ageBox.addItem(24);
        ageBox.addItem(25);
        ageBox.addItem(26);
        ageBox.setBounds(150,120,50,20);
        panel.add(ageBox);
        // 设置性别单选框
        JR1.setSelected(true);
        JR1.setFont(new Font("宋体", Font.PLAIN, 14));
        JR2.setFont(new Font("宋体", Font.PLAIN, 14));
        JR1.setBounds(300, 120, 54, 23);
        JR2.setBounds(350, 120, 54, 23);
        group.add(JR1);
        group.add(JR2);
        panel.add(JR1);
        panel.add(JR2);
        //设置标签名
        infoLab.setBounds(200,3,200,30);
        panel.add(infoLab);
        //设置NameJLabel
        nameLabel.setBounds(30, 30, 80, 25);
        panel.add(nameLabel);
        //设置文本域用于用户输入名称
        nameText.setBounds(105, 30, 165, 25);
        panel.add(nameText);
        //设置UserJLabel
        userLabel.setBounds(30, 60, 80, 25);
        panel.add(userLabel);
        //设置文本域用于用户输入账号
        userText.setBounds(105, 60, 165, 25);
        panel.add(userText);
        //设置PassJLabel
        passLabel.setBounds(30, 90, 80, 25);
        panel.add(passLabel);
        //设置密码输入框用于用户输入密码
        passText.setBounds(105, 90, 165, 25);
        panel.add(passText);

        phone.setBounds(30,150,80,25);
        panel.add(phone);
        phoneText.setBounds(105,150,165,25);
        panel.add(phoneText);

        // 创建注册按钮
        registerButton.setBounds(300, 30, 80, 25);
        panel.add(registerButton);
        //创建返回按钮
        reset.setBounds(300, 60, 80, 25);
        panel.add(reset);
        //创建重置按钮
        back.setBounds(300,90,80,25);
        panel.add(back);
    }

    public UserRegist() {
        final JPanel panel = new JPanel();
        //设置窗体的位置及大小

        frame.setSize(500, 300);
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

            back.addActionListener(actionEvent -> {
                frame.dispose();
                new UserLogin(null);
            });

            registerButton.addActionListener(actionEvent -> {
                String name=nameText.getText();
                String username=userText.getText();
                String password=new String(passText.getPassword());
                String gender;
                if(JR1.isSelected()){
                    gender="男";
                }else{
                    gender="女";
                }
                String age= ageBox.getSelectedItem().toString();
                String phone = phoneText.getText();
                if(name==null||"".equals(name)||username==null||"".equals(username)||"".equals(password)){
                    infoLab.setText("账号,密码或名称不能为空");
                }else{
                    user=new User(name,username,password,gender,Integer.parseInt(age),phone);

                    if(userregist.regist(user)){
                        frame.dispose();
                        new UserLogin(user);
                    }else{
                        infoLab.setText("账号已存在请重新输入！");
                    }
                }
            });

            reset.addActionListener(e -> {
                if (e.getSource() == reset){
                    nameText.setText(null);
                    userText.setText(null);
                    passText.setText(null);
                    phoneText.setText(null);
                    infoLab.setText("用户注册系统");
                }
            });


        }
}