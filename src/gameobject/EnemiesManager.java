package gameobject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.Resource;

public class EnemiesManager {
	
	private BufferedImage cactus1;
	private BufferedImage cactus2;
	private BufferedImage bird;
	
	private Random rand;
	
	private List<Enemy> enemies;
	private MainCharacter mainCharacter;
	
//	public EnemiesManager(MainCharacter mainCharacter) {
//		rand = new Random();
//		cactus1 = Resource.getResouceImage("data/cactus1.png");
//		cactus2 = Resource.getResouceImage("data/cactus2.png");
//		bird = Resource.getResouceImage("data/bird.png");
//		
//		enemies = new ArrayList<Enemy>();
//		this.mainCharacter = mainCharacter;
//		enemies.add(createEnemy());	
//	}
	
	public EnemiesManager(MainCharacter mainCharacter) {
	    rand = new Random();
	    cactus1 = Resource.getResouceImage("data/cactus1.png");
	    cactus2 = Resource.getResouceImage("data/cactus2.png");
	    bird = Resource.getResouceImage("data/bird.png");
	    
	    enemies = new ArrayList<Enemy>();
	    this.mainCharacter = mainCharacter;
	    enemies.addAll(createEnemies());
	}

	
//	private Enemy createEnemy() {
//		int type = rand.nextInt(3);
//		if(type == 0) {
//			return new Bird(mainCharacter, 800, bird.getWidth() , bird.getHeight() , bird);
//		}
//		if(type == 1) {
//			return new Cactus(mainCharacter, 800, cactus1.getWidth(), cactus1.getHeight(), cactus1);
//		}
//		else {
//			return new Cactus(mainCharacter, 800, cactus2.getWidth() , cactus2.getHeight() , cactus2);
//		}
//	}
	
	private List<Enemy> createEnemies() {
	    List<Enemy> newEnemies = new ArrayList<Enemy>();
	    int type1 = rand.nextInt(3);
	    int type2 = rand.nextInt(3);
	    int distance = rand.nextInt(300) + 200; // khoảng cách giữa hai kẻ thù
	    
	    if(type1 == 0) {
	        newEnemies.add(new Bird(mainCharacter, 800, bird.getWidth(), bird.getHeight(), bird));
	    } else if(type1 == 1) {
	        newEnemies.add(new Cactus(mainCharacter, 800, cactus1.getWidth(), cactus1.getHeight(), cactus1));
	    } else {
	        newEnemies.add(new Cactus(mainCharacter, 800, cactus2.getWidth(), cactus2.getHeight(), cactus2));
	    }
	    
	    if(type2 == 0) {
	        newEnemies.add(new Bird(mainCharacter, 800 + distance, bird.getWidth(), bird.getHeight(), bird));
	    } else if(type2 == 1) {
	        newEnemies.add(new Cactus(mainCharacter, 800 + distance, cactus1.getWidth(), cactus1.getHeight(), cactus1));
	    } else {
	        newEnemies.add(new Cactus(mainCharacter, 800 + distance, cactus2.getWidth(), cactus2.getHeight(), cactus2));
	    }
	    
	    return newEnemies;
	}

	
	
//	public void update() {
//		for(Enemy e : enemies) {
//			e.update();
//		}
//		Enemy enemy = enemies.get(0);
//		if(enemy.isOutOfScreen()) {
//			mainCharacter.upScore();
//			enemies.clear();
//			enemies.add(createEnemy());
//		}
//	}
	
	public void update() {
	    for(Enemy e : enemies) {
	        e.update();
	    }
	    
	    Enemy lastEnemy = enemies.get(enemies.size() - 1);
	    if(lastEnemy.isOutOfScreen()) {
	        mainCharacter.upScore();
	        enemies.clear();
	        enemies.addAll(createEnemies());
	    }
	}

	
	public void draw(Graphics g) {
		for(Enemy e : enemies) {
			e.draw(g);
		}
	}
	
	
	
	public boolean isCollision() {
		for(Enemy e : enemies) {
			if (mainCharacter.getBound().intersects(e.getBound())) {
				return true;
			}
		}
		return false;
	}
	
	public void reset() {
//		enemies.clear();
//		enemies.add(createEnemy());
		enemies.clear();
        enemies.addAll(createEnemies());
		
	}
	
}
