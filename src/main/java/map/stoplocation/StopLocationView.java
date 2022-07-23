package map.stoplocation;

import javafx.scene.layout.Pane;

public class StopLocationView extends Pane {
    //
    private StopLocationModel model;

    public StopLocationView() {
        setStyle("-fx-border-color: #000000; -fx-background-color: #0000FF");
    }

    public StopLocationView(StopLocationModel model) {
        this();
        this.model = model;

        setTranslateX(model.getVolume().getValue().getXcoordinate());
        setTranslateY(model.getVolume().getValue().getYcoordinate());
        setPrefSize(model.getVolume().getValue().getWidth(), model.getVolume().getValue().getHeight());
    }
}
