package Commands;

import Figures.Figure;

import java.util.Arrays;
import java.util.List;

public class Scale extends Command {
	private List<Figure> figures;
	private Figure figure;
	private Double scaleX;
	private Double scaleY;

	public Scale(List<Figure> figures, String... args) {
		this.figures = figures;
		if (args != null) {
			if (args.length == 3) {
				this.figure = getFigure(figures, args[0]);
				this.scaleX = Double.parseDouble(args[1]);
				this.scaleY = Double.parseDouble(args[2]);
			} else if (args.length == 2) {
				this.scaleX = Double.parseDouble(args[0]);
				this.scaleY = Double.parseDouble(args[1]);
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public void undo() {
		if (figure == null) {
			String scaleX = (1 / this.scaleX) + "";
			String scaleY = (1 / this.scaleY) + "";
			for (Figure figure : figures) {
				new Scale(figures, figure.getSignature(), scaleX, scaleY).execute();
			}
		} else {
			figure.scale((1 / this.scaleX), (1 / this.scaleY));
		}
	}

	@Override
	public void execute() {
		if (figure == null) {
			String scaleX = this.scaleX.toString();
			String scaleY = this.scaleY.toString();
			for (Figure figure : figures) {
				new Translate(figures, figure.getSignature(), scaleX, scaleY).execute();
			}
		} else {
			figure.scale(this.scaleX, this.scaleY);
		}
	}

	@Override
	public String toString() {
		return "scale " + figure.getSignature() + " " + scaleX + " " + scaleY;
	}
}
