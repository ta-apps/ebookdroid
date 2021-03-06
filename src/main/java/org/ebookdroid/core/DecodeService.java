package org.ebookdroid.core;

import android.graphics.RectF;
import org.ebookdroid.common.bitmaps.IBitmapCore;
import org.ebookdroid.common.bitmaps.IBitmapRef;
import org.ebookdroid.core.codec.CodecFeatures;
import org.ebookdroid.core.codec.CodecPage;
import org.ebookdroid.core.codec.CodecPageInfo;
import org.ebookdroid.core.codec.OutlineLink;

import java.util.List;

public interface DecodeService extends CodecFeatures {

	void open(String fileName, String password);

	void decodePage(ViewState viewState, PageTreeNode node);

	void searchText(Page page, String pattern, SearchCallback callback);

	// This is used if document supports FEATURE_DOCUMENT_MANAGE_SEARCH
	void searchNext(boolean forward);

	void stopSearch(String pattern);

	void stopDecoding(PageTreeNode node, String reason);

	int getPageCount();

	List<OutlineLink> getOutline();

	CodecPageInfo getUnifiedPageInfo();

	CodecPageInfo getPageInfo(int pageIndex);

	void recycle();

	void updateViewState(ViewState viewState);

	IBitmapRef createThumbnail(boolean useEmbeddedIfAvailable, int width, int height, int pageNo, RectF region);

	IBitmapCore createPageThumbnail(int width, int height, int pageNo, RectF region);

	interface DecodeCallback {

		void decodeComplete(CodecPage codecPage, IBitmapCore bitmap, RectF croppedPageBounds);

	}

	interface SearchCallback {

		void searchComplete(Page page, List<? extends RectF> regions);

	}

}
