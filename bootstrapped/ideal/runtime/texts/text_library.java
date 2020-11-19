// Autogenerated from runtime/texts/text_library.i

package ideal.runtime.texts;

import ideal.library.elements.*;
import ideal.library.texts.*;
import ideal.runtime.elements.*;
import ideal.library.channels.output;

public class text_library {
  public static final base_namespace HTML_NS = new base_namespace(new base_string("html"));
  public static final base_element_id HTML = new base_element_id(text_library.HTML_NS, new base_string("html"));
  public static final base_element_id HEAD = new base_element_id(text_library.HTML_NS, new base_string("head"));
  public static final base_element_id TITLE = new base_element_id(text_library.HTML_NS, new base_string("title"));
  public static final base_element_id LINK = new base_element_id(text_library.HTML_NS, new base_string("link"));
  public static final base_element_id BODY = new base_element_id(text_library.HTML_NS, new base_string("body"));
  public static final base_element_id P = new base_element_id(text_library.HTML_NS, new base_string("p"));
  public static final base_element_id DIV = new base_element_id(text_library.HTML_NS, new base_string("div"));
  public static final base_element_id H1 = new base_element_id(text_library.HTML_NS, new base_string("h1"));
  public static final base_element_id H2 = new base_element_id(text_library.HTML_NS, new base_string("h2"));
  public static final base_element_id PRE = new base_element_id(text_library.HTML_NS, new base_string("pre"));
  public static final base_element_id TABLE = new base_element_id(text_library.HTML_NS, new base_string("table"));
  public static final base_element_id TR = new base_element_id(text_library.HTML_NS, new base_string("tr"));
  public static final base_element_id TH = new base_element_id(text_library.HTML_NS, new base_string("th"));
  public static final base_element_id TD = new base_element_id(text_library.HTML_NS, new base_string("td"));
  public static final base_element_id SPAN = new base_element_id(text_library.HTML_NS, new base_string("span"));
  public static final base_element_id BR = new base_element_id(text_library.HTML_NS, new base_string("br"));
  public static final base_element_id EM = new base_element_id(text_library.HTML_NS, new base_string("em"));
  public static final base_element_id A = new base_element_id(text_library.HTML_NS, new base_string("a"));
  public static final base_element_id B = new base_element_id(text_library.HTML_NS, new base_string("b"));
  public static final base_element_id UNDERLINE = new base_element_id(text_library.HTML_NS, new base_string("u"));
  public static final base_element_id UNDERLINE2 = new base_element_id(text_library.HTML_NS, new base_string("u2"));
  public static final base_attribute_id ID = new base_attribute_id(text_library.HTML_NS, new base_string("id"));
  public static final base_attribute_id NAME = new base_attribute_id(text_library.HTML_NS, new base_string("name"));
  public static final base_attribute_id CLEAR = new base_attribute_id(text_library.HTML_NS, new base_string("clear"));
  public static final base_attribute_id CLASS = new base_attribute_id(text_library.HTML_NS, new base_string("class"));
  public static final base_attribute_id STYLE = new base_attribute_id(text_library.HTML_NS, new base_string("style"));
  public static final base_attribute_id HREF = new base_attribute_id(text_library.HTML_NS, new base_string("href"));
  public static final base_attribute_id REL = new base_attribute_id(text_library.HTML_NS, new base_string("rel"));
  public static final base_attribute_id TYPE = new base_attribute_id(text_library.HTML_NS, new base_string("style"));
  public static final text_entity BULL = new text_entity(text_library.HTML_NS, new base_string("*"), new base_string("&bull;"));
  public static final text_entity MIDDOT = new text_entity(text_library.HTML_NS, new base_string("."), new base_string("&middot;"));
  public static final text_entity MDASH = new text_entity(text_library.HTML_NS, new base_string("--"), new base_string("&mdash;"));
  public static final text_entity NBSP = new text_entity(text_library.HTML_NS, new base_string(" "), new base_string("&nbsp;"));
  public static final text_entity THINSP = new text_entity(text_library.HTML_NS, new base_string(" "), new base_string("&thinsp;"));
  public static final text_entity LARR = new text_entity(text_library.HTML_NS, new base_string("<-"), new base_string("&larr;"));
  public static final text_entity UARR = new text_entity(text_library.HTML_NS, new base_string("^"), new base_string("&uarr;"));
  public static final text_entity RARR = new text_entity(text_library.HTML_NS, new base_string("->"), new base_string("&rarr;"));
  public static final text_entity DARR = new text_entity(text_library.HTML_NS, new base_string("V"), new base_string("&darr;"));
  public static final string FRAGMENT_SEPARATOR = new base_string("#");
  public static final base_namespace IDEAL_TEXT = new base_namespace(new base_string("itext"));
  public static final base_element_id INDENT = new base_element_id(text_library.IDEAL_TEXT, new base_string("indent"));
}
