package interfacePackage;

public class InterfaceClass {
    public static void main(String[] args) {
        TestInter dgdf = new Employee();
        Employee fds = (Employee)dgdf;
        String a = dgdf.name;
        String b = fds.name;
        System.out.println(a);
        System.out.println(b);
    }
}
