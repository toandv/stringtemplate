package io.github.toandv.html;

public class Cell {
    String value;

    String css = "";

    public Cell css(String css) {
        this.css = " " + css;
        return this;
    }

    public Cell(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "<td" + css + ">" + value + "</td>";
    }

}
