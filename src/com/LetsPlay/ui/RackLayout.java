/* The RackLayout class creates the player rack. It also provides a function for adding 
 * tiles to the rack. As the the other classes created May 26 2017, its properties and methods
 * are not final and is subject to change to reflect the evolving nature of the project.
 * 
 * This Class might be deleted.
 */
package com.LetsPlay.ui;

//import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;

public class RackLayout extends HBox {
			public RackLayout(){
				this.setPrefSize(276.85, 36.6);
				this.setSpacing(3);
			}
			
}
