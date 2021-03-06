/*
 * Copyright 2014-2021 The Ideal Authors. All rights reserved.
 *
 * Use of this source code is governed by a BSD-style
 * license that can be found in the LICENSE file or at
 * https://developers.google.com/open-source/licenses/bsd
 */

package ideal.machine.characters;

import ideal.library.characters.*;

public class normal_handler implements character_handler {
  public static final normal_handler instance = new normal_handler();

  @Override
  public boolean is_letter(char the_character) {
    return Character.isLetter(the_character);
  }

  @Override
  public boolean is_letter_or_digit(char the_character) {
    return Character.isLetterOrDigit(the_character);
  }

  @Override
  public boolean is_whitespace(char the_character) {
    return Character.isWhitespace(the_character);
  }

  @Override
  public boolean is_upper_case(char c) {
    return Character.isUpperCase(c);
  }

  @Override
  public char to_lower_case(char c) {
    return Character.toLowerCase(c);
  }
}
