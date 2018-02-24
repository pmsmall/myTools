package com.mine.MyUI.theme;

import java.awt.Color;
import java.awt.Image;

import com.mine.MyUI.MyPanel;
import com.mine.MyUI.theme.PanelTheme;

public class DefaultPanelTheme extends PanelTheme {

	public DefaultPanelTheme(MyPanel mypanel) {
		super(mypanel);
	}

	public DefaultPanelTheme(Color color) {
		super(color);
	}

	public DefaultPanelTheme(String backgroundImage) {
		super(backgroundImage);
	}

	public DefaultPanelTheme(MyPanel mypanel, Color color) {
		super(mypanel, color);
	}

	public DefaultPanelTheme() {
		super();
	}

	public DefaultPanelTheme(Image backgroundImage) {
		super(backgroundImage);
	}
}
