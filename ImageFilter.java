package mashro3elta5rog;


import java.util.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.geom.AffineTransform;

public class ImageFilter {

	public static void main(String[] args) {
		File file = new File("8c92d5e9-e397-423a-b504-2e046446a6df.jpg");
		//File file = new File("License Plate Photos/ca_10.jpeg");
		BufferedImage img = null;

		try { img = ImageIO.read(file); } 
		catch (IOException e) { e.printStackTrace(System.out); }

		if (img != null) {
			display(img);
			display(img);
		}
	}

	// display image in a JPanel popup
	public static void display (BufferedImage img) {
		System.out.println("  Displaying image.");
		JFrame frame = new JFrame();
	        JLabel label = new JLabel();
		frame.setSize(img.getWidth(), img.getHeight());
		label.setIcon(new ImageIcon(img));
		frame.getContentPane().add(label, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}



	// scale a grayscale image
	public static BufferedImage resize (BufferedImage img, int newHeight) {
		System.out.println("  Scaling image.");
		double scaleFactor = (double) newHeight/img.getHeight();
		BufferedImage scaledImg = new BufferedImage(
			(int)(scaleFactor*img.getWidth()), newHeight, BufferedImage.TYPE_BYTE_GRAY);
		AffineTransform at = new AffineTransform();
		at.scale(scaleFactor, scaleFactor);
		AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
		return scaleOp.filter(img, scaledImg);
	}

	// detect edges of a grayscale image using Sobel algorithm 
	// (for best results, apply blur before finding edges)


}











