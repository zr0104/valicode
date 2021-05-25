package com.pxy;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Servlet implementation class NewCode
 */
@WebServlet("/NewCode")
public class NewCode extends HttpServlet {
	
	private Random random = new Random();
	private int width = 80;//���
	private int height = 30;//�߶�
	private int fontsize = 12;//�����С
	private String str = "0123456789abcdef";
	
	private String randCode(){
		String code ="";
		for (int i = 0; i < 4; i++) {
			code += str.charAt(random.nextInt(str.length()));
		}
		return code;
	}
	
	//���������ɫ
	private Color randColor() {
		int r = random.nextInt(255);
		int g = random.nextInt(255);
		int b = random.nextInt(255);
		return new Color(r,g,b);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��������
		BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//2.��������
		Graphics2D pen = (Graphics2D)img.getGraphics();
		//3.�����������
		String code = randCode();
		//4.��������
		//  4.1���û�������
		pen.fillRect(0, 0, width, height);
		//  4.2��������
		pen.setFont(new Font("΢���ź�",Font.BOLD,fontsize));
		//  4.3��˳����������ַ�
		for (int i = 0; i < code.length(); i++) {
			pen.setColor(randColor());
			//�����ַ�
			pen.drawString(code.charAt(i)+"", 5+i*fontsize, (fontsize+height)/2);
			
		}
		//  4.4����������
		//5.��ΪͼƬ������
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(img, "png", out);
		out.flush();
		out.close();
	}

}
