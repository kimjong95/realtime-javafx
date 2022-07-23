package service.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class YardCrane {
    //
    private double id;
    private String equipmentNumber;
    private int status;

    private YardMaterial material;
    private YardVolume volume;

//    public YardCrane(double id, String equipmentNumber, double status) {
//        this.id = id;
//        this.equipmentNumber = equipmentNumber;
//        this.status = status;
//    }
}
