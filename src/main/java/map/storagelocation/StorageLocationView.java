package map.storagelocation;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import map.mateiral.MaterialView;

public class StorageLocationView extends VBox {
    //
    private StorageLocationModel model;

    public StorageLocationView() {
        setStyle("-fx-border-color:#000000");
        setSpacing(0.5);
        setAlignment(Pos.BOTTOM_CENTER);
    }

    public StorageLocationView(StorageLocationModel model) {
        this();
        this.model = model;

        setTranslateX(model.getVolume().getValue().getXcoordinate());
        setTranslateY(model.getVolume().getValue().getYcoordinate());
        setPrefSize(model.getVolume().getValue().getWidth(), model.getVolume().getValue().getHeight());

        redrawMaterials();
    }

    private void redrawMaterials() {
        double materialHeight = this.getPrefHeight() / model.getMaxStackCount().get();
        if(!model.getMaterials().isEmpty()) {
            model.getMaterials().sorted().forEach(materialModel -> {
                MaterialView materialView = new MaterialView(materialModel);
                materialView.setPrefSize(this.getPrefWidth(), materialHeight);
                this.getChildren().add(materialView);
            });
        }
    }
}
