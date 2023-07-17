package pr.iceworld.fernando.java8.basic;

import java.io.*;

public class FileClass implements Serializable {
    FileClass() {
        System.out.println("File");
    }

    /**
     * 如果父类没有被序列化，则反序列化时会自动调用父类无参构造函数
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ChildFileClass childFileClass = new ChildFileClass("XYZ");
        FileOutputStream file = new FileOutputStream("Data.txt");
        ObjectOutputStream output = new ObjectOutputStream(file);
        output.writeObject(childFileClass);
        output.close();
        FileInputStream fis = new FileInputStream("Data.txt");
        ObjectInputStream is = new ObjectInputStream(fis);
        ChildFileClass c2 = (ChildFileClass) is.readObject();
        System.out.println(c2.getName());
        is.close();
    }
}

class ChildFileClass extends FileClass implements Serializable {
    private String name;
    ChildFileClass(String name) {
        this.name = name;
        System.out.println("Test");
    }

    public String getName() {
        return this.name;
    }
}
