package io.github.toandv.template;

import java.util.Map;

public interface Template {
	String render(Map<String, Object> parameters);
}
