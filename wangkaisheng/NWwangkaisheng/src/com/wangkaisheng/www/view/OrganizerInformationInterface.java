package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Impl.OrganizerInformationInterfaceImpl;
import com.wangkaisheng.www.controller.Impl.OrganizerregistImpl;
import com.wangkaisheng.www.controller.OrganizerinformationInterface;
import com.wangkaisheng.www.controller.Organizerregist;
import com.wangkaisheng.www.po.Organizer;

import javax.swing.*;

/**
 * @author Administrator
 */
public class OrganizerInformationInterface {
    private final JFrame frame = new JFrame("修改社团信息");
    /** 创建NameLabel**/
    private final JLabel nameLabel = new JLabel("名称:");
    /** 获取名称 **/
    private final JTextField nameText = new JTextField();
    /** 创建PassJLabel **/
    private final JLabel passLabel = new JLabel("密码:");
    /** 密码框隐藏 **/
    private final JPasswordField passText = new JPasswordField(20);
    private final JLabel passLabel1= new JLabel("确认密码");
    private final JPasswordField passText1 = new JPasswordField();


    /**创建电话获取框**/
    private final JLabel phone = new JLabel("电话");
    private final JTextField phoneText = new JTextField();
    /**创建负责人获取框**/
    private final JLabel person = new JLabel("社团负责人");
    private final JTextField personText = new JTextField();

    /** 创建注册按钮 **/
    private final JButton modifyButton = new JButton("修改");
    /** 创建重置按钮 **/
    private final JButton reset = new JButton("重置");
    /** 创建返回按钮 **/
    private final JButton back = new JButton("返回");
    /** 设置标签名 **/
    private final JLabel infoLab = new JLabel("用户注册系统");
    /**创建DescriptionLabel**/
    private final JLabel descriptionLabel = new JLabel("简介:");
    /** 获得个人说明 **/
    private final JTextArea descriptionText = new JTextArea();

    private final OrganizerinformationInterface organizerinformationInterface = new OrganizerInformationInterfaceImpl();

    private void placeComponents(JPanel panel) {
        //设置布局为 null
        panel.setLayout(null);
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
        passLabel1.setBounds(30, 60, 80, 25);
        panel.add(passLabel1);
        //设置文本域用于用户输入账号
        passText1.setBounds(105, 60, 165, 25);
        panel.add(passText1);
        //设置PassJLabel
        passLabel.setBounds(30, 90, 80, 25);
        panel.add(passLabel);
        //设置密码输入框用于用户输入密码
        passText.setBounds(105, 90, 165, 25);
        panel.add(passText);

        phone.setBounds(30,120,80,25);
        panel.add(phone);
        phoneText.setBounds(105,120,165,25);
        panel.add(phoneText);
        person.setBounds(30,150,80,25);
        panel.add(person);
        personText.setBounds(105,150,165,25);
        panel.add(personText);

        //设置个人说明框标签
        descriptionLabel.setBounds(30,180,80,25);
        panel.add(descriptionLabel);
        //设置个人说明框用于用户输入个人说明
        descriptionText.setLineWrap(true);
        //设置文本域中的文本为自动换行
        descriptionText.setColumns(10);
        descriptionText.setRows(10);
        descriptionText.setBounds(105,180,165,100);
        panel.add(descriptionText);

        // 创建修改按钮
        modifyButton.setBounds(300, 30, 80, 25);
        panel.add(modifyButton);
        //创建返回按钮
        reset.setBounds(300, 60, 80, 25);
        panel.add(reset);
        //创建重置按钮
        back.setBounds(300,90,80,25);
        panel.add(back);
    }

    public OrganizerInformationInterface(Organizer organizer) {
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

        nameText.setText(organizer.getName());
        passText1.setText(null);
        passText.setText(organizer.getPassword());
        phoneText.setText(organizer.getPhone());
        personText.setText(organizer.getPerson());
        descriptionText.setText(organizer.getIntroduction());

        back.addActionListener(actionEvent -> {
            frame.dispose();
            new HomePage(organizer);
        });

        reset.addActionListener(actionEvent -> {
            nameText.setText(organizer.getName());
            passText1.setText(null);
            passText.setText(organizer.getPassword());
            phoneText.setText(organizer.getPhone());
            personText.setText(organizer.getPerson());
            descriptionText.setText(organizer.getIntroduction());
        });

        modifyButton.addActionListener(actionEvent -> {
            String name = nameText.getText();
            if(name==null||"".equals(name)){
                infoLab.setText("名称不能为空");
                return;
            }
            organizer.setName(name);
            String password = passText.getText();
            if(password==null||"".equals(password)){
                infoLab.setText("密码不能为空");
                return;
            }
            String password1 = String.valueOf(passText1.getPassword());
            if("".equals(password1)){
                infoLab.setText("请再次输入密码");
                return;
            }else {
                if(!password.equals(password1)){
                    infoLab.setText("两次输入密码不同");
                    return;
                }
            }
            organizer.setPassword(password);
            String phone = phoneText.getText();
            if(phone==null||"".equals(phone)){
                infoLab.setText("电话号码不能为空");
                return;
            }
            organizer.setPhone(phone);
            String person = personText.getText();
            if(person==null||"".equals(person)){
                infoLab.setText("负责人不能为空");
                return;
            }
            organizer.setPerson(person);
            String introduction = descriptionText.getText();
            if(!introduction.equals(organizer.getIntroduction())){
                organizer.setIntroduction(introduction);
            }
            if(organizerinformationInterface.OrganizerModify(organizer)){
                frame.dispose();
                new HomePage(organizer);
            }else{
                infoLab.setText("修改失败");
            }
        });

    }

}
