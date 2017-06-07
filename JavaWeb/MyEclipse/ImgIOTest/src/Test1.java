import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class Test1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedImage img = ImageIO.read(new File("F:\\Programming\\Code\\mv.png"));
		Graphics2D g = img.createGraphics();
		g.setFont(new Font("ÀŒÃÂ",Font.BOLD,30));
		g.setColor(Color.red);
		g.drawString("»Á≈ÙÕ¯", 69, 234);
		g.dispose();
		FileOutputStream fos = new FileOutputStream("F:\\Programming\\Code\\mv.jpg");
		ImageIO.write(img, "JPEG", fos);
		fos.close();
		
	}

}
