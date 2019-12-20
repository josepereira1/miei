package ex1;

public interface Bank {
    int createAccount(float initialBalance);
    float closeAccount(int id) throws ContaInvalidaException;
    void transfer(int from, int to, float amount) throws ContaInvalidaException, NaoDinheiroException;
    float totalBalance(int accounts[]);
}
