-- Copyright 2014-2020 The Ideal Authors. All rights reserved.
--
-- Use of this source code is governed by a BSD-style
-- license that can be found in the LICENSE file or at
-- https://developers.google.com/open-source/licenses/bsd

class operator_type {
  implements identifier, readonly displayable;

  final string name;
  final nonnegative arity;

  private operator_type(string name, nonnegative arity) {
    this.name = name;
    this.arity = arity;
  }

  override string to_string() => name;

  override string display() => to_string;

  static operator_type PREFIX : operator_type.new("prefix", 1);

  static operator_type POSTFIX : operator_type.new("postfix", 1);

  static operator_type INFIX : operator_type.new("infix", 2);

  -- TODO: do we need this?
  static operator_type ASSIGNMENT : operator_type.new("assignment", 2);
}