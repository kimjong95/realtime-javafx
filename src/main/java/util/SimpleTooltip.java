package util;

import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;

public class SimpleTooltip extends Tooltip {
    //
    private static SimpleTooltip instance;

    public SimpleTooltip() {
        //
    }

    public static SimpleTooltip getInstance() {
        if(instance == null) {
            instance = new SimpleTooltip();
        }
        return instance;
    }
}
