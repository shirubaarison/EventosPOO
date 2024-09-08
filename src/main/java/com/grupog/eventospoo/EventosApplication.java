        package com.grupog.eventospoo;
        import com.grupog.eventospoo.view.BemVindoView;
        import javafx.application.Application;
        import javafx.stage.Stage;

        import java.io.IOException;

        public class EventosApplication extends Application {

            @Override
            public void start(Stage stage) throws IOException {
                new BemVindoView(stage);
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

