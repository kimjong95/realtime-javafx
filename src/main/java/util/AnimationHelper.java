package util;

import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class AnimationHelper {
    //
    public static void setOnBlowingAnimation(Node node, double scale, int durationMillis) {
        //
        if (node == null) return;

        ScaleTransition blowTransition = new ScaleTransition(Duration.millis(durationMillis), node);
        blowTransition.setFromX(1);
        blowTransition.setFromY(1);
        blowTransition.setByX(scale);
        blowTransition.setByY(scale);
        KeyFrame blowAnimation = new KeyFrame(Duration.millis(300), event -> blowTransition.play());
        Timeline blowTimeline = new Timeline(blowAnimation);

        ScaleTransition reverseTransition = new ScaleTransition(Duration.millis(durationMillis), node);
        reverseTransition.setFromX(1);
        reverseTransition.setFromY(1);
        reverseTransition.setByX(1 / scale);
        reverseTransition.setByY(1 / scale);
        KeyFrame reverseAnimation = new KeyFrame(Duration.millis(300), event -> reverseTransition.play());
        Timeline reverseTimeline = new Timeline(reverseAnimation);

        node.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
            if (isRunning(reverseTimeline)) {
                reverseTimeline.stop();
            }

            if (!isRunning(blowTimeline)) {
                blowTimeline.playFromStart();
            }
        });

        node.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
            if (isRunning(blowTimeline)) {
                blowTimeline.stop();
            }
            reverseTimeline.playFromStart();
        });
    }

    private static boolean isRunning(Timeline timeline) {
        return timeline.getStatus() == Timeline.Status.RUNNING;
    }
}
