// Autogenerated from development/futures/base_lifespan.i

package ideal.development.futures;

import ideal.library.elements.*;
import ideal.runtime.elements.*;

import javax.annotation.Nullable;

public class base_lifespan extends resource_manager implements lifespan {
  public base_lifespan(final @Nullable lifespan parent) {
    if (parent != null) {
      parent.add_resource((disposable) this);
    }
  }
  public @Override lifespan make_sub_span() {
    return new base_lifespan(this);
  }
}
