// Autogenerated from runtime/texts/text_visitor.i

package ideal.runtime.texts;

import ideal.library.elements.*;
import ideal.library.characters.*;
import ideal.library.texts.*;
import ideal.runtime.elements.*;
import ideal.library.channels.output;

public abstract class text_visitor<result_type> {
  public result_type process(final text_fragment fragment) {
    if (fragment instanceof string) {
      return this.process_string(((string) fragment));
    } else if (fragment instanceof text_element) {
      return this.process_element(((text_element) fragment));
    } else if (fragment instanceof list_text_node) {
      return this.process_nodes(((list_text_node) fragment));
    } else if (fragment instanceof special_text) {
      return this.process_special(((special_text) fragment));
    } else if (fragment instanceof list_attribute_fragment) {
      return this.process_attributes(((list_attribute_fragment) fragment));
    } else {
      {
        utilities.panic(ideal.machine.elements.runtime_util.concatenate(new base_string("Unknown fragment: "), fragment));
        return null;
      }
    }
  }
  public result_type process_attribute(final attribute_fragment fragment) {
    if (fragment instanceof string) {
      return this.process_string(((string) fragment));
    } else if (fragment instanceof special_text) {
      return this.process_special(((special_text) fragment));
    } else if (fragment instanceof list_attribute_fragment) {
      return this.process_attributes(((list_attribute_fragment) fragment));
    } else {
      {
        utilities.panic(ideal.machine.elements.runtime_util.concatenate(new base_string("Unknown attribute fragment: "), fragment));
        return null;
      }
    }
  }
  protected abstract result_type process_string(string s);
  protected abstract result_type process_element(text_element element);
  protected abstract result_type process_nodes(list_text_node nodes);
  protected abstract result_type process_special(special_text t);
  protected abstract result_type process_attributes(list_attribute_fragment fragments);
}
