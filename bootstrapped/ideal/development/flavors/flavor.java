// Autogenerated from development/flavors/flavor.i

package ideal.development.flavors;

import ideal.library.elements.*;
import ideal.runtime.elements.*;
import ideal.runtime.logs.*;
import ideal.development.elements.*;
import ideal.development.names.*;

public class flavor {
  public final static type_flavor nameonly_flavor = new type_flavor_impl(new base_string("nameonly"), flavor_profiles.nameonly_profile, new empty<type_flavor>());
  public final static type_flavor any_flavor = new type_flavor_impl(new base_string("any"), flavor_profiles.mutable_profile, new empty<type_flavor>());
  public final static type_flavor readonly_flavor = new type_flavor_impl(new base_string("readonly"), flavor_profiles.mutable_profile, new base_immutable_list<type_flavor>(new ideal.machine.elements.array<type_flavor>(new type_flavor[]{ any_flavor })));
  public final static type_flavor writeonly_flavor = new type_flavor_impl(new base_string("writeonly"), flavor_profiles.mutable_profile, new base_immutable_list<type_flavor>(new ideal.machine.elements.array<type_flavor>(new type_flavor[]{ any_flavor })));
  public final static type_flavor mutable_flavor = new type_flavor_impl(new base_string("mutable"), flavor_profiles.mutable_profile, new base_immutable_list<type_flavor>(new ideal.machine.elements.array<type_flavor>(new type_flavor[]{ readonly_flavor, writeonly_flavor })));
  public final static type_flavor immutable_flavor = new type_flavor_impl(new base_string("immutable"), flavor_profiles.immutable_profile, new base_immutable_list<type_flavor>(new ideal.machine.elements.array<type_flavor>(new type_flavor[]{ readonly_flavor })));
  public final static type_flavor deeply_immutable_flavor = new type_flavor_impl(new base_string("deeply_immutable"), flavor_profiles.deeply_immutable_profile, new base_immutable_list<type_flavor>(new ideal.machine.elements.array<type_flavor>(new type_flavor[]{ immutable_flavor })));
  public final static type_flavor raw_flavor = new type_flavor_impl(new base_string("raw"), flavor_profiles.mutable_profile, new empty<type_flavor>());
  public final static immutable_list<type_flavor> all_flavors = new base_immutable_list<type_flavor>(new ideal.machine.elements.array<type_flavor>(new type_flavor[]{ nameonly_flavor, any_flavor, readonly_flavor, writeonly_flavor, mutable_flavor, raw_flavor, immutable_flavor, deeply_immutable_flavor }));
  public final static type_flavor DEFAULT_FLAVOR = mutable_flavor;
  public final static immutable_list<type_flavor> PRIMARY_FLAVORS = new base_immutable_list<type_flavor>(new ideal.machine.elements.array<type_flavor>(new type_flavor[]{ any_flavor, readonly_flavor, writeonly_flavor, mutable_flavor, immutable_flavor, deeply_immutable_flavor }));
}
