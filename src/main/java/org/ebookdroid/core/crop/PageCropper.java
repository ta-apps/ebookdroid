package org.ebookdroid.core.crop;

import android.graphics.RectF;
import org.ebookdroid.common.bitmaps.IBitmapCore;

import java.nio.ByteBuffer;

public class PageCropper {

	public static final int BMP_SIZE = 400;

	private PageCropper() {
	}

	public static synchronized RectF getCropBounds(final IBitmapCore bitmap, final RectF psb) {
		return nativeGetCropBounds(bitmap.getPixels(), bitmap.getWidth(), bitmap.getHeight(), psb.left, psb.top,
				psb.right, psb.bottom);
	}

	public static synchronized RectF getColumn(final IBitmapCore bitmap, final float x, final float y) {
		return nativeGetColumn(bitmap.getPixels(), bitmap.getWidth(), bitmap.getHeight(), x, y);
	}

	private static native RectF nativeGetCropBounds(ByteBuffer pixels, int width, int height, float left, float top,
													float right, float bottom);

	private static native RectF nativeGetColumn(ByteBuffer pixels, int width, int height, float x, float y);
}
