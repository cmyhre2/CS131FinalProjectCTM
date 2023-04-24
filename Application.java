/**
 * This class runs the gem collection game.
 * 
 * @author Chris Myhre
 * @version 1.1 (CS-131 Final Project)
 * Spring 2023 (04/23/2023)
 */
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
public class Application {
	public static void main(String[] argv) throws Exception {
		System.out.println("Welcome to Gemattic!");
        System.out.println("W to move up.\nS to move down.\nA to move left.\nD to move right.\nESC to close the game.");
        System.out.println("Game Started.\n");
        

        /*
         * Creates a instance of Gemattic, creates a JFrame to implement Gemattic's controls.
         */
		Game game = new Game();
		game.generate();
		game.printBoard();
	    JFrame myJFrame = new JFrame();
	    
	    
	    /*
	     * A KeyListener to determine what keys were pressed while in the JFrame window.
	     * int keyCode = the Unicode number of the key pressed and depending on what key
	     * was pressed, the game will do certain things.
	     */
	    myJFrame.addKeyListener(new KeyAdapter() {
	      public void keyPressed(KeyEvent e) {
	        int keyCode = e.getKeyCode();
	        
	        if (keyCode == KeyEvent.VK_W) {
	          game.moveUp();
	          game.checkLocation();
	          game.printBoard();
	          game.checkBoard();
	        }
	        else if (keyCode == KeyEvent.VK_S) {
	          game.moveDown();
	          game.checkLocation();
	          game.printBoard();
	          game.checkBoard();
	        }
	        else if (keyCode == KeyEvent.VK_A) {
		          game.moveLeft();
		          game.checkLocation();
		          game.printBoard();
		          game.checkBoard();
		        }
	        else if (keyCode == KeyEvent.VK_D) {
		          game.moveRight();
		          game.checkLocation();
		          game.printBoard();
		          game.checkBoard();
		        }
	        else if (keyCode == KeyEvent.VK_ESCAPE) {
	        	  System.out.println("\nGame Ended. Rerun the game to play again.\nScore: " + game.getScore() + ", Moves Left: " + game.getMovesLeft());
		          System.exit(0);
		        }
	        else if (keyCode != KeyEvent.VK_W || keyCode != KeyEvent.VK_S || keyCode != KeyEvent.VK_A || keyCode != KeyEvent.VK_D || keyCode != KeyEvent.VK_ESCAPE) {
		          System.out.println("\nInvalid Key.\nW to move up.\nS to move down.\nA to move left.\nD to move right.\nESC to close the game.");
		        }
	      }
	    });
	    /*
	     * This allows the user see the JFrame to know if the game is listening for keys and
	     * allow the game to take in input if the user clicks off and then clicks back onto
	     * the JFrame window via taskbar.
	     */
	    myJFrame.setVisible(true);

		
	}//main() method
}//Application class