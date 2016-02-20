package io.github.toandv.template;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

/**
 * An Immutable and thread-safe implementation of Template
 * @author toandv
 * @since 17/02/2016
 */
public class StringTemplate implements Template {

    private String text;

    private List<String> parts = new ArrayList<>();

    private Set<String> parameters = new HashSet<>();

    public StringTemplate(String text) {
        Objects.requireNonNull(text, "Text must not be null.");
        this.text = text;
        parseW(text);
    }

    // for loop version
    void parseF(String text) {
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == '$' && text.charAt(i + 1) == '{') {
                int j = text.indexOf('}', i + 1);
                if (j == -1 && text.charAt(text.length() - 1) == '}') {
                    j = text.length() - 1;
                }
                if (j != -1) {
                    String textPart = text.substring(startIndex, i);
                    String paramPart = text.substring(i, j + 1);
                    parts.add(textPart);
                    parts.add(paramPart);
                    collectParameterName(paramPart);
                    startIndex = j + 1;
                    endIndex = startIndex;
                }
            }
        }

        if (endIndex < text.length()) {
            String last = text.substring(endIndex, text.length());
            parts.add(last);
        }

    }

    private void collectParameterName(String wrappedParameterName) {
        parameters.add(wrappedParameterName.substring(2, wrappedParameterName.length() - 1));
    }

    // while loop version
    private void parseW(String text) {
        int startIndex = 0;
        int endIndex = 0;
        int firstParamIndex = text.indexOf("${");
        while (firstParamIndex != -1) {
            int endParamIndex = text.indexOf('}', firstParamIndex);
            if (endParamIndex == -1) {
                break;
            }
            if (endParamIndex != -1) {
                String textPart = text.substring(startIndex, firstParamIndex);
                String paramPart = text.substring(firstParamIndex, endParamIndex + 1);
                parts.add(textPart);
                parts.add(paramPart);
                collectParameterName(paramPart);
                startIndex = endParamIndex + 1;
                endIndex = startIndex;
            }
            firstParamIndex = text.indexOf("${", endParamIndex);
        }

        if (endIndex < text.length()) {
            String last = text.substring(endIndex, text.length());
            parts.add(last);
        }
    }

    @Override
    public String toString() {
        return "StringTemplate [text=" + text + ", parts=" + parts + "]";
    }

    public String render(Map<String, Object> parameters) {
        StringBuilder sb = new StringBuilder();
        for (String p : parts) {
            if (p.startsWith("${") && p.endsWith("}")) {
                sb.append(parameters.get(p.substring(2, p.length() - 1)));
            } else {
                sb.append(p);
            }
        }
        return sb.toString();
    }

    @Override
    public Set<String> getParameterNames() {
        return ImmutableSet.copyOf(parameters);
    }

}
