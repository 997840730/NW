package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Impl.SeeactivityInterfaceImpl;
import com.wangkaisheng.www.controller.SeeactivityInterface;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.po.User;

import javax.swing.*;
import java.awt.*;

/**
 * @author Administrator
 */
public class SeeActivityInterface {
    private final JFrame frame = new JFrame("活动");
    private final JButton seePicture = new JButton("查看附件");
    private final JButton attendActivity = new JButton("参加活动");
    private final JButton cancelActivity = new JButton("退出活动");
    private final JLabel activityTitle = new JLabel("活动主题",JLabel.CENTER);
    private final JTextField activityTitleText = new JTextField();

    private final JLabel activityAddress = new JLabel("活动地点",JLabel.CENTER);
    private final JLabel activityTime = new JLabel("活动时间",JLabel.CENTER);
    private final JLabel activityOrganizer = new JLabel("活动主办方",JLabel.CENTER);
    private final JLabel activityPerson = new JLabel("活动负责人",JLabel.CENTER);
    private final JLabel activityPhone = new JLabel("活动热线",JLabel.CENTER);

    private final JLabel activityAddressTest = new JLabel("",JLabel.CENTER);
    private final JLabel activityTimeTest = new JLabel("",JLabel.CENTER);
    private final JLabel activityOrganizerTest = new JLabel("",JLabel.CENTER);
    private final JLabel activityPersonTest = new JLabel("",JLabel.CENTER);
    private final JLabel activityPhoneTest = new JLabel("",JLabel.CENTER);

    private final JLabel activityContent = new JLabel("活动内容:",JLabel.CENTER);
    private final JTextArea activityContentText = new JTextArea();
    private final JLabel infoLab = new JLabel("活动",JLabel.CENTER);

    private final SeeactivityInterface seeactivityInterface = new SeeactivityInterfaceImpl();

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        //设置布局为 null
        infoLab.setBounds(150,30,150,20);
        panel.add(infoLab);
        activityTitle.setBounds(175,60,100,25);
        panel.add(activityTitle);
        activityTitleText.setBounds(175,90,100,25);
        panel.add(activityTitleText);

        activityAddress.setBounds(30,120,180,20);
        panel.add(activityAddress);
        activityAddressTest.setBounds(30,140,180,30);
        panel.add(activityAddressTest);
        activityTime.setBounds(240,120,180,20);
        panel.add(activityTime);
        activityTimeTest.setBounds(240,140,180,30);
        panel.add(activityTimeTest);

        activityOrganizer.setBounds(30,180,180,20);
        panel.add(activityOrganizer);
        activityOrganizerTest.setBounds(30,200,180,30);
        panel.add(activityOrganizerTest);
        activityPerson.setBounds(240,180,180,20);
        panel.add(activityPerson);
        activityPersonTest.setBounds(240,200,180,30);
        panel.add(activityPersonTest);

        activityPhone.setBounds(175,240,100,20);
        panel.add(activityPhone);
        activityPhoneTest.setBounds(175,260,100,30);
        panel.add(activityPhoneTest);

        activityContent.setBounds(175,290,100,25);
        panel.add(activityContent);
        activityContentText.setBounds(50,320,350,250);
        panel.add(activityContentText);

        attendActivity.setBounds(30,600,100,25);
        panel.add(attendActivity);
        seePicture.setBounds(160,600,100,25);
        panel.add(seePicture);
        cancelActivity.setBounds(300,600,100,25);
        panel.add(cancelActivity);

    }

    public SeeActivityInterface(User user, Activity activity) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 680);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);
        activityTitleText.setText(activity.getActivity_name());
        activityContentText.setText(activity.getActivity_content());
        activityAddressTest.setText(activity.getActivity_address());
        activityTimeTest.setText(activity.getActivity_date().toString());
        activityOrganizerTest.setText(activity.getActivity_organizer());
        activityPersonTest.setText(activity.getActivity_person());
        activityPhoneTest.setText(activity.getActivity_phone());

        attendActivity.addActionListener(actionEvent -> {
            if(seeactivityInterface.attendActivity(user,activity)){
                infoLab.setText("参加成功,正在审核");
            }else {
                infoLab.setText("您已参加");
            }
        });

        cancelActivity.addActionListener(actionEvent -> {
            if(seeactivityInterface.isActivity(user,activity)){
                infoLab.setText("审核已通过，不可退出");
            }else {
                if(seeactivityInterface.cancelActivity(user,activity)){
                    infoLab.setText("退出成功");
                }else {
                    infoLab.setText("您未参加过该活动");
                }
            }
        });
        seePicture.setText("没用的键");
    }
    public SeeActivityInterface(Organizer organizer, Activity activity) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 680);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);
        activityTitleText.setText(activity.getActivity_name());
        activityContentText.setText(activity.getActivity_content());
        activityAddressTest.setText(activity.getActivity_address());
        activityTimeTest.setText(activity.getActivity_date().toString());
        activityOrganizerTest.setText(activity.getActivity_organizer());
        activityPersonTest.setText(activity.getActivity_person());
        activityPhoneTest.setText(activity.getActivity_phone());


        attendActivity.setText("查看参加成员");
        cancelActivity.setText("查看申请成员");

        attendActivity.addActionListener(actionEvent -> {
            new seeUsered(organizer,activity);
        });

        cancelActivity.addActionListener(actionEvent -> {
           new seeUsering(activity);
        });

        seePicture.addActionListener(actionEvent -> {
            new OpenPicture(activity);
        });
    }

    public SeeActivityInterface(Organizer organizer, Activity activity,boolean flag) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 680);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);
        activityTitleText.setText(activity.getActivity_name());
        activityContentText.setText(activity.getActivity_content());
        activityAddressTest.setText(activity.getActivity_address());
        activityTimeTest.setText(activity.getActivity_date().toString());
        activityOrganizerTest.setText(activity.getActivity_organizer());
        activityPersonTest.setText(activity.getActivity_person());
        activityPhoneTest.setText(activity.getActivity_phone());


        attendActivity.setText("没用的键");
        cancelActivity.setText("撤销申请");


        cancelActivity.addActionListener(actionEvent -> {
            if(seeactivityInterface.cancelActivitying(activity)){
                frame.dispose();
            }else {
                infoLab.setText("撤销失败");
            }
        });

        seePicture.addActionListener(actionEvent -> {
            new OpenPicture(activity);
        });
    }

    public SeeActivityInterface(Activity activity) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 680);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);
        activityTitleText.setText(activity.getActivity_name());
        activityContentText.setText(activity.getActivity_content());
        activityAddressTest.setText(activity.getActivity_address());
        activityTimeTest.setText(activity.getActivity_date().toString());
        activityOrganizerTest.setText(activity.getActivity_organizer());
        activityPersonTest.setText(activity.getActivity_person());
        activityPhoneTest.setText(activity.getActivity_phone());


        attendActivity.setText("通过请求");
        cancelActivity.setText("没用的键");

        attendActivity.addActionListener(actionEvent -> {
            if(seeactivityInterface.adoptActivitying(activity)){
                frame.dispose();
            }else {
                infoLab.setText("执行失败");
            }
        });

        seePicture.addActionListener(actionEvent -> {
            new OpenPicture(activity);
        });
    }
}
