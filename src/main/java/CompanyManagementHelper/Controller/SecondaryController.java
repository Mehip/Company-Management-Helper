package CompanyManagementHelper.Controller;

import java.io.IOException;

import CompanyManagementHelper.App;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}