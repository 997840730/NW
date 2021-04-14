package com.wangkaisheng.www.view;


import com.wangkaisheng.www.controller.Impl.InformationinterfaceImpl;
import com.wangkaisheng.www.controller.Informationinterface;
import com.wangkaisheng.www.po.User;

import javax.swing.*;
import java.awt.*;

/**
 * @author Administrator
 */
public class InformationInterface {
    private final JFrame frame = new JFrame("欢迎");


    /**创建一个性别单选框**/
    private final JRadioButton JR1 = new JRadioButton("男");
    private final JRadioButton JR2 = new JRadioButton("女");
    private final ButtonGroup group = new ButtonGroup();
    /**创建一个年龄下拉列表**/
    private final JComboBox<Integer> ageBox = new JComboBox<>();

    /** 创建NameLabel**/
    private final JLabel nameLabel = new JLabel("名称:");
    /** 获取名称 **/
    private final JTextField nameText = new JTextField();
    /** 创建PassJLabel **/
    private final JLabel passLabel = new JLabel("密码:");
    /** 密码框隐藏 **/
    private final JPasswordField passText = new JPasswordField(20);
    /** 创建PassJLabel **/
    private final JLabel passLabel2 = new JLabel("确认密码:");
    /** 密码框隐藏用于确认密码 **/
    private final JPasswordField passText2 = new JPasswordField(20);
    private final JLabel phoneLabel = new JLabel("手机号码:");
    private final JTextField phoneText = new JTextField();
    private final JLabel timeLable = new JLabel("时长:");
    private final JLabel timeText = new JLabel();
    /** 创建确定修改按钮 **/
    private final JButton modifyButton = new JButton("确认修改");
    /** 创建重置按钮 **/
    private final JButton reset = new JButton("重置");
    /** 创建返回按钮 **/
    private final JButton back = new JButton("返回");
    /** 创建返回按钮 **/
    private final JButton cancellation = new JButton("注销");

    private final JLabel infoLab = new JLabel("用户修改个人信息");

    private final Informationinterface informationinterface = new InformationinterfaceImpl();

    public InformationInterface(User user) {
        final JPanel panel = new JPanel();
        //设置窗体的位置及大小
        nameText.setText(user.getName());
        passText.setText(user.getPassword());
        phoneText.setText(user.getPhone());
        timeText.setText(String.valueOf(user.getTime()));

        if (!JR1.getText().equals(user.getGender())) {
            JR2.isSelected();
        } else {
            JR1.isSelected();
        }

        frame.setSize(500, 320);
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
            new HomePage(user);
        });

        modifyButton.addActionListener(actionEvent -> {
            String name=nameText.getText();
            String password=new String(passText.getPassword());
            String password2= new String(passText2.getPassword());
            String phone = phoneText.getText();
            String age = ageBox.getSelectedItem().toString();
            String gender;
            if(JR1.isSelected()){
                gender = "男";
            }else {
                gender = "女";
            }
            if(!password.equals(password2)){
                infoLab.setText("两次输入密码不同");
            }else{
                if(name==null||"".equals(name)||"".equals(password2)){
                    infoLab.setText("密码或名称不能为空");
                }else{
                    user.setName(name);
                    user.setPassword(password);
                    if(phone!=null&&!"".equals(phone)){
                        user.setPhone(phone);
                    }
                    user.setAge(Integer.parseInt(age));
                    user.setGender(gender);
                    if (informationinterface.modifyUser(user)){
                        frame.dispose();
                        new HomePage(user);
                    }else {
                        infoLab.setText("修改失败");
                    }
                }
            }
        });

        reset.addActionListener(e -> {
            if (e.getSource() == reset){
                nameText.setText(user.getName());
                passText.setText(user.getPassword());
            }
        });

        cancellation.addActionListener(actionEvent -> {
            frame.dispose();
            new ConfirmCancellation(user);
        });
    }
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

        infoLab.setBounds(200,3,200,30);

        panel.add(infoLab);
        //设置NameJLabel
        nameLabel.setBounds(30, 30, 80, 25);
        panel.add(nameLabel);
        //设置文本域用于用户输入名称
        nameText.setBounds(105, 30, 165, 25);
        panel.add(nameText);
        //设置UserJLabel
        passLabel.setBounds(30, 60, 80, 25);
        panel.add(passLabel);
        //设置文本域用于用户输入账号
        passText.setBounds(105, 60, 165, 25);
        panel.add(passText);
        //设置PassJLabel
        passLabel2.setBounds(30, 90, 80, 25);
        panel.add(passLabel2);
        //设置密码输入框用于用户输入密码
        passText2.setBounds(105, 90, 165, 25);
        panel.add(passText2);

        phoneLabel.setBounds(30,150,80, 25);
        panel.add(phoneLabel);
        phoneText.setBounds(105,150,80, 25);
        panel.add(phoneText);

        timeLable.setBounds(30,180,80, 25);
        panel.add(timeLable);
        timeText.setBounds(105,180,80, 25);
        panel.add(timeText);
        // 创建确定修改按钮
        modifyButton.setBounds(300, 30, 100, 25);
        panel.add(modifyButton);
        //创建重置按钮
        reset.setBounds(300, 60, 100, 25);
        panel.add(reset);
        //创建返回按钮
        back.setBounds(300,90,100,25);
        panel.add(back);
        //创建注销按钮
        cancellation.setBounds(300,150,100,25);
        panel.add(cancellation);

    }
}
