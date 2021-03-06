package com.wangkaisheng.www.view;

import com.wangkaisheng.www.po.Organizer;
import com.wangkaisheng.www.po.Picture;
import com.wangkaisheng.www.po.TimePictures;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class OpenTimepicture {
    private final JFrame frame = new JFrame("所有附件");
    private final JButton cancelPicture = new JButton("删除");
    private final JButton seePicture = new JButton("查看");
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();
    private final JLabel infoLab = new JLabel("附件",JLabel.CENTER);

    private void placeComponents(JPanel panel, TimePictures timePictures) {
        panel.setLayout(null);
        //设置布局为 null

        seePicture.setBounds(50,60,150,25);
        panel.add(seePicture);
        cancelPicture.setBounds(250,60,150,25);
        panel.add(cancelPicture);
        infoLab.setBounds(60,30,330,25);
        panel.add(infoLab);
        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"地址"});
        tableUser.setRowHeight(30);
        add(timePictures);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,150,390,250);
        panel.add(scrollPane);
    }

    private void add(TimePictures timePictures){
        if(timePictures!=null){
            for (String temp:timePictures.getPictures()) {
                tableModel.addRow(new Object[]{temp});
            }
        }
    }
    public OpenTimepicture(Organizer organizer) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        placeComponents(panel,organizer.getTimePictures());
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setVisible(true);

        cancelPicture.addActionListener(actionEvent -> {
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要删除的附件");
                return;
            }
            TimePictures timePictures = organizer.getTimePictures();
            List<String> stringList = timePictures.getPictures();
            stringList.remove(selectedRow);
            timePictures.setPictures(stringList);
            organizer.setTimePictures(timePictures);
            infoLab.setText("删除成功");
            frame.dispose();
            new OpenTimepicture(organizer);
        });

        seePicture.addActionListener(actionEvent -> {
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要查看的附件");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            Picture picture=new Picture();
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    picture.setFilename(temp.elementAt(0).toString());
                    break;
                }
                temp1++;
            }
            new SeeTimePicture(picture);
        });
    }
}
