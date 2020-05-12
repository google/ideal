// Autogenerated from runtime/elements/test_range.i

package ideal.runtime.elements;

import ideal.library.elements.*;

public class test_range {
  public void run_all_tests() {
    ideal.machine.elements.runtime_util.start_test("test_range.test_empty");
    test_empty();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_range.test_simple_range");
    test_simple_range();
    ideal.machine.elements.runtime_util.end_test();
  }
  public void test_empty() {
    final base_range the_range = new base_range(68, 68);
    assert the_range.is_empty();
    assert the_range.size() == 0;
    assert the_range.begin() == 68;
    assert the_range.end() == 68;
    final range new_range = the_range.slice(0, 0);
    assert new_range.is_empty();
    assert !new_range.is_not_empty();
    assert new_range.size() == 0;
    assert new_range.begin() == 68;
    assert new_range.end() == 68;
  }
  public void test_simple_range() {
    final base_range the_range = new base_range(5, 8);
    assert the_range.begin() == 5;
    assert the_range.end() == 8;
    assert the_range.size() == 3;
    assert !the_range.is_empty();
    assert the_range.is_not_empty();
    assert the_range.first() == 5;
    assert the_range.last() == 7;
    assert the_range.get(0) == 5;
    assert the_range.get(1) == 6;
    assert the_range.get(2) == 7;
    assert ideal.machine.elements.runtime_util.values_equal(the_range.elements(), the_range);
    assert ideal.machine.elements.runtime_util.values_equal(the_range.frozen_copy(), the_range);
    final range the_slice = the_range.skip(1);
    assert the_slice.size() == 2;
    assert the_slice.begin() == 6;
    assert the_slice.end() == 8;
    assert the_slice.first() == 6;
    assert the_slice.last() == 7;
    final range the_slice2 = the_range.slice(1, 1);
    assert the_slice2.size() == 0;
    assert the_slice2.is_empty();
    assert the_slice2.begin() == 6;
    assert the_slice2.end() == 6;
    final immutable_list<Integer> reversed = the_range.reverse();
    assert reversed.size() == 3;
    assert !reversed.is_empty();
    assert reversed.is_not_empty();
    assert reversed.first() == 7;
    assert reversed.last() == 5;
    assert reversed.get(0) == 7;
    assert reversed.get(1) == 6;
    assert reversed.get(2) == 5;
  }
}
