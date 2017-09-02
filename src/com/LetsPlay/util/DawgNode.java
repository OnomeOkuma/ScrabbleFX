/* This class implements the Node for the Dawg class.  
 */
package com.LetsPlay.util;

import java.util.ArrayList;
import java.util.Iterator;

public class DawgNode {
		
		// properties of the class.
		public char character;
		private ArrayList<DawgNode> children = new ArrayList<DawgNode>();
		
		// Constructor statement.
		public DawgNode(){
		}
	
		
		// Returns true if the character is a child of this node.
		public boolean isCharContained(char letter){
			
			// Get the iterator of its children.
			Iterator<DawgNode> iterator = this.children.iterator();
			
			while(iterator.hasNext()){
				
				// Get the next child.
				DawgNode temp = iterator.next();
				
				// Returns true if it is not null and its character property is the letter.
				if( temp != null && temp.character == letter)
					return true;
			}
			
			// Otherwise, return false.
			return false;
		}
		
		// Return the Node containing the parameter.
		public DawgNode getNode(char letter){

			Iterator<DawgNode> iterator = this.children.iterator();
			
			while(iterator.hasNext()){
				
				DawgNode temp = iterator.next();
				
				// Return the Node satisfying this requirement.
				if(temp != null && temp.character == letter)
					return temp;
			}
			
			// Otherwise return null
			return null;
		}
		
		
		// Adds a child to this Node.
		public void addChild(char letter){
			
				// Create a new Node.
				DawgNode temp = new DawgNode();
				
				// Set its Character property.
				temp.character = letter;
				
				// Add to this Node's Children.
				this.children.add(temp);
				
				// Trim this Node's Children ArrayList to reduce memory usage.
				this.children.trimToSize();
		}
		
		
		// Returns the nodes children.
		ArrayList<DawgNode> getChildren(){
			return this.children;
		}
		
		// Creates a Terminal Node.
		public void terminalNode(){
			
			// Add a null value.
			this.children.add(null);
			
			// Trim this Node's Children ArrayList to reduce memory usage.
			this.children.trimToSize();
		}
		
		// Returns true if this node is a Terminal node.
		public boolean isTerminalNode(){
			return this.children.contains(null);
		}
		
}
