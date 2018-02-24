package com.mine.load;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import com.mine.MyUI.MyButton;
import com.mine.MyUI.MyFrame;
import com.mine.MyUI.MyLabel;
import com.mine.MyUI.MyPanel;
import com.mine.MyUI.MyTextField;
import com.mine.MyUI.theme.ButtonTheme;
import com.mine.MyUI.theme.FrameTheme;
import com.mine.MyUI.theme.LabelTheme;
import com.mine.MyUI.theme.PanelTheme;

public class Load {

	private MyFrame loadFrame;

	public void create() {
		loadFrame = new MyFrame(new FrameTheme(new ImageIcon("image\\background-demo-two.png").getImage()) {
		});

		loadFrame.setLocationRelativeTo(null);

		MyButton min = new MyButton(new ButtonTheme(new ImageIcon("image\\min_button.png").getImage(),
				new ImageIcon("image\\min_button_press.png").getImage(),
				new ImageIcon("image\\min_button_hover.png").getImage()) {
			@Override
			public void onClick(MouseEvent e) {
				loadFrame.setExtendedState(JFrame.ICONIFIED);
			}
		});
		loadFrame.add(min);
		min.setSize(new Dimension(25, 25));
		min.setLocation(542, 65);

		MyButton close = new MyButton(new ButtonTheme(new ImageIcon("image\\close_button.png").getImage(),
				new ImageIcon("image\\close_button_press.png").getImage(),
				new ImageIcon("image\\close_button_hover.png").getImage()) {
			@Override
			public void onClick(MouseEvent e) {
				System.exit(1);
			}
		});
		loadFrame.add(close);
		close.setSize(new Dimension(25, 25));
		close.setLocation(576, 65);

		MyPanel centerPanel = new MyPanel(new PanelTheme(new Color(220, 232, 216)) {
		});
		loadFrame.add(centerPanel);
		centerPanel.setSize(new Dimension(270, 320));
		centerPanel.setLocation(335, 105);

		MyButton register = new MyButton(new ButtonTheme(new ImageIcon("image\\register_button.png").getImage(),
				new ImageIcon("image\\close_button_press.png").getImage(),
				new ImageIcon("image\\close_button_hover.png").getImage()) {
			@Override
			public void onClick(MouseEvent e) {

			}
		});
		register.setSize(new Dimension(100, 30));
		register.setLocation(23, 260);
		centerPanel.add(register);

		MyButton load = new MyButton(new ButtonTheme(new ImageIcon("image\\load_button.png").getImage(),
				new ImageIcon("image\\close_button_press.png").getImage(),
				new ImageIcon("image\\close_button_hover.png").getImage()) {
			@Override
			public void onClick(MouseEvent e) {

			}
		});
		load.setSize(new Dimension(100, 30));
		load.setLocation(148, 260);
		centerPanel.add(load);

		MyPanel accountPanel = new MyPanel(
				new PanelTheme(new ImageIcon("image\\load_0014_accountview.png").getImage()) {
				});

		centerPanel.add(accountPanel);
		// System.out.println(loadPanel.getBackground());
		accountPanel.setSize(new Dimension(200, 30));
		accountPanel.setLocation(35, 100);

		Point pOfLogo = new Point(3, 3), pOfTextfield = new Point(26, 3);
		Dimension dimensionOfTextfield = new Dimension(170, 24);
		Color textfieldColor = new Color(230, 242, 226);

		MyLabel peopleLogo = new MyLabel(new LabelTheme(new ImageIcon("image\\load_0010_people.png").getImage()) {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean HasListener() {
				// TODO Auto-generated method stub
				return false;
			}
		});
		accountPanel.add(peopleLogo);
		peopleLogo.setLocation(pOfLogo);

		MyTextField accountText = new MyTextField();
		accountPanel.add(accountText);
		accountText.setBackground(textfieldColor);
		accountText.setSize(dimensionOfTextfield);
		accountText.setLocation(pOfTextfield);
		accountText.setBorder(null);
		accountText.setHint("«Î ‰»Î’À∫≈");

		MyPanel keyPanel = new MyPanel(new PanelTheme(new ImageIcon("image\\load_0014_keyview.png").getImage()) {
		});

		centerPanel.add(keyPanel);
		// System.out.println(loadPanel.getBackground());
		keyPanel.setSize(new Dimension(200, 30));
		keyPanel.setLocation(35, 158);
		MyLabel lockLogo = new MyLabel(new LabelTheme(new ImageIcon("image\\load_0012_lock.png").getImage()) {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean HasListener() {
				// TODO Auto-generated method stub
				return false;
			}
		});
		keyPanel.add(lockLogo);
		lockLogo.setLocation(pOfLogo);
		MyTextField keyText = new MyTextField();
		keyText.setBackground(textfieldColor);
		keyPanel.add(keyText);
		keyText.setSize(dimensionOfTextfield);
		keyText.setLocation(pOfTextfield);
		keyText.setBorder(null);
		keyText.setHint("«Î ‰»Î√‹¬Î");
		
		loadFrame.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Load load = new Load();
		load.create();
	}
}
