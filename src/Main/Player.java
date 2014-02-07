package Main;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Rectangle;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.Color;

public class Player extends MovableGameComponent{

	private Vector2f Velocity, Position;
	
	public Player(Rectangle rectangle) {
		super(rectangle);
		this.Position = new Vector2f(rect.getX(), rect.getY());
		this.Velocity = new Vector2f(0,0);
	}

	@Override
	public void Initialize() {
		glEnable(GL_TEXTURE_2D);
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	}

	@Override
	public void Update() {
		switch(Keys.getNext())
		{
			case Keyboard.KEY_A:
				if (Velocity.x > -7) 
					Velocity.x -= 0.5f;
				break;
			case Keyboard.KEY_D:
				if (Velocity.x < 7) 
					Velocity.x += 0.5f;
				break;
			default:
				if (Velocity.x < 0) 
					Velocity.x += 0.5f;
				else if (Velocity.x > 0)
					Velocity.x -= 0.5f;
				break;
		}

		this.Position.x += Velocity.x;
		this.Position.y += Velocity.y;
		
		rect.setX((int) Position.x);
		rect.setY((int) Position.y);
	}

	@Override
	public void Draw() {
		Color.white.bind();
		glBegin(GL_QUADS);
			glColor3f(0.5f, 0.5f, 1.0f);
			glVertex2f(Position.x, Position.y);
			glVertex2f(Position.x, Position.y + rect.getHeight());
			glVertex2f(Position.x + rect.getWidth(), Position.y + rect.getHeight());
			glVertex2f(Position.x + rect.getWidth(), Position.y);
		glEnd();	
	}

}
