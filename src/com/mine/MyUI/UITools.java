package com.mine.MyUI;

public class UITools {

	public static void bindUI(MyUI ui1, MyUI ui2) {
		ui1.bind(ui2);
		ui2.bind(ui1);
	}

}
