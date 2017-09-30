/**
 * 单例枚举
 */
public enum SomeThing {
    INSTANCE;
    private Abc instance;

    SomeThing() {
        instance = new Abc();
    }

    public Abc getInstance() {
        return instance;
    }

    // 实际需要的单例对象
    private class Abc {
        private Abc() {
            System.out.print("666==" + new Random().nextInt());
        }
    }
}

/**
 * 测试类
 */
public class Test {
    // 测试代码
    public static void main(String[] args) throws IOException{
        SomeThing.INSTANCE.getInstance();
        SomeThing.INSTANCE.getInstance();
        SomeThing.INSTANCE.getInstance();
        //new SomeThing.Abc(); // 直接new对象，编译不通过
    }
}
    
// 结果输出：只有一个结果输出，证明对象只被创建了一次
// 666==1588658361
