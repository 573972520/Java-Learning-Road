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
		// ����һ���߶�Ϊ100�����Ϊ50��ͼƬ
		/*
		BufferedImage img = new BufferedImage(500, 500, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = img.createGraphics();
		g.setFont(new Font("����",Font.BOLD,30));
		g.setColor(Color.red);
		g.drawString("������", 69, 234);
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
			int index = rand.nextInt(chars.length);//����һ��chars�е����λ��
			char ch = chars[index];//ȡ��������λ�õ��ַ���Ϊ��֤���һ����
			yzm = yzm + ch;
		}
		System.out.println(yzm);
	}

}
