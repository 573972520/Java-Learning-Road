import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Test2 {

	public static void main(String[] args) throws IOException {
		// 创建一个高度为100，宽度为50的图片
		/*
		BufferedImage img = new BufferedImage(500, 500, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = img.createGraphics();
		g.setFont(new Font("宋体",Font.BOLD,30));
		g.setColor(Color.red);
		g.drawString("如鹏网", 69, 234);
		g.drawRect(10, 10, 350, 200);
		g.drawArc(30, 80, 34, 34, 0, 360);
		g.dispose();
		FileOutputStream fos = new FileOutputStream("F:\\Programming\\Code\\yzm.jpg");
		ImageIO.write(img, "JPEG", fos);
		fos.close();
		*/
		
		char[] chars = new char[]{'a','b','c','d','e','f','h','k','l','m','4','7'};
		String yzm = "";
		Random rand = new Random();
		for(int i = 0;i<4;i++) 
		{
			int index = rand.nextInt(chars.length);//生成一个chars中的随机位置
			char ch = chars[index];//取出这个随机位置的字符作为验证码的一部分
			yzm = yzm + ch;
		}
		System.out.println(yzm);
	}

}
