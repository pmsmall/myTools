package com.mine.encrypt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Listener implements ActionListener {

	private RSAFrame frame;
	private final String p = "生成第一个质数", q = "生成第二个质数", n = "得到质数的乘积";

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
