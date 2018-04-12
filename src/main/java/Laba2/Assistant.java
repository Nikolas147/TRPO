package Laba2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Assistant {
    private List<Object> Max;
    private List<Object> Min;
    private int num_record;
    private String column;
    private int num_column;
    private float sum;
    private String start_date;
    private String end_date;


    public Assistant(TableOut table, String column) {
        Max = table.getTable().getRows().get(0);
        Min = table.getTable().getRows().get(0);
        this.num_record = 0;
        this.column = column;
        this.num_column = whatSearch(column, table.getTable().getColumnNames());
        this.sum = 0;
        this.start_date = getDate(table, 0);
        this.end_date = getDate(table, table.getTable().getRows().size() - 1);
    }
    public Assistant() {
        this.num_record = 0;
        this.num_column = -1;
        this.sum = 0;
    }

    public List<Object> getMax() {
        return Max;
    }
    public List<Object> getMin() {
        return Min;
    }
    public int getNum_record() {
        return num_record;
    }
    public String getColumn() {
        return column;
    }
    public int getNum_column() {
        return num_column;
    }
    public float getSum() {
        return sum;
    }
    public String getStart_date() {
        return start_date;
    }
    public String getEnd_date() {
        return end_date;
    }

    public void setMax(List<Object> max) {
        Max = max;
    }
    public void setMin(List<Object> min) {
        Min = min;
    }
    public void setNum_record(int num_record) {
        this.num_record = num_record;
    }
    public void setColumn(String column) {
        this.column = column;
    }
    public void setNum_column(int num_column) {
        this.num_column = num_column;
    }
    public void setSum(float sum) {
        this.sum = sum;
    }
    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }
    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDate(TableOut table, int number){
        String str = table.getTable().getRows().get(number).get(3).toString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dateFormat.format(date);

    }

    public void calculate(List<Object> counter){
        if( Float.parseFloat(counter.get(num_column+1).toString()) == 0 ) {
            if ((Float.parseFloat(counter.get(num_column).toString())) > (Float.parseFloat(Max.get(num_column).toString()))) {
                Max = counter;
            }
            if ((Float.parseFloat(counter.get(num_column).toString())) < (Float.parseFloat(Min.get(num_column).toString()))) {
                Min = counter;
            }
            num_record += 1;
            sum += Float.parseFloat(counter.get(num_column).toString());
        }
    }

    public static int whatSearch(String what, List<Object> where){
        int number = -1;
        int counter = 0;
        for (Object i : where) {
            if (Objects.equals(what, i.toString())){
                number = counter;
            }
            counter += 1;
        }
        return number;
    }

    @Override
    public String toString() {
        return  "    \"" + column + "\": {\n" +
                "       \"start_date\": \"" + start_date + "\",\n" +
                "       \"end_date\": \"" + end_date + "\",\n" +
                "       \"num_records\": " + num_record + ",\n" +
                "       \"min_" + column + "\": " + Min.get(num_column) + ",\n" +
                "       \"min_time\": \"" + Min.get(3) + "\",\n" +
                "       \"max_" + column + "\": " + Max.get(num_column) + ",\n" +
                "       \"max_time\": \"" + Max.get(3) + "\",\n" +
                "       \"avg_" + column + "\": " + sum/num_record +
                "\n   }";


    }
}
