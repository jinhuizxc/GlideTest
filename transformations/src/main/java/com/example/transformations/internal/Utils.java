package com.example.transformations.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;

/**
 * Copyright (C) 2019 Wasabeef
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public final class Utils {

  private Utils() {
    // Utility class.
  }

  public static Drawable getMaskDrawable(Context context, int maskId) {
    Drawable drawable;
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      drawable = context.getDrawable(maskId);
    } else {
      drawable = context.getResources().getDrawable(maskId);
    }

    if (drawable == null) {
      throw new IllegalArgumentException("maskId is invalid");
    }

    return drawable;
  }

  public static int toDp(int px) {
    return px * (int) Resources.getSystem().getDisplayMetrics().density;
  }
}
