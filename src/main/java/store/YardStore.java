package store;

import map.crane.CraneModel;
import map.line.LineModel;
import map.mateiral.MaterialModel;
import map.stoplocation.StopLocationModel;
import map.storagelocation.StorageLocationModel;
import service.sdo.YardLine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YardStore {
    //
    private static YardStore instance;

    private Map<Double, CraneModel> craneMap;
    private Map<Double, LineModel> lineMap;
    private Map<String, MaterialModel> materialMap;
    private Map<Double, StopLocationModel> stopLocationMap;
    private Map<Double, StorageLocationModel> storageLocationMap;

    public YardStore() {
        //
        craneMap = new HashMap<>();
        lineMap = new HashMap<>();
        materialMap = new HashMap<>();
        stopLocationMap = new HashMap<>();
        storageLocationMap = new HashMap<>();
    }

    public static YardStore getInstance() {
        if(instance == null) {
            instance = new YardStore();
        }
        return instance;
    }

//    public void addLineModels(List<YardLine>)

    public void addCraneModels(List<CraneModel> craneModels) {
        craneModels.forEach(craneModel -> {
            craneMap.put(craneModel.getId(), craneModel);
        });
    }

    public void addLineModels(List<LineModel> lineModels) {
        lineModels.forEach(lineModel -> {
            lineMap.put(lineModel.getLineNumber(), lineModel);
        });
    }

    public void addMaterialModels(List<MaterialModel> materialModels) {
        materialModels.forEach(materialModel -> {
            for (StorageLocationModel storageLocationModel : storageLocationMap.values()) {
                if (storageLocationModel.getLocationCode().equals(materialModel.getStorageLocationCode().get())) {
                    storageLocationModel.addMaterial(materialModel);
                }
            }

            materialMap.put(materialModel.getMaterialNumber(), materialModel);
        });
    }

    public void addStopLocationModels(List<StopLocationModel> stopLocationModels) {
        stopLocationModels.forEach(stopLocationModel -> {
            stopLocationMap.put(stopLocationModel.getLocationId(), stopLocationModel);
        });
    }

    public void addStorageLocationModels(List<StorageLocationModel> storageLocationModels) {
        storageLocationModels.forEach(storageLocationModel -> {
            storageLocationMap.put(storageLocationModel.getLocationId(), storageLocationModel);
        });
    }

    public Map<Double, CraneModel> getCraneMap() {
        return craneMap;
    }

    public Map<Double, LineModel> getLineMap() { return lineMap; }

    public Map<String, MaterialModel> getMaterialMap() { return materialMap; }

    public Map<Double, StopLocationModel> getStopLocationMap() { return stopLocationMap; }

    public Map<Double, StorageLocationModel> getStorageLocationMap() { return storageLocationMap; }
}
