package map;

import javafx.scene.layout.AnchorPane;
import map.crane.CraneView;
import map.line.LineView;
import map.stoplocation.StopLocationView;
import map.storagelocation.StorageLocationView;
import store.YardStore;

public class YardMap extends AnchorPane {
    //
    public YardMap() {
        draw();
    }

    private void draw() {
        //
        YardStore.getInstance().getLineMap().values().stream().map(LineView::new).forEach((lineView -> this.getChildren().add(lineView)));
        System.out.println("draw line");
        YardStore.getInstance().getCraneMap().values().stream().map(CraneView::new).forEach((craneView) -> this.getChildren().add(craneView));
        System.out.println("draw crane");
        YardStore.getInstance().getStopLocationMap().values().stream().map(StopLocationView::new).forEach(stopLocationView -> this.getChildren().add(stopLocationView));
        System.out.println("draw stopLocation");
        YardStore.getInstance().getStorageLocationMap().values().stream().map(StorageLocationView::new).forEach(storageLocationView -> this.getChildren().add(storageLocationView));
        System.out.println("draw storageLocation");
    }
}