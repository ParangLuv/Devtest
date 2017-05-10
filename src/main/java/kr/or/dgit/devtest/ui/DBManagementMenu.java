package kr.or.dgit.devtest.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.devtest.dao.DataBaseDao;
import lombok.Data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Data
public class DBManagementMenu extends JFrame implements ActionListener {
	private static int dbNo = 0;
	
	private JPanel contentPane;
	private JButton initBtn;
	private JButton backupBtn;
	private JButton restoreBtn;
	
	public DBManagementMenu() {
		setTitle("DB관리메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(1, 3, 0, 0));
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

	
	
//	액션 리스너 분기처리
	@Override
	public void actionPerformed(ActionEvent e) {
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
	
	
//	복구 액션 리스너 구현
	private void restoreBtnActionPerformed(ActionEvent e) {

	}

	
//	백업 액션 리스너 구현
	private void backupBtnActionPerformed(ActionEvent e) {

	}

	
//	초기화 액션 리스너 구현
	private void initBtnActionPerformed(ActionEvent e) {
		DataBaseDao dao = DataBaseDao.getInstance();
		int dbNo = 0;
		dao.createDataBase(dbNo);
		dao.selectUseDatabase(dbNo);
		dao.createTable(dbNo);
		dao.createUser(dbNo);
		JOptionPane.showMessageDialog(null, "초기화 완료.");
	}
}
