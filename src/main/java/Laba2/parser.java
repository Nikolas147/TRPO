package Laba2;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

public class parser {
    public static void main(String[] args) throws IOException {


        tableOUT table = JSON.parseObject(readFile(), tableOUT.class);
        table.toString();



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
