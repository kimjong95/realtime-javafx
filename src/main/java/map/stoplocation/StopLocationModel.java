package map.stoplocation;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import lombok.Getter;
import lombok.Setter;
import service.sdo.YardStopLocation;
import service.sdo.YardVolume;

@Getter
@Setter
public class StopLocationModel {
    //
    private double locationId;
    private String locationCode;
    private IntegerProperty status;

    private ObjectProperty<YardVolume> volume;

    public StopLocationModel() {
        status = new SimpleIntegerProperty();
        volume = new SimpleObjectProperty<>();
    }

    public StopLocationModel(YardStopLocation stopLocation) {
        this();
        this.locationId = stopLocation.getLocationId();
        this.locationCode = stopLocation.getLocationCode();
        this.status.set(stopLocation.getStatus());
        this.volume.set(stopLocation.getVolume());
    }
}
