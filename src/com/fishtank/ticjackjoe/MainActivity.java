package com.fishtank.ticjackjoe;

import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


@SuppressLint("NewApi")
public class MainActivity extends Activity {

	public String currentPlayer = "X"; //declared up here so that it can be global

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final GameBoard board = new GameBoard();
		
		
		LinearLayout buttonLayout = (LinearLayout)findViewById(R.id.buttonlayout);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		
		//this is the loop that creates all the buttons
		for(int tileNum = 0; tileNum < board.tiles.length; tileNum++) {

			//declaring the attributes of the button about to be added
			Button newTile = new Button(this);
			newTile.setId(tileNum);
			newTile.setText("-");
			
			newTile.setOnClickListener(new OnClickListener(){	
				//the function that's called when the button's clicked on
				public void onClick(View v) {
					
					//the id for each button, which was set above numerically at tileNum
					int selectedTile = v.getId();
					Boolean didTileSet = board.setTile(selectedTile, currentPlayer);
					
					//if the tile was not already take
					if (didTileSet) {
						Button updateButton = (Button) findViewById(selectedTile);			
						updateButton.setText(currentPlayer);
						switchTurn();
					}
					
					else {
						changeMessage("Please pick an open tile");
					}	
				}
			});

			//where the button is actually added
			buttonLayout.addView(newTile, lp);
			
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//changes the players turn
	public void switchTurn() {
		if (currentPlayer == "X") {
			currentPlayer = "O";
		}
		else {
			currentPlayer = "X";
		}
		changeMessage("It is player " + currentPlayer + "'s turn");
	}

	//changes the message
	public void changeMessage(String newMessage) {
		TextView message = (TextView) findViewById(R.id.messageText);
		message.setText(newMessage);
	}
}
