package Laba2;

import java.util.List;
import java.util.Objects;

public class Assistant {
    private List<Object> Max;
    private List<Object> Min;
    private int num_record;
    private String column;
    private int num_column;
    private float sum;


    public Assistant(List<Object> temp, String column, List<Object> where) {
        Max = temp;
        Min = temp;
        this.num_record = 0;
        this.column = column;
        this.num_column = whatSearch(column, where);
        this.sum = 0;
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
                "       \"start_date\": \"2015-08-15\",\n" +
                "       \"end_date\": \"2016-12-05\",\n" +
                "       \"num_records\": " + num_record + ",\n" +
                "       \"min_" + column + "\": " + Min.get(num_column) + ",\n" +
                "       \"min_time\": \"" + Min.get(3) + "\",\n" +
                "       \"max_" + column + "\": " + Max.get(num_column) + ",\n" +
                "       \"max_time\": \"" + Max.get(3) + "\",\n" +
                "       \"avg_" + column + "\": " + sum/num_record +
                "\n   }";


    }
}
