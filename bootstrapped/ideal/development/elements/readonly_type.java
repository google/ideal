// Autogenerated from development/elements/type.i

package ideal.development.elements;

import ideal.library.elements.*;
import ideal.library.reflections.*;

public interface readonly_type extends readonly_abstract_value, readonly_data, readonly_stringable, readonly_reference_equality, readonly_type_id, any_type {
  boolean is_subtype_of(type the_supertype);
  principal_type principal();
  type_flavor get_flavor();
  type get_flavored(type_flavor flavored);
}