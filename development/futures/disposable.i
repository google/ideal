-- Copyright 2014-2021 The Ideal Authors. All rights reserved.
--
-- Use of this source code is governed by a BSD-style
-- license that can be found in the LICENSE file or at
-- https://developers.google.com/open-source/licenses/bsd

--- Encapsulates disposable objects.
--- Similar to finalization, only the timing of the clean up operation
--- is explicitly controlled by the developer.
interface disposable {
  extends value;

  --- Dispose of resources associated with this object.
  --- The dispose method should cleanup event listeners, resources, and any other allocations.
  --- It is safe to call this method more than once.
  void dispose();
}
