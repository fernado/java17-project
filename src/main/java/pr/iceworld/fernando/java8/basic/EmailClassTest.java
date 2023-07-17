package pr.iceworld.fernando.java8.basic;

class SendDocument {
    {
        System.out.println("In SendDocument.");
    }
    public SendDocument() {
        System.out.println("Start to send document.");
    }

    {
        System.out.println("....................");
    }
    static {
        System.out.println("Check check.");
    }
}

class EmailDocument extends SendDocument {
    static {
        System.out.println("In EmailDocument.");
    }
    public EmailDocument() {
        System.out.println("EmailDocument is in progress.");
    }
    static {
        System.out.println("EmailDocument is complete.");
    }
}

/**
 * Check check.
 * In EmailDocument.
 * EmailDocument is complete.
 * Pre process document before send.
 * In SendDocument.
 * Start to send document.
 * EmailDocument is in progress.
 * Document has been processed and send.
 *
 */
class ProcessDocument extends EmailDocument {
    private void method1() {

    }
    void method2() {

    }
    public static void main(String[] args) {
        System.out.println("Pre process document before send.");
        ProcessDocument pd = new ProcessDocument();
        System.out.println("Document has been processed and send.");
        pd.method1();
        pd.method2();
    }
}

/**
 * Pre process document before send.
 * Check check.
 * In EmailDocument.
 * EmailDocument is complete.
 * In SendDocument.
 * Start to send document.
 * EmailDocument is in progress.
 * Document has been processed and send.
 */
class ExternalDoc {
    public static void main(String[] args) {
        System.out.println("Pre process document before send.");
        ProcessDocument pd = new ProcessDocument();
        System.out.println("Document has been processed and send.");
        // 'method1()' has private access
//        pd.method1();
        pd.method2();
    }
}
