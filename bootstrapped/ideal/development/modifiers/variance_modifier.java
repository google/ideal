// Autogenerated from development/modifiers/variance_modifier.i

package ideal.development.modifiers;

import ideal.library.elements.*;
import ideal.runtime.elements.*;
import ideal.runtime.logs.*;
import ideal.development.elements.*;
import ideal.development.names.*;

public class variance_modifier extends base_modifier_kind {
  public static final variance_modifier invariant_modifier = new variance_modifier(new base_string("invariant"));
  public static final variance_modifier covariant_modifier = new variance_modifier(new base_string("covariant"));
  public static final variance_modifier contravariant_modifier = new variance_modifier(new base_string("contravariant"));
  public static final variance_modifier combivariant_modifier = new variance_modifier(new base_string("combivariant"));
  private variance_modifier(final string name) {
    super(name);
  }
}