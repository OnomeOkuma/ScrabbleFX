package com.LetsPlay.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;

public class PlayersView {
	private static ObservableList<String> names = FXCollections.observableArrayList(
	          "Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan", "Denise");
	 private static ListView<String> listView = new ListView<String>(names);
		public static ScrollPane playerview = new ScrollPane(listView);
		
		
		
}
