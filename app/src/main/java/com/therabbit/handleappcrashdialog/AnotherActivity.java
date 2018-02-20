package com.therabbit.handleappcrashdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class AnotherActivity extends Activity {

	TextView error;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		Dialog builder = new Dialog(this, R.style.AlertDialogTheme);
		builder.setContentView(R.layout.crash_layout);
		builder.show();

		TextView t1 = (TextView) builder.findViewById(R.id.hello);
		final TextView t2 = (TextView) builder.findViewById(R.id.hello2);
		t2.setMovementMethod(new ScrollingMovementMethod());
		t2.setText(getIntent().getStringExtra("error"));
		btn = (Button) builder.findViewById(R.id.btn_ok);
		btn.setOnClickListener(view->restartApp());
		t1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (t2.getVisibility() == View.GONE) {
					t2.setVisibility(View.VISIBLE);

				} else {
					t2.setVisibility(View.GONE);
				}
			}
		});

	}

	public void restartApp() {
		Intent i = getBaseContext().getPackageManager()
				.getLaunchIntentForPackage(getBaseContext().getPackageName());
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		finish();
		startActivity(i);
	}
}
