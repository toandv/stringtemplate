package io.github.toandv.html;

import java.util.Objects;

public class Cell {

    protected String value;

    protected String css = "";

    public Cell css(String css) {
        Objects.requireNonNull(css);
        this.css = " " + css;
        return this;
    }

    public Cell(String value) {
        Objects.requireNonNull(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return "<td" + css + ">" + value + "</td>";
    }

}
