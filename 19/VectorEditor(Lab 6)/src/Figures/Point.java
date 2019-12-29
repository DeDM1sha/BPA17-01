package Figures;

public class Point {
	private double x;
	private double y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void translate(int x, int y) {
		this.x += x;
		this.y += y;
	}

	public void scale(double x, double y) {
		this.x *= x;
		this.y *= y;
	}

	public void rotate(int degree) {
		this.x = this.x * Math.cos(Math.toRadians(degree)) - this.y * Math.sin(Math.toRadians(degree));
		this.y = this.x * Math.sin(Math.toRadians(degree)) + this.y * Math.cos(Math.toRadians(degree));
	}

	public int getX() {
		return (int) Math.round(x);
	}

	public int getY() {
		return (int) Math.round(y);
	}
}
