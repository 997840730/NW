package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Adminactivity;
import com.wangkaisheng.www.controller.Adminorganizer;
import com.wangkaisheng.www.controller.Impl.AdminactivityImpl;
import com.wangkaisheng.www.controller.Impl.AdminorganizerImpl;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllActivity;
import com.wangkaisheng.www.po.Allpo.AllOrganizer;
import com.wangkaisheng.www.po.Organizer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * @author Administrator
 */
public class AdminOrganizer {
    private final JFrame frame = new JFrame("申请中的账号");
    private final JButton quaryOrganizer = new JButton("查找账号");
    private final JButton seeOrganizer = new JButton("查看账号");
    private final JButton back = new JButton("返回");
    private final JButton refresh = new JButton("刷新");
    private final JLabel infoLab = new JLabel("所有活动",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();
    private final JLabel nameActivity = new JLabel("请输入活动主题");
    private final JTextField activityName = new JTextField();

    private final Adminorganizer adminorganizer = new AdminorganizerImpl();

    private void placeComponents(JPanel panel, AllOrganizer allOrganizer) {
        panel.setLayout(null);
        //设置布局为 null

        nameActivity.setBounds(60,10,120,10);
        panel.add(nameActivity);
        activityName.setBounds(60,30,180,25);
        panel.add(activityName);

        quaryOrganizer.setBounds(50,60,150,25);
        panel.add(quaryOrganizer);
        seeOrganizer.setBounds(250,60,150,25);
        panel.add(seeOrganizer);
        back.setBounds(50,90,150,25);
        panel.add(back);
        refresh.setBounds(250,90,150,25);
        panel.add(refresh);

        infoLab.setBounds(60,120,330,25);
        panel.add(infoLab);

        //获得表格模型
        tableModel.setRowCount(0);
        //清空表格中的数据
        tableModel.setColumnIdentifiers(new Object[]{"账号","社团名","社团负责人","社团热线"});
        tableUser.setRowHeight(30);
        addComment(allOrganizer);
        tableUser.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //单选
        tableUser.setSelectionBackground(Color.RED);
        tableUser.setModel(tableModel);
        scrollPane.add(tableUser);
        scrollPane.setViewportView(tableUser);
        scrollPane.setBounds(30,150,390,250);
        panel.add(scrollPane);
    }

    private void addComment(AllOrganizer allOrganizer){
        if(allOrganizer!=null){
            for (Organizer temp:allOrganizer.getOrganizerList()) {
                tableModel.addRow(new Object[]{temp.getUsername(),temp.getName(),temp.getPerson(),temp.getPhone()});
            }
        }
    }

    public AdminOrganizer() {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        AllOrganizer allOrganizer  = adminorganizer.findAllOrganizer() ;
        placeComponents(panel,allOrganizer);
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
            new AdminOrganizer();
        });

        quaryOrganizer.addActionListener(actionEvent -> {
            String name=activityName.getText();
            if(name==null||"".equals(name)){
                infoLab.setText("输入不得为空");
                return;
            }
            Organizer organizer = new Organizer();
            organizer.setName(name);
            AllOrganizer allOrganizer1 = adminorganizer.findOrganizer(organizer);
            if (allOrganizer1 == null) {
                infoLab.setText("未找到该活动");
            }else {
                tableModel.setRowCount(0);
                addComment(allOrganizer1);
            }
        });

        seeOrganizer.addActionListener(actionEvent -> {
            boolean flag=false;
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要查看的活动");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            Organizer organizer = null;
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    organizer = new Organizer();
                    organizer.setUsername(temp.elementAt(0).toString());
                    flag=true;
                    break;
                }
                temp1++;
            }
            Organizer organizer1 =  adminorganizer.getAllOrganizer(allOrganizer,organizer);
            if(organizer1!=null){
                infoLab.setText("获取成功");
            }else {
                infoLab.setText("获取失败");
                return;
            }
            if(flag){
                new SeeOrganizerInterface(organizer1);
            }else{
                infoLab.setText("进入失败");
            }
        });
    }
}
