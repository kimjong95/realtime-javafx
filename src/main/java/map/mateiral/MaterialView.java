package map.mateiral;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import service.EventService;
import util.SimpleTooltip;
import util.TooltipHelper;

public class MaterialView extends Pane {
    //
    private MaterialModel model;

    public MaterialView() {
        setStyle("-fx-background-color: #AA00EE");
        addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            System.out.println(model.getStackLevel());
        });
    }

    public MaterialView(MaterialModel model) {
        this();
        this.model = model;
//        setPrefSize(100, 100);
        addEventHandler(MouseEvent.MOUSE_ENTERED, event -> {
            SimpleTooltip.getInstance().setText(model.getMaterialNumber());
        });

        TooltipHelper.installTooltip(this, SimpleTooltip.getInstance());
    }
}
