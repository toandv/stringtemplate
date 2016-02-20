package io.github.toandv.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Table {

    protected List<Row> rows = new ArrayList<>();

    protected String css = "";

    public Table addRow(Row row) {
        Objects.requireNonNull(row);
        rows.add(row);
        return this;
    }

    public Table addRows(List<Row> rows) {
        Objects.requireNonNull(rows);
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
}
