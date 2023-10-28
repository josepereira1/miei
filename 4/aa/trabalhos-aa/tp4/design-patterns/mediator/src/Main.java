public class Main {
    public static void main(String[] args) {

        Mediator mediator = new UIHandler(); /** Acts as a mediator between UI components. */
        Button button = new Button(mediator);
        TextBox textBox = new TextBox(mediator);
        TextInput textInput = new TextInput(mediator);
        mediator.addComponent(button);
        mediator.addComponent(textBox);
        mediator.addComponent(textInput);

        textInput.setText("Nestor"); /** Simular a introdução do nome na UI. */
        button.hover(); /** Simular passar o rato em cima do botão. */
        button.click(); /** Simular o clicar no botão. */
    }
}
