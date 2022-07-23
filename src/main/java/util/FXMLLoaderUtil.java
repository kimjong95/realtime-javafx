
package util;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * FXMLLoaderUtil
 *
 * @author <a href="mailto:mhjang@nextree.co.kr">Jang, Mihyeon</a>
 * @since 2018. 10. 07.
 */
public class FXMLLoaderUtil {

    private static Map<String, FXMLLoader> fxmlLoaderMap = new HashMap<>();

    public static void loadFXML(Initializable node, String fxmlResourcePath) {
        //
        if (!fxmlLoaderMap.containsKey(fxmlResourcePath)) {
            fxmlLoaderMap.put(fxmlResourcePath, new FXMLLoader(node.getClass().getResource(fxmlResourcePath)));
        }
        FXMLLoader fxmlLoader = fxmlLoaderMap.get(fxmlResourcePath);
        fxmlLoader.setRoot(node);
        fxmlLoader.setController(node);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            //
            e.printStackTrace();
        }
    }
}
