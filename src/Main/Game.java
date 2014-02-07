package Main;

import java.util.ArrayList;

import Screens.State;

public abstract class Game implements GlobalSettings {

	static State state = State.INTRO;

	public Game() {
		Initialize();
		LoadContent();
	}

	public abstract void Initialize();

	public abstract void LoadContent();

	public void Update() {
		Components.Update();
	}

	public static class Components {
		private static ArrayList<GameComponent> RemoveComponents;
		private static ArrayList<GameComponent> Components;
		public static ArrayList<GameComponent> getComponents() {
			return Components;
		}

		public static void add(GameComponent comp) {
			if (Components == null) {
				Components = new ArrayList<GameComponent>();
			}
			Components.add(comp);
		}

		private static void remove(GameComponent comp) {
			if (RemoveComponents == null) {
				RemoveComponents = new ArrayList<GameComponent>();
			}
			RemoveComponents.add(comp);
		}

		protected static void Update() {
			if (Components == null) {
				Components = new ArrayList<GameComponent>();
			}
			if (RemoveComponents == null) {
				RemoveComponents = new ArrayList<GameComponent>();
			}
			if (Components.size() != 0) {
				for (GameComponent Component : Components) {
					if (Component.Remove)
						remove(Component);
					else
						Component.Update();
						Component.Draw();
				}

				for (GameComponent Component : RemoveComponents) {
					Components.remove(Component);
				}
				RemoveComponents.clear();

			}
		}

	}

}
