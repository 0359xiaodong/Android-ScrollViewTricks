package net.appkraft.scrollviewtricks;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;

public class QuickReturnListViewGlobalLayoutListener implements ViewTreeObserver.OnGlobalLayoutListener {

	View mQuickReturnView;
	View mPlaceholderView;
	ObservableListView mObservableScrollView;;
    QuickReturnListViewCallbacks mCallbacks;

	public QuickReturnListViewGlobalLayoutListener(View mQuickReturnView, View mPlaceholderView,
			ObservableListView mObservableScrollView, 
			QuickReturnListViewCallbacks mCallbacks) {

		this.mQuickReturnView = mQuickReturnView;
		this.mPlaceholderView = mPlaceholderView;
		this.mObservableScrollView = mObservableScrollView;
		this.mCallbacks = mCallbacks;
		
	}

	@Override
	public void onGlobalLayout() {
		
		mCallbacks.onScrollChanged();
		mCallbacks.mCachedVerticalScrollRange = mObservableScrollView.computeVerticalScrollRange();
		mCallbacks.mQuickReturnHeight = mQuickReturnView.getHeight();
		
	}

}
