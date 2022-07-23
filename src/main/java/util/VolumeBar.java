package util;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.HashMap;
import java.util.Map;

public class VolumeBar extends HBox {
    //
    private int barLength;
    private int barThickness;
    private Map<String, Label> gages;

    private VolumeBar() {
        super();
        this.gages = new HashMap<>();
        this.setAlignment(Pos.CENTER_LEFT);
        this.getStyleClass().add("piling-volume-bar");
    }

    public VolumeBar(int barLength, int barThickness) {
        this();
        this.barLength = barLength;
        this.barThickness = barThickness;
        this.minWidth(barLength);
        this.maxWidth(barLength);
    }

    public void addGage(String name, Color color, long value) {
        //
        Label gage = new Label();
        String style = String.format(
                "-fx-background-color: %s; -fx-font-size: %d;",
                color.getCode(), barThickness);
        gage.setStyle(style);

        double refinedValue = (value * barLength) / 100;
        gage.setMinWidth(refinedValue);
        gage.setMaxWidth(refinedValue);

        this.gages.put(name, gage);
        this.getChildren().add(gage);
    }

    public enum Color {
        //
        RED("#985754"), BLUE("#638ea1"), GREY("#BCBCBC"), WHITE("#FFFFFF");

        private String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
