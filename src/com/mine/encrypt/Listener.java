package com.mine.encrypt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

	private RSAFrame frame;
	private final String p = "���ɵ�һ������", q = "���ɵڶ�������", n = "�õ������ĳ˻�";

	public Listener(RSAFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals(p)) {
			frame.setText1String();
		}
		if (e.getActionCommand().equals(q)) {
			frame.setText2String();
		}
		if (e.getActionCommand().equals(n)) {
			frame.setText3String();
		}
	}

}
