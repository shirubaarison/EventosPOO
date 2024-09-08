        package com.grupog.eventospoo;
        import com.grupog.eventospoo.view.HomeView;
        import javafx.application.Application;
        import javafx.stage.Stage;

        import java.io.IOException;

        public class EventosApplication extends Application {

            @Override
            public void start(Stage stage) throws IOException {
                new HomeView(stage);
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

