-- Copyright 2014-2020 The Ideal Authors. All rights reserved.
--
-- Use of this source code is governed by a BSD-style
-- license that can be found in the LICENSE file or at
-- https://developers.google.com/open-source/licenses/bsd

--- Code shared by patterns: |split|, more in the futurte.
abstract class base_pattern[readonly value element_type] {
  implements pattern[element_type];

  implement immutable list[immutable list[element_type]] split(
      immutable list[element_type] the_list) {

    result : base_list[immutable list[element_type]].new();
    var index : 0;

    loop {
      match : find_first(the_list, index);
      if (match is_not null) {
        result.append(the_list.slice(index, match.begin));
        index = match.end;
      } else {
        result.append(the_list.skip(index));
        break;
      }
    }

    return result.frozen_copy();
  }
}