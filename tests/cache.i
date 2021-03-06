

var nonnegative size : 40;
void foo(nonnegative arg) {
  println(arg);
}
foo(1 + 2);
size += 2;
foo(size);
class testcache {
  var integer index;
  private var string or null generated_foo_cache;

  string foo() {
    var result : generated_foo_cache;
    if (result is null) {
      result = generated_foo_compute();
      generated_foo_cache = result;
    }
    return result;
  }

  private string generated_foo_compute() {
    return perform_expensive_operation();
  }

  testcache() {
    index = 0;
    generated_foo_cache = missing.instance;
  }

  string bar() {
    return perform_expensive_operation();
  }

  string perform_expensive_operation() {
    index += 1;
    return "$$$" ++ index;
  }
}


instance : testcache.new();

println(instance.bar());
println(instance.bar());
println(instance.foo());
println(instance.foo());

import ideal.runtime.elements.base_list;

immutable list[nonnegative] reverse() {
  nonnegative the_begin : 6;
  nonnegative the_end : 8;
  result : base_list[nonnegative].new();
  for (var integer value : the_end - 1; value >= the_begin; value -= 1) {
    assert value is nonnegative;
    result.append(value);
--    nonnegative_value : value;
--    assert nonnegative_value is nonnegative;
--    result.append(nonnegative_value);
  }
  return result.frozen_copy();
}

--for (element : reverse()) {
--  println(":" ++ element);
--}
