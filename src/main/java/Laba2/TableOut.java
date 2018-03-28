package Laba2;

public class TableOut {
    private TableIn table;

    public TableIn getTable() {
        return table;
    }

    public void setTable(TableIn table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "TableOut{" +
                "table=" + table +
                '}';
    }


}
