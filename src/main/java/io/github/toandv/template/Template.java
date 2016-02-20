package io.github.toandv.template;

import java.util.Map;
import java.util.Set;

/**
 * A template that contains text and parameters which are surrounded by '${' and '}'
 * and can be replaced by values to render a pure text having no parameters 
 * 
 * @author toandv
 * @since 17/02/2016
 *
 */
public interface Template {
    String render(Map<String, Object> parameters);

    Set<String> getParameterNames();
}
