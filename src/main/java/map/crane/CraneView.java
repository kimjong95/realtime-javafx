package map.crane;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CraneView extends Pane {
    //
    private CraneModel model;

    public CraneView() {
        setStyle("-fx-border-color: #000000; -fx-background-color: #999999");
    }

    public CraneView(CraneModel model) {
        this();
        this.model = model;

        setTranslateX(model.getVolume().getValue().getXcoordinate());
        setTranslateY(model.getVolume().getValue().getYcoordinate());
        setPrefSize(model.getVolume().getValue().getWidth(), model.getVolume().getValue().getHeight());
    }
}
