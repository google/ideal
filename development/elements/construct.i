-- Copyright 2014-2021 The Ideal Authors. All rights reserved.
--
-- Use of this source code is governed by a BSD-style
-- license that can be found in the LICENSE file or at
-- https://developers.google.com/open-source/licenses/bsd

--- Constructs are the abstract syntax tree (AST) data structures used in ideal.
interface construct {
  extends data, origin;

  readonly list[construct] children();
  boolean has(predicate[construct] the_predicate);

  origin deeper_origin();
}
