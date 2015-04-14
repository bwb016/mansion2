package game;

import org.newdawn.slick.Color;

public class Events {

	private GameCharSprite character;
	private ObjectManager manager;
	private TileGrid grid;
	private TextManager textManager;
	private int levelX = 650, levelY = 50;
	private int Entrance1 = 0, Entrance2 = 1, LivingRoom1 = 2, LivingRoom2 = 3,
			LivingRoom3 = 4, LivingRoom4 = 5, LivingRoom5 = 6;
	private CollisionGrid collide;
	private Inventory gui;

	// private static TextString text;

	public Events(GameCharSprite character, TileGrid grid,
			TextManager textManager,ObjectManager manager, CollisionGrid collide, Inventory gui) {

		this.character = character;
		this.grid = grid;
		this.textManager = textManager;
		this.manager = manager;
		this.collide = collide;
		this.gui = gui;
		
	}

	public void Update() {
		//System.out.println((Artist.WIDTH - character.getX()-1)/32);

		if (character.getLevel() == Entrance1) { // Entrance1 == 0
			// System.out.println("Level is 0");
			textManager.setText(textManager.getText(0), "Entrance 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Entrance1();
			manager.Entrance1();
			if(!(gui.getInventorySlot(1).getImageNum()==0)){
				//gui.addItem(1, "empty");
				System.out.println("ran");
			}
			
			

		}
		if (character.getLevel() == Entrance2) { // Entrance2 == 1
			// System.out.println("Level is 1");
			textManager.setText(textManager.getText(0), "Entrance 2", levelX,
					levelY, Color.red);
			textManager.callText(0);
			Entrance2();
			manager.Entrance2();
			if(gui.isEmpty(1)){
				gui.addItem(1, "sword");
				System.out.println("ran");
			}
			

		}
		if (character.getLevel() == LivingRoom1) { // LivingRoom1 == 2
			// text();System.out.println("Level is 2");
			LivingRoom1();
			textManager.setText(textManager.getText(0), "LivingRoom 1", levelX,
					levelY, Color.red);
			textManager.callText(0);
			if(!(gui.getInventorySlot(1).getImageNum()==2)){
				character.setSpeed(100);
			}
			
		}else{
			character.setSpeed(200);	
		}
		if (character.getLevel() == LivingRoom2) {
			// System.out.println("Level is 3");
			LivingRoom2();
			textManager.setText(textManager.getText(0), "LivingRoom2", levelX,
					levelY, Color.red);
			textManager.callText(0);

		}
		if (character.getLevel() == LivingRoom3) {
			// System.out.println("Level is 3");
			LivingRoom3();
			textManager.setText(textManager.getText(0), "LivingRoom3", levelX,
					levelY, Color.red);
			textManager.callText(0);

		}
		if (character.getLevel() == LivingRoom4) {
			// System.out.println("Level is 3");
			LivingRoom4();
			textManager.setText(textManager.getText(0), "LivingRoom 4", levelX,
					levelY, Color.red);
			textManager.callText(0);

		}
		if (character.getLevel() == LivingRoom5) {
			// System.out.println("Level is 3");
			LivingRoom5();
			textManager.setText(textManager.getText(0), "LivingRoom 5", levelX,
					levelY, Color.red);
			textManager.callText(0);
			LivingRoom5();

		}

	}

	private void Entrance2() {
		
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.Entrance1());
			character.setX(500);
			character.setLevel(Entrance1);
			collide.setGrid(CollideMaps.Entrance1());

		}

	}

	private void Entrance1() {
		//collide.setGrid(CollideMaps.Entrance1());
		if (character.getXInt() == 27) {

			grid.setGrid(Map.Entrance2());
			character.setX(50);
			character.setLevel(Entrance2);
			collide.setGrid(CollideMaps.Entrance2());
		}
		
		if (character.getXInt() == 0
				&& (character.getYInt() == 13 ||character.getYInt() == 12 || character.getYInt() == 11  )) {

			grid.setGrid(Map.LivingRoom1());
			character.setX(550);
			character.setLevel(LivingRoom1);
			collide.setGrid(CollideMaps.LivingRoom1());
		}

	}

	private void LivingRoom1() {
		
		if (character.getXInt() == 27
				&& (character.getYInt() == 12 || character.getYInt() == 11 || character
						.getYInt() == 13)) {
			// System.out.println("events");
			grid.setGrid(Map.Entrance1());
			character.setX(50);
			character.setLevel(Entrance1);
			collide.setGrid(CollideMaps.Entrance1());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom2());
			character.setX(550);
			character.setLevel(LivingRoom2);
			collide.setGrid(CollideMaps.LivingRoom2());

		}

	}

	private void LivingRoom2() {

		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom1());
			character.setX(64);
			character.setLevel(LivingRoom1);

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom3());
			character.setX(550);
			character.setLevel(LivingRoom3);
			collide.setGrid(CollideMaps.LivingRoom3());

		}
		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom5());
			character.setY(540);
			character.setLevel(LivingRoom5);
			collide.setGrid(CollideMaps.LivingRoom5());

		}

	}

	private void LivingRoom3() {

		if (character.getYInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom4());
			character.setY(540);
			character.setLevel(LivingRoom4);
			collide.setGrid(CollideMaps.LivingRoom4());

		}

		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom2());
			character.setX(64);
			character.setLevel(LivingRoom2);
			collide.setGrid(CollideMaps.LivingRoom2());

		}

	}

	private void LivingRoom4() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom3());
			character.setY(50);
			character.setLevel(LivingRoom3);
			collide.setGrid(CollideMaps.LivingRoom3());

		}
		if (character.getXInt() == 27) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom5());
			character.setX(50);
			character.setLevel(LivingRoom5);
			collide.setGrid(CollideMaps.LivingRoom5());

		}

	}

	private void LivingRoom5() {
		if (character.getYInt() == 17) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom2());
			character.setY(50);
			character.setLevel(LivingRoom2);
			collide.setGrid(CollideMaps.LivingRoom2());

		}
		if (character.getXInt() == 0) {
			// System.out.println("events");
			grid.setGrid(Map.LivingRoom4());
			character.setX(550);
			character.setLevel(LivingRoom4);
			collide.setGrid(CollideMaps.LivingRoom4());

		}

	}

}
