package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.AddactivityInterface;
import com.wangkaisheng.www.controller.Impl.AddactivityInterfaceImpl;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Organizer;

import javax.swing.*;
import java.text.SimpleDateFormat;

/**
 * @author Administrator
 */
public class AddActivityInterface {
    private final JFrame frame = new JFrame("活动");
    private final JButton seePicture = new JButton("查看附件");
    private final JButton addActivity = new JButton("发布");
    private final JButton reset = new JButton("重置");
    private final JLabel activityTitle = new JLabel("活动主题",JLabel.CENTER);
    private final JTextField activityTitleText = new JTextField();

    private final JLabel activityAddress = new JLabel("活动地点",JLabel.CENTER);
    private final JLabel activityTime = new JLabel("活动时间",JLabel.CENTER);

    private final JTextField activityAddressTest = new JTextField("",JLabel.CENTER);
    private final JLabel year = new JLabel("年");
    private final JLabel month = new JLabel("月");
    private final JLabel day = new JLabel("日");
    private final JTextField yearText = new JTextField("",JLabel.CENTER);
    private final JTextField monthText = new JTextField("",JLabel.CENTER);
    private final JTextField dayText = new JTextField("",JLabel.CENTER);

    private final JLabel activityContent = new JLabel("活动内容:",JLabel.CENTER);
    private final JTextArea activityContentText = new JTextArea();
    private final JLabel infoLab = new JLabel("活动",JLabel.CENTER);

    private final AddactivityInterface addactivityInterface = new AddactivityInterfaceImpl();

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

        year.setBounds(240,140,30,30);
        panel.add(year);
        yearText.setBounds(270,140,30,30);
        panel.add(yearText);
        month.setBounds(300,140,30,30);
        panel.add(month);
        monthText.setBounds(330,140,30,30);
        panel.add(monthText);
        day.setBounds(360,140,30,30);
        panel.add(day);
        dayText.setBounds(390,140,30,30);
        panel.add(dayText);

        activityContent.setBounds(175,170,100,25);
        panel.add(activityContent);
        activityContentText.setBounds(50,200,350,250);
        panel.add(activityContentText);

        addActivity.setBounds(30,480,100,25);
        panel.add(addActivity);
        seePicture.setBounds(160,480,100,25);
        panel.add(seePicture);
        reset.setBounds(300,480,100,25);
        panel.add(reset);

    }

    public AddActivityInterface(Organizer organizer) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 640);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);

        addActivity.addActionListener(actionEvent -> {
            String title = activityTitleText.getText();
            if(title==null||"".equals(title)){
                infoLab.setText("题目不能为空");
                return;
            }
            String content = activityContentText.getText();
            if(content==null||"".equals(content)){
                infoLab.setText("内容不能为空");
                return;
            }
            String address = activityAddressTest.getText();
            if(address==null||"".equals(address)){
                infoLab.setText("地点不能为空");
                return;
            }
            String year = yearText.getText();
            String month = monthText.getText();
            String day = dayText.getText();
            if(year==null||month==null||day==null){
                infoLab.setText("日期不能为空");
                return;
            }
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            String time = year+"-"+month+"-"+day;
            Activity activity = null;
            activity = new Activity(title,content,java.sql.Date.valueOf(time),address,organizer.getName(),organizer.getPerson(),organizer.getPhone(),organizer.getId());
            System.out.println(activity);
            if(addactivityInterface.addactivity(organizer,activity)){
                frame.dispose();
            }else {
                infoLab.setText("发布失败");
            }
        });

        reset.addActionListener(actionEvent -> {
            activityTitleText.setText(null);
            activityContentText.setText(null);
            activityAddressTest.setText(null);
            yearText.setText(null);
            monthText.setText(null);
            dayText.setText(null);

        });

        seePicture.addActionListener(actionEvent -> {
            new Addpicture(organizer);
        });
    }
}
