package com.example.logogame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	Button buttonStart, buttonHelp;
	Button buttonHome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);




	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void start(View view) {
		Intent intent = new Intent(this, PlaygroundActivity.class);
		this.startActivity(intent);

	}

	public void help(View view) {
		this.setContentView(R.layout.activity_correct);
		buttonHome = (Button) findViewById(R.id.Home);
		this.buttonHome.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.Home:
			this.setContentView(R.layout.main);
			break;
		}

	}

}
