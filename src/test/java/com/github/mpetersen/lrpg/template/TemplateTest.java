package com.github.mpetersen.lrpg.template;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class TemplateTest {

  @Test
  public void testReplace() {
    final Template template = new Template("Hello, $name!");
    template.replace("name", "World");
    assertThat(template.toString(), is("Hello, World!"));
    template.reset();
    template.replace("name", "Horst");
    assertThat(template.toString(), is("Hello, Horst!"));
    template.reset();
    assertThat(template.toString(), is("Hello, $name!"));
  }

  @Test
  public void testMultiReplace() {
    final Template template = new Template("$a, $b");
    template.replace("a", "123");
    template.replace("b", "abc");
    assertThat(template.toString(), is("123, abc"));
  }

}