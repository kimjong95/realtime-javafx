import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import map.YardMap;
import map.crane.CraneModel;
import map.crane.CraneView;
import service.ServiceRequester;
import service.sdo.YardCrane;
import util.HTTPRequester;
import util.JsonUtil;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.stream.Collectors;

/**
 * YardMonitoringApp
 *
 * @author <a href="mailto:mhjang@nextree.co.kr">Jang, Mihyeon</a>
 * @since 2018. 10. 07.
 */
public class YardMonitoringApp extends Application {
    //
//    private PileYardController controller;

    public YardMonitoringApp() {
        //
//        this.controller = new PileYardController();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //
        String fxmlPath = "/com/pilot/mes/yard/fx/views/PileYardMainView.fxml";
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
//        loader.setController(controller);
//        BorderPane rootLayout = loader.load();
        ServiceRequester.getInstance().initialize();

        YardMap yardMap = new YardMap();
        Scene scene = new Scene(yardMap, 1250, 620);
//        scene.getStylesheets().add("/com/pilot/mes/yard/fx/css/layout.css");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.setOnCloseRequest(event -> {
            //
            if (Platform.isFxApplicationThread()) {
//                controller.onDispose();
                primaryStage.close();
                Platform.exit();
            }

//            BackgroundTask.stopAllTask();

            Timer timer = new Timer(true);
            timer.schedule(new TimerTask() {
                //
                @Override
                public void run() {
                    System.exit(0);
                }
            }, 1000);
        });


        primaryStage.show();
    }

    public static void main(String[] args) {
        //
        launch(args);
    }

}
