// Autogenerated from development/names/base_token_type.i

package ideal.development.names;

import ideal.library.elements.*;
import ideal.runtime.elements.*;
import ideal.runtime.logs.*;
import ideal.development.elements.*;
import ideal.development.symbols.base_symbols;

import ideal.machine.annotations.dont_display;

public class base_token_type implements token_type, readonly_displayable {
  private final string the_name;
  @dont_display private final int the_symbol;
  public base_token_type(final string name, final int the_symbol) {
    assert name.is_not_empty();
    this.the_name = name;
    this.the_symbol = the_symbol;
  }
  public base_token_type(final string name) {
    this(name, -1);
  }
  public @Override string name() {
    return the_name;
  }
  public @Override int symbol() {
    return the_symbol;
  }
  public @Override string to_string() {
    return ideal.machine.elements.runtime_util.concatenate(ideal.machine.elements.runtime_util.concatenate(new base_string("\""), the_name), new base_string("\""));
  }
  public @Override string display() {
    return the_name;
  }
}
