package cs1302.arcade;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;





public class ArcadeApp extends Application {

	Random rng = new Random();

	@Override
	public void start(Stage stage) {

		/* You are allowed to rewrite this start method, add other methods, 
		 * files, classes, etc., as needed. This currently contains some 
		 * simple sample code for mouse and keyboard interactions with a node
		 * (rectangle) in a group. 
		 */
		
		Image image = new Image("https://upload.wikimedia.org/wikipedia/en/8/8d/NES_Tetris_Box_Front.jpg");
		Image image2 = new Image("https://upload.wikimedia.org/wikipedia/en/3/31/Minesweeper_XP.png");

		
		//sets up the MenuBar
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("File");
		MenuItem menuItem1 = new MenuItem("Exit");
		menuItem1.setOnAction(event -> Platform.exit());
		menu1.getItems().add(menuItem1);
		menuBar.getMenus().add(menu1);
		Menu menu2 = new Menu("Options");
		menuBar.getMenus().add(menu2);	
		Menu menu3 = new Menu("Help");
		MenuItem menuItem4 = new MenuItem("Tetris Rules");
		MenuItem menuItem3 = new MenuItem("Minesweeper Rules");
		menu3.getItems().add(menuItem3);
		menu3.getItems().add(menuItem4);
		//displays a new window containing rules on how to play Tetris
		menuItem4.setOnAction(event ->{
			TetrisRules.display();
		});
		//displays a new window containing rules on how to play Minesweeper
		menuItem3.setOnAction(event ->{
			MinesweeperRules.display();
		});
		menuBar.getMenus().add(menu3);
		
		Button tetris = new Button();
		tetris.setGraphic(new ImageView(image));
		tetris.setOnAction(event ->{
			//change to TetrisGame once working
			TetrisRules.display();
		});
		Button minesweeper = new Button();
		minesweeper.setGraphic(new ImageView(image2));
		minesweeper.setOnAction(event ->{
			//change to MinesweeperGame once working
			MinesweeperRules.display();
		});
		
		HBox gameSelect = new HBox(tetris, minesweeper);
		gameSelect.setSpacing(100);
		VBox root = new VBox(menuBar, gameSelect);
		
		Scene scene = new Scene(root, 640, 480);
		stage.setTitle("cs1302-arcade!");
		stage.setScene(scene);
		stage.sizeToScene();
		stage.show();


	} // start

	public static void main(String[] args) {
		try {
			Application.launch(args);
		} catch (UnsupportedOperationException e) {
			System.out.println(e);
			System.err.println("If this is a DISPLAY problem, then your X server connection");
			System.err.println("has likely timed out. This can generally be fixed by logging");
			System.err.println("out and logging back in.");
			System.exit(1);
		} // try
	} // main

} // ArcadeApp
