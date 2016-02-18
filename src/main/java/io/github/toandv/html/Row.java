package io.github.toandv.html;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Row {
    List<Cell> cells = new ArrayList<>();

    String css = "";

    public Row css(String css) {
        this.css = " " + css;
        return this;
    }

    public Row addCell(Cell cell) {
        cells.add(cell);
        return this;
    }

    public Row addCells(List<Cell> cells) {
        cells.addAll(cells);
        return this;
    }

    @Override
    public String toString() {
        return "<tr" + css + ">\n" + cells.stream().map(cell -> cell.toString()).collect(Collectors.joining("\n"))
                + "\n</tr>";
    }

}
