package pr.iceworld.fernando.java8.basic;

import java.util.function.Consumer;
import java.util.function.Supplier;

class Invoice {
    public static String formatId(String oldId) {
        return oldId + "_Invoice";
    }

    public String formatId2(String oldId) {
        return oldId + "_Invoice2";
    }
}

public class SalesInvoice extends Invoice {
    public static String formatId(String oldId) {
        return oldId + "_SalesInvoice";
    }

    public String formatId2(String oldId) {
        return oldId + "_SalesInvoice2";
    }

    public static void main(String[] args) {
        Invoice invoice = new SalesInvoice();
        System.out.println(invoice.formatId("1234"));
        System.out.println(invoice.formatId2("5555"));

        // compile error
        //System.out.println((SalesInvoice)Invoice.formatId("1234"));

        invoice = new Invoice();
        System.out.println(invoice.formatId("1234"));
        System.out.println(invoice.formatId2("6666"));

        SalesInvoice invoice2 = new SalesInvoice();
        System.out.println(invoice2.formatId("1234"));
        System.out.println(invoice2.formatId2("7777"));


        Supplier<String> i = () -> "Card";
        Consumer<String> c = x -> System.out.print(x.toLowerCase());
        Consumer<String> d = x -> System.out.print(x.toUpperCase());
        c.andThen(d).accept(i.get());
        System.out.println();


    }
}
