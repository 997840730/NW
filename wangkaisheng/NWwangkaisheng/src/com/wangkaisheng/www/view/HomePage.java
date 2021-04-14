package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Homepage;
import com.wangkaisheng.www.controller.Impl.HomepageImpl;
import com.wangkaisheng.www.po.Allpo.AllNotice;
import com.wangkaisheng.www.po.Notice;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.po.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * @author Administrator
 */
public class HomePage {
    private final JFrame frame = new JFrame("首页");
    private final JButton Information = new JButton("个人信息");
    private final JButton activity = new JButton("活动");
    private final JButton back = new JButton("退出");
    private final JLabel infoLab = new JLabel("公告",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();

    private final Homepage homepage = new HomepageImpl();

    private void placeComponents(JPanel panel, AllNotice allNotice) {
        panel.setLayout(null);
        //设置布局为 null
        Information.setBounds(50,30,150,25);
        panel.add(Information);
        activity.setBounds(250,30,150,25);
        panel.add(activity);
        back.setBounds(50,60,150,25);
        panel.add(back);
        infoLab.setBounds(60,90,330,25);
        panel.add(infoLab);

        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"标题","内容","公告时间"});
        tableUser.setRowHeight(30);
        addComment(allNotice);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,120,390,270);
        panel.add(scrollPane);
    }

    private void addComment(AllNotice allNotice){
        if(allNotice!=null){
            for (Notice temp:allNotice.getNoticeList()) {
                tableModel.addRow(new Object[]{temp.getNotice_title(),temp.getNotice_content(),temp.getNotice_date()});
            }
        }
    }

    public HomePage(User user) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        AllNotice allNotice = homepage.findAllNotice();
        placeComponents(panel,allNotice);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        frame.setVisible(true);

        back.addActionListener(actionEvent -> {
            frame.dispose();
            new UserLogin(user);
        });

        activity.addActionListener(actionEvent -> {
            frame.dispose();
            new ActivityInterface(user);
        });

        Information.addActionListener(actionEvent -> {
            frame.dispose();
            new InformationInterface(user);
        });
    }
    public HomePage(Organizer organizer) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        AllNotice allNotice = homepage.findAllNotice();
        placeComponents(panel,allNotice);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        frame.setVisible(true);

        back.addActionListener(actionEvent -> {
            frame.dispose();
            new OrganizerLogin(organizer);
        });

        activity.addActionListener(actionEvent -> {
            frame.dispose();
            new OrganizerActivity(organizer);
        });

        Information.addActionListener(actionEvent -> {
            frame.dispose();
            new OrganizerInformationInterface(organizer);
        });
    }

    public HomePage() {
        final JButton notice = new JButton("公告");
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        AllNotice allNotice = homepage.findAllNotice();
        placeComponents(panel,allNotice);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        frame.setVisible(true);

        notice.setBounds(250,60,150,25);
        panel.add(notice);

        back.addActionListener(actionEvent -> {
            frame.dispose();
            new AdminLogin();
        });

        activity.setText("活动申请");

        activity.addActionListener(actionEvent -> {
            frame.dispose();
            new AdminActivity();
        });

        Information.setText("主办方申请");

        Information.addActionListener(actionEvent -> {
            frame.dispose();
            new AdminOrganizer();
        });

        notice.addActionListener(actionEvent -> {
            frame.dispose();
            new AdminNotice();
        });

    }
}
