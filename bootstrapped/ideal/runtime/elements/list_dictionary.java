// Autogenerated from runtime/elements/list_dictionary.i

package ideal.runtime.elements;

import ideal.library.elements.*;
import ideal.machine.elements.runtime_util;

import javax.annotation.Nullable;

public class list_dictionary<key_type, value_type> extends base_list_dictionary<key_type, value_type> implements dictionary<key_type, value_type> {
  public list_dictionary(final equivalence_relation<key_type> equivalence) {
    super(equivalence);
  }
  public list_dictionary() {
    super((equivalence_relation<key_type>) (equivalence_relation) runtime_util.default_equivalence);
  }
  public list_dictionary(final key_type the_key, final value_type the_value) {
    super(the_key, the_value, (equivalence_relation<key_type>) (equivalence_relation) runtime_util.default_equivalence);
  }
  public @Override immutable_dictionary<key_type, value_type> frozen_copy() {
    return new immutable_list_dictionary<key_type, value_type>(this);
  }
  public @Override void clear() {
    this.the_size = 0;
    this.entries = null;
  }
  public @Override @Nullable value_type put(final key_type key, final value_type value) {
    @Nullable base_list_dictionary.entry_cell<key_type, value_type> entry = this.entries;
    if (entry == null) {
      this.entries = new base_list_dictionary.entry_cell<key_type, value_type>(key, value);
      this.the_size = 1;
      return null;
    }
    while (true) {
      if (this.equivalence.call(key, entry.key())) {
        final value_type old_value = entry.value();
        entry.set_value(value);
        return old_value;
      }
      final @Nullable base_list_dictionary.entry_cell<key_type, value_type> next = entry.next;
      if (next == null) {
        entry.next = new base_list_dictionary.entry_cell<key_type, value_type>(key, value);
        this.the_size += 1;
        return null;
      } else {
        entry = next;
      }
    }
  }
  public @Override @Nullable value_type remove(final key_type key) {
    @Nullable base_list_dictionary.entry_cell<key_type, value_type> entry = this.entries;
    if (entry == null) {
      return null;
    }
    if (this.equivalence.call(key, entry.key())) {
      final value_type old_value = entry.value();
      this.entries = entry.next;
      final int new_size = this.the_size - 1;
      assert new_size >= 0;
      this.the_size = new_size;
      return old_value;
    }
    while (true) {
      final @Nullable base_list_dictionary.entry_cell<key_type, value_type> next_entry = entry.next;
      if (next_entry == null) {
        return null;
      }
      if (this.equivalence.call(key, next_entry.key())) {
        final value_type old_value = next_entry.value();
        entry.next = next_entry.next;
        final int new_size = this.the_size - 1;
        assert new_size >= 0;
        this.the_size = new_size;
        return old_value;
      }
      entry = next_entry;
    }
  }
}
