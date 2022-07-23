package map.line;

import javafx.scene.layout.Pane;

public class LineView extends Pane {
    //
    private LineModel model;

    public LineView() {
        setStyle("-fx-border-color: #6286b8; -fx-background-color: #EEEEEE");
    }

    public LineView(LineModel model) {
        //
        this();
        this.model = model;

        setTranslateX(model.getVolume().getValue().getXcoordinate());
        setTranslateY(model.getVolume().getValue().getYcoordinate());
        setPrefSize(model.getVolume().getValue().getWidth(), model.getVolume().getValue().getHeight());
    }
}
