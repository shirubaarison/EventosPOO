package com.grupog.eventospoo.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.stage.Stage;


public class MainController {

    private final Scene cenaPrincipal;

    public MainController() {
        VBox layout = new VBox(50);
        Button botaoVisitante = new Button("Registrar como Visitante");
        Button botaoOrganizador = new Button("Registrar como Organizador");
        Button botaoPatrocinador = new Button("Registrar como Patrocinador");
        Button botaoLogin = new Button("Login");
        botaoVisitante.setOnAction(e -> mostrarRegistroVisitante());
        botaoOrganizador.setOnAction(e -> mostrarRegistroOrganizador());
        botaoPatrocinador.setOnAction(e-> mostrarRegistroPatrocinador());
        botaoLogin.setOnAction(e->mostrarLogin());
        
        layout.getChildren().addAll(botaoVisitante, botaoOrganizador, botaoPatrocinador);
        cenaPrincipal = new Scene(layout, 600, 400);
        layout.setAlignment(Pos.CENTER);

    }

    public Scene getCenaPrincipal() {
        return cenaPrincipal;
    }

    private void mostrarRegistroVisitante() {
        VisitanteController visitanteController = new VisitanteController();
        Stage stage = (Stage) cenaPrincipal.getWindow();
        stage.setScene(visitanteController.getCenaVisitante());
    }

    private void mostrarRegistroOrganizador() {
        OrganizadorController organizadorController = new OrganizadorController();
        Stage stage = (Stage) cenaPrincipal.getWindow();
        stage.setScene(organizadorController.getCenaOrganizador());
    }
    private void mostrarRegistroPatrocinador() {
        PatrocinadorController patrocinadorController = new PatrocinadorController();
        Stage stage = (Stage) cenaPrincipal.getWindow();
        stage.setScene(patrocinadorController.getCenaPatrocinador());
    }

    private void mostrarLogin() {
        LoginController loginController = new LoginController(); //ta dando pau
        Stage stage = (Stage) cenaPrincipal.getWindow();
        stage.setScene(loginController.getCenaLogin());
    }

}
