package com.mine.MyUI.theme;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.image.PixelGrabber;

import com.mine.MyUI.MyWindow;
import com.mine.MyUI.MyImageIcon;

public abstract class WindowTheme implements Theme {

	protected MyWindow myWindow;
	protected Dimension d;

	protected Shape shape;
	protected Image backgroundImage;
	// private Image originalBackgroundImage;

	protected int w, h;
	protected float alpha;
	private scaleType sType = scaleType.magnify;
	private int scale = 1;

	/**
	 * ��ʼ��һ��frame����
	 * 
	 * @param myWindow
	 *            ��Ҫ��������myWindow
	 */
	public WindowTheme(MyWindow myWindow) {
		init(myWindow);
	}

	/**
	 * ��ʼ��һ��frame����
	 * 
	 * @param myWindow
	 *            ��Ҫ��������myWindow
	 */
	public WindowTheme(MyWindow myWindow, Image backgroundImage) {
		init(myWindow, backgroundImage);
	}

	public WindowTheme(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public WindowTheme(Image backgroundImage, int scale, scaleType sType) {
		this.backgroundImage = backgroundImage;
		this.scale = scale;
		this.sType = sType;
	}

	public WindowTheme(String backgroundImage) {
		this.backgroundImage = new MyImageIcon(backgroundImage).getImage();
	}

	public WindowTheme(String backgroundImage, int scale, scaleType sType) {
		this.backgroundImage = new MyImageIcon(backgroundImage).getImage();
		this.scale = scale;
		this.sType = sType;
	}

	/**
	 * ��ʼ��myWindow
	 * 
	 * @param myWindow
	 */
	public void init(Container container) {
		if (container == null) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					throw new NullPointerException("myWindow����Ϊ��");
				}
			});
		} else
			this.myWindow = (MyWindow) container;
		if (backgroundImage == null) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					throw new NullPointerException("background����Ϊ��");
				}
			});
		} else {
			if (sType == scaleType.shrink) {
				w = backgroundImage.getWidth(null) / scale;
				h = backgroundImage.getHeight(null) / scale;
			} else {
				w = backgroundImage.getWidth(null) * scale;
				h = backgroundImage.getHeight(null) * scale;
			}
			initShape();
		}
		alpha = 1;
		if (d == null) {
			d = new Dimension(w, h);
		}
	}

	/**
	 * ��ʼ��myWindow
	 * 
	 * @param myWindow
	 * @param backgroundImage
	 */
	public void init(MyWindow myWindow, Image backgroundImage) {
		// originalBackgroundImage = backgroundImage;
		// this.backgroundImage = originalBackgroundImage;
		this.backgroundImage = backgroundImage;
		init(myWindow);
	}

	/**
	 * ��ʼ��myWindow
	 * 
	 * @param myWindow
	 *            Ӧ��Ƥ���Ĵ���
	 */
	public void setFrame(MyWindow myWindow) {
		init(myWindow);
	}

	/**
	 * ���������ô�С
	 * 
	 * @param d
	 *            �����С
	 */
	public void setSize(Dimension d) {
		if (!this.d.equals(d))
			this.d = d;
		if (myWindow != null) {
			if (!myWindow.getSize().equals(d))
				myWindow.setSize(d);
		}
	}

	/**
	 * ���������ô�С
	 */
	public void setSize() {
		if (d != null && myWindow != null)
			setSize(this.d);
	}

	/**
	 * ���������ñ���ͼƬ
	 */
	public void setBackgroudImage() {
		if (myWindow != null) {
			Graphics2D g = myWindow.getGraphics2D();
			if (backgroundImage != null) {
				g.drawImage(backgroundImage, 0, 0, myWindow.getWidth(), myWindow.getHeight(), null);
			}
		}
	}

	/**
	 * ���������ñ���ͼƬ
	 * 
	 * @param g
	 *            ����Ļ���
	 */
	public void setBackgroudImage(Graphics g) {
		if (backgroundImage != null) {
			g.drawImage(backgroundImage, 0, 0, myWindow.getWidth(), myWindow.getHeight(), null);
		}
	}

	/**
	 * ����������͸����
	 */
	public void setAlpha() {
		System.out.println(alpha);
		myWindow.setOpacity(alpha);
	}

	/**
	 * ������������״
	 */
	public void setShape() {
		myWindow.setShape(shape);
	}

	/**
	 * ����������logo
	 */
	public void setLogo() {
	}

	/**
	 * ��ȡ��С����
	 * 
	 * @return ��С�ľ���
	 */
	public Rectangle getRectangle() {
		return null;
	}

	/**
	 * ��ȡ��Ƥ���ĳߴ�
	 * 
	 * @return ��Ƥ���ĳߴ�
	 */
	public Dimension getDimension() {
		return d;
	}

	/**
	 * ��ȡͼƬ
	 * 
	 * @return ͼƬ
	 */
	public Image getImage() {
		return null;
	}

	/**
	 * ��ȡ����ͼƬ
	 * 
	 * @return ����ͼƬ
	 */
	public Image getBackgroudImage() {
		return backgroundImage;
	}

	/**
	 * ��ȡlogo
	 * 
	 * @return logo
	 */
	public Image getLog() {
		return null;
	}

	/**
	 * ��ȡ͸����
	 * 
	 * @return ͸����
	 */
	public int getAlpha() {
		return (int) (alpha * 255);
	}

	protected int getAlpha(int pixel) {
		return (pixel >> 24) & 0xff;
	}

	protected void initShape() {

		PixelGrabber pgb = new PixelGrabber(backgroundImage, 0, 0, -1, -1, true);
		try {
			pgb.grabPixels();
			int pixels[] = (int[]) pgb.getPixels();

			int alphaList[][] = new int[h][w];

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					alphaList[i][j] = (getAlpha(pixels[j + i * w]) >= 170) ? 1 : 0;
				}
			}
			Area rectangle = new Area();
			int temp = 0;

			// ��һ��bug������ͼƬ���ܶ���//�����
			if (scale == 1 || sType != scaleType.magnify)
				for (int i = 0; i < h; i += scale) {
					for (int j = 0; j < w; j += scale) {
						if (alphaList[i][j] == 1) {
							if (temp == 0)
								temp = j;
						} else {
							if (temp != 0) {
								Rectangle rectemp = new Rectangle(temp, i, j - temp, 1);
								rectangle.add(new Area(rectemp));
								temp = 0;
							}
						}
					}
					if (temp != 0) {
						Rectangle rectemp = new Rectangle(temp, i, w, 1);
						rectangle.add(new Area(rectemp));
						temp = 0;
					}
				}
			shape = rectangle;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * �ͷ���Դ
	 */
	public void dispose() {
		myWindow = null;
		d = null;
		shape = null;
		backgroundImage = null;
	}

	// public void finalize() {
	// System.out.println("system is destroying " + this);
	// }
	/**
	 * include type of magnify and shrink
	 * 
	 * @author �����
	 * @since jdk_8
	 */
	public enum scaleType {
		/**
		 * 
		 */
		magnify,
		/**
		 * 
		 */
		shrink;
	}
}
