package com.mine.MyUI;

import com.mine.MyUI.theme.Theme;

public interface MyUI {
	public void dispose();

	public void bind(MyUI ui);

	public int getX();

	public int getY();

	public void setLocation(int x, int y);

	public Theme getTheme();

	public void setVisible(boolean visible);

}
