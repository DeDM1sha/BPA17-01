package Figures;

public abstract class Figure {
	public static final String RECT = "rect";
	public static final String LINE = "line";
	public static final String ELLIPSE = "ellipse";

	private String signature;

	Figure(String signature) {
		this.signature = signature;
	}

	public String getSignature() {
		return signature;
	}

	public abstract void translate(int x, int y);
	public abstract void scale(double x, double y);
	public abstract void rotate(int degree);
}
