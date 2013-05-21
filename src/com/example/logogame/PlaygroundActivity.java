package com.example.logogame;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PlaygroundActivity extends Activity implements OnClickListener {
	ImageView img2;
	ImageView img1;
	Button Home;
	ImageButton buttonHint;
	int wc = 0;
	int i = 0;
	int j = 0;
	int k = 0;
	Button button;
	EditText inputAns;
	int count = 0;
	int set[] = new int[10];
	List<Question> questions = new ArrayList<Question>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.playground);
		// Show the Up button in the action bar.
		setupActionBar();

		img1 = (ImageView) findViewById(R.id.img1);
		img2 = (ImageView) findViewById(R.id.img2);
		button = (Button) findViewById(R.id.buttonCheck);
		inputAns = (EditText) findViewById(R.id.inputAns);
		buttonHint = (ImageButton) findViewById(R.id.buttonHint);
		Home = (Button) findViewById(R.id.buttonHome);

		questions.add(new Question("Facebook", "FB", "0.png", " It is a Social website"));
		questions.add(new Question("American Eagle", null, "1.png", "It is a clothing and accessories retailer"));
		questions.add(new Question("Ebay", null, "2.png", "It is a online shopping site"));
		questions.add(new Question("BP", "Bharat Petroleum", "3.png", "It is a petroleum company"));
		questions.add(new Question("MySpace", null, "4.png", "It is a social networking site"));
		questions.add(new Question("Expedia", null, "5.png", "It is an Internet-based travel website company"));
		questions.add(new Question("Fox", null, "6.png", "It is a Broadcasting company"));
		questions.add(new Question("Pantene", null, "7.png", "It is a famous shampoo company"));
		questions.add(new Question("Corvette", null, "8.png", "It is a famous car company"));
		questions.add(new Question("Chanel", null, "9.png", "It  is a high fashion brand"));

		this.displayImage(i);
		button.setOnClickListener(this);
		buttonHint.setOnClickListener(this);
		Home.setOnClickListener(this);
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
			bitmap1 = this.getAssets().open(questions.get(index).filename);
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
			Intent intent = new Intent(this, MainActivity.class);
			this.startActivity(intent);

			break;

		case R.id.buttonHint: {
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Hint");
			StringBuffer err = new StringBuffer();
			err.append((questions.get(i).hint).toString());
			alertDialog.setMessage(new String(err));
			alertDialog.show();
			return;
		}

		case R.id.buttonCheck:
			String b = button.getText().toString();
			if (b.equalsIgnoreCase("Check")) {
				img2.setVisibility(View.VISIBLE);
				if (questions.get(i).answer.equalsIgnoreCase((inputAns.getText().toString()).trim())
						|| questions.get(i).answer2.equalsIgnoreCase((inputAns.getText().toString()).trim())) {
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

				count++;
				if (count == 10) {

					Intent int1 = new Intent(this, GameoverActivity.class);
					this.startActivity(int1);

				}

				questions.remove(i);
				i = (int) (Math.random() * 10) % questions.size();

				this.displayImage(i);

			}

			else if (b.equalsIgnoreCase("Try Again")) {
				img2.setVisibility(View.GONE);
				button.setText("Check");
				inputAns.setText("");
				wc++;
				if (wc >= 3) {
					AlertDialog alertDialog2 = new AlertDialog.Builder(this).create();
					alertDialog2.setTitle("Wrong Answer");
					StringBuffer err2 = new StringBuffer();
					err2.append("The Correct Answer is " + (questions.get(i).answer).toString() + " or "
							+ (questions.get(i).answer2).toString());
					alertDialog2.setMessage(new String(err2));
					alertDialog2.show();
					inputAns.setText(questions.get(i).answer);
					button.setText("Next");
					return;

				}

			}

			break;

		}

	}
}
