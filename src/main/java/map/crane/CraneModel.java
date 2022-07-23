package map.crane;

import javafx.beans.property.*;
import lombok.Getter;
import lombok.Setter;
import service.sdo.YardCrane;
import service.sdo.YardVolume;

@Getter
@Setter
public class CraneModel {
    //
    private double id;
    private String equipmentNumber;

    private IntegerProperty status;
    private ObjectProperty<YardVolume> volume;

    public CraneModel() {
        status = new SimpleIntegerProperty();
        volume = new SimpleObjectProperty<>();
    }

    public CraneModel(YardCrane crane) {
        this();
        id = crane.getId();
        equipmentNumber = crane.getEquipmentNumber();

        status.setValue(crane.getStatus());
        volume.setValue(crane.getVolume());
    }
}
