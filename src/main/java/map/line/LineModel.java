package map.line;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import lombok.Getter;
import lombok.Setter;
import service.sdo.YardLine;
import service.sdo.YardVolume;

@Getter
@Setter
public class LineModel {
    //
    private double lineNumber;

    private ObjectProperty<YardVolume> volume;

    public LineModel() {
        //
        volume = new SimpleObjectProperty<>();
    }

    public LineModel(YardLine line) {
        this();
        this.lineNumber = line.getLineNumber();
        volume.setValue(line.getVolume());
    }
}
