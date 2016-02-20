package io.github.toandv.html;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Row {

    protected List<Cell> cells = new ArrayList<>();

    protected String css = "";

    public Row css(String css) {
        Objects.requireNonNull(css);
        this.css = " " + css;
        return this;
    }

    public Row addCell(Cell cell) {
        Objects.requireNonNull(cell);
        cells.add(cell);
        return this;
    }

    public Row addCells(List<Cell> cells) {
        Objects.requireNonNull(cells);
        this.cells.addAll(cells);
        return this;
    }

    @Override
    public String toString() {
        return "<tr" + css + ">\n" + cells.stream().map(cell -> cell.toString()).collect(Collectors.joining("\n"))
                + "\n</tr>";
    }

}
