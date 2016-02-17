package io.github.toandv.template;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class StringTemplateTest {

    @Test
    public void testRender() {
        Template template = new StringTemplate("This is a simple ${var0} for parsing ${var1}.");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("var0", "template engine");
        parameters.put("var1", "text");
        String text = template.render(parameters);
        Assert.assertEquals("This is a simple template engine for parsing text.", text);
        Assert.assertEquals(ImmutableSet.of("var0", "var1"), template.getParameters());
    }

    @Test
    public void testRender1() {
        long start = System.nanoTime();
        String text1 = "This is a simple ${var0} for parsing ${var1}.";
        for (int i = 0; i < 10; i++) {
            text1 += text1;
        }
        Template template = new StringTemplate(text1);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("var0", "template engine");
        parameters.put("var1", "text");
        String text = template.render(parameters);
        System.out.println(text.length());
        System.out.println(template.getParameters());
        long elapsedTime = System.nanoTime() - start;
        System.out.println(elapsedTime);
    }
}
