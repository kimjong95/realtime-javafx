package service.sdo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class YardStorageLocation {
    //
    private double locationId;
    private String locationCode;
    private int stackLevel;
    private int maxStackCount;
    private int status;

    private YardVolume volume;
}
