/*
 * Copyright 2014-2020 The Ideal Authors. All rights reserved.
 *
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file or at
 * https://developers.google.com/open-source/licenses/bsd
 */

package ideal.development.constructs;

import ideal.library.elements.*;
import ideal.runtime.elements.*;
import ideal.development.elements.*;

public class supertype_construct extends base_construct {
  public final subtype_tag tag;
  public final readonly_list<construct> types;

  public supertype_construct(subtype_tag tag, readonly_list<construct> types, position pos) {
    super(pos);
    this.tag = tag;
    this.types = types;

    assert !types.is_empty();
  }

  public readonly_list<construct> children() {
    return types;
  }
}
