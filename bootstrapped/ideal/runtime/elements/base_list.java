// Autogenerated from runtime/elements/base_list.i

package ideal.runtime.elements;

import ideal.library.elements.*;

public class base_list<element_type> extends base_readonly_list<element_type> implements list<element_type> {
  public base_list() { }
  public base_list(final element_type n1) {
    this();
    append(n1);
  }
  public base_list(final element_type n1, final element_type n2) {
    this();
    append(n1);
    append(n2);
  }
  public base_list(final element_type n1, final element_type n2, final element_type n3) {
    this();
    append(n1);
    append(n2);
    append(n3);
  }
  public base_list(final element_type n1, final element_type n2, final element_type n3, final element_type n4) {
    this();
    append(n1);
    append(n2);
    append(n3);
    append(n4);
  }
  public base_list(final element_type n1, final element_type n2, final element_type n3, final element_type n4, final element_type n5) {
    this();
    append(n1);
    append(n2);
    append(n3);
    append(n4);
    append(n5);
  }
  public base_list(final element_type n1, final element_type n2, final element_type n3, final element_type n4, final element_type n5, final element_type n6) {
    this();
    append(n1);
    append(n2);
    append(n3);
    append(n4);
    append(n5);
    append(n6);
  }
  public base_list(final element_type n1, final element_type n2, final element_type n3, final element_type n4, final element_type n5, final element_type n6, final element_type n7) {
    this();
    append(n1);
    append(n2);
    append(n3);
    append(n4);
    append(n5);
    append(n6);
    append(n7);
  }
  public base_list(final readonly_list<element_type> the_list) {
    this();
    append_all(the_list);
  }
  public @Override void clear() {
    if (is_not_empty()) {
      state = new list_state<element_type>();
    }
  }
  private list_state<element_type> writable_state() {
    if (!state.writable) {
      state = state.copy();
      assert state.writable;
    }
    return state;
  }
  public @Override void append(final element_type element) {
    writable_state().insert(size(), element);
  }
  public @Override void append_all(final readonly_list<element_type> new_elements) {
    writable_state().insert_all(size(), new_elements);
  }
  public @Override void prepend(final element_type element) {
    writable_state().insert(0, element);
  }
  public @Override reference<element_type> at(final int index) {
    assert index < state.size;
    return writable_state().the_elements.at(index);
  }
  public @Override element_type remove_last() {
    assert is_not_empty();
    final int last_index = size() - 1;
    assert last_index >= 0;
    final element_type result = state.the_elements.at(last_index).get();
    writable_state().clear(last_index, 1);
    return result;
  }
}
