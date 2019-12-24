package Figures;

public class Ellipse extends Figure {
	private Point center;
	private int widthRadius;
	private int heightRadius;

	public Ellipse(String signature, Point center, int widthRadius, int heightRadius) {
		super(signature);
		this.center = center;
		this.widthRadius = widthRadius;
		this.heightRadius = heightRadius;
	}

	@Override
	public void translate(int x, int y) {
		center.translate(x, y);
	}

	@Override
	public void scale(double x, double y) {
		widthRadius *= x;
		heightRadius *= y;
	}

	@Override
	public void rotate(int degree) {
		center.rotate(degree);
	}

	@Override
	public String toString() {
		return getSignature() + " " + center.getX() + " " + center.getY() + " " + widthRadius + " " + heightRadius;
	}
}
