package map.storagelocation;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import lombok.Setter;
import map.mateiral.MaterialModel;
import service.sdo.YardStorageLocation;
import service.sdo.YardVolume;

import java.util.List;

@Getter
@Setter
public class StorageLocationModel {
    //
    private double locationId;
    private String locationCode;
    private IntegerProperty stackLevel;
    private IntegerProperty maxStackCount;
    private IntegerProperty status;

    private ObjectProperty<YardVolume> volume;

    private ObservableList<MaterialModel> materials;

    public StorageLocationModel() {
        stackLevel = new SimpleIntegerProperty();
        maxStackCount = new SimpleIntegerProperty();
        status = new SimpleIntegerProperty();

        volume = new SimpleObjectProperty<>();

        materials = FXCollections.observableArrayList();
    }

    public StorageLocationModel(YardStorageLocation storageLocation) {
        this();
        this.locationId = storageLocation.getLocationId();
        this.locationCode = storageLocation.getLocationCode();
        this.stackLevel.set(storageLocation.getStackLevel());
        this.maxStackCount.set(storageLocation.getMaxStackCount());
        this.status.set(storageLocation.getStatus());
        this.volume.set(storageLocation.getVolume());
    }

    public void addMaterials(List<MaterialModel> materialModels) {
        materials.addAll(materialModels);
    }

    public void addMaterial(MaterialModel material) {
        materials.add(material);
    }

    public void removeMaterial(MaterialModel material) {
        materials.remove(material);
    }
}
