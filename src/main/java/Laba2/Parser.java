package Laba2;


import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import com.alibaba.fastjson.JSON;

public class Parser {
    public static void main(String[] args) throws IOException, ParseException {
        TableOut table = JSON.parseObject(readFile(), TableOut.class);
        String what = "current_speed";
        Assistant Current_speed = new Assistant(table, what);
        what = "temperature";
        Assistant Temperature = new Assistant(table, what);
        what = "salinity";
        Assistant Salinity = new Assistant(table, what);

        for (List<Object> i : table.getTable().getRows()) {
            Current_speed.calculate(i);
            Temperature.calculate(i);
            Salinity.calculate(i);
            }

        System.out.println("{\n" + Current_speed + ",");
        System.out.println(Temperature + ",");
        System.out.println(Salinity + "\n}");

    }

    public static String readFile() throws IOException {
        String fileName = "C:\\Users\\Алексей\\Desktop\\Технология разработки ПО\\Labs\\src\\main\\java\\Laba2\\file.json";

        Scanner scanner = new Scanner(Paths.get(fileName));
        String s;
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()) {
            s = scanner.nextLine();
            builder.append(s).append('\n');
        }
        return builder.toString();

    }
}
