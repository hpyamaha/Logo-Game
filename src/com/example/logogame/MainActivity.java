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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		buttonStart = (Button) findViewById(R.id.buttonStart);
		buttonStart = (Button) findViewById(R.id.buttonHelp);
		
		buttonStart.setOnClickListener(this);
		buttonHelp.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.buttonStart: {
			Intent intent = new Intent(this, PlaygroundActivity.class);
			this.startActivity(intent);
		}
			break;
		case R.id.buttonHelp:
			this.setContentView(R.layout.activity_correct);
			break;
		}

	}

}
