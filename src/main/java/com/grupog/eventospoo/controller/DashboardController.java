package com.grupog.eventospoo.controller;

import com.grupog.eventospoo.model.SystemModel;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class DashboardController {

    private SystemModel systemModel;

    @FXML
    public void initialize() {
        systemModel = SystemModel.getInstance();
    }

    @FXML
    private void handleLogout() {
        systemModel.logout();
    }
}
