// Autogenerated from development/kinds/base_subtype_tag.i

package ideal.development.kinds;

import ideal.library.elements.*;
import ideal.runtime.elements.*;
import ideal.runtime.logs.*;
import ideal.development.elements.*;
import ideal.development.names.*;
import ideal.development.flavors.*;

public class base_subtype_tag extends debuggable implements subtype_tag, readonly_displayable {
  private final simple_name the_name;
  public base_subtype_tag(final string the_name) {
    this.the_name = simple_name.make(the_name);
  }
  public simple_name name() {
    return this.the_name;
  }
  public string to_string() {
    return name_utilities.in_brackets(this.the_name);
  }
  public string display() {
    return this.to_string();
  }
}
