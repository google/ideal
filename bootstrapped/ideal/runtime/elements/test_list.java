// Autogenerated from runtime/elements/test_list.i

package ideal.runtime.elements;

import ideal.library.elements.*;

public class test_list {
  public void run_all_tests() {
    ideal.machine.elements.runtime_util.start_test("test_list.test_empty");
    test_empty();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_list.test_simple_list");
    test_simple_list();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_list.test_list_elements");
    test_list_elements();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_list.test_list_remove");
    test_list_remove();
    ideal.machine.elements.runtime_util.end_test();
  }
  public void test_empty() {
    final empty<string> strings = new empty<string>();
    assert strings.is_empty();
    assert strings.size() == 0;
    final immutable_list<string> slice = strings.slice(0, 0);
    assert slice.is_empty();
    assert !slice.is_not_empty();
    assert slice.size() == 0;
  }
  public void test_simple_list() {
    final base_list<string> strings = new base_list<string>();
    assert strings.is_empty();
    assert strings.size() == 0;
    strings.append(new base_string("foo"));
    assert strings.size() == 1;
    assert !strings.is_empty();
    assert strings.is_not_empty();
    assert ideal.machine.elements.runtime_util.values_equal(strings.first(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.last(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(0).get(), new base_string("foo"));
    strings.append(new base_string("bar"));
    assert strings.size() == 2;
    assert !strings.is_empty();
    assert strings.is_not_empty();
    assert ideal.machine.elements.runtime_util.values_equal(strings.first(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.last(), new base_string("bar"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(0).get(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(1).get(), new base_string("bar"));
    final string removed = strings.remove_last();
    assert ideal.machine.elements.runtime_util.values_equal(removed, new base_string("bar"));
    assert strings.size() == 1;
    assert !strings.is_empty();
    assert strings.is_not_empty();
    assert ideal.machine.elements.runtime_util.values_equal(strings.first(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.last(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(0).get(), new base_string("foo"));
  }
  public void test_list_elements() {
    final base_list<string> strings = new base_list<string>();
    assert strings.is_empty();
    assert !strings.is_not_empty();
    assert strings.size() == 0;
    strings.append(new base_string("foo"));
    assert strings.size() == 1;
    assert !strings.is_empty();
    assert strings.is_not_empty();
    assert ideal.machine.elements.runtime_util.values_equal(strings.first(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.last(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(0).get(), new base_string("foo"));
    final immutable_list<string> elements = strings.elements();
    assert elements.size() == 1;
    assert !elements.is_empty();
    assert strings.is_not_empty();
    assert ideal.machine.elements.runtime_util.values_equal(elements.first(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(elements.last(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(elements.get(0), new base_string("foo"));
    assert strings.size() == 1;
    strings.append(new base_string("bar"));
    assert strings.size() == 2;
    assert !strings.is_empty();
    assert strings.is_not_empty();
    assert ideal.machine.elements.runtime_util.values_equal(strings.first(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.last(), new base_string("bar"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(0).get(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(1).get(), new base_string("bar"));
  }
  public void test_list_remove() {
    final base_list<string> strings = new base_list<string>();
    strings.append(new base_string("foo"));
    strings.append(new base_string("bar"));
    strings.append(new base_string("baz"));
    assert strings.size() == 3;
    assert !strings.is_empty();
    assert strings.is_not_empty();
    assert ideal.machine.elements.runtime_util.values_equal(strings.first(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.last(), new base_string("baz"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(0).get(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(1).get(), new base_string("bar"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(2).get(), new base_string("baz"));
    strings.remove_at(1);
    assert strings.size() == 2;
    assert !strings.is_empty();
    assert strings.is_not_empty();
    assert ideal.machine.elements.runtime_util.values_equal(strings.first(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.last(), new base_string("baz"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(0).get(), new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(1).get(), new base_string("baz"));
    strings.remove_at(0);
    assert strings.size() == 1;
    assert !strings.is_empty();
    assert strings.is_not_empty();
    assert ideal.machine.elements.runtime_util.values_equal(strings.first(), new base_string("baz"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.last(), new base_string("baz"));
    assert ideal.machine.elements.runtime_util.values_equal(strings.at(0).get(), new base_string("baz"));
    strings.remove_at(0);
    assert strings.size() == 0;
    assert strings.is_empty();
    assert !strings.is_not_empty();
  }
}
