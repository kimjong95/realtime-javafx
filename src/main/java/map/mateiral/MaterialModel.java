package map.mateiral;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;
import lombok.Setter;
import service.sdo.YardMaterial;

@Getter
@Setter
public class MaterialModel implements Comparable<MaterialModel> {
    //
    private String materialNumber;
    private StringProperty storageLocationCode;
    private IntegerProperty status;
    private IntegerProperty stackLevel;

    private double width;
    private double height;
    private double thickness;

    public MaterialModel() {
        storageLocationCode = new SimpleStringProperty();
        status = new SimpleIntegerProperty();
        stackLevel = new SimpleIntegerProperty();
    }

    public MaterialModel(YardMaterial yardMaterial) {
        this();
        this.materialNumber = yardMaterial.getMaterialNumber();
        storageLocationCode.set(yardMaterial.getStorageLocationCode());
        status.set(yardMaterial.getStatus());
        stackLevel.set(yardMaterial.getStackLevel());

        this.width = yardMaterial.getWidth();
        this.height = yardMaterial.getHeight();
        this.thickness = yardMaterial.getThickness();
    }

    @Override
    public int compareTo(MaterialModel o) {
        return Integer.compare(o.getStackLevel().get(), this.getStackLevel().get());
    }
}
