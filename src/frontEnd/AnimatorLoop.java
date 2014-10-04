package frontEnd;

import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

class AnimatorLoop {
	
	private KeyFrame frame;
	
	/**
	 * To be implemented later if we need to animate the turtle moving
	 */
	public AnimatorLoop() {
	}
	
	private EventHandler<ActionEvent> oneFrame = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			update();
		}
	};
	
	public KeyFrame start() {
		frame = new KeyFrame(Duration.millis(1000 / 60), oneFrame);
		return frame;
	}
	
	private void update() { 
	}

}
