package Laba2;

import java.util.List;
import java.util.Objects;

public class Assistant {
    private List<Object> Max;
    private List<Object> Min;
    private int num_record;
    private String colomn;
    private int num_colomn;
    private float sum;


    public Assistant(List<Object> temp, String colomn, List<Object> where) {
        Max = temp;
        Min = temp;
        this.num_record = 0;
        this.colomn = colomn;
        this.num_colomn = whatSearch(colomn, where);
        this.sum = 0;
    }
    public Assistant() {
        this.num_record = 0;
        this.num_colomn = -1;
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
    public String getColomn() {
        return colomn;
    }
    public int getNum_colomn() {
        return num_colomn;
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
    public void setColomn(String colomn) {
        this.colomn = colomn;
    }
    public void setNum_colomn(int num_colomn) {
        this.num_colomn = num_colomn;
    }
    public void setSum(float sum) {
        this.sum = sum;
    }

    public void find(List<Object> i){
        if( Float.parseFloat(i.get(num_colomn+1).toString()) == 0 ) {
            if ((Float.parseFloat(i.get(num_colomn).toString())) > (Float.parseFloat(Max.get(num_colomn).toString()))) {
                Max = i;
            }
            if ((Float.parseFloat(i.get(num_colomn).toString())) < (Float.parseFloat(Min.get(num_colomn).toString()))) {
                Min = i;
            }
            num_record += 1;
            sum += Float.parseFloat(i.get(num_colomn).toString());
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
        return  "    \"" + colomn + "\": {\n" +
                "       \"start_date\": \"2015-08-15\",\n" +
                "       \"end_date\": \"2016-12-05\",\n" +
                "       \"num_records\": " + num_record + ",\n" +
                "       \"min_" + colomn + "\": " + Min.get(num_colomn) + ",\n" +
                "       \"min_time\": \"" + Min.get(3) + "\",\n" +
                "       \"max_" + colomn + "\": " + Max.get(num_colomn) + ",\n" +
                "       \"max_time\": \"" + Max.get(3) + "\",\n" +
                "       \"avg_" + colomn + "\": " + sum/num_record +
                "\n   }";


    }
}
