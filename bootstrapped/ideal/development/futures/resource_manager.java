// Autogenerated from development/futures/resource_manager.i

package ideal.development.futures;

import ideal.library.elements.*;
import ideal.runtime.elements.*;

public abstract class resource_manager implements lifespan {
  public final set<disposable> resources = new hash_set<disposable>();
  public @Override void add_resource(final disposable resource) {
    this.resources.add(resource);
  }
  public @Override void dispose() {
    {
      final readonly_list<disposable> resource_list = this.resources.elements();
      for (int resource_index = 0; resource_index < resource_list.size(); resource_index += 1) {
        final disposable resource = resource_list.get(resource_index);
        resource.dispose();
      }
    }
    this.resources.clear();
  }
}