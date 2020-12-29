// Autogenerated from runtime/patterns/test_procedure_matcher.i

package ideal.runtime.patterns;

import ideal.library.elements.*;
import ideal.library.patterns.*;
import ideal.runtime.elements.*;

import javax.annotation.Nullable;

public class test_procedure_matcher {
  public void run_all_tests() {
    ideal.machine.elements.runtime_util.start_test("test_procedure_matcher.test_match");
    test_match();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_procedure_matcher.test_viable_prefix");
    test_viable_prefix();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_procedure_matcher.test_match_prefix");
    test_match_prefix();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_procedure_matcher.test_find_first");
    test_find_first();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_procedure_matcher.test_split");
    test_split();
    ideal.machine.elements.runtime_util.end_test();
  }
  private boolean test_predicate(final char c) {
    return c == 'a' || c == 'b' || c == 'c';
  }
  private string as_string(final readonly_list<Character> char_list) {
    return (base_string) char_list.frozen_copy();
  }
  public matcher<Character, string> make_matcher() {
    return new procedure_matcher<Character, string>(new repeat_element<Character>(new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return test_procedure_matcher.this.test_predicate(first);
      }
    }, false), new procedure1<string, readonly_list<Character>>() {
      @Override public string call(readonly_list<Character> first) {
        return test_procedure_matcher.this.as_string(first);
      }
    });
  }
  public void test_match() {
    final matcher<Character, string> the_matcher = this.make_matcher();
    assert the_matcher.call(new base_string("a"));
    assert the_matcher.call(new base_string("ab"));
    assert the_matcher.call(new base_string("abca"));
    assert !the_matcher.call(new base_string(""));
    assert !the_matcher.call(new base_string("abcda"));
    assert !the_matcher.call(new base_string("y"));
    assert !the_matcher.call(new base_string("xab"));
    assert ideal.machine.elements.runtime_util.values_equal(the_matcher.parse(new base_string("a")), new base_string("a"));
    assert ideal.machine.elements.runtime_util.values_equal(the_matcher.parse(new base_string("ab")), new base_string("ab"));
    assert ideal.machine.elements.runtime_util.values_equal(the_matcher.parse(new base_string("abca")), new base_string("abca"));
  }
  public void test_viable_prefix() {
    final matcher<Character, string> the_pattern = this.make_matcher();
    assert the_pattern.is_viable_prefix(new base_string(""));
    assert the_pattern.is_viable_prefix(new base_string("a"));
    assert the_pattern.is_viable_prefix(new base_string("ab"));
    assert !the_pattern.is_viable_prefix(new base_string("y"));
    assert !the_pattern.is_viable_prefix(new base_string("ay"));
  }
  public void test_match_prefix() {
    final matcher<Character, string> the_pattern = this.make_matcher();
    assert the_pattern.match_prefix(new base_string("")) == null;
    assert the_pattern.match_prefix(new base_string("a")) == 1;
    assert the_pattern.match_prefix(new base_string("abc")) == 3;
    assert the_pattern.match_prefix(new base_string("abcdef")) == 3;
    assert the_pattern.match_prefix(new base_string("x")) == null;
    assert the_pattern.match_prefix(new base_string("xabc")) == null;
    assert the_pattern.match_prefix(new base_string("abcabc")) == 6;
  }
  public void test_find_first() {
    final matcher<Character, string> the_pattern = this.make_matcher();
    assert the_pattern.find_first(new base_string(""), 0) == null;
    assert the_pattern.find_first(new base_string("foo"), 0) == null;
    assert the_pattern.find_first(new base_string("bfoo"), 1) == null;
    final @Nullable range match = the_pattern.find_first(new base_string("a"), 0);
    assert match != null;
    assert match.begin() == 0;
    assert match.end() == 1;
    final @Nullable range match2 = the_pattern.find_first(new base_string("-abc-"), 0);
    assert match2 != null;
    assert match2.begin() == 1;
    assert match2.end() == 4;
    final @Nullable range match3 = the_pattern.find_first(new base_string("ayzzybacy"), 2);
    assert match3 != null;
    assert match3.begin() == 5;
    assert match3.end() == 8;
  }
  public void test_split() {
    final matcher<Character, string> the_pattern = this.make_matcher();
    final immutable_list<immutable_list<Character>> split0 = the_pattern.split(new base_string("foo"));
    assert split0.size() == 1;
    assert this.equals(split0.get(0), new base_string("foo"));
    final immutable_list<immutable_list<Character>> split1 = the_pattern.split(new base_string("fooabcxyzc"));
    assert split1.size() == 3;
    assert this.equals(split1.get(0), new base_string("foo"));
    assert this.equals(split1.get(1), new base_string("xyz"));
    assert this.equals(split1.get(2), new base_string(""));
    final immutable_list<immutable_list<Character>> split2 = the_pattern.split(new base_string("ab1bc2ca3"));
    assert split2.size() == 4;
    assert this.equals(split2.get(0), new base_string(""));
    assert this.equals(split2.get(1), new base_string("1"));
    assert this.equals(split2.get(2), new base_string("2"));
    assert this.equals(split2.get(3), new base_string("3"));
  }
  public boolean equals(final immutable_list<Character> s0, final string s1) {
    return ideal.machine.elements.runtime_util.values_equal(((string) s0), s1);
  }
}
