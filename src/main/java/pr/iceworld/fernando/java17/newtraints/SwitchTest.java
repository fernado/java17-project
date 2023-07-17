package pr.iceworld.fernando.java17.newtraints;

public class SwitchTest {

    public static void main(String[] args) {
        switchAction(null);

        switchAction("20");

        System.out.println(xxx);
    }

    static String xxx = """
            this is a test \
            concat here
            this is another line
             """;
    static void switchAction(String s) {
        switch (s) {
            case null:
                System.out.println("null");
                break;
            case "10", "20":
                System.out.println("10");
                break;
            default:
                System.out.println("default");
        }
    }
}
