package yzh.dataByte;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class CartesianCurve extends Applet {
	int width, height;// 声明int类型变量
	Image image;// 声明图像变量
	Graphics draw_Curve;// 声明图形绘制变量

	public void init() {// Applect程序初始化
		setBackground(Color.black);
		this.setSize(700, 700);
		width = getSize().width;
		height = getSize().height;
		image = createImage(width, height);
		draw_Curve = image.getGraphics();
	}

	public void paint(Graphics g) {// 利用Graphics绘制组件
		draw_Curve.clearRect(0, 0, width, height);// 用红色来填充清除指定的矩形。
		draw_Curve.setColor(Color.red);
		int i, j;
		double x, y, r;
		// 笛卡儿数学公式&#xff1a;(x*x+y*y-2ax)2=4a*a(x*x+y*y)
		for (i = 0; i <= 90; i++)
			for (j = 0; j <= 90; j++) {
				r = Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
				x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + width / 2;
				y = -r * Math.sin(Math.PI / 45 * j) + height / 4;
				draw_Curve.fillOval((int) x, (int) y, 2, 2);
			}
		g.drawImage(image, 0, 0, this);
	}
}