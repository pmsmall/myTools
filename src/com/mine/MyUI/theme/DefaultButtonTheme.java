package com.mine.MyUI.theme;

import java.awt.Color;
import java.awt.Image;

import com.mine.MyUI.MyButton;

public class DefaultButtonTheme extends ButtonTheme {

	/**
	 * 初始化一个button主题
	 * 
	 * @param myButton
	 *            需要添加主题的myButton
	 */
	public DefaultButtonTheme(MyButton myButton) {
		super(myButton);
	}

	/**
	 * 初始化一个button主题
	 * 
	 * @param myButton
	 *            需要添加主题的myButton
	 */
	public DefaultButtonTheme() {
		super();
	}

	/**
	 * 初始化一个button主题
	 * 
	 * @param releasedImage
	 *            未按下去时，按钮的图片
	 * @param pressedImage
	 *            按下去时按钮的图片
	 * @param hoverImage
	 *            悬停时按钮的图片
	 */
	public DefaultButtonTheme(Image releasedImage, Image pressedImage, Image hoverImage) {
		super(releasedImage, pressedImage, hoverImage);
	}

	/**
	 * 初始化一个button主题
	 * 
	 * @param releasedImage
	 *            未按下去时，按钮的图片
	 * @param pressedImage
	 *            按下去时按钮的图片
	 * @param hoverImage
	 *            悬停时按钮的图片
	 */
	public DefaultButtonTheme(Color releasedColor, Color pressedColor, Color hoverColor) {
		super(releasedColor, pressedColor, hoverColor);
	}

	/**
	 * 初始化一个button主题
	 * 
	 * @param image
	 *            按钮的图片
	 */
	public DefaultButtonTheme(Image image) {
		super(image);
	}

	/**
	 * 初始化一个button主题
	 * 
	 * @param image
	 */
	public DefaultButtonTheme(String image) {
		super(image);
	}

	/**
	 * 初始化一个button主题
	 * 
	 * @param releasedImage
	 *            未按下去时，按钮的图片
	 * @param pressedImage
	 *            按下去时按钮的图片
	 * @param hoverImage
	 *            悬停时按钮的图片
	 */
	public DefaultButtonTheme(Image releasedImage, Image pressedImage, Image hoverImage, Color c) {
		super(releasedImage, pressedImage, hoverImage, c);
	}

	/**
	 * 初始化一个button主题
	 * 
	 * @param releasedImage
	 *            未按下去时，按钮的图片
	 * @param pressedImage
	 *            按下去时按钮的图片
	 * @param hoverImage
	 *            悬停时按钮的图片
	 */
	public DefaultButtonTheme(String releasedImage, String pressedImage, String hoverImage) {
		super(releasedImage, pressedImage, hoverImage);
	}

	/**
	 * 初始化一个button主题
	 * 
	 * @param myButton
	 *            需要添加主题的myButton
	 * @param releasedImage
	 *            未按下去时，按钮的图片
	 * @param pressedImage
	 *            按下去时按钮的图片
	 * @param hoverImage
	 *            悬停时按钮的图片
	 */
	public DefaultButtonTheme(MyButton myButton, String releasedImage, String pressedImage, String hoverImage) {
		super(myButton, releasedImage, pressedImage, hoverImage);
	}

	/**
	 * 初始化一个button主题
	 * 
	 * @param myButton
	 *            需要添加主题的myButton
	 * @param releasedImage
	 *            未按下去时，按钮的图片
	 * @param pressedImage
	 *            按下去时按钮的图片
	 * @param hoverImage
	 *            悬停时按钮的图片
	 */
	public DefaultButtonTheme(MyButton myButton, Image releasedImage, Image pressedImage, Image hoverImage) {
		super(myButton, releasedImage, pressedImage, hoverImage);
	}

	/**
	 * 初始化一个button主题
	 * 
	 * @param releasedImage
	 *            未按下去时，按钮的图片
	 * @param pressedImage
	 *            按下去时按钮的图片
	 * @param hoverImage
	 *            悬停时按钮的图片
	 */
	public DefaultButtonTheme(MyButton myButton, Color releasedColor, Color pressedColor, Color hoverColor) {
		super(myButton, releasedColor, pressedColor, hoverColor);
	}
}
