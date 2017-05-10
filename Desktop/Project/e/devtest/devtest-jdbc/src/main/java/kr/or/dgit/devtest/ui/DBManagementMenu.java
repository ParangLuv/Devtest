package kr.or.dgit.devtest.ui;

import lombok.Data;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by DGIT on 2017-05-10.
 */
@Data
public class DBManagementMenu extends JFrame implements ActionListener{
    private JPanel contentPane;
    private JButton initBtn;
    private JButton backupBtn;
    private JButton restoreBtn;

    public DBManagementMenu(){
        setTitle("DB관리메뉴");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 300, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new GridLayout(1,3,0,0));
        setContentPane(contentPane);

        initBtn = new JButton("초기화");
        backupBtn = new JButton("백업");
        restoreBtn = new JButton("복원");

        initBtn.addActionListener(this);
        backupBtn.addActionListener(this);
        restoreBtn.addActionListener(this);

        contentPane.add(initBtn);
        contentPane.add(backupBtn);
        contentPane.add(restoreBtn);


        setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 액션리스너 분기처리
        if (e.getSource() == initBtn) {
            initBtnActionPerformed(e);
        }
        if (e.getSource() == backupBtn) {
            backupBtnActionPerformed(e);
        }
        if (e.getSource() == restoreBtn) {
            restoreBtnActionPerformed(e);
        }
    }

    private void restoreBtnActionPerformed(ActionEvent e) {
        ServiceSetting create = new ImportSettingService();
        create.initSetting();
        hairEvnetAdminPanel.setInitPanel();
        hairinfoAdminPanel.setInitPanel();
        adminSettingPanel.setinitPanel();
    }

    private void backupBtnActionPerformed(ActionEvent e) {
        ServiceSetting create = new ExportSettingService();
        create.initSetting();
    }

    private void initBtnActionPerformed(ActionEvent e) {

        }
    }
}
