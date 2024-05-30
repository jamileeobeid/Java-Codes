public class AdditionController {

    private AdditionModel model;
    private AdditionView view;

    public AdditionController(AdditionModel model, AdditionView view) {
        this.model = model;
        this.view = view;
        view.getAddButton().setOnAction(e -> addNumbers());
    }

    private void addNumbers() {

    try {

        double num1 =
        Double.parseDouble(view.getNum1Field().getText());
        double num2 =
        Double.parseDouble(view.getNum2Field().getText());
        double result = model.addNumbers(num1, num2);
        view.getResultLabel().setText("Result: " + result);

    } catch (NumberFormatException e) {
        view.getResultLabel().setText("Please enter valid numbers.");
        }
    }
}
    