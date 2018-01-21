package me.checkcode.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage bufferedImage = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		Graphics g = bufferedImage.getGraphics();
		Color color = new Color(200, 150, 155);
		g.setColor(color);
		g.fillRect(0, 0, 68, 22);
		
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		Random random = new Random();
		int length = ch.length, index;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			index = random.nextInt(length);
			g.setColor(new Color(random.nextInt(88), random.nextInt(188), random.nextInt(255)));
			g.drawString(ch[index] + "", (i*15) + 3, 18);
			sb.append(ch[index]);
		}
		request.getSession().setAttribute("piccode", sb.toString());
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
