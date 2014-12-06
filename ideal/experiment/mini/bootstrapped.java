/*
 * Copyright 2014 The Ideal Authors. All rights reserved.
 *
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file or at
 * https://developers.google.com/open-source/licenses/bsd
 */

package ideal.experiment.mini;

import static ideal.experiment.mini.library.*;

import java.util.List;

import javax.annotation.Nullable;

/**
 * Autogenerated code, do not edit.
 */
public interface bootstrapped {
  interface text {
  }
  class text_string implements text {
    private final String value;
    public text_string(String value) {
      this.value = value;
    }
    public String value() {
      return value;
    }
  }
  class indented_text implements text {
    private final text inside;
    public indented_text(text inside) {
      this.inside = inside;
    }
    public text inside() {
      return inside;
    }
  }
  class text_list implements text {
    private final List<text> texts;
    public text_list(List<text> texts) {
      this.texts = texts;
    }
    public List<text> texts() {
      return texts;
    }
  }
  interface describable {
    text description();
  }
  interface source {
    @Nullable source the_source();
  }
  interface source_text extends source, describable {
    String name();
    String content();
    @Nullable source the_source();
  }
  class source_text_class implements source_text {
    private final String name;
    private final String content;
    public source_text_class(String name, String content) {
      this.name = name;
      this.content = content;
    }
    @Override public String name() {
      return name;
    }
    @Override public String content() {
      return content;
    }
    @Override public @Nullable source the_source() {
      return null;
    }
    @Override public text description() {
      return join_fragments("source_text_class", START_OBJECT, SPACE, describe(name), SPACE, END_OBJECT);
    }
  }
  interface text_position extends source, describable {
    source_text the_source();
    int character_index();
  }
  class text_position_class implements text_position {
    private final source_text the_source;
    private final int character_index;
    public text_position_class(source_text the_source, int character_index) {
      this.the_source = the_source;
      this.character_index = character_index;
    }
    @Override public source_text the_source() {
      return the_source;
    }
    @Override public int character_index() {
      return character_index;
    }
    @Override public text description() {
      return join_fragments("text_position_class", START_OBJECT, NEWLINE, indent(field_is("the_source", the_source), field_is("character_index", character_index)), END_OBJECT);
    }
  }
  class builtin_source implements source, describable {
    public static final builtin_source instance = new builtin_source();
    @Override public @Nullable source the_source() {
      return null;
    }
    @Override public text description() {
      return new text_string("builtin_source");
    }
  }
  enum token_type {
    WHITESPACE,
    COMMENT,
    OPEN,
    CLOSE,
    IDENTIFIER,
    LITERAL,
    MODIFIER;
  }
  interface token extends source {
    token_type type();
  }
  class simple_token implements token, describable {
    private final token_type type;
    private final source the_source;
    public simple_token(token_type type, source the_source) {
      this.type = type;
      this.the_source = the_source;
    }
    @Override public token_type type() {
      return type;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("simple_token", START_OBJECT, NEWLINE, indent(field_is("type", type), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  interface construct extends source {
  }
  class identifier implements token, construct, describable {
    private final String name;
    private final source the_source;
    public identifier(String name, source the_source) {
      this.name = name;
      this.the_source = the_source;
    }
    public String name() {
      return name;
    }
    @Override public token_type type() {
      return token_type.IDENTIFIER;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("identifier", START_OBJECT, NEWLINE, indent(field_is("name", name), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  enum operator_type {
    DOT("."),
    ASSIGN("="),
    NEW("new");
    private final String symbol;
    operator_type(String symbol) {
      this.symbol = symbol;
    }
    public String symbol() {
      return symbol;
    }
  }
  class operator implements construct, describable {
    private final operator_type the_operator_type;
    private final source the_source;
    public operator(operator_type the_operator_type, source the_source) {
      this.the_operator_type = the_operator_type;
      this.the_source = the_source;
    }
    public operator_type the_operator_type() {
      return the_operator_type;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("operator", START_OBJECT, NEWLINE, indent(field_is("the_operator_type", the_operator_type), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  class string_literal implements token, construct, describable {
    private final String value;
    private final @Nullable String with_quotes;
    private final source the_source;
    public string_literal(String value, @Nullable String with_quotes, source the_source) {
      this.value = value;
      this.with_quotes = with_quotes;
      this.the_source = the_source;
    }
    public String value() {
      return value;
    }
    public @Nullable String with_quotes() {
      return with_quotes;
    }
    @Override public token_type type() {
      return token_type.LITERAL;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("string_literal", START_OBJECT, NEWLINE, indent(field_is("value", value), field_is("with_quotes", with_quotes), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  enum grouping_type {
    PARENS,
    ANGLE_BRACKETS,
    OPERATOR;
  }
  class parameter_construct implements construct, describable {
    private final construct main;
    private final List<construct> parameters;
    private final @Nullable grouping_type grouping;
    private final source the_source;
    public parameter_construct(construct main, List<construct> parameters, @Nullable grouping_type grouping, source the_source) {
      this.main = main;
      this.parameters = parameters;
      this.grouping = grouping;
      this.the_source = the_source;
    }
    public construct main() {
      return main;
    }
    public List<construct> parameters() {
      return parameters;
    }
    public @Nullable grouping_type grouping() {
      return grouping;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("parameter_construct", START_OBJECT, NEWLINE, indent(field_is("main", main), field_is("parameters", parameters), field_is("grouping", grouping), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  enum modifier_kind {
    PUBLIC,
    PRIVATE,
    FINAL,
    STATIC,
    OVERRIDE,
    DONT_DESCRIBE,
    NULLABLE;
  }
  class modifier_construct implements token, construct, describable {
    private final modifier_kind the_modifier_kind;
    private final source the_source;
    public modifier_construct(modifier_kind the_modifier_kind, source the_source) {
      this.the_modifier_kind = the_modifier_kind;
      this.the_source = the_source;
    }
    public modifier_kind the_modifier_kind() {
      return the_modifier_kind;
    }
    @Override public token_type type() {
      return token_type.MODIFIER;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("modifier_construct", START_OBJECT, NEWLINE, indent(field_is("the_modifier_kind", the_modifier_kind), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  class s_expression implements construct, describable {
    private final List<construct> parameters;
    private final source the_source;
    public s_expression(List<construct> parameters, source the_source) {
      this.parameters = parameters;
      this.the_source = the_source;
    }
    public List<construct> parameters() {
      return parameters;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("s_expression", START_OBJECT, NEWLINE, indent(field_is("parameters", parameters), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  class block_construct implements construct, describable {
    private final List<construct> statements;
    private final source the_source;
    public block_construct(List<construct> statements, source the_source) {
      this.statements = statements;
      this.the_source = the_source;
    }
    public List<construct> statements() {
      return statements;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("block_construct", START_OBJECT, NEWLINE, indent(field_is("statements", statements), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  class return_construct implements construct, describable {
    private final @Nullable construct expression;
    private final source the_source;
    public return_construct(@Nullable construct expression, source the_source) {
      this.expression = expression;
      this.the_source = the_source;
    }
    public @Nullable construct expression() {
      return expression;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("return_construct", START_OBJECT, NEWLINE, indent(field_is("expression", expression), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  class variable_construct implements construct, describable {
    private final List<modifier_construct> modifiers;
    private final @Nullable construct type;
    private final String name;
    private final @Nullable construct initializer;
    private final source the_source;
    public variable_construct(List<modifier_construct> modifiers, @Nullable construct type, String name, @Nullable construct initializer, source the_source) {
      this.modifiers = modifiers;
      this.type = type;
      this.name = name;
      this.initializer = initializer;
      this.the_source = the_source;
    }
    public List<modifier_construct> modifiers() {
      return modifiers;
    }
    public @Nullable construct type() {
      return type;
    }
    public String name() {
      return name;
    }
    public @Nullable construct initializer() {
      return initializer;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("variable_construct", START_OBJECT, NEWLINE, indent(field_is("modifiers", modifiers), field_is("type", type), field_is("name", name), field_is("initializer", initializer), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  class procedure_construct implements construct, describable {
    private final List<modifier_construct> modifiers;
    private final @Nullable construct return_type;
    private final String name;
    private final List<variable_construct> parameters;
    private final @Nullable construct body;
    private final source the_source;
    public procedure_construct(List<modifier_construct> modifiers, @Nullable construct return_type, String name, List<variable_construct> parameters, @Nullable construct body, source the_source) {
      this.modifiers = modifiers;
      this.return_type = return_type;
      this.name = name;
      this.parameters = parameters;
      this.body = body;
      this.the_source = the_source;
    }
    public List<modifier_construct> modifiers() {
      return modifiers;
    }
    public @Nullable construct return_type() {
      return return_type;
    }
    public String name() {
      return name;
    }
    public List<variable_construct> parameters() {
      return parameters;
    }
    public @Nullable construct body() {
      return body;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("procedure_construct", START_OBJECT, NEWLINE, indent(field_is("modifiers", modifiers), field_is("return_type", return_type), field_is("name", name), field_is("parameters", parameters), field_is("body", body), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  enum supertype_kind {
    EXTENDS,
    IMPLEMENTS;
  }
  class supertype_construct implements construct, describable {
    private final supertype_kind the_supertype_kind;
    private final List<construct> supertypes;
    private final source the_source;
    public supertype_construct(supertype_kind the_supertype_kind, List<construct> supertypes, source the_source) {
      this.the_supertype_kind = the_supertype_kind;
      this.supertypes = supertypes;
      this.the_source = the_source;
    }
    public supertype_kind the_supertype_kind() {
      return the_supertype_kind;
    }
    public List<construct> supertypes() {
      return supertypes;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("supertype_construct", START_OBJECT, NEWLINE, indent(field_is("the_supertype_kind", the_supertype_kind), field_is("supertypes", supertypes), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  enum type_kind {
    INTERFACE,
    DATATYPE,
    ENUM,
    CLASS,
    SINGLETON;
  }
  class type_construct implements construct, describable {
    private final List<modifier_construct> modifiers;
    private final type_kind the_type_kind;
    private final String name;
    private final List<construct> body;
    private final source the_source;
    public type_construct(List<modifier_construct> modifiers, type_kind the_type_kind, String name, List<construct> body, source the_source) {
      this.modifiers = modifiers;
      this.the_type_kind = the_type_kind;
      this.name = name;
      this.body = body;
      this.the_source = the_source;
    }
    public List<modifier_construct> modifiers() {
      return modifiers;
    }
    public type_kind the_type_kind() {
      return the_type_kind;
    }
    public String name() {
      return name;
    }
    public List<construct> body() {
      return body;
    }
    @Override public source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("type_construct", START_OBJECT, NEWLINE, indent(field_is("modifiers", modifiers), field_is("the_type_kind", the_type_kind), field_is("name", name), field_is("body", body), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  interface type {
    String name();
  }
  interface action extends source {
    type result();
  }
  enum core_type implements type {
    VOID,
    INTEGER,
    STRING,
    LIST,
    NULLABLE,
    UNREACHABLE,
    ERROR;
  }
  interface type_action extends action, describable {
    type result();
    @Nullable source the_source();
  }
  class type_action_class implements type_action {
    private final type result;
    private final @Nullable source the_source;
    public type_action_class(type result, @Nullable source the_source) {
      this.result = result;
      this.the_source = the_source;
    }
    @Override public type result() {
      return result;
    }
    @Override public @Nullable source the_source() {
      return the_source;
    }
    @Override public text description() {
      return join_fragments("type_action_class", START_OBJECT, NEWLINE, indent(field_is("result", result), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  interface notification_message {
    notification_type type();
    String text();
  }
  class notification_message_class implements notification_message {
    private final notification_type type;
    private final String text;
    public notification_message_class(notification_type type, String text) {
      this.type = type;
      this.text = text;
    }
    @Override public notification_type type() {
      return type;
    }
    @Override public String text() {
      return text;
    }
  }
  class error_signal implements action, describable {
    private final notification_message message;
    private final source the_source;
    public error_signal(notification_message message, source the_source) {
      this.message = message;
      this.the_source = the_source;
    }
    public notification_message message() {
      return message;
    }
    public source the_source() {
      return the_source;
    }
    @Override public type result() {
      return core_type.ERROR;
    }
    @Override public text description() {
      return join_fragments("error_signal", START_OBJECT, NEWLINE, indent(field_is("message", message), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  interface principal_type extends type, describable {
    String name();
    @Nullable principal_type parent();
  }
  class principal_type_class implements principal_type {
    private final String name;
    private final @Nullable principal_type parent;
    public principal_type_class(String name, @Nullable principal_type parent) {
      this.name = name;
      this.parent = parent;
    }
    @Override public String name() {
      return name;
    }
    @Override public @Nullable principal_type parent() {
      return parent;
    }
    @Override public text description() {
      return join_fragments("principal_type_class", START_OBJECT, NEWLINE, indent(field_is("name", name), field_is("parent", parent)), END_OBJECT);
    }
  }
  class top_type implements principal_type, describable {
    public static final top_type instance = new top_type();
    @Override public String name() {
      return "<top>";
    }
    @Override public @Nullable principal_type parent() {
      return null;
    }
    @Override public text description() {
      return new text_string("top_type");
    }
  }
  interface master_type extends principal_type, describable {
    String name();
    principal_type parent();
  }
  class master_type_class implements master_type {
    private final String name;
    private final principal_type parent;
    public master_type_class(String name, principal_type parent) {
      this.name = name;
      this.parent = parent;
    }
    @Override public String name() {
      return name;
    }
    @Override public principal_type parent() {
      return parent;
    }
    @Override public text description() {
      return join_fragments("master_type_class", START_OBJECT, NEWLINE, indent(field_is("name", name), field_is("parent", parent)), END_OBJECT);
    }
  }
  class type_declaration implements type_action, describable {
    private final master_type declared_type;
    private final source the_source;
    public type_declaration(master_type declared_type, source the_source) {
      this.declared_type = declared_type;
      this.the_source = the_source;
    }
    public master_type declared_type() {
      return declared_type;
    }
    public source the_source() {
      return the_source;
    }
    @Override public type result() {
      return declared_type;
    }
    @Override public text description() {
      return join_fragments("type_declaration", START_OBJECT, NEWLINE, indent(field_is("declared_type", declared_type), field_is("the_source", the_source)), END_OBJECT);
    }
  }
  enum notification_type implements notification_message {
    UNRECOGNIZED_CHARACTER("Unrecognized character"),
    EOF_IN_STRING_LITERAL("End of file in string literal"),
    NEWLINE_IN_STRING_LITERAL("Newline in string literal"),
    PARSE_ERROR("Parse error"),
    CLOSE_PAREN_NOT_FOUND("Close parenthesis not found"),
    MODIFIER_EXPECTED("Modifier expected"),
    ANALYSIS_ERROR("Analysis error"),
    SYMBOL_LOOKUP_FAILED("Symbol lookup failed");
    private final String text;
    notification_type(String text) {
      this.text = text;
    }
    public String text() {
      return text;
    }
    @Override public notification_type type() {
      return this;
    }
  }
}
