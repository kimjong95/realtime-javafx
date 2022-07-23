package service;

import com.google.gson.reflect.TypeToken;
import map.crane.CraneModel;
import map.line.LineModel;
import map.mateiral.MaterialModel;
import map.stoplocation.StopLocationModel;
import map.storagelocation.StorageLocationModel;
import service.sdo.*;
import store.YardStore;
import util.HTTPRequester;
import util.JsonUtil;

import java.util.List;
import java.util.stream.Collectors;

public class ServiceRequester {
    //
    private static ServiceRequester instance;
    private static final String connectURL = "http://localhost:8080";

    public ServiceRequester() {
        //
//        initialize();
    }

    public static ServiceRequester getInstance() {
        //
        if(instance == null) {
            instance = new ServiceRequester();
        }
        return instance;
    }

    public void initialize() {
        //
        // lines
        List<YardLine> lines = JsonUtil.fromJson(HTTPRequester.get(connectURL+"/lines", null), new TypeToken<List<YardLine>>(){}.getType());
        List<LineModel> lineModels = lines.stream().map(LineModel::new).collect(Collectors.toList());
        YardStore.getInstance().addLineModels(lineModels);

        // cranes
        List<YardCrane> cranes = JsonUtil.fromJson(HTTPRequester.get(connectURL+"/cranes", null), new TypeToken<List<YardCrane>>() {}.getType());
        List<CraneModel> craneModels = cranes.stream().map(CraneModel::new).collect(Collectors.toList());

        YardStore.getInstance().addCraneModels(craneModels);

        // stoplocations
        List<YardStopLocation> stopLocations = JsonUtil.fromJson(HTTPRequester.get(connectURL+"/stoplocations", null), new TypeToken<List<YardStopLocation>>(){}.getType());
        List<StopLocationModel> stopLocationModels = stopLocations.stream().map(StopLocationModel::new).collect(Collectors.toList());
        YardStore.getInstance().addStopLocationModels(stopLocationModels);

        // storagelocations
        List<YardStorageLocation> storageLocations = JsonUtil.fromJson(HTTPRequester.get(connectURL+"/storagelocations", null), new TypeToken<List<YardStorageLocation>>(){}.getType());
        List<StorageLocationModel> storageLocationModels = storageLocations.stream().map(StorageLocationModel::new).collect(Collectors.toList());
        YardStore.getInstance().addStorageLocationModels(storageLocationModels);

        // materials
        List<YardMaterial> materials = JsonUtil.fromJson(HTTPRequester.get(connectURL+"/materials", null), new TypeToken<List<YardMaterial>>(){}.getType());
        List<MaterialModel> materialModels = materials.stream().map(MaterialModel::new).collect(Collectors.toList());
        YardStore.getInstance().addMaterialModels(materialModels);

        System.out.println("Intiailize complete");
    }
}
