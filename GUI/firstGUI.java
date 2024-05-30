import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class firstGUI extends Application{

    @Override
    public void start(Stage stage) {

        stage.setTitle("MY first GUI");
        Label label= new Label("Hello Everyone");
        Scene s = new Scene(label);
        stage.setScene(s);
        stage.show();
        
    }
        public static void main(String[] args) {
            launch(args);
        }
}