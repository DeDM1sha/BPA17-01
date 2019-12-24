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
		this.x = this.x * Math.cos(degree) - this.y * Math.sin(degree);
		this.y = this.x * Math.sin(degree) + this.y * Math.cos(degree);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}
