package frontEnd;

import javafx.animation.KeyFrame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

class AnimatorLoop {
	
	private static final double FRAMES_PER_SECOND = 60;
	private static final double FRAME_LENGTH = 1000 / FRAMES_PER_SECOND;

	private KeyFrame myFrame;
	
	private EventHandler<ActionEvent> myOneFrame = new EventHandler<ActionEvent>() {
		@Override
		public void handle (ActionEvent event) {
			update();
		}
	};
	
	/**
	 * To be implemented later if we need to animate the turtle moving
	 */
	AnimatorLoop () {
	}
	
	KeyFrame start () {
		myFrame = new KeyFrame(Duration.millis(FRAME_LENGTH), myOneFrame);
		return myFrame;
	}
	
	private void update () { 
	}

}
