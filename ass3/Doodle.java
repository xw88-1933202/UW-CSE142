// Xuqing Wu
// 10/13/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #3 PartA
//
// This program will show a beatuful picture.

import java.awt.*;

public class Doodle{
	public static void main(String[] args){
		DrawingPanel panel = new DrawingPanel(400,400);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.BLUE);
		g.setColor(Color.RED);
		g.fillRect(50,50,300,300);
		g.setColor(Color.BLACK);
		g.fillOval(100,100,200,200);
		g.setColor(Color.GREEN);
		g.fillOval(150,150,100,100);
		g.setColor(Color.CYAN);
		g.drawLine(100,200,300,200);
		g.drawLine(200,100,200,300);
	}
}
