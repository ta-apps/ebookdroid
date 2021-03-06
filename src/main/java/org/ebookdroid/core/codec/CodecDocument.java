package org.ebookdroid.core.codec;

import android.graphics.Bitmap;
import android.graphics.RectF;

import java.util.List;

public interface CodecDocument extends CodecFeatures {

	void recycle();

	boolean isRecycled();

	CodecContext getContext();

	int getPageCount();

	CodecPage getPage(int pageNuber);

	CodecPageInfo getPageInfo(int pageNuber);

	CodecPageInfo getUnifiedPageInfo();

	List<? extends RectF> searchText(int pageNuber, final String pattern);

	// This is used if document supports FEATURE_DOCUMENT_MANAGE_SEARCH
	void searchNext(boolean forward);

	List<OutlineLink> getOutline();

	Bitmap getEmbeddedThumbnail();
}
