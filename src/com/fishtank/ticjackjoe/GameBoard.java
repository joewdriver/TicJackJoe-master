package com.fishtank.ticjackjoe;

public class GameBoard {

	//	private int [][] Tiles =  new int[3][3];
	public int [] tiles = new int[3];
	
	//constructor
	public GameBoard() {
			
		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = 0;
		}
		
	}
	
	//this function isn't really necessary since I made the tile array a public variable
	public int getTile(int coord) {
		return tiles[coord];
	}
	
	public boolean setTile(int coord, String currentPlayer) {
		if (tiles[coord] == 0) {
			
			//player 1 is X, player 2 is O... there's definitely a better way to do this
			if (currentPlayer == "X") {
				tiles[coord] = 1;
			}
			//I've changed O value from 2 to -1 to utilize the absolute values in wincheck
			else {
				tiles[coord] = -1;
			}
			return true;
		}
		
		else {
			return false;
		}
		
	}
	{
	//Checking for tie game
	if ((Math.abs(tiles[0])+Math.abs(tiles[1])+Math.abs(tiles[2])+Math.abs(tiles[3])+Math.abs(tiles[4])+Math.abs(tiles[5])+Math.abs(tiles[6])+Math.abs(tiles[7])+Math.abs(tiles[8])!=9))
		changeMessage("Tie Game!");
	//8 win conditions based on absolute values -- cannot figure out how to call the changeMethod function from Gameboard
	else if ((Math.abs(tiles[0])+Math.abs(tiles[1])+Math.abs(tiles[2]))==3) {
		changeMessage("You are the winner!");}
	else if ((Math.abs(tiles[3])+Math.abs(tiles[4])+Math.abs(tiles[5]))==3) {
		changeMessage("You are the winner!");}
	else if ((Math.abs(tiles[6])+Math.abs(tiles[7])+Math.abs(tiles[8]))==3) {
		changeMessage("You are the winner!");}		
	else if ((Math.abs(tiles[0])+Math.abs(tiles[3])+Math.abs(tiles[6]))==3) {
		changeMessage("You are the winner!");}
	else if ((Math.abs(tiles[1])+Math.abs(tiles[4])+Math.abs(tiles[7]))==3) {
		changeMessage("You are the winner!");}
	else if ((Math.abs(tiles[2])+Math.abs(tiles[5])+Math.abs(tiles[8]))==3) {
		changeMessage("You are the winner!");}	
	else if ((Math.abs(tiles[0])+Math.abs(tiles[4])+Math.abs(tiles[8]))==3) {
		changeMessage("You are the winner!");}	
	else if ((Math.abs(tiles[2])+Math.abs(tiles[4])+Math.abs(tiles[6]))==3) {
		changeMessage("You are the winner!");}
	
	}
}
