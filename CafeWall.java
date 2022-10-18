// Xuqing Wu
// 10/13/2019
// CSE142
// TA: Ethan M Knutson
// Assignment #3 PartB
//
// This program will show a Cafe Wall.

import java.awt.*;

public class CafeWall{
	public static final int GAP=2;
	public static void main(String[] args){
		DrawingPanel panel = new DrawingPanel(650,400);
		Graphics s = panel.getGraphics();
		panel.setBackground(Color.GRAY);
		drawrow(s,0,0,20,4);
		drawrow(s,50,70,30,5);
		drawgrid(s,8,4,0,25,10,150);
		drawgrid(s,6,3,10,25,250,200);
		drawgrid(s,10,5,10,20,425,180);
		drawgrid(s,4,2,35,35,400,20);
	}
	
	//draw one single row
	public static void drawrow(Graphics s, int x, int y, int size, int num){
		for(int i=1; i<=num; i++){
			s.setColor(Color.BLACK);
			s.fillRect(x+2*size*(i-1),y,size,size);
			
			s.setColor(Color.BLUE);
			s.drawLine(x+2*size*(i-1),y,x+2*size*i-size,y+size);
			s.drawLine(x+2*size*i-size,y,x+2*size*(i-1),y+size);
		   
         s.setColor(Color.WHITE);
			s.fillRect(x+2*size*i-size,y,size,size);
		}
	}
	
	//draw repetitive rows
	public static void drawgrid(Graphics s, int row, int column, int offset, int size, int x, int y){
		for(int i=1; i<=row; i++){
			drawrow(s,x+((i+1)%2)*offset,y+(size+GAP)*(i-1),size,column);
		}
	}
}