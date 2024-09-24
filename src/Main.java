//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
     String name1 = "Victor";
     String name2 = "Victor";
     String name3 = new String("Victor A");
     String name4 = "Victor";
        System.out.println(Integer.toHexString(name1.hashCode()));
        System.out.println(Integer.toHexString(name2.hashCode()));
        System.out.println(Integer.toHexString(name3.hashCode()));
        System.out.println(Integer.toHexString(name4.hashCode()));

    }
}