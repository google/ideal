-- Copyright 2014-2021 The Ideal Authors. All rights reserved.
--
-- Use of this source code is governed by a BSD-style
-- license that can be found in the LICENSE file or at
-- https://developers.google.com/open-source/licenses/bsd

namespace patterns {
  implicit import ideal.library.elements;
  implicit import ideal.library.patterns;
  implicit import ideal.runtime.elements;

  interface validatable;
  class base_pattern;
  class one_pattern;
  class singleton_pattern;
  class predicate_pattern;
  class base_repeat_element;
  class repeat_element;
  class sequence_pattern;
  class procedure_matcher;
  class sequence_matcher;
  class option_pattern;
  class repeat_pattern;
  class option_matcher;
  class repeat_matcher;

  class test_singleton_pattern;
  class test_predicate_pattern;
  class test_repeat_element;
  class test_sequence_pattern;
  class test_procedure_matcher;
  class test_sequence_matcher;
  class test_option_pattern;
  class test_repeat_pattern;
  class test_option_matcher;
  class test_repeat_matcher;
}
