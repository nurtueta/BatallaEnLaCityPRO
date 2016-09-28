package Logica;

import javax.swing.*;

import Grafica.CeldaGrafica;
import Grafica.ComponenteGrafico;

import javax.imageio.*;
import java.awt.*;

/** GameObject is the base abstract class for all objects in the game (i.e. characters and buildings).
    @author Sam Baldwin
*/

public abstract class GameObject extends JLabel
{
	protected int xPos;   // Measured in Tiles
	protected int yPos;   // Measured in Tiles
	protected int xOffset;  // Measured in pixels
	protected int yOffset;  // Measured in pixels

	protected int width;  // Measured in Tiles
	protected int height; // Measured in Tiles
	

	protected ComponenteGrafico miGrafica;
	
	//protected GameGrid.GridValue[][] collisionValue;
	
	protected boolean interactuable=true;
	
	
	public GameObject()
	{
		/*
		this.xPos = 0;
		this.yPos = 0;
		
		this.width = 1;
		this.height = 1;
		
		collisionValue = new GameGrid.GridValue[width][height];
		collisionValue[0][0] = GameGrid.GridValue.FREE;
		
		interactable = false;
		
		texture = GameMain.getRenderer().getTile(0, 0, 16, 16);
		*/
	}
	
	/** Constructor 
		@param x X Position
		@param y Y Position
		@param width Width of GameObject
		@param height Height of GameObject
		@param interactable Whether or not the object may be interacted with
    	*/
	public GameObject(ComponenteGrafico objeto)
	{/*
		this.width = width;
		this.height = height;
		
		this.interactuable = interactable;
		
		// Create Collision Values and Initialize to FREE
		//collisionValue = new GameGrid.GridValue[width][height];
		
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
				//collisionValue[wCounter][hCounter] = GameGrid.GridValue.FREE;
			}
		}
		
		// Set the position (Has to be after the Initialization of collisionValues
		this.setPos(x, y);
		*/
		miGrafica=objeto;
		//this.setBounds(miGrafica.getMiX(), miGrafica.getMiY(), miGrafica.getAncho(),miGrafica.getAlto());
		
	}
	
	public boolean isInteractable()
	{
		return interactuable;
	}
	
	public void interact()
	{
		return;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public int getXPos()
	{
		return xPos;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getXOffset()
	{
		return this.xOffset;
	}
	
	public int getYOffset()
	{
		return this.yOffset;
	}
	
	/*public GameGrid.GridValue getCollisionValue(int x, int y)
	{
		return collisionValue[x][y];
	}
	*/
	
	public ComponenteGrafico getGrafico()
	{
		return miGrafica;
	}
	/*
	public void setPos(int x, int y)
	{
		/*
		this.xPos = x;
		this.yPos = y;
		
		// Update the Object Grid
		//GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
		
		// Update the Collision Grid
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
			/*	if(collisionValue[wCounter][hCounter] != GameGrid.GridValue.FREE)
				{
					GameMain.getRenderer().getGameGrid().setCollisionGrid(collisionValue[wCounter][hCounter],
										  	     (xPos + wCounter), (yPos + hCounter));
				}
						
		
		
	}
	*/
	public void updatePos()
	{
		//GameMain.getRenderer().getGameGrid().setObjectGrid(this, xPos, yPos);
	}
	/*
	public void setCollisionValue(GameGrid.GridValue cv, int x, int y)
	{
		this.collisionValue[x][y] = cv;
		
		// Update the Grid
		for(int wCounter = 0; wCounter < this.width; wCounter ++)
		{
			for(int hCounter = 0; hCounter < this.height; hCounter ++)
			{
				if(collisionValue[wCounter][hCounter] != GameGrid.GridValue.FREE)
				{
					GameMain.getRenderer().getGameGrid().setCollisionGrid(collisionValue[wCounter][hCounter],
										  	     (xPos + wCounter), (yPos + hCounter));
				}
			}
		}
	}*/
}