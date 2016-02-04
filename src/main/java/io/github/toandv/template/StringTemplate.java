package io.github.toandv.template;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StringTemplate implements Template {

	private String text;

	private List<String> parts = new ArrayList<>();

	public StringTemplate(String text) {
		this.text = text;
		parseW(text);
	}

	// for loop version
	void parseF(String text) {
		int start = 0;
		int end = 0;

		for (int i = 0; i < text.length() - 1; i++) {
			if (text.charAt(i) == '$' && text.charAt(i + 1) == '{') {
				int j = text.indexOf('}', i + 1);
				if (j == -1 && text.charAt(text.length() - 1) == '}') {
					j = text.length() - 1;
				}
				if (j != -1) {
					String pureText = text.substring(start, i);
					String var = text.substring(i, j + 1);
					parts.add(pureText);
					parts.add(var);
					start = j + 1;
					end = start;
				}
			}
		}

		if (end < text.length()) {
			String last = text.substring(end, text.length());
			parts.add(last);
		}

	}

	// while loop version
	private void parseW(String text) {
		int start = 0;
		int end = 0;
		int firstVarIndex = text.indexOf("${");
		while (firstVarIndex != -1) {
			int endVarIndex = text.indexOf('}', firstVarIndex);
			if (endVarIndex == -1) {
				break;
			}
			if (endVarIndex != -1) {
				String pureText = text.substring(start, firstVarIndex);
				String var = text.substring(firstVarIndex, endVarIndex + 1);
				parts.add(pureText);
				parts.add(var);
				start = endVarIndex + 1;
				end = start;
			}
			firstVarIndex = text.indexOf("${", endVarIndex);
		}

		if (end < text.length()) {
			String last = text.substring(end, text.length());
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

}
