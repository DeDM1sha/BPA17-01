package Figures;

public class Rect extends Figure {
	private Point fPoint;
	private Point sPoint;

	public Rect(String signature, Point fPoint, Point sPoint) {
		super(signature);
		this.fPoint = fPoint;
		this.sPoint = sPoint;
	}

	@Override
	public void translate(int x, int y) {
		fPoint.translate(x, y);
		sPoint.translate(x, y);
	}

	@Override
	public void scale(double x, double y) {
		fPoint.scale(x, y);
		sPoint.scale(x, y);
	}

	@Override
	public void rotate(int degree) {
		fPoint.rotate(degree);
		sPoint.rotate(degree);
	}

	@Override
	public String toString() {
		return getSignature() + " " + fPoint.getX() + " " + fPoint.getY() + " " + sPoint.getX() + " " + sPoint.getY();
	}
}
