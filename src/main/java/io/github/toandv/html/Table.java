package io.github.toandv.html;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Table {
    List<Row> rows = new ArrayList<>();

    String css = "";

    public Table addRow(Row row) {
        rows.add(row);
        return this;
    }

    public Table addRows(List<Row> rows) {
        this.rows.addAll(rows);
        return this;
    }

    public Table css(String css) {
        this.css = " " + css;
        return this;
    }

    public String toString() {
        return "<table" + css + ">\n" + rows.stream().map(row -> row.toString()).collect(Collectors.joining("\n"))
                + "\n</table>";
    }

    public static void main(String[] args) {
        Table table = new Table().addRow(new Row().addCell(new HCell("Name")).addCell(new HCell("Age")))
                .addRow(new Row().addCell(new Cell("toandv")).addCell(new Cell("25"))).css("border=1px");
        System.out.println(table);
    }
}
