package com.mine.encrypt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.math.BigInteger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RSAFrame extends JFrame {

	private Listener listener;
	private JTextField text1, text2, text3, text4, text5;
	private BigInteger p, q, n, e1, e2;

	/**
	 * 
	 */
	private static final long serialVersionUID = -1047747000740555395L;

	public void build() {
		setSize(new Dimension(800, 500));

		setLayout(new BorderLayout());

		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		listener = new Listener(this);
		setPanel(this, BorderLayout.WEST, new Dimension(70, 0));
		setPanel(this, BorderLayout.EAST, new Dimension(70, 0));
		setNorthPanel();
		setCenterPanel();

		setVisible(true);
	}

	public void setNorthPanel() {
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(0, 120));
		// north.setBackground(Color.red);

		add(north, BorderLayout.NORTH);
	}

	public void setCenterPanel() {
		JPanel center = new JPanel();
		JPanel p;

		center.setLayout(new BorderLayout());
		p = (JPanel) setPanel(center, BorderLayout.WEST, new Dimension(125, 0));
		setButton(p, "生成第一个质数");
		setButton(p, "生成第二个质数");
		setButton(p, "得到质数的乘积");
		p = (JPanel) setPanel(center, BorderLayout.CENTER,
				new Dimension(130, 0));
		setText(p);
		add(center, BorderLayout.CENTER);
	}

	public JPanel setPanel(Container c, String s, Dimension d) {
		JPanel panel = new JPanel();
		panel.setPreferredSize(d);
		c.add(panel, s);
		return panel;
	}

	public void setText(JPanel p) {
		Dimension d = new Dimension(500, 25);
		text1 = new JTextField();
		text1.setPreferredSize(d);
		text1.setEditable(false);
		text1.setBackground(Color.white);
		p.add(text1);

		text2 = new JTextField();
		text2.setPreferredSize(d);
		text2.setEditable(false);
		text2.setBackground(Color.white);
		p.add(text2);

		text3 = new JTextField();
		text3.setPreferredSize(d);
		text3.setEditable(false);
		text3.setBackground(Color.white);
		text3.setText("n");
		p.add(text3);

		text4 = new JTextField();
		text4.setPreferredSize(d);
		text4.setEditable(false);
		text4.setBackground(Color.white);
		text4.setText("e1");
		p.add(text4);

		text5 = new JTextField();
		text5.setPreferredSize(d);
		text5.setEditable(false);
		text5.setBackground(Color.white);
		text5.setText("e2");
		p.add(text5);
	}

	public void setButton(JPanel p, String s) {
		JButton button = new JButton(s);
		button.setActionCommand(s);
		button.addActionListener(listener);
		p.add(button);
	}

	public void setText1String() {
		encrypt encrypt = new encrypt();
		p = encrypt.findPrime();
		text1.setText(p + "");
	}

	public void setText2String() {
		encrypt encrypt = new encrypt();
		q = encrypt.findPrime();
		text2.setText(q + "");
	}

	public void setText3String() {

		n = p.multiply(q);
		final BigInteger t = (p.subtract(BigInteger.ONE)).multiply((q
				.subtract(BigInteger.ONE)));
		text3.setText(n + "");
		new Thread(new Runnable() {
			@Override
			public void run() {
				encrypt encrypt = new encrypt();
				// TODO Auto-generated method stub
				while (true) {
					e1 = encrypt.makeRandom();
					if (isPrime(e1, t)) {
						text4.setText(e1 + "");
						break;
					}
				}
				e2 = niyuan(e1, t);
				text5.setText(e2 + "");
			}
		}).start();

	}

	public boolean isPrime(BigInteger m, BigInteger n) {
		if ((m.compareTo(n)) < 0) {
			BigInteger tmp = m;
			m = n;
			n = tmp;
		}
		BigInteger c;
		while (!(c = m.mod(n)).equals(BigInteger.ZERO)) {
			m = n;
			n = c;
		}
		return n.equals(BigInteger.ONE);
	}

	public BigInteger findE2(BigInteger m, BigInteger n) {
		System.out.println(n + "");
		BigInteger e2;
		for (BigInteger i = new BigInteger("2");; i.add(BigInteger.ONE)) {
			if ((((n.multiply(i)).add(BigInteger.ONE)).mod(m))
					.equals(BigInteger.ZERO)) {
				e2 = (((n.multiply(i)).add(BigInteger.ONE)).divide(m));
				break;
			}
		}
		return e2;
	}

	public BigInteger niyuan(BigInteger a, BigInteger b) // 求550关于模1769的乘法逆元
	// 550*X(mod1769)=1
	// niyuan(1769,550)
	{
		BigInteger[] m = { BigInteger.ONE, BigInteger.ZERO, a };
		BigInteger[] n = { BigInteger.ZERO, BigInteger.ONE, b };
		BigInteger[] temp = new BigInteger[3];
		BigInteger q = BigInteger.ZERO; // 初始化
		boolean flag = true;
		while (flag) {
			q = m[2].divide(n[2]);
			for (int i = 0; i < 3; i++) {
				temp[i] = m[i].subtract(q.multiply(n[i]));
				m[i] = n[i];
				n[i] = temp[i];
			}
			if (n[2].equals(BigInteger.ONE)) {
				if (n[1].compareTo(BigInteger.ZERO) < 0) {
					n[1] = n[1].add(a);
				}
				return n[1];
			}
			if (n[2].equals(BigInteger.ZERO)) {
				flag = false;
			}
		}
		return BigInteger.ZERO;
	}
}
