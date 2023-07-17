package pr.iceworld.fernando.java17.ocp;

/**
 * 先使用 javac NoStaticMainMethod.java 命令进行编译，会得到 NoStaticMainMethod.class 文件；
 * java NoStaticMainMethod.class 命令运行，会看到输出如下的错误
 * 错误: main 方法不是类 pr.iceworld.fernando.java17.ocp.NoStaticMainMethod 中的static, 请将 main 方法定义为:
 *    public static void main(String[] args)
 */
public class NoStaticMainMethod {

    public void main(String[] args) {
        System.out.println("hello");
    }
}
