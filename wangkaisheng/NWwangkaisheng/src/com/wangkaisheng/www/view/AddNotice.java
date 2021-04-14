package com.wangkaisheng.www.view;

import com.wangkaisheng.www.controller.Addnotice;
import com.wangkaisheng.www.controller.Impl.AddnoticeImpl;
import com.wangkaisheng.www.po.Notice;

import javax.swing.*;

/**
 * @author Administrator
 */
public class AddNotice {
    private final JFrame frame = new JFrame("公告");
    private final JButton creatNtice = new JButton("创建");
    private final JButton back = new JButton("返回");
    private final JButton reset = new JButton("重置");
    private final JLabel nameNotice = new JLabel("请输入公告题目");
    private final JTextField nameNoticeText = new JTextField();
    private final JLabel noticeConetnt = new JLabel("公告内容:",JLabel.CENTER);
    private final JTextArea noticeConetntText = new JTextArea();
    private final JLabel infoLab = new JLabel("创建公告",JLabel.CENTER);

    private final Addnotice addnotice = new AddnoticeImpl();

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        infoLab.setBounds(175,30,100,20);
        panel.add(infoLab);
        nameNotice.setBounds(175,60,100,25);
        panel.add(nameNotice);
        nameNoticeText.setBounds(175,90,100,25);
        panel.add(nameNoticeText);
        noticeConetnt.setBounds(175,120,100,25);
        panel.add(noticeConetnt);
        noticeConetntText.setBounds(50,150,350,400);
        panel.add(noticeConetntText);

        creatNtice.setBounds(30,580,100,25);
        panel.add(creatNtice);
        back.setBounds(160,580,100,25);
        panel.add(back);
        reset.setBounds(300,580,100,25);
        panel.add(reset);
    }
    public AddNotice() {
        final JPanel panel = new JPanel();
        frame.setSize(450, 680);
        frame.setLocationRelativeTo(null);
        //在屏幕中居中显示
        frame.add(panel);
        // 添加面板
        placeComponents(panel);
        //往窗体里放其他控件
        frame.setVisible(true);

        back.addActionListener(actionEvent -> frame.dispose());

        reset.addActionListener(actionEvent -> noticeConetntText.setText(null));

        creatNtice.addActionListener(actionEvent -> {
            String title = nameNoticeText.getText();
            String content = noticeConetntText.getText();
            if("".equals(title)||"".equals(content)){
                infoLab.setText("标题或内容不得为空");
                return;
            }
            Notice notice = new Notice();
            notice.setNotice_title(title);
            notice.setNotice_content(content);
            if(addnotice.addNotice(notice)){
                frame.dispose();
                infoLab.setText("创建成功");
            }else {
                infoLab.setText("创建失败");
            }

        });
    }
}
