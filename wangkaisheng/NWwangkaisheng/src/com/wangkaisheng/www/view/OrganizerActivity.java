package com.wangkaisheng.www.view;

import com.wangkaisheng.www.po.Allpo.AllActivity;
import com.wangkaisheng.www.po.Organizer;

import javax.swing.*;

/**
 * @author Administrator
 */
public class OrganizerActivity {
    private final JFrame frame = new JFrame("活动");
    private final JButton Activityed = new JButton("已发布的活动");
    private final JButton Activitying = new JButton("审核中的活动");
    private final JButton AddActivity = new JButton("发布活动");
    private final JButton back = new JButton("返回");

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);
        Activityed.setBounds(50,30,150,25);
        panel.add(Activityed);
        Activitying.setBounds(250,30,150,25);
        panel.add(Activitying);
        AddActivity.setBounds(50,60,150,25);
        panel.add(AddActivity);
        back.setBounds(250,60,150,25);
        panel.add(back);
    }
    public OrganizerActivity(Organizer organizer) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        placeComponents(panel);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        frame.setVisible(true);

        back.addActionListener(actionEvent -> {
            frame.dispose();
            new HomePage(organizer);
        });

        Activityed.addActionListener(actionEvent -> {
            frame.dispose();
            new ActivityedInterface(organizer);
        });

        Activitying.addActionListener(actionEvent -> {
            frame.dispose();
            new ActivityingInterface(organizer);
        });

        AddActivity.addActionListener(actionEvent -> {
            new AddActivityInterface(organizer);
        });
    }
}
