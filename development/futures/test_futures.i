-- Copyright 2014-2020 The Ideal Authors. All rights reserved.
--
-- Use of this source code is governed by a BSD-style
-- license that can be found in the LICENSE file or at
-- https://developers.google.com/open-source/licenses/bsd

--- Tests associated with futures.
class test_futures {

  testcase test_simple_futures() {
    future0 : base_future[string].new("foo");
    assert future0.value == "foo";

    future1 : base_future[string].new();
    assert future1.value is null;
    future1.set("bar");
    assert future1.value is_not null;
    assert future1.value == "bar";
  }

  var string or null value0 : missing.instance;

  void observe0(string value) {
    value0 = value;
  }

  testcase test_future_observers() {
    lifespan the_lifespan : base_lifespan.new(missing.instance);

    future0 : base_future[string].new("foo");
    assert value0 is null;
    --future0.observe(observe0, the_lifespan);
    --assert value0 == "foo";
  }
}
