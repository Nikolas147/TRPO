package Laba2;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Parser {
    public static void main(String[] args) throws IOException {
        TableOut table = JSON.parseObject(readFile(), TableOut.class);
        String what = "current_speed";
        Assistant Current_speed = new Assistant(table.getTable().getRows().get(0), what, table.getTable().getColumnNames());
        what = "temperature";
        Assistant Temperature = new Assistant(table.getTable().getRows().get(0), what, table.getTable().getColumnNames());
        what = "salinity";
        Assistant Salinity = new Assistant(table.getTable().getRows().get(0), what, table.getTable().getColumnNames());

        for (List<Object> i : table.getTable().getRows()) { //изменить i!!!!!!!!!
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
