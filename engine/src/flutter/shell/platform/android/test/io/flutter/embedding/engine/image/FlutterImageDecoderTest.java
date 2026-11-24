// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.embedding.engine.image;

import static org.junit.Assert.assertNull;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import io.flutter.Build;
import java.nio.ByteBuffer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

/** Unit tests for {@link FlutterImageDecoder}. */
@RunWith(AndroidJUnit4.class)
@Config(minSdk = Build.API_LEVELS.API_28)
public class FlutterImageDecoderTest {

  @Test
  public void decodeImage_returnsNullInsteadOfThrowingOnRuntimeException() {
    // A null buffer makes Metadata.create throw a NullPointerException. Native code aborts the
    // process if any throwable escapes decodeImage, so it must return null instead.
    ByteBuffer buffer = null;
    assertNull(FlutterImageDecoder.decodeImage(buffer, (width, height) -> {}));
  }
}
