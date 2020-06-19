-- Copyright 2014-2020 The Ideal Authors. All rights reserved.
--
-- Use of this source code is governed by a BSD-style
-- license that can be found in the LICENSE file or at
-- https://developers.google.com/open-source/licenses/bsd

--- All information encapsulated in a variable declaration.
interface variable_declaration {
  extends declaration, variable_id;

  variable_category get_category;
  annotation_set annotations;
  override action_name short_name;
  override principal_type declared_in_type;
  --- Get (flavored) variable type.
  override type value_type;
  override type reference_type;
  analyzable or null get_type_analyzable;
  analyzable or null initializer;
  action or null init_action;
  variable_declaration specialize(specialization_context context, principal_type new_parent);
}