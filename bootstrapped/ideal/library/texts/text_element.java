// Autogenerated from isource/library/texts.i

package ideal.library.texts;

import ideal.library.elements.*;

import javax.annotation.Nullable;

public interface text_element extends text_node {
  element_id get_id();
  immutable_dictionary<attribute_id, string> attributes();
  @Nullable text_fragment children();
}
