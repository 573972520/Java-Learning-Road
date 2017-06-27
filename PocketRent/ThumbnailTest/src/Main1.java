import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnailator;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.util.ThumbnailatorUtils;

public class Main1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Thumbnails.of(new File("F:\\Programming\\Code\\mv.png")).size(150, 150).toFile("F:\\Programming\\Code\\1.jpg");
		BufferedImage waterImg = ImageIO.read(new File("F:\\Programming\\Code\\yzm.jpg"));
		Thumbnails.of(new File("F:\\Programming\\Code\\mv.png")).size(500, 500).watermark(Positions.BOTTOM_RIGHT, waterImg, 1f).toFile("F:\\Programming\\Code\\1.jpg");
	}

}
