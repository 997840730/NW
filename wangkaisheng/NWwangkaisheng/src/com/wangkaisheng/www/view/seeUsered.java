package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Impl.SeeuseredImpl;
import com.wangkaisheng.www.controller.Seeusered;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllUser;
import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.po.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class seeUsered {
    private final JFrame frame = new JFrame("所有参加人员");
    private final JButton refresh = new JButton("刷新");
    private final JButton over = new JButton("结束活动");
    private final JLabel infoLab = new JLabel("所有活动",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();

    private final Seeusered seeusered = new SeeuseredImpl();

    private void placeComponents(JPanel panel, AllUser allUser) {
        panel.setLayout(null);
        //设置布局为 null

        refresh.setBounds(50,60,150,25);
        panel.add(refresh);
        over.setBounds(250,60,150,25);
        panel.add(over);


        infoLab.setBounds(60,120,330,25);
        panel.add(infoLab);

        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"账号","姓名","手机号码"});
        tableUser.setRowHeight(30);
        addComment(allUser);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,150,390,250);
        panel.add(scrollPane);
    }

    private void addComment(AllUser allUser){
        if(allUser!=null){
            for (User temp:allUser.getUserList()) {
                tableModel.addRow(new Object[]{temp.getUsername(),temp.getName(),temp.getPhone()});
            }
        }
    }
    public seeUsered(Organizer organizer,Activity activity) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        AllUser allUser = seeusered.findUser(activity);
        placeComponents(panel,allUser);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setVisible(true);

        refresh.addActionListener(actionEvent -> {
            frame.dispose();
            new seeUsered(organizer,activity);
        });

        over.addActionListener(actionEvent -> {
            if(seeusered.overActivity(allUser,activity)){
                frame.dispose();
            }else {
                infoLab.setText("结束失败");
            }
        });
    }
}
