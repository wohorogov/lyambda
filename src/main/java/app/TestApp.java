package app;

import java.util.ArrayList;
public class TestApp {
    public void action() {
        testWithString();
        testIntegrals();
    }
    public void testWithString() {
        ArrayList<String> array = new ArrayList<>();
        array.add("QWER");
        array.add("ASDASDAD");
        array.add("VSDVS");
        array.add("BNGSS");
        array.add("FGNSNY");
        array.add("CWEFVCS");
        array.add("BGSBS");
        array.add("GJGFD");

        for (String str: array) {
            System.out.println(str + " ");
        }
        System.out.println();

        array.replaceAll(String::toLowerCase);
        System.out.println("Строчные буквы");
        for (String str: array) {
            System.out.println(str + " ");
        }
        System.out.println();

        System.out.println("Отсортировано по количеству символов");
        array.sort((s1, s2) -> s1.length() > s2.length()? -1: 1);
        for (String str: array) {
            System.out.println(str + " ");
        }
        System.out.println();

        System.out.println("Отсортировано по содержимому");
        array.sort((s1, s2) -> s1.compareTo(s2) * (-1));
        for (String str: array) {
            System.out.println(str + " ");
        }
        System.out.println();
    }

    public void testIntegrals() {
        Function function = (a, b, ff) -> {
            double area = 0;
            double h = 0.01;
            for (int i = 0; i < (b - a) / h; i++) {
                area += h * (0.5 * (ff.functionDefault(a + i * h)) + ff.functionDefault(a + (i + 1) * h));
            }
            return area;
        };

        System.out.println(function.getIntegral(1, 10, function));

        Function functionSimpson = (a, b, ff) -> {
            return (b - a) / 6 * (ff.functionDefault(a) + 4 * ff.functionDefault((a + b) / 2)
                            + ff.functionDefault(b));
        };

        System.out.println(functionSimpson.getIntegral(1, 10, functionSimpson));
    }
}
