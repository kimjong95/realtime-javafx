package service.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class YardMaterial {
    //
    private String materialNumber;
    private String storageLocationCode;
    private int status;
    private int stackLevel;

    private double width;
    private double height;
    private double thickness;
}
