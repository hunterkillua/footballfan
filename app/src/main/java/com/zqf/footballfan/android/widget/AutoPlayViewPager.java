package com.zqf.footballfan.android.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;

import java.lang.ref.WeakReference;

public class AutoPlayViewPager extends DefaultViewPager{
	private static final int MSG_AUTO_PLAY = 0;
	private int mPlaySeconds = 5000;
	private PlayHandler mHandler = new PlayHandler(this);
	
	public AutoPlayViewPager(Context context){
		super(context);
	}

	public AutoPlayViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}
	
	public void setPlaySeconds(int seconds){
		mPlaySeconds = seconds;
	}
	
	public void startPlay(){
		mHandler.sendEmptyMessageDelayed(MSG_AUTO_PLAY, mPlaySeconds);
	}
	
	public void stopPlay(){
		mHandler.removeMessages(MSG_AUTO_PLAY);
	}
	
	private void autoPlay(){
		PagerAdapter adapter = getAdapter();
		if(adapter!=null&&adapter.getCount()>0){
			  int toItem = getCurrentItem() + 1 >= adapter.getCount() ? 0 : getCurrentItem()  + 1;
			  setCurrentItem(toItem, true);
			  mHandler.sendEmptyMessageDelayed(MSG_AUTO_PLAY, mPlaySeconds);
		}
	}
	
//	 private Handler mHandler = new Handler(){
//
//		 @Override
//	        public void handleMessage(Message msg) {
//			 super.handleMessage(msg);
//			 switch (msg.what){
//			     case MSG_AUTO_PLAY:
//			    	 autoPlay();
//				     break;
//				 default:
//					 break;
//			 }
//		 }
//
//	 };

	static class PlayHandler extends Handler {
		private final WeakReference<AutoPlayViewPager> mPlayViewPager;

		public PlayHandler(AutoPlayViewPager playViewPager) {
			mPlayViewPager = new WeakReference<AutoPlayViewPager>(playViewPager);
		}

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what){
				case MSG_AUTO_PLAY:
					if (mPlayViewPager != null && mPlayViewPager.get() != null) {
						mPlayViewPager.get().autoPlay();
					}
					break;
				default:
					break;
			}
		}
	}
}
