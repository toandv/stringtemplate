package io.github.toandv.html;

public class HCell extends Cell {

    public HCell(String value) {
        super(value);
    }

    @Override
    public String toString() {
        return "<th" + css + ">" + value + "</th>";
    }

}
