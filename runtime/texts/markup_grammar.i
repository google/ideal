-- Copyright 2014-2021 The Ideal Authors. All rights reserved.
--
-- Use of this source code is governed by a BSD-style
-- license that can be found in the LICENSE file or at
-- https://developers.google.com/open-source/licenses/bsd

--- The grammar for a subset of XML.
---
--- Used https://cs.lmu.edu/~ray/notes/xmlgrammar/ as a reference.
class markup_grammar {
  implicit import ideal.library.patterns;
  implicit import ideal.runtime.patterns;
  implicit import character_patterns;

  character_handler the_character_handler;
  dictionary[string, special_text] entities;
  var pattern[character] document_pattern;
  var matcher[character, special_text] entity_ref;
  var matcher[character, string] quot_attr_value;
  var matcher[character, string] apos_attr_value;
  var matcher[character, attribute_fragment] attribute_value_in_quot;
  var matcher[character, attribute_fragment] attribute_value_in_apos;

  markup_grammar(character_handler the_character_handler) {
    this.the_character_handler = the_character_handler;
    this.entities = hash_dictionary[string, special_text].new();
  }

  private boolean is_completed => document_pattern is_not null;

  public void add_entities(readonly collection[special_text] new_entities) {
    assert !is_completed();
    for (the_entity : new_entities.elements) {
      this.entities.put(the_entity.name, the_entity);
    }
  }

  public void complete() {
    assert !is_completed();
    document_pattern = document();
  }

  protected boolean name_start(character c) pure {
    return the_character_handler.is_letter(c) || c == '_' || c == ':';
  }

  protected boolean name_char(character c) pure {
    return the_character_handler.is_letter(c) || c == '.' || c == '-' || c == '_' || c == ':';
  }

  protected boolean content_char(character c) pure {
    return c != '<' && c != '&';
  }

  protected boolean content_not_apos(character c) pure {
    return c != '<' && c != '&' && c != '\'';
  }

  protected boolean content_not_quot(character c) pure {
    return c != '<' && c != '&' && c != '"';
  }

  special_text make_entity_2nd(readonly list[any value] the_list) pure {
    string entity_name : the_list[1] as string;
    entity : entities.get(entity_name);
    -- TODO: report error to user
    assert entity is_not null;
    return entity;
  }

  protected pattern[character] document() {
    lt : one_character('<');
    gt : one_character('>');
    slash : one_character('/');
    amp : one_character('&');
    semicolon : one_character(';');
    quot : one_character('"');
    apos : one_character('\'');
    eq : one_character('=');

    space_opt : zero_or_more(the_character_handler.is_whitespace);
    name : as_string(sequence_pattern[character].new([ one(name_start), zero_or_more(name_char) ]));

    entity_ref = sequence_matcher[character, special_text].new([ amp, name, semicolon ],
        make_entity_2nd);


    equals : sequence([ space_opt, eq, space_opt ]);

    quot_attr_value = as_string(one_or_more(content_not_quot));
    attribute_value_in_quot = sequence_matcher[character, attribute_fragment].new([ quot,
        repeat_or_none_fragment(option_fragment(quot_attr_value, entity_ref)), quot ],
        select_2nd_attribute_fragment);

    apos_attr_value = as_string(one_or_more(content_not_apos));
    attribute_value_in_apos = sequence_matcher[character, attribute_fragment].new([ apos,
        repeat_or_none_fragment(option_fragment(apos_attr_value, entity_ref)), apos ],
        select_2nd_attribute_fragment);

    attribute_value : option_fragment_list([ attribute_value_in_quot, attribute_value_in_apos ]);
    attribute : sequence([ name, equals, attribute_value ]);
    attributes : repeat_or_none(sequence([ space_opt, attribute ]));

    empty_element : sequence([ lt, name, attributes, space_opt, slash, gt ]);
    element : option([empty_element, ]);
    char_data_opt : zero_or_more(content_char);
    pattern[character] entity_ref_pattern : entity_ref;
    content_element : option([ element, entity_ref_pattern ]);
    content_tail : repeat_or_none(sequence([ content_element, char_data_opt ]));
    content : sequence([ char_data_opt, content_tail ]);

    start_tag : sequence([ lt, name, attributes, space_opt, gt ]);
    end_tag : sequence([ lt, slash, name, space_opt, gt ]);
    element.add_option(sequence([ start_tag, content, end_tag ]));

    -- sequence_matcher[character, string].new([ space_opt, element, space_opt ], select_2nd);
    result : sequence([ space_opt, element, space_opt ]);

    -- TODO: cast should be redundant.
    (result as validatable).validate();

    return result;
  }
}
