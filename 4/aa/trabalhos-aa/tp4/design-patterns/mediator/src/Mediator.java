public interface Mediator {
    void notify(Component sender, String event);
    void addComponent(Component component);
}
