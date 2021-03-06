// Autogenerated from development/declarations/declaration_pass.i

package ideal.development.declarations;

import ideal.library.elements.*;
import ideal.library.reflections.*;
import ideal.runtime.elements.*;
import ideal.runtime.logs.*;
import ideal.development.elements.*;
import ideal.development.futures.*;
import ideal.development.names.*;
import ideal.development.comments.*;
import ideal.development.modifiers.*;

public enum declaration_pass implements deeply_immutable_data, stringable, readonly_displayable {
  NONE,
  FLAVOR_PROFILE,
  TYPES_AND_PROMOTIONS,
  METHODS_AND_VARIABLES;
  public boolean is_before(final declaration_pass other) {
    return this.ordinal() < other.ordinal();
  }
  public boolean is_after(final declaration_pass other) {
    return this.ordinal() > other.ordinal();
  }
  public @Override string to_string() {
    return ideal.machine.elements.runtime_util.concatenate(new base_string(""), this.name());
  }
  public @Override string display() {
    return this.to_string();
  }
  public static declaration_pass last() {
    return declaration_pass.METHODS_AND_VARIABLES;
  }
}
