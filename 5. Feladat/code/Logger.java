import java.util.List;

public class Logger {
    private static int tabs;

    public Logger() {
        tabs = 0;
    }

    public static void addTab() {
        tabs++;
    }

    public static void removeTab() {
        tabs--;
    }

    public static void log(Object o, String functionName, List<Object> parameters) {
        for(int i = 0; i < tabs; i++) {
            System.out.print('\t');
        }
        System.out.print(o.getClass() + "." + functionName);
        System.out.print("(");
        int i = 0;
        for(i = 0; i < parameters.size()-1; i++) {
            System.out.print(parameters.get(i) + " ");
        }
        System.out.println(parameters.get(i) + ")");
    }
}
