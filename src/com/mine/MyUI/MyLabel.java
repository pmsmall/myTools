package com.mine.MyUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;

import com.mine.MyUI.theme.LabelTheme;
import com.mine.MyUI.theme.LabelTheme.stringType;

public class MyLabel extends JLabel implements MyUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4992477824614587877L;

	/**
	 * Creates a <code>JLabel</code> instance with the specified text, image,
	 * and horizontal alignment. The label is centered vertically in its display
	 * area. The text is on the trailing edge of the image.
	 * 
	 * @param text
	 *            The text to be displayed by the label.
	 * @param icon
	 *            The image to be displayed by the label.
	 * @param horizontalAlignment
	 *            One of the following constants defined in
	 *            <code>SwingConstants</code>: <code>LEFT</code>,
	 *            <code>CENTER</code>, <code>RIGHT</code>, <code>LEADING</code>
	 *            or <code>TRAILING</code>.
	 */

	protected LabelTheme theme;

	public MyLabel(String text, LabelTheme theme) {
		this(text);
		setTheme(theme);
	}

	public void setTheme(LabelTheme theme) {
		this.theme = theme;
		theme.init(this);
		if (theme.HasListener())
			addMouseListener(theme);
		// setOpaque(true);
	}

	public MyLabel(LabelTheme theme) {
		this();
		setTheme(theme);
		theme.setSize();
		theme.setShape();
	}

	public MyLabel(String text, Icon icon, int horizontalAlignment) {
		setText(text);
		setIcon(icon);
		setHorizontalAlignment(horizontalAlignment);
		updateUI();
		setAlignmentX(LEFT_ALIGNMENT);
		theme = new LabelTheme(text, stringType.text) {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public boolean HasListener() {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

	/**
	 * Creates a <code>JLabel</code> instance with the specified text and
	 * horizontal alignment. The label is centered vertically in its display
	 * area.
	 * 
	 * @param text
	 *            The text to be displayed by the label.
	 * @param horizontalAlignment
	 *            One of the following constants defined in
	 *            <code>SwingConstants</code>: <code>LEFT</code>,
	 *            <code>CENTER</code>, <code>RIGHT</code>, <code>LEADING</code>
	 *            or <code>TRAILING</code>.
	 */
	public MyLabel(String text, int horizontalAlignment) {
		this(text, null, horizontalAlignment);
	}

	/**
	 * Creates a <code>JLabel</code> instance with the specified text. The label
	 * is aligned against the leading edge of its display area, and centered
	 * vertically.
	 * 
	 * @param text
	 *            The text to be displayed by the label.
	 */
	public MyLabel(String text) {
		this(text, null, LEADING);
	}

	/**
	 * Creates a <code>JLabel</code> instance with the specified image and
	 * horizontal alignment. The label is centered vertically in its display
	 * area.
	 * 
	 * @param image
	 *            The image to be displayed by the label.
	 * @param horizontalAlignment
	 *            One of the following constants defined in
	 *            <code>SwingConstants</code>: <code>LEFT</code>,
	 *            <code>CENTER</code>, <code>RIGHT</code>, <code>LEADING</code>
	 *            or <code>TRAILING</code>.
	 */
	public MyLabel(Icon image, int horizontalAlignment) {
		this(null, image, horizontalAlignment);
	}

	/**
	 * Creates a <code>JLabel</code> instance with the specified image. The
	 * label is centered vertically and horizontally in its display area.
	 * 
	 * @param image
	 *            The image to be displayed by the label.
	 */
	public MyLabel(Icon image) {
		this(null, image, CENTER);
	}

	/**
	 * Creates a <code>JLabel</code> instance with no image and with an empty
	 * string for the title. The label is centered vertically in its display
	 * area. The label's contents, once set, will be displayed on the leading
	 * edge of the label's display area.
	 */
	public MyLabel() {
		this("", null, LEADING);
	}

	/**
	 * Paints each of the components in this container.
	 * 
	 * @param g
	 *            the graphics context.
	 * @see Component#paint
	 * @see Component#paintAll
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (theme != null)
			theme.setBackgroudImage(g);
	}

	public void paint(Graphics g) {
		// if (theme.getFont() == null)
		// super.paint(g);
		if (theme != null)
			theme.setBackgroudImage(g);
	}

	@Override
	public void dispose() {
		if (theme != null) {
			theme.dispose();
			theme = null;
		}
	}

	/**
	 * Sets the background color of this component. The background color is used
	 * only if the component is opaque, and only by subclasses of
	 * <code>JComponent</code> or <code>ComponentUI</code> implementations.
	 * Direct subclasses of <code>JComponent</code> must override
	 * <code>paintComponent</code> to honor this property.
	 * <p>
	 * It is up to the look and feel to honor this property, some may choose to
	 * ignore it.
	 *
	 * @param bg
	 *            the desired background <code>Color</code>
	 * @see java.awt.Component#getBackground
	 * @see #setOpaque
	 *
	 * @beaninfo preferred: true bound: true attribute: visualUpdate true
	 *           description: The background color of the component.
	 */
	public void setBackground(Color bg) {
		Color oldBg = getBackground();
		super.setBackground(bg);
		if (!isOpaque())
			setOpaque(true);
		if (theme != null)
			theme.setColor(bg);
		if ((oldBg != null) ? !oldBg.equals(bg) : ((bg != null) && !bg.equals(oldBg))) {
			// background already bound in AWT1.2
			repaint();
		}
	}

	public LabelTheme getTheme() {
		return theme;
	}

	/**
	 * Sets the font for this component.
	 *
	 * @param font
	 *            the desired <code>Font</code> for this component
	 * @see java.awt.Component#getFont
	 *
	 * @beaninfo preferred: true bound: true attribute: visualUpdate true
	 *           description: The font for the component.
	 */
	public void setFont(Font font) {
		if (theme != null) {
			theme.setFont(font);
		}
		super.setFont(font);
	}

	/**
	 * Sets the foreground color of this component. It is up to the look and
	 * feel to honor this property, some may choose to ignore it.
	 *
	 * @param fg
	 *            the desired foreground <code>Color</code>
	 * @see java.awt.Component#getForeground
	 *
	 * @beaninfo preferred: true bound: true attribute: visualUpdate true
	 *           description: The foreground color of the component.
	 */
	public void setForeground(Color fg) {
		if (theme != null) {
			theme.setForeground(fg);
		}
		super.setForeground(fg);
	}

	/**
	 * Defines the single line of text this component will display. If the value
	 * of text is null or empty string, nothing is displayed.
	 * <p>
	 * The default value of this property is null.
	 * <p>
	 * This is a JavaBeans bound property.
	 *
	 * @see #setVerticalTextPosition
	 * @see #setHorizontalTextPosition
	 * @see #setIcon
	 * @beaninfo preferred: true bound: true attribute: visualUpdate true
	 *           description: Defines the single line of text this component
	 *           will display.
	 */
	public void setText(String text) {
		if (theme != null && theme.getStringType().equals(stringType.text))
			theme.setText(text);
		else
			super.setText(text);

	}

	@Override
	public void bind(MyUI ui) {
		// TODO Auto-generated method stub

	}
}
