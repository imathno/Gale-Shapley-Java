import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileInputStream fileInputStream1, fileInputStream2;
        BufferedReader bufferedReader1, bufferedReader2;

        String[][] m = new String[Integer.parseInt(args[0])][Integer.parseInt(args[1])];
        String[][] w = new String[Integer.parseInt(args[0])][Integer.parseInt(args[1])];

        try {
            fileInputStream1 = new FileInputStream(args[2]);
            bufferedReader1 = new BufferedReader(new InputStreamReader(fileInputStream1));

            fileInputStream2 = new FileInputStream(args[3]);
            bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream2));


            String line = bufferedReader1.readLine();

            int i = 0;
            while (line != null) {
                m[i] = line.split(",");
                line = bufferedReader1.readLine();
                i++;
            }

            line = bufferedReader2.readLine();

            i = 0;
            while (line != null) {
                w[i] = line.split(",");
                line = bufferedReader2.readLine();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<GaleShapley.Pair> pairs = GaleShapley.getMatches(m, w);

        for (GaleShapley.Pair p : pairs) {
            System.out.println(p.a + " <3 " + p.b);
        }
    }

    public static void test() {
        String[][] m = {
                {"1", "4", "5", "6"},
                {"2", "5", "4", "6"},
                {"3", "6", "4", "5"}};

        String[][] w = {
                {"4", "1", "2", "3"},
                {"5", "2", "3", "1"},
                {"6", "3", "1", "2"}};

        List<GaleShapley.Pair> pairs = GaleShapley.getMatches(m, w);

        for (GaleShapley.Pair p : pairs) {
            System.out.println(p.a + " <3 " + p.b);
        }

        String[][] m2 = {
                {"Bill", "Jane", "Joan", "Diana", "Brianna"},
                {"Alex", "Joan", "Jane", "Brianna", "Diana"},
                {"John", "Joan", "Diana", "Brianna", "Jane"},
                {"Alfred", "Diana", "Brianna", "Joan", "Jane"}};

        String[][] w2 = {
                {"Jane", "Alex", "Bill", "John", "Alfred"},
                {"Joan", "John", "Alex", "Bill", "Alfred"},
                {"Diana", "Alfred", "Alex", "John", "Bill"},
                {"Brianna", "Bill", "Alex", "John", "Alfred"}};

        List<GaleShapley.Pair> pairs2 = GaleShapley.getMatches(m2, w2);

        for (GaleShapley.Pair p : pairs2) {
            System.out.println(p.a + " <3 " + p.b);
        }
    }
}
