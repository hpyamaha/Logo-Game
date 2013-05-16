package com.example.logogame;

import java.io.IOException;
import java.io.InputStream;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class PlaygroundActivity extends Activity implements OnClickListener {
	ImageView img2;
	ImageView img1;
	String ans[] = new String[10];
	int i = 0;
	Button button;
	EditText inputAns;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playground);
		// Show the Up button in the action bar.
		setupActionBar();
		img1 = (ImageView) findViewById(R.id.img1);
		img2 = (ImageView) findViewById(R.id.imd2);
		button = (Button) findViewById(R.id.buttonCheck);
		inputAns = (EditText) findViewById(R.id.inputAns);
		ans[0] = "Facebook";
		ans[1] = "American Eagle";
		ans[2] = "Ebay";
		ans[3] = "BP";
		ans[4] = "MySpace";
		ans[5] = "Expedia";
		ans[6] = "Fox";
		ans[7] = "Pantene";
		ans[8] = "Corvette";
		ans[9] = "Chanel";

		this.displayImage(i);
		button.setOnClickListener(this);
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.playground, menu);
		return true;
	}

	/**
	 * will display an image i
	 * 
	 * @param i
	 */
	private void displayImage(int index) {
		InputStream bitmap1 = null;
		try {
			bitmap1 = this.getAssets().open(index + ".png");
			Bitmap bit1 = BitmapFactory.decodeStream(bitmap1);

			img1.setImageBitmap(bit1);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bitmap1 != null) {
				try {
					bitmap1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void onClick(View arg0) {

		switch (arg0.getId()) {
		case R.id.buttonHome:
			this.setContentView(R.layout.main);
			break;

		case R.id.buttonCheck:
			String b = button.getText().toString();
			if (b.equalsIgnoreCase("Check")) {
				img2.setVisibility(View.VISIBLE);
				if (ans[i].equalsIgnoreCase(inputAns.getText().toString())) {

					img2.setImageResource(R.drawable.tickmark);
					button.setText("Next");
				} else {

					img2.setImageResource(R.drawable.crossmark);
					button.setText("Try Again");

				}
			}

			else if (b.equalsIgnoreCase("Next")) {
				img2.setVisibility(View.GONE);
				button.setText("Check");
				inputAns.setText("");
				i++;
				this.displayImage(i);
			} else if (b.equalsIgnoreCase("Try Again")) {
				img2.setVisibility(View.GONE);
				button.setText("Check");
				inputAns.setText("");
				
			}
			break;

		}

	}
}
