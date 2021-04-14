package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Adminnotice;
import com.wangkaisheng.www.controller.Homepage;
import com.wangkaisheng.www.controller.Impl.AdminnoticeImpl;
import com.wangkaisheng.www.controller.Impl.HomepageImpl;
import com.wangkaisheng.www.po.Activity;
import com.wangkaisheng.www.po.Allpo.AllNotice;
import com.wangkaisheng.www.po.Notice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * @author Administrator
 */
public class AdminNotice {
    private final JFrame frame = new JFrame("首页");
    private final JButton addNotice = new JButton("发表公告");
    private final JButton cancelNotice = new JButton("删除公告");
    private final JButton back = new JButton("退出");
    private final JLabel infoLab = new JLabel("公告",JLabel.CENTER);
    private final JTable tableUser=new JTable();
    private final DefaultTableModel tableModel=(DefaultTableModel) tableUser.getModel();
    private final JScrollPane scrollPane=new JScrollPane();

    private final Adminnotice adminnotice = new AdminnoticeImpl();

    private void placeComponents(JPanel panel, AllNotice allNotice) {
        panel.setLayout(null);
        //设置布局为 null
        addNotice.setBounds(50,30,150,25);
        panel.add(addNotice);
        cancelNotice.setBounds(250,30,150,25);
        panel.add(cancelNotice);
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

    public AdminNotice() {
        final JPanel panel = new JPanel();
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);

        AllNotice allNotice = adminnotice.findAllNotice();

        placeComponents(panel,allNotice);
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

        addNotice.addActionListener(actionEvent -> {
            new AddNotice();
        });

        cancelNotice.addActionListener(actionEvent -> {
            boolean flag=false;
            int selectedRow = tableUser.getSelectedRow();
            if(selectedRow==-1){
                infoLab.setText("请选择要查看的活动");
                return;
            }
            Vector<Vector> dataVector = tableModel.getDataVector();
            int temp1=0;
            Notice notice = null;
            for (Vector temp:dataVector) {
                if(temp1==selectedRow){
                    notice = new Notice();
                    notice.setNotice_title(temp.elementAt(0).toString());
                    notice.setNotice_content(temp.elementAt(1).toString());
                    flag=true;
                    break;
                }
                temp1++;
            }
            if(flag){
                if(adminnotice.cancelNotice(notice)){
                    new AdminNotice();
                }
            }else {
                infoLab.setText("删除失败");
            }
        });

    }
}
