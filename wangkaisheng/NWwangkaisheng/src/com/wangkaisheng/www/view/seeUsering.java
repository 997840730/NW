package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Impl.SeeuseredImpl;
import com.wangkaisheng.www.controller.Impl.SeeuseringImpl;
import com.wangkaisheng.www.controller.Seeusered;
import com.wangkaisheng.www.controller.Seeusering;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllUser;
import com.wangkaisheng.www.po.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * @author Administrator
 */
public class seeUsering {
    private final JFrame frame = new JFrame("所有报名人员");
    private final JButton refresh = new JButton("刷新");
    private final JButton adopt = new JButton("通过审核");
    private final JLabel infoLab = new JLabel("所有活动",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();

    private final Seeusering seeusering = new SeeuseringImpl();

    private void placeComponents(JPanel panel, AllUser allUser) {
        panel.setLayout(null);
        //设置布局为 null

        refresh.setBounds(50,60,150,25);
        panel.add(refresh);
        adopt.setBounds(250,60,150,25);
        panel.add(adopt);


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

    public seeUsering(Activity activity) {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        AllUser allUser = seeusering.findUser(activity);
        placeComponents(panel,allUser);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        frame.setVisible(true);

        refresh.addActionListener(actionEvent -> {
            frame.dispose();
            new seeUsering(activity);
        });

        adopt.addActionListener(actionEvent -> {
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要查看的活动");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            User user = null;
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    user = new User();
                    user.setUsername(temp.elementAt(0).toString());
                    break;
                }
                temp1++;
            }
            if(seeusering.adoptUser(user,activity)){
                frame.dispose();
                new seeUsering(activity).infoLab.setText("已批准");
            }else {
                infoLab.setText("审核失败");
            }
        });
    }
}
