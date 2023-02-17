/*
 * Guizhi Xu
 * CWID: 20008770
 * */

package Maze;

public class PairInt {
	// Data Fields which represent coordinates including x and y. //
	private int x;
	private int y;

	// Set up a constructor //
	public PairInt(int x, int y) {

		this.x = x;
		this.y = y;
	}

	// Return Coordiniate y //

	public int getX() {

		return this.x;
	}

	// Return Coordiniate y //
	public int getY() {
		return this.y;
	}

	// Set the value of Coordinate x //
	public void setX(int x) {

		this.x = x;
	}

	// Set the value of Coordinate y //
	public void setY(int y) {

		this.y = y;
	}

	// Compare the object with Object p, and it will return true or false //

	public boolean equals(Object p) {
		// if p is not the tpye of PairInt or p is null, return false. //
		if (p == null || !(p instanceof PairInt))
			return false;

		PairInt pairint = (PairInt) p;
		return this.x == pairint.x && this.y == pairint.y;

	}

	public String toString() {

		return "(" + this.x + "," + this.y + ")";
	}

	// Return a new copy of a PairInt //
	public PairInt copy() {
		return new PairInt(this.x, this.y);
	}
}
