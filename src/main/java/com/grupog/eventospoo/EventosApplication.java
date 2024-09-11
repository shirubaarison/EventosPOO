        package com.grupog.eventospoo;
        import com.grupog.eventospoo.controller.HomeController;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

        import java.io.IOException;

        public class EventosApplication extends Application {

            @Override
            public void start(Stage stage) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/HomeView.fxml"));
                Parent root = loader.load();

                Scene homeScene = new Scene(root);

                stage.setTitle("Eventos Acadêmicos");
                stage.setScene(homeScene);

                // Pegar controller
                HomeController homeController = loader.getController();
                // setar o stage
                homeController.setPrimaryStage(stage);

                stage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

