        package com.grupog.eventospoo;
        import com.grupog.eventospoo.controller.HomeController;
        import com.grupog.eventospoo.exceptions.AtividadeException;
        import com.grupog.eventospoo.exceptions.UsuarioException;
        import com.grupog.eventospoo.model.*;
        import com.grupog.eventospoo.utils.PasswordUtils;
        import javafx.application.Application;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Parent;
        import javafx.scene.Scene;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.util.Date;

        public class EventosApplication extends Application {

            @Override
            public void start(Stage stage) throws IOException, UsuarioException, AtividadeException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/grupog/eventospoo/views/HomeView.fxml"));
                Parent root = loader.load();

                Scene homeScene = new Scene(root);

                stage.setTitle("Eventos Acadêmicos");
                stage.setScene(homeScene);

                // Pegar controller
                HomeController homeController = loader.getController();
                // setar o stage
                homeController.setPrimaryStage(stage);

                // Inicializar o systemModel com usuários e eventos...
                SystemModel systemModel = SystemModel.getInstance();

                systemModel.addUsuario(new Usuario("amostradinho", "12312312343", "UFC", PasswordUtils.hashPassword("123"), "amostradinho@gmail.com", TipoUsuario.VISITANTE));
                systemModel.addUsuario(new Usuario("caska de bala", "11312312343", "UFBA", PasswordUtils.hashPassword("22"), "caska@gmail.com", TipoUsuario.ORGANIZADOR));
                systemModel.addUsuario(new Usuario("borabill", "12312312343", "UFRN", PasswordUtils.hashPassword("boraBill"), "borabill@gmail.com", TipoUsuario.AUTOR));
                systemModel.addUsuario(new Usuario("a", "12312312343", "UFC", PasswordUtils.hashPassword("1"), "amostradinho@gmail.com", TipoUsuario.VISITANTE));

                Evento sescomp = new Evento("SESCOMP", "O maior evento de tecnologia do vale do Jaguaribe", new Date(), "00:00", new Local("UFC Campus Russas", "Rua Universitária"));
                sescomp.adicionarAtividade(new Atividade("Maratona de programacao", TipoAtividade.MARATONA, new Autor("Amostradinho")));

                systemModel.addEvento(sescomp);

                systemModel.addEvento(new Evento("Torneio de Baladeira", "Valendo 2 milhões", new Date(), "01:00", new Local("Figuereido", "Figuereido")));

                stage.show();
            }

            public static void main(String[] args) {
                launch(args);
            }
        }

