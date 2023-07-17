package pr.iceworld.fernando.java8.basic;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class ByteArrayTest {

    public static void main(String[] args) throws IOException {
        byte c1[] = {10, 20, 30, 40, 50};
        byte c2[] = {60, 70, 80, 90};
        ByteArrayOutputStream b1 = new ByteArrayOutputStream();
        ByteArrayOutputStream b2 = new ByteArrayOutputStream(10);
        b2.write(100);;
        System.out.println("Out 1: " + b2.size());
        b2.write(c1, 0, c2.length);
        System.out.println("Out 2: " + b2.size());
        byte[] bs = b2.toByteArray();
        System.out.println("Out 3: " + bs.length);
        System.out.println("Out 33: " + Arrays.toString(bs));
        b2.flush();
        bs= b2.toByteArray();
        System.out.println("Out 4: " + b2.size());
        b1.writeTo(b2);
        b2.reset();
        System.out.println("Out 5: " + b2.size());
        b1.writeTo(b2);
        System.out.println("Out 6: " + b1.size());

//        Locale locale = new Locale();

        String message = null;
        try {
            message = getMessage();
            System.out.println(message);
        } catch (Exception e) {
            message += "F";
            System.out.println(message);
        } finally {
            System.out.println(message);
        }

        Double d = new Double("12.33d");
//        Character c = new Character("C");
        Boolean bb = new Boolean("false");
        Float f = new Float(2323.3);
//        Integer i = Integer.parseUnsignedInt(4);


        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add(0, "3");
        list.add(1, "4");
        list.forEach(System.out::println);

        System.out.println("cccccccccccccccc");

        list.spliterator().forEachRemaining(System.out::println);


        byte[] arr = new byte[] {2, 3, 4, 5};

        for(final int i : getCharArray(arr)) {
            System.out.print(i + " ");
        }
    }

    static char[] getCharArray(byte[] arr) {
        char[] charr = new char[4];
        int i = 0;
        for (byte c: arr) {
            charr[i] = (char) c++;
            i++;
        }
        return charr;
    }

    interface OnClickListener {
        void onClick(String v);
    }




    public void openAccount(String accountNumber) {
        OnClickListener newAcc = new OnClickListener() {
            @Override
            public void onClick(String v) {

            }
        };

        OnClickListener a = v -> {
            // ccc
        };
    }

    public void openAccount(int cc) {

    }

    public String openAccount(String accountNumber, String bb) {
        return "";
    }

    public static String getMessage() throws Exception {
        String message = "A";
        try {
            throw new Exception();
        } catch (Exception e) {
            try {
                try {
                    throw new Exception();
                } catch (Exception ex) {
                    message += "B";
                }
                throw new Exception();
            } catch (Exception x) {
                message += "C";
            } finally {
                message += "D";
            }
        } finally {
            message += "E";
        }
        return message;

    }
}
