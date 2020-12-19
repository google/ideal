// Autogenerated from runtime/patterns/test_sequence_pattern.i

package ideal.runtime.patterns;

import ideal.library.elements.*;
import ideal.library.patterns.*;
import ideal.runtime.elements.*;

import javax.annotation.Nullable;

public class test_sequence_pattern {
  public void run_all_tests() {
    ideal.machine.elements.runtime_util.start_test("test_sequence_pattern.test_match");
    test_match();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_sequence_pattern.test_viable_prefix");
    test_viable_prefix();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_sequence_pattern.test_match_prefix");
    test_match_prefix();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_sequence_pattern.test_find_first");
    test_find_first();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_sequence_pattern.test_split");
    test_split();
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
  public sequence_pattern<Character> make_pattern() {
    final pattern<Character> match_one_or_more_a = new repeat_pattern<Character>(new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return test_sequence_pattern.this.match_a(first);
      }
    }, false);
    final pattern<Character> match_zero_or_more_b = new repeat_pattern<Character>(new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return test_sequence_pattern.this.match_b(first);
      }
    }, true);
    final pattern<Character> match_one_or_more_c = new repeat_pattern<Character>(new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return test_sequence_pattern.this.match_c(first);
      }
    }, false);
    final list<pattern<Character>> patterns_list = new base_list<pattern<Character>>(match_one_or_more_a, match_zero_or_more_b, match_one_or_more_c);
    return new sequence_pattern<Character>(patterns_list);
  }
  public sequence_pattern<Character> make_pattern2() {
    final pattern<Character> match_one_or_more_a = new repeat_pattern<Character>(new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return test_sequence_pattern.this.match_a(first);
      }
    }, false);
    final pattern<Character> match_one_or_more_b = new repeat_pattern<Character>(new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return test_sequence_pattern.this.match_b(first);
      }
    }, false);
    final pattern<Character> match_one_or_more_c = new repeat_pattern<Character>(new function1<Boolean, Character>() {
      @Override public Boolean call(Character first) {
        return test_sequence_pattern.this.match_c(first);
      }
    }, false);
    final list<pattern<Character>> patterns_list = new base_list<pattern<Character>>(match_one_or_more_a, match_one_or_more_b, match_one_or_more_c);
    return new sequence_pattern<Character>(patterns_list);
  }
  public void test_match() {
    final sequence_pattern<Character> the_pattern = this.make_pattern();
    assert the_pattern.call(new base_string("abc"));
    assert the_pattern.call(new base_string("AC"));
    assert the_pattern.call(new base_string("AaaCcc"));
    assert the_pattern.call(new base_string("AaaBBBCcc"));
    assert !the_pattern.call(new base_string("bac"));
    assert !the_pattern.call(new base_string("aabb"));
    assert !the_pattern.call(new base_string("aaca"));
  }
  public void test_viable_prefix() {
    final sequence_pattern<Character> the_pattern = this.make_pattern();
    assert the_pattern.is_viable_prefix(new base_string(""));
    assert the_pattern.is_viable_prefix(new base_string("a"));
    assert the_pattern.is_viable_prefix(new base_string("aAa"));
    assert the_pattern.is_viable_prefix(new base_string("aabb"));
    assert the_pattern.is_viable_prefix(new base_string("aacc"));
    assert the_pattern.is_viable_prefix(new base_string("aaBcc"));
    assert !the_pattern.is_viable_prefix(new base_string("x"));
    assert !the_pattern.is_viable_prefix(new base_string("xyz"));
    assert !the_pattern.is_viable_prefix(new base_string("bbb"));
    assert !the_pattern.is_viable_prefix(new base_string("bcc"));
    assert !the_pattern.is_viable_prefix(new base_string("Ccc"));
    final sequence_pattern<Character> the_pattern2 = this.make_pattern2();
    assert the_pattern2.is_viable_prefix(new base_string(""));
    assert the_pattern2.is_viable_prefix(new base_string("a"));
    assert the_pattern2.is_viable_prefix(new base_string("aAa"));
    assert the_pattern2.is_viable_prefix(new base_string("aabb"));
    assert the_pattern2.is_viable_prefix(new base_string("aaBcc"));
    assert !the_pattern2.is_viable_prefix(new base_string("x"));
    assert !the_pattern2.is_viable_prefix(new base_string("xyz"));
    assert !the_pattern2.is_viable_prefix(new base_string("bbb"));
    assert !the_pattern2.is_viable_prefix(new base_string("bcc"));
    assert !the_pattern2.is_viable_prefix(new base_string("Ccc"));
  }
  public void test_match_prefix() {
    final sequence_pattern<Character> the_pattern = this.make_pattern();
    assert the_pattern.match_prefix(new base_string("")) == null;
    assert the_pattern.match_prefix(new base_string("a")) == null;
    assert the_pattern.match_prefix(new base_string("x")) == null;
    assert the_pattern.match_prefix(new base_string("xabc")) == null;
    assert the_pattern.match_prefix(new base_string("abc")) == 3;
    assert the_pattern.match_prefix(new base_string("abcdef")) == 3;
    assert the_pattern.match_prefix(new base_string("aAbBcCdef")) == 6;
    assert the_pattern.match_prefix(new base_string("aAbCdef")) == 4;
    assert the_pattern.match_prefix(new base_string("aaabbbcccddd")) == 9;
  }
  public void test_find_first() {
    final sequence_pattern<Character> the_pattern = this.make_pattern();
    assert the_pattern.find_first(new base_string(""), 0) == null;
    assert the_pattern.find_first(new base_string("foo"), 0) == null;
    assert the_pattern.find_first(new base_string("abcfoo"), 3) == null;
    final @Nullable range match = the_pattern.find_first(new base_string("xxaabbcczz"), 0);
    assert match != null;
    assert match.begin() == 2;
    assert match.end() == 8;
    final @Nullable range match2 = the_pattern.find_first(new base_string("aaabbbAAACCCBBB"), 1);
    assert match2 != null;
    assert match2.begin() == 6;
    assert match2.end() == 12;
    final @Nullable range match3 = the_pattern.find_first(new base_string("fooACxyzABC"), 0);
    assert match3 != null;
    assert match3.begin() == 3;
    assert match3.end() == 5;
  }
  public void test_split() {
    final sequence_pattern<Character> the_pattern = this.make_pattern();
    final immutable_list<immutable_list<Character>> split0 = the_pattern.split(new base_string("foo"));
    assert split0.size() == 1;
    assert this.equals(split0.get(0), new base_string("foo"));
    final immutable_list<immutable_list<Character>> split1 = the_pattern.split(new base_string("fooACxyzABC"));
    assert split1.size() == 3;
    assert this.equals(split1.get(0), new base_string("foo"));
    assert this.equals(split1.get(1), new base_string("xyz"));
    assert this.equals(split1.get(2), new base_string(""));
    final immutable_list<immutable_list<Character>> split2 = the_pattern.split(new base_string("aaabc1ac2ABC3"));
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
