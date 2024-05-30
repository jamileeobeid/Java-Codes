import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdditionView {

    TextField num1Field = new TextField();
    TextField num2Field = new TextField();
    Button addButton = new Button("Add");
    Label resultLabel = new Label("Result: ");

    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.getChildren().addAll(num1Field, num2Field, addButton, resultLabel);
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Add Two Numbers");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public TextField getNum1Field() {
        return num1Field;
    }

    public TextField getNum2Field() {
        return num2Field;
    }

    public Button getAddButton() {
        return addButton;
    }

    public Label getResultLabel() {
        return resultLabel;
    }
}