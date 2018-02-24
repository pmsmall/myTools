package com.mine.iostream;

import java.io.IOException;

public class Manage {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileIo f = new FileIo("C:\\Users\\hzkxma\\Desktop\\ipdata_small.txt",
				"open");
		// System.out.println(FileIo
		// .readFile("C:\\Users\\hzkxma\\Desktop\\ipdata_small.txt"));
		char ch;
		while ((ch = (char)f.read()) != -1) {
			System.out.print(ch);
		}
		// char[] c = { '1', '2', '3' };
		// char[] ch = new char[4];
		// for (int i = 0; i < c.length; i++) {
		// ch[i] = c[i];
		// }
		// ch[3]='\0';
		// System.out.println(new String(ch));
	}

}
