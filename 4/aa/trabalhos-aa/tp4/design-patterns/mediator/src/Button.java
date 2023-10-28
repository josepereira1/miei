public class Button extends Component {

    public Button(Mediator mediator) {
        super(mediator);
    }

    public void click() {
        this.mediator.notify(this, "click");
    }

    public void hover() {
        this.mediator.notify(this, "hover");
    }
}
