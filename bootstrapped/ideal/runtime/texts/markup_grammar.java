// Autogenerated from runtime/texts/markup_grammar.i

package ideal.runtime.texts;

import ideal.library.elements.*;
import ideal.library.characters.*;
import ideal.library.texts.*;
import ideal.runtime.elements.*;
import ideal.library.channels.output;

public class markup_grammar {
  public final character_handler the_character_handler;
  public markup_grammar(final character_handler the_character_handler) {
    this.the_character_handler = the_character_handler;
  }
  public boolean is_letter(final char the_character) {
    return this.the_character_handler.is_letter(the_character);
  }
  public string parse(final string input) {
    final function1<Boolean, Character> is_whitespace = new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return markup_grammar.this.the_character_handler.is_whitespace(first);
      }
    };
    int index = 0;
    while (index < input.size() && is_whitespace.call(input.get(index))) {
      index += 1;
    }
    final int begin = index;
    while (index < input.size() && this.is_letter(input.get(index))) {
      index += 1;
    }
    final int end = index;
    return input.slice(begin, end);
  }
}
