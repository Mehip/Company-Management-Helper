package CompanyManagementHelper.Controller;

import java.io.IOException;

import CompanyManagementHelper.App;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
