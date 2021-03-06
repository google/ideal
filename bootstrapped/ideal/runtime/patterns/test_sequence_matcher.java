// Autogenerated from runtime/patterns/test_sequence_matcher.i

package ideal.runtime.patterns;

import ideal.library.elements.*;
import ideal.library.patterns.*;
import ideal.runtime.elements.*;

public class test_sequence_matcher {
  public void run_all_tests() {
    ideal.machine.elements.runtime_util.start_test("test_sequence_matcher.test_match_parse");
    test_match_parse();
    ideal.machine.elements.runtime_util.end_test();
  }
  private boolean match_a(final char c) {
    return c == 'a' || c == 'A';
  }
  private boolean match_b(final char c) {
    return c == 'b' || c == 'B';
  }
  private boolean match_c(final char c) {
    return c == 'c' || c == 'C';
  }
  private string as_string(final readonly_list<Character> char_list) {
    return (base_string) char_list.frozen_copy();
  }
  public matcher<Character, string> make_matcher(final function1<Boolean, Character> the_predicate) {
    return new procedure_matcher<Character, string>(new repeat_element<Character>(the_predicate, false), new procedure1<string, readonly_list<Character>>() {
      @Override public string call(readonly_list<Character> first) {
        return test_sequence_matcher.this.as_string(first);
      }
    });
  }
  public string match_procedure(final readonly_list<any_value> the_list) {
    string result = new base_string("");
    {
      final readonly_list<any_value> element_list = the_list;
      for (int element_index = 0; element_index < element_list.size(); element_index += 1) {
        final any_value element = element_list.get(element_index);
        assert element instanceof string;
        result = ideal.machine.elements.runtime_util.concatenate(ideal.machine.elements.runtime_util.concatenate(result, new base_string("-")), ((string) element));
      }
    }
    return result;
  }
  public void test_match_parse() {
    final list<pattern<Character>> patterns_list = new base_list<pattern<Character>>(this.make_matcher(new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return test_sequence_matcher.this.match_a(first);
      }
    }), this.make_matcher(new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return test_sequence_matcher.this.match_b(first);
      }
    }), this.make_matcher(new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return test_sequence_matcher.this.match_c(first);
      }
    }));
    final sequence_matcher<Character, string> the_matcher = new sequence_matcher<Character, string>(patterns_list, new procedure1<string, readonly_list<any_value>>() {
      @Override public string call(readonly_list<any_value> first) {
        return test_sequence_matcher.this.match_procedure(first);
      }
    });
    assert the_matcher.call(new base_string("abc"));
    assert the_matcher.call(new base_string("AbC"));
    assert the_matcher.call(new base_string("AaaBbCcc"));
    assert the_matcher.call(new base_string("AaaBBBCcc"));
    assert !the_matcher.call(new base_string("bac"));
    assert !the_matcher.call(new base_string("aabb"));
    assert !the_matcher.call(new base_string("aaca"));
    assert ideal.machine.elements.runtime_util.values_equal(the_matcher.parse(new base_string("abc")), new base_string("-a-b-c"));
    assert ideal.machine.elements.runtime_util.values_equal(the_matcher.parse(new base_string("AbC")), new base_string("-A-b-C"));
    assert ideal.machine.elements.runtime_util.values_equal(the_matcher.parse(new base_string("AaaBbCcc")), new base_string("-Aaa-Bb-Ccc"));
    assert ideal.machine.elements.runtime_util.values_equal(the_matcher.parse(new base_string("AaaBBBCcc")), new base_string("-Aaa-BBB-Ccc"));
  }
}
