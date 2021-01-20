// Autogenerated from runtime/patterns/repeat_matcher.i

package ideal.runtime.patterns;

import ideal.library.elements.*;
import ideal.library.patterns.*;
import ideal.runtime.elements.*;

import javax.annotation.Nullable;

public class repeat_matcher<element_type, result_type, intermediate_type> extends repeat_pattern<element_type> implements matcher<element_type, result_type> {
  public final procedure1<result_type, readonly_list<intermediate_type>> list_converter;
  public repeat_matcher(final matcher<element_type, intermediate_type> the_pattern, final boolean do_match_empty, final procedure1<result_type, readonly_list<intermediate_type>> list_converter) {
    super(the_pattern, do_match_empty);
    this.list_converter = list_converter;
  }
  public @Override result_type parse(final readonly_list<element_type> the_list) {
    int index = 0;
    final base_list<intermediate_type> intermediate_list = new base_list<intermediate_type>();
    while (index < the_list.size()) {
      final @Nullable Integer match = this.the_pattern.match_prefix(the_list.skip(index));
      if (match == null) {
        {
          utilities.panic(new base_string("Can\'t parse list in repeat_matcher"));
          return null;
        }
      }
      assert match > 0;
      final intermediate_type matched = ((matcher<element_type, intermediate_type>) this.the_pattern).parse(the_list.slice(index, index + match));
      intermediate_list.append(matched);
      index += match;
    }
    return this.list_converter.call(intermediate_list);
  }
}