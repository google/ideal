// Autogenerated from development/names/special_name.i

package ideal.development.names;

import ideal.library.elements.*;
import ideal.runtime.elements.*;
import ideal.runtime.logs.*;
import ideal.development.elements.*;
import ideal.development.symbols.base_symbols;

public class special_name extends debuggable implements action_name {
  public static final special_name ROOT = new special_name(new base_string("root"));
  public static final special_name PROMOTION = new special_name(new base_string("promotion"));
  public static final special_name TYPE_ALIAS = new special_name(new base_string("type_alias"));
  public static final special_name THIS = new special_name(keyword.THIS);
  public static final special_name SUPER = new special_name(keyword.SUPER);
  public static final special_name NEW = new special_name(keyword.NEW);
  public static final special_name IMPLICIT_CALL = new special_name(new base_string("implicit_call"));
  public static final special_name SUPERTYPE = new special_name(new base_string("supertype"));
  public static final special_name CONSTRUCTOR = new special_name(new base_string("constructor"));
  public static final special_name THIS_CONSTRUCTOR = new special_name(new base_string("this_constructor"));
  public static final special_name SUPER_CONSTRUCTOR = new special_name(new base_string("super_constructor"));
  public static final special_name RETURN = new special_name(keyword.RETURN);
  public static final action_name SEQUENCE = new special_name(new base_string("list"));
  public final string name;
  public special_name(final token_type the_token_name) {
    this.name = the_token_name.name();
  }
  public special_name(final string name) {
    this.name = name;
  }
  public special_name(final string name, final string namespace_id) {
    this(name);
  }
  public string to_string() {
    return name_utilities.in_brackets(name);
  }
}