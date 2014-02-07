package Main;

import org.lwjgl.util.Rectangle;

public abstract class MovableGameComponent extends GameComponent
{
	protected Rectangle rect;
	
	public Rectangle getRectangle(){return this.rect;}
	public MovableGameComponent(Rectangle rectangle)
	{	
		rect = rectangle;
		Initialize();
	}
	public abstract void Initialize();
	public abstract void Update();
	public abstract void Draw();
	
	public boolean intersects(MovableGameComponent MGB)
	{
		if(rect.intersects(MGB.getRectangle()))
			return true;
		else
			return false;
	}
	
}
