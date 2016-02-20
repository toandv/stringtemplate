# StringTemplate

Simple template that can embded paramters/variables and render text.

## Usage

```java
	Template template = new StringTemplate("This is a simple ${var0} for parsing ${var1}.");
	Map<String, Object> parameters = new HashMap<>();
	parameters.put("var0", "template engine");
	parameters.put("var1", "text");
	String text = template.render(parameters);
	Assert.assertEquals("This is a simple template engine for parsing text.", text);
	Assert.assertEquals(ImmutableSet.of("var0", "var1"), template.getParameterNames());
```



## Maven dependency 

```xml
  	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
	
	<dependency>
	    <groupId>com.github.toandv</groupId>
	    <artifactId>template</artifactId>
	    <version>0.1.0</version>
	</dependency>
