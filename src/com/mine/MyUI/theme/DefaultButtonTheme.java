package com.mine.MyUI.theme;

import java.awt.Color;
import java.awt.Image;

import com.mine.MyUI.MyButton;

public class DefaultButtonTheme extends ButtonTheme {

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param myButton
	 *            ��Ҫ��������myButton
	 */
	public DefaultButtonTheme(MyButton myButton) {
		super(myButton);
	}

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param myButton
	 *            ��Ҫ��������myButton
	 */
	public DefaultButtonTheme() {
		super();
	}

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param releasedImage
	 *            δ����ȥʱ����ť��ͼƬ
	 * @param pressedImage
	 *            ����ȥʱ��ť��ͼƬ
	 * @param hoverImage
	 *            ��ͣʱ��ť��ͼƬ
	 */
	public DefaultButtonTheme(Image releasedImage, Image pressedImage, Image hoverImage) {
		super(releasedImage, pressedImage, hoverImage);
	}

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param releasedImage
	 *            δ����ȥʱ����ť��ͼƬ
	 * @param pressedImage
	 *            ����ȥʱ��ť��ͼƬ
	 * @param hoverImage
	 *            ��ͣʱ��ť��ͼƬ
	 */
	public DefaultButtonTheme(Color releasedColor, Color pressedColor, Color hoverColor) {
		super(releasedColor, pressedColor, hoverColor);
	}

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param image
	 *            ��ť��ͼƬ
	 */
	public DefaultButtonTheme(Image image) {
		super(image);
	}

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param image
	 */
	public DefaultButtonTheme(String image) {
		super(image);
	}

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param releasedImage
	 *            δ����ȥʱ����ť��ͼƬ
	 * @param pressedImage
	 *            ����ȥʱ��ť��ͼƬ
	 * @param hoverImage
	 *            ��ͣʱ��ť��ͼƬ
	 */
	public DefaultButtonTheme(Image releasedImage, Image pressedImage, Image hoverImage, Color c) {
		super(releasedImage, pressedImage, hoverImage, c);
	}

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param releasedImage
	 *            δ����ȥʱ����ť��ͼƬ
	 * @param pressedImage
	 *            ����ȥʱ��ť��ͼƬ
	 * @param hoverImage
	 *            ��ͣʱ��ť��ͼƬ
	 */
	public DefaultButtonTheme(String releasedImage, String pressedImage, String hoverImage) {
		super(releasedImage, pressedImage, hoverImage);
	}

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param myButton
	 *            ��Ҫ��������myButton
	 * @param releasedImage
	 *            δ����ȥʱ����ť��ͼƬ
	 * @param pressedImage
	 *            ����ȥʱ��ť��ͼƬ
	 * @param hoverImage
	 *            ��ͣʱ��ť��ͼƬ
	 */
	public DefaultButtonTheme(MyButton myButton, String releasedImage, String pressedImage, String hoverImage) {
		super(myButton, releasedImage, pressedImage, hoverImage);
	}

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param myButton
	 *            ��Ҫ��������myButton
	 * @param releasedImage
	 *            δ����ȥʱ����ť��ͼƬ
	 * @param pressedImage
	 *            ����ȥʱ��ť��ͼƬ
	 * @param hoverImage
	 *            ��ͣʱ��ť��ͼƬ
	 */
	public DefaultButtonTheme(MyButton myButton, Image releasedImage, Image pressedImage, Image hoverImage) {
		super(myButton, releasedImage, pressedImage, hoverImage);
	}

	/**
	 * ��ʼ��һ��button����
	 * 
	 * @param releasedImage
	 *            δ����ȥʱ����ť��ͼƬ
	 * @param pressedImage
	 *            ����ȥʱ��ť��ͼƬ
	 * @param hoverImage
	 *            ��ͣʱ��ť��ͼƬ
	 */
	public DefaultButtonTheme(MyButton myButton, Color releasedColor, Color pressedColor, Color hoverColor) {
		super(myButton, releasedColor, pressedColor, hoverColor);
	}
}
