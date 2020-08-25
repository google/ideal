// Autogenerated from development/futures/test_futures.i

package ideal.development.futures;

import ideal.library.elements.*;
import ideal.runtime.elements.*;

import javax.annotation.Nullable;

public class test_futures {
  public void run_all_tests() {
    ideal.machine.elements.runtime_util.start_test("test_futures.test_simple_futures");
    test_simple_futures();
    ideal.machine.elements.runtime_util.end_test();
    ideal.machine.elements.runtime_util.start_test("test_futures.test_future_observers");
    test_future_observers();
    ideal.machine.elements.runtime_util.end_test();
  }
  public void test_simple_futures() {
    final base_future<string> future0 = new base_future<string>(new base_string("foo"));
    assert ideal.machine.elements.runtime_util.values_equal(future0.value(), new base_string("foo"));
    final base_future<string> future1 = new base_future<string>();
    assert future1.value() == null;
    future1.set(new base_string("bar"));
    assert future1.value() != null;
    assert ideal.machine.elements.runtime_util.values_equal(future1.value(), new base_string("bar"));
  }
  public @Nullable string value0 = null;
  public void observe0(final string value) {
    this.value0 = value;
  }
  public void test_future_observers() {
    final lifespan the_lifespan = new base_lifespan(null);
    final base_future<string> future0 = new base_future<string>(new base_string("foo"));
    assert this.value0 == null;
  }
}
