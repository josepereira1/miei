public class TextInput extends Component {

    private StringBuilder currentText;

    public TextInput(Mediator mediator) {
        super(mediator);
        this.currentText = new StringBuilder();
    }

    public void appendText(String text) {
        this.currentText.append(text);
    }

    public void setText(String text) {
        this.currentText.setLength(0);
        this.currentText.append(text);
    }

    public String getText() {
        return this.currentText.toString();
    }
}
