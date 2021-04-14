package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Impl.SeeactivityInterfaceImpl;
import com.wangkaisheng.www.controller.Impl.SeeorganizerInterfaceImpl;
import com.wangkaisheng.www.controller.SeeactivityInterface;
import com.wangkaisheng.www.controller.SeeorganizerInterface;
import com.wangkaisheng.www.po.Organizer;

import javax.swing.*;

/**
 * @author Administrator
 */
public class SeeOrganizerInterface {
    private final JFrame frame = new JFrame("申请的账号");
    private final JButton attendOrganizer = new JButton("批准");

    private final JLabel organizerName = new JLabel("社团名",JLabel.CENTER);
    private final JLabel organizerUsername = new JLabel("账号",JLabel.CENTER);
    private final JLabel organizerPerson = new JLabel("负责人",JLabel.CENTER);
    private final JLabel organizerPhone = new JLabel("手机号码",JLabel.CENTER);

    private final JLabel organizerNameText = new JLabel("",JLabel.CENTER);
    private final JLabel organizerUsernameTest = new JLabel("",JLabel.CENTER);
    private final JLabel organizerPersonTest = new JLabel("",JLabel.CENTER);
    private final JLabel organizerPhoneTest = new JLabel("",JLabel.CENTER);


    private final JLabel introduction = new JLabel("简介:",JLabel.CENTER);
    private final JTextArea introductionText = new JTextArea();
    private final JLabel infoLab = new JLabel("活动",JLabel.CENTER);

    private final SeeorganizerInterface seeorganizerInterface = new SeeorganizerInterfaceImpl();

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        //设置布局为 null
        infoLab.setBounds(150,30,150,20);
        panel.add(infoLab);

        organizerName.setBounds(30,60,180,20);
        panel.add(organizerName);
        organizerNameText.setBounds(30,80,180,30);
        panel.add(organizerNameText);
        organizerUsername.setBounds(240,60,180,20);
        panel.add(organizerUsername);
        organizerUsernameTest.setBounds(240,80,180,30);
        panel.add(organizerUsernameTest);

        organizerPerson.setBounds(30,110,180,20);
        panel.add(organizerPerson);
        organizerPersonTest.setBounds(30,130,180,30);
        panel.add(organizerPersonTest);
        organizerPhone.setBounds(240,110,180,20);
        panel.add(organizerPhone);
        organizerPhoneTest.setBounds(240,130,180,30);
        panel.add(organizerPhoneTest);

        introduction.setBounds(175,160,100,25);
        panel.add(introduction);
        introductionText.setBounds(50,180,350,200);
        panel.add(introductionText);

        attendOrganizer.setBounds(160,420,100,25);
        panel.add(attendOrganizer);

    }

    public SeeOrganizerInterface(Organizer organizer) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 500);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);
        organizerNameText.setText(organizer.getName());
        organizerUsernameTest.setText(organizer.getUsername());
        organizerPersonTest.setText(organizer.getPerson());
        organizerPhoneTest.setText(organizer.getPhone());
        introductionText.setText(organizer.getIntroduction());

        attendOrganizer.addActionListener(actionEvent -> {
            if(seeorganizerInterface.attendOrganizer(organizer)){
                frame.dispose();
            }else {
                infoLab.setText("批准失败");
            }
        });
    }
}
