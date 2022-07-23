package util;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * TooltipHelper
 *
 * @author <a href="mailto:mhjang@nextree.co.kr">Jang, Mihyeon</a>
 * @since 2018. 12. 08.
 */
public class TooltipHelper {
    //
    public static void installTooltip(Node node, Tooltip tooltip) {
        //
        if (node == null) return;

        KeyFrame keyFrame = new KeyFrame(Duration.millis(800), event -> tooltip.hide());
        Timeline hideTimer = new Timeline(keyFrame);

        node.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            //
            if (!tooltip.isShowing()) {
                tooltip.show(node, event.getScreenX(), event.getScreenY());
            }
        });

        tooltip.addEventHandler(MouseEvent.MOUSE_MOVED, event -> {
            //
            if (hideTimer.getStatus() == Timeline.Status.RUNNING) {
                hideTimer.stop();
            }
        });

        node.addEventHandler(MouseEvent.MOUSE_EXITED, handleMouseExitEvent(tooltip, hideTimer));
    }

    private static EventHandler<MouseEvent> handleMouseExitEvent(Tooltip tooltip, Timeline hideTimer) {
        return (MouseEvent event) -> {
            //
            if (tooltip.isShowing()) {
                hideTimer.playFromStart();
                tooltip.hide();
            }
        };
    }
}
