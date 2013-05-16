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
	int j = 0;
	int k = 0;
	Button button;
	EditText inputAns;
	int count = 0;
	int set[] = new int[10];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.playground);
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

	/*
	 * public void setIni() { set[0][0] = 3; set[0][1] = 2; set[0][2] = 5;
	 * set[0][3] = 1; set[0][4] = 4; set[0][5] = 6; set[0][6] = 9; set[0][7] =
	 * 7; set[0][8] = 0; set[0][9] = 8;
	 * 
	 * set[1][0] = 0; set[1][1] = 5; set[1][2] = 9; set[1][3] = 7; set[1][4] =
	 * 3; set[1][5] = 1; set[1][6] = 2; set[1][7] = 8; set[1][8] = 6; set[1][9]
	 * = 4;
	 * 
	 * set[2][0] = 1; set[2][1] = 2; set[2][2] = 3; set[2][3] = 4; set[2][4] =
	 * 5; set[2][5] = 6; set[2][6] = 7; set[2][7] = 8; set[2][8] = 9; set[2][9]
	 * = 0;
	 * 
	 * }
	 */

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
			} else if (b.equalsIgnoreCase("Next")) {
				img2.setVisibility(View.GONE);
				button.setText("Check");
				inputAns.setText("");
				i = (int) (Math.random() * 10);

				if (i != set[0] && i != set[1] && i != set[2] && i != set[3] && i != set[4] && i != set[5] && i != set[6] && i != set[7]
						&& i != set[8] && i != set[9]) {
					this.displayImage(i);
				}

				set[k] = i;

				k = k + 1;
				count++;
				
			} else if (b.equalsIgnoreCase("Try Again")) {
				img2.setVisibility(View.GONE);
				button.setText("Check");
				inputAns.setText("");

			}
			else if(count==10){
				this.setContentView(R.layout.gameover);
			}

			break;

		}

	}
}
