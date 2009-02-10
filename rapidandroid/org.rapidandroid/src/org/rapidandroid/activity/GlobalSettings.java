package org.rapidandroid.activity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.rapidandroid.ApplicationGlobals;
import org.rapidandroid.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * @author Daniel Myung dmyung@dimagi.com
 * @created Feb 10, 2009 Summary:
 */
public class GlobalSettings extends Activity {


	/**
	 * 
	 */
	private static final String ACTIVITY_TITLE_STRING = "RapidAndroid :: Global Settings";
	
	/**
	 * 
	 */
	public static final String LOG_DEBUG_KEY = "GlobalSettings";
	
	private static final int MENU_DONE = Menu.FIRST;
	
	private CheckBox mParseCheckbox;
	private EditText mParseReplyText;
	private CheckBox mNoparseCheckBox;
	private EditText mNoparseReplyText;
	
	
	private OnClickListener mCheckChangeListener = new OnClickListener() {

		public void onClick(View v) {
			if (v.equals(mParseCheckbox)) {
				mNoparseCheckBox.setEnabled(mParseCheckbox.isChecked());
			} else if (v.equals(mNoparseCheckBox)) {
				mNoparseCheckBox.setEnabled(mNoparseCheckBox.isChecked());
			}
		}
	};

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setTitle(ACTIVITY_TITLE_STRING);
		setContentView(R.layout.global_settings);

		mParseCheckbox = (CheckBox) findViewById(R.id.glb_chk_parse);
		mParseCheckbox.setOnClickListener(mCheckChangeListener);
		this.mParseReplyText = (EditText) findViewById(R.id.glb_etx_success);

		mNoparseCheckBox = (CheckBox) findViewById(R.id.glb_chk_noparse);
		mNoparseCheckBox.setOnClickListener(mCheckChangeListener);
		this.mNoparseReplyText = (EditText) findViewById(R.id.glb_etx_failed);
		
		loadSettingsFromGlobals();
	}

	/**
	 * 
	 */
	private void loadSettingsFromGlobals() {
		// TODO Auto-generated method stub
		JSONObject globals = ApplicationGlobals.loadSettingsFromFile(this);
		try {
			mParseCheckbox.setChecked(globals.getBoolean(ApplicationGlobals.KEY_PARSE_REPLY));
			mParseReplyText.setText(globals.getString(ApplicationGlobals.KEY_PARSE_REPLY_TEXT));
			mNoparseCheckBox.setChecked(globals.getBoolean(ApplicationGlobals.KEY_FAILED_REPLY));
			mNoparseReplyText.setText(globals.getString(ApplicationGlobals.KEY_FAILED_REPLY_TEXT));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, MENU_DONE, 0, R.string.formreview_menu_done).setIcon(android.R.drawable.ic_menu_close_clear_cancel);		
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
			case MENU_DONE:
				finish();
				break;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		super.onPause();
		ApplicationGlobals.saveGlobalSettings(this, mParseCheckbox.isChecked(), 
		                                      mParseReplyText.getText().toString(), 
		                                      mNoparseCheckBox.isChecked(), 
		                                      mNoparseReplyText.getText().toString());
		
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {		
		super.onResume();
		loadSettingsFromGlobals();
	}

}
