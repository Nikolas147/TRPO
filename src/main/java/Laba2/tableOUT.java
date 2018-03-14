package Laba2;

public class tableOUT {
    private tableIN table;

    public tableIN getTable() {
        return table;
    }

    public void setTable(tableIN table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "tableOUT{" +
                "table=" + table +
                '}';
    }


}
