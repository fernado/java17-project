package pr.iceworld.fernando.java8.basic;

public class Account<T> {
    private T accountType;

    public void add(T newType) {
        accountType = newType;
    }

    public T get() {
        return accountType;
    }

    public static void main(String[] args) {
        Account<String> account = new Account<>();
        account.add("h");
        System.out.println(account.get());
    }
}