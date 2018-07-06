// Autogenerated from isource/runtime/elements/base_readonly_list.i

package ideal.runtime.elements;

import ideal.library.elements.*;
import java.lang.Object;
import ideal.machine.elements.array;

public class base_readonly_list<element_type> implements readonly_list<element_type> {
  public static class parameters {
    public final static int default_size = 16;
  }
  protected static class list_state<element_type> {
    public boolean writable;
    public array<element_type> the_elements;
    public int size;
    public list_state(final int initial_size) {
      writable = true;
      the_elements = new array<element_type>(initial_size);
      size = 0;
    }
    public list_state() {
      this(parameters.default_size);
    }
    public void reserve(final int reserve_size) {
      if (the_elements.size >= reserve_size) {
        return;
      }
      int new_size = the_elements.size * 2;
      if (new_size < reserve_size) {
        new_size = reserve_size;
      }
      final array<element_type> new_elements = new array<element_type>(new_size);
      the_elements.copy(0, new_elements, 0, size);
      the_elements = new_elements;
    }
    public void insert_all(final int index, final readonly_list<element_type> new_elements) {
      if (new_elements.is_empty()) {
        return;
      } else if (new_elements.size() == 1) {
        insert(index, new_elements.get(0));
        return;
      }
      assert writable;
      final int extra_size = new_elements.size();
      reserve_and_move(index, extra_size);
      final array<element_type> new_elements_array = ((base_readonly_list<element_type>) new_elements).state.the_elements;
      new_elements_array.copy(0, the_elements, index, extra_size);
    }
    public void insert(final int index, final element_type element) {
      assert writable;
      reserve_and_move(index, 1);
      the_elements.set(index, element);
    }
    private void reserve_and_move(final int index, final int extra_size) {
      reserve(size + extra_size);
      if (index < size) {
        final int tail_size = size - index;
        assert tail_size >= 0;
        the_elements.move(index, index + extra_size, tail_size);
      }
      size += extra_size;
    }
    public void clear(final int begin, final int length) {
      if (begin + length < size) {
        the_elements.move(begin + length, begin, length);
      }
      final int new_size = size - length;
      assert new_size >= 0;
      size = new_size;
      the_elements.scrub(size, length);
    }
    public list_state<element_type> copy() {
      final base_readonly_list.list_state<element_type> new_state = new list_state<element_type>(size);
      the_elements.copy(0, new_state.the_elements, 0, size);
      new_state.size = size;
      return new_state;
    }
  }
  protected list_state<element_type> state;
  protected base_readonly_list() {
    state = new list_state<element_type>();
  }
  protected base_readonly_list(final list_state<element_type> state) {
    this.state = state;
  }
  public @Override int size() {
    return state.size;
  }
  public @Override boolean is_empty() {
    return state.size == 0;
  }
  public @Override element_type get(final int index) {
    assert index < state.size;
    return state.the_elements.at(index).get();
  }
  public @Override immutable_list<element_type> elements() {
    return frozen_copy();
  }
  public @Override immutable_list<element_type> frozen_copy() {
    return new base_immutable_list<element_type>(state);
  }
  public @Override immutable_list<element_type> slice(final int begin, final int end) {
    assert begin >= 0 && end <= size();
    final int length = end - begin;
    assert length >= 0;
    final base_readonly_list.list_state<element_type> slice_state = new list_state<element_type>(length);
    slice_state.size = length;
    state.the_elements.copy(begin, slice_state.the_elements, 0, length);
    return new base_immutable_list<element_type>(slice_state);
  }
  public @Override immutable_list<element_type> skip(final int count) {
    return slice(count, size());
  }
}
