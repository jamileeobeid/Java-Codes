import javafx.application.Application;
import javafx.stage.Stage;

public class AdditionApp extends Application {

    @Override

    public void start(Stage primaryStage) {

        AdditionModel model = new AdditionModel();
        AdditionView view = new AdditionView();
        new AdditionController(model, view);
        view.start(primaryStage);
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}