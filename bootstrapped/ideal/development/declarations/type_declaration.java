// Autogenerated from development/declarations/type_declaration.i

package ideal.development.declarations;

import ideal.library.elements.*;
import ideal.library.reflections.*;
import ideal.runtime.elements.*;
import ideal.runtime.logs.*;
import ideal.development.elements.*;
import ideal.development.futures.*;
import ideal.development.names.*;
import ideal.development.comments.*;
import ideal.development.modifiers.*;

public interface type_declaration extends declaration, readonly_type_declaration, writeonly_type_declaration {
  void process_declaration(declaration_pass pass);
  future<analysis_result> process_type(declaration_pass pass);
}
