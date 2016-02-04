package io.github.toandv.template;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class StringTemplateTest {


	@Test
	public void testRender() {
		Template template = new StringTemplate("This is a simple ${var0} for parsing ${var1}.");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("var0", "template engine");
		parameters.put("var1", "text");
		String text = template.render(parameters);
		Assert.assertEquals("This is a simple template engine for parsing text.", text);
	}
}
