package com.example.logogame;

import android.app.Activity;
import android.os.Bundle;

public class Wrong extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playground);
		PlaygroundActivity correct = new PlaygroundActivity();
		correct.i=0;
	}
}
