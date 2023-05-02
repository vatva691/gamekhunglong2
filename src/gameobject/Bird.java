package gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Bird extends Enemy {
	
	public static final int Y_LAND = 125;
	
	private Random rand;
	private int posY;

	
	private int posX;
	private int width;
	private int height;
	
	private BufferedImage image;
	private MainCharacter mainCharacter;
	
	private Rectangle rectBound;
	
	public Bird(MainCharacter mainCharacter, int posX, int width, int height, BufferedImage image) {
		this.posX = posX;
		this.width = width;
		this.height = height;
		this.image = image;
		this.mainCharacter = mainCharacter;
		rectBound = new Rectangle();
	}
	
	public void update() {
		posX -= mainCharacter.getSpeedX();
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, posX, Y_LAND - image.getHeight() - 30, null);
		g.setColor(Color.black);
		Rectangle bound = getBound();
		g.drawRect(bound.x, bound.y, bound.width, bound.height);
	}
	
	public Rectangle getBound() {
		
		rectBound = new Rectangle();
		rectBound.x = (int) posX + (image.getWidth() - width)/2;
		rectBound.y = (int) (Y_LAND - image.getHeight()) -(image.getHeight() + height)/2 ;
		rectBound.width = width;
		rectBound.height = height;
		return rectBound;
	}

	@Override
	public boolean isOutOfScreen() {
		if(posX < -image.getWidth()) {
			return true;
		}
		return false;
	}
	
}
