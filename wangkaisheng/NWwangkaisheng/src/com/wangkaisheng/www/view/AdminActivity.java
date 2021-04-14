package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Adminactivity;
import com.wangkaisheng.www.controller.Impl.AdminactivityImpl;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class AdminActivity {
    private final JFrame frame = new JFrame("申请中的活动");
    private final JButton quaryActivity = new JButton("查找活动");
    private final JButton seeActivity = new JButton("查看活动");
    private final JButton back = new JButton("返回");
    private final JButton refresh = new JButton("刷新");
    private final JLabel infoLab = new JLabel("所有活动",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();
    private final JLabel nameActivity = new JLabel("请输入活动主题");
    private final JTextField activityName = new JTextField();

    private final Adminactivity adminactivity = new AdminactivityImpl();

    private void placeComponents(JPanel panel, AllActivity allActivity) {
        panel.setLayout(null);
        //设置布局为 null

        nameActivity.setBounds(60,10,120,10);
        panel.add(nameActivity);
        activityName.setBounds(60,30,180,25);
        panel.add(activityName);

        quaryActivity.setBounds(50,60,150,25);
        panel.add(quaryActivity);
        seeActivity.setBounds(250,60,150,25);
        panel.add(seeActivity);
        back.setBounds(50,90,150,25);
        panel.add(back);
        refresh.setBounds(250,90,150,25);
        panel.add(refresh);

        infoLab.setBounds(60,120,330,25);
        panel.add(infoLab);

        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"id","活动名","主办方","活动时间"});
        tableUser.setRowHeight(30);
        addComment(allActivity);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,150,390,250);
        panel.add(scrollPane);
    }

    private void addComment(AllActivity allActivity){
        if(allActivity!=null){
            for (Activity temp:allActivity.getActivities()) {
                tableModel.addRow(new Object[]{temp.getActivity_id(),temp.getActivity_name(),temp.getActivity_organizer(),temp.getActivity_date()});
            }
        }
    }

    public AdminActivity() {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        AllActivity allActivity = adminactivity.findAllActivity() ;
        placeComponents(panel,allActivity);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置X号后关闭
        frame.setVisible(true);

        back.addActionListener(actionEvent -> {
            frame.dispose();
            new HomePage();
        });

        refresh.addActionListener(actionEvent -> {
            frame.dispose();
            new AdminActivity();
        });

        quaryActivity.addActionListener(actionEvent -> {
            String name=activityName.getText();
            if(name==null||"".equals(name)){
                infoLab.setText("输入不得为空");
                return;
            }
            Activity activity = new Activity();
            activity.setActivity_name(name);
            AllActivity allActivity1 = adminactivity.findActivity(activity);
            if (allActivity1 == null) {
                infoLab.setText("未找到该活动");
            }else {
                tableModel.setRowCount(0);
                addComment(allActivity1);
            }
        });

        seeActivity.addActionListener(actionEvent -> {
            boolean flag=false;
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要查看的活动");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            Activity activity = null;
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    activity = new Activity();
                    activity.setActivity_id(Integer.parseInt(temp.elementAt(0).toString()));
                    flag=true;
                    break;
                }
                temp1++;
            }
            Activity activity1 =  adminactivity.getAllActivity(allActivity,activity);
            if(activity1!=null){
                infoLab.setText("获取成功");
            }else {
                infoLab.setText("获取失败");
                return;
            }
            if(flag){
                new SeeActivityInterface(activity1);
            }else{
                infoLab.setText("进入失败");
            }
        });
    }
}
