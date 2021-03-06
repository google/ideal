/*
 * Copyright 2014-2021 The Ideal Authors. All rights reserved.
 *
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file or at
 * https://developers.google.com/open-source/licenses/bsd
 */

package ideal.development.analyzers;

import ideal.library.elements.*;
import ideal.library.reflections.*;
import javax.annotation.Nullable;
import ideal.runtime.elements.*;
import ideal.runtime.logs.*;
import ideal.runtime.reflections.*;
import ideal.development.elements.*;
import ideal.development.actions.*;
import ideal.development.constructs.*;
import ideal.development.notifications.*;
import ideal.development.names.*;
import ideal.development.types.*;
import ideal.development.kinds.*;
import ideal.development.values.*;
import ideal.development.modifiers.*;
import ideal.development.flavors.*;
import ideal.development.declarations.*;

public class procedure_executor extends base_procedure {
  public final procedure_declaration the_declaration;

  public procedure_executor(procedure_declaration the_declaration, action_name the_name) {
    super(the_name, the_declaration.get_procedure_type());
    this.the_declaration = the_declaration;
  }

  public procedure_executor(procedure_declaration the_declaration) {
    this(the_declaration, the_declaration.short_name());
  }

  @Override
  public boolean has_this_argument() {
    return get_category() != procedure_category.STATIC;
  }

  @Override
  public declaration get_declaration() {
    return the_declaration;
  }

  public procedure_category get_category() {
    return the_declaration.get_category();
  }

  @Override
  public entity_wrapper execute(readonly_list<entity_wrapper> arguments,
      execution_context the_context) {
    if (has_this_argument()) {
      return action_utilities.execute_procedure(the_declaration, (value_wrapper) arguments.first(),
          arguments.skip(1), the_context);
    } else {
      return action_utilities.execute_procedure(the_declaration, null, arguments, the_context);
    }
  }
}
