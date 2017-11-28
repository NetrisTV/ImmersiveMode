/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2010 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package com.n0n1.immersive.mode;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiC;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;


// This proxy can be created by calling ImmersiveMode.createImmersiveView();
@Kroll.proxy(creatableInModule=ImmersiveModeModule.class)
public class ImmersiveViewProxy extends TiViewProxy
{
	// Standard Debugging variables
	public static final String TAG = "ImmersiveViewProxy";
	public static final String VERSION = ImmersiveModeModule.VERSION;
	
	@Kroll.constant public static final String MODULE_NAME = "Immersive Module: ";
	private static final int MSG_FIRST_ID = TiViewProxy.MSG_LAST_ID + 1;
	private static final int MSG_RESET_SYSTEM_UI = MSG_FIRST_ID + 1;
	private static final int MSG_HIDE_SYSTEM_UI = MSG_FIRST_ID + 2;
	private static final int MSG_SHOW_SYSTEM_UI = MSG_FIRST_ID + 3;
	private static final int MSG_SET_SYSTEM_UI = MSG_FIRST_ID + 4;

	
	@Kroll.constant public static int UI_FLAG_IMMERSIVE = View.SYSTEM_UI_FLAG_IMMERSIVE;
	@Kroll.constant public static int UI_FLAG_IMMERSIVE_STICKY = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
	@Kroll.constant public static int UI_FLAG_HIDE_NAVIGATION = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
	@Kroll.constant public static int UI_FLAG_LAYOUT_HIDE_NAVIGATION = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
	@Kroll.constant public static int UI_FLAG_FULLSCREEN = View.SYSTEM_UI_FLAG_FULLSCREEN;
	@Kroll.constant public static int UI_FLAG_LAYOUT_FULLSCREEN = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
	@Kroll.constant public static int UI_FLAG_LAYOUT_STABLE = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
	@Kroll.constant public static int UI_FLAG_LOW_PROFILE = View.SYSTEM_UI_FLAG_LOW_PROFILE;
	@Kroll.constant public static int UI_FLAG_RESET = 0;
	
	
	@Kroll.constant public static int DEAFAULT_MODE= 0;
	@Kroll.constant public static int IMMERSIVE_MODE= 1;
	
	Handler handlerImmersiveMode = new Handler();
	
	private Runnable resetSystemUI = new Runnable() {
		
		@Override
		public void run() {
			Log.d(MODULE_NAME, "RESET" );
			Activity activity = getActivity();
			if (activity == null) {
				return;
			}
			activity.getWindow().getDecorView().setSystemUiVisibility(UI_FLAG_RESET);
		}
	};
	
	private Runnable hideSystemUi = new Runnable() {
		
		@Override
		public void run() {
			Log.d(MODULE_NAME, "HIDE_SYSTEM_UI");
			Activity activity = getActivity();
			if (activity == null) {
				return;
			}
			activity.getWindow().getDecorView().setSystemUiVisibility(UI_FLAG_FULLSCREEN | UI_FLAG_HIDE_NAVIGATION);
		}
	};
	
	
	
	private int typeMode = DEAFAULT_MODE;
	
	private class ExampleView extends TiUIView
	{
		public ExampleView(TiViewProxy proxy) {
			super(proxy);
			LayoutArrangement arrangement = LayoutArrangement.DEFAULT;

//			handlerImmersiveMode.post(hideSystemUi);
			
			if (proxy.hasProperty(TiC.PROPERTY_LAYOUT)) {
				String layoutProperty = TiConvert.toString(proxy.getProperty(TiC.PROPERTY_LAYOUT));
				if (layoutProperty.equals(TiC.LAYOUT_HORIZONTAL)) {
					arrangement = LayoutArrangement.HORIZONTAL;
				} else if (layoutProperty.equals(TiC.LAYOUT_VERTICAL)) {
					arrangement = LayoutArrangement.VERTICAL;
				}
			}
			
			setNativeView(new TiCompositeLayout(proxy.getActivity(), arrangement));
		}

		@Override
		public void processProperties(KrollDict d)
		{
			super.processProperties(d);
		}
	}

	// Constructor
	public ImmersiveViewProxy()
	{
		super();
	}

	@Override
	public boolean handleMessage(Message msg) {
		Log.d(TAG, "[handleMessage]");
		Activity activity;
		switch (msg.what) {
		case MSG_HIDE_SYSTEM_UI:
			Log.d(MODULE_NAME, "HIDE_SYSTEM_UI");
			activity = getActivity();
			if (activity == null) {
				return true;
			}
			activity.getWindow().getDecorView().setSystemUiVisibility(UI_FLAG_FULLSCREEN | UI_FLAG_HIDE_NAVIGATION);
			return true;
		case MSG_RESET_SYSTEM_UI:
			Log.d(MODULE_NAME, "RESET");
			activity = getActivity();
			if (activity == null) {
				return true;
			}
			activity.getWindow().getDecorView().setSystemUiVisibility(UI_FLAG_RESET);
			return true;
		case MSG_SHOW_SYSTEM_UI:
			Log.d(MODULE_NAME, "SHOW_SYSTEM_UI");
			activity = getActivity();
			if (activity == null) {
				return true;
			}
			activity.getWindow().getDecorView().setSystemUiVisibility(~UI_FLAG_FULLSCREEN | ~UI_FLAG_HIDE_NAVIGATION);
			return true;
		case MSG_SET_SYSTEM_UI:
			Log.d(MODULE_NAME, "SET_SYSTEM_UI");
			activity = getActivity();
			if (activity == null) {
				return true;
			}
			activity.getWindow().getDecorView().setSystemUiVisibility(msg.arg1);
			return true;
		default:
			return super.handleMessage(msg);
		}
		
	}
	
	@Override
	public TiUIView createView(Activity activity)
	{
		
		TiUIView view = new ExampleView(this);
		view.getLayoutParams().autoFillsHeight = true;
		view.getLayoutParams().autoFillsWidth = true;
		return view;
	}
	
	public int getTypeMode() {
		return typeMode;
	}
	
	public void setTypeMode(int type) {
		typeMode = type;
	}
	
	public void about() {
		Log.d(TAG, "About: ");
		Log.d(TAG, "Version Immersive Module: " + VERSION);
		Log.d(TAG, "typeMode" + typeMode);
	}
	
	@Override
	public void onCreate(Activity activity, Bundle savedInstanceState) {
		Log.d(TAG, "[onCreate]");
		super.onCreate(activity, savedInstanceState);
	}
	
	@Override
	public void onStart(Activity activity) {
		super.onStart(activity);
	}
	
	@Override
	public void onPause(Activity activity) {
		Log.d(TAG, "[onPause]");
		super.onPause(activity);
	}
	
	@Override
	public void onResume(Activity activity) {
		Log.d(TAG, "[onResume]");
		super.onResume(activity);
	}
	
	@Override
	public void onStop(Activity activity) {
		super.onStop(activity);
	}
	
	@Override
	public void onDestroy(Activity activity) {
		Log.d(TAG, "[onDestroy]");
		super.onDestroy(activity);
	}
	
	@Override
	public void add(TiViewProxy child) {
		super.add(child);
	}
	
	@Override
	public void setView(TiUIView view) {
		super.setView(view);
	}
	
	
	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict options)
	{
		super.handleCreationDict(options);

		if (options.containsKey("type")) {
			
		}
	}
	
	@Kroll.method
	public void hideSystemUI() {
		if(TiApplication.isUIThread()) {
			Log.d(MODULE_NAME, "[hideSystemUI]");
			Activity activity = getActivity();
			if (activity == null) {
				return;
			}
			activity.getWindow().getDecorView().setSystemUiVisibility(UI_FLAG_FULLSCREEN | UI_FLAG_HIDE_NAVIGATION);
			return;
		}
		
		Message msg = getMainHandler().obtainMessage(MSG_HIDE_SYSTEM_UI);
		
		msg.sendToTarget();	
	}
	
	@Kroll.method
	public void showSystemUI() {
		if(TiApplication.isUIThread()) {
			Log.d(MODULE_NAME, "SHOW_SYSTEM_UI");
			Activity activity = getActivity();
			if (activity == null) {
				return;
			}
			int systemUiOptions = activity.getWindow().getDecorView().getSystemUiVisibility();
			systemUiOptions = systemUiOptions & ~UI_FLAG_FULLSCREEN & ~UI_FLAG_HIDE_NAVIGATION;
			activity.getWindow().getDecorView().setSystemUiVisibility(systemUiOptions);
			return;
		}
		
		Message msg = getMainHandler().obtainMessage(MSG_SHOW_SYSTEM_UI);
		msg.sendToTarget();	
	}
	
	@Kroll.method
	public void resetSystemUI() {
		if(TiApplication.isUIThread()) {
			Log.d(MODULE_NAME, "RESET");
			Activity activity = getActivity();
			if (activity == null) {
				return;
			}
			activity.getWindow().getDecorView().setSystemUiVisibility(UI_FLAG_RESET);
			return;
		}
		
		Message msg = getMainHandler().obtainMessage(MSG_RESET_SYSTEM_UI);
		msg.sendToTarget();
	}
	
	@Kroll.method 
	public int getSystemUIVisivility() {
		Activity activity = getActivity();
		if (activity == null) {
			return 0;
		}
		return activity.getWindow().getDecorView().getSystemUiVisibility();
	}

	@Kroll.method
	public void setSystemUIVisivility(int visibility) {
		if(TiApplication.isUIThread()) {
			Log.d(MODULE_NAME, "setSystemUIVisivility");
			Activity activity = getActivity();
			if (activity == null) {
				return;
			}
			activity.getWindow().getDecorView().setSystemUiVisibility(visibility);
			return;
		}

		Message msg = getMainHandler().obtainMessage(MSG_SET_SYSTEM_UI);
		msg.arg1 = visibility;
		msg.sendToTarget();
	}
	
	@Kroll.method 
	public void aboutSystemUI() {
		Activity activity = getActivity();
		if (activity == null) {
			return;
		}
		int uiOptions = activity.getWindow().getDecorView().getSystemUiVisibility();
		Log.d(MODULE_NAME, "SYSTEM_UI_OPTIONS: " + uiOptions);
	}
}