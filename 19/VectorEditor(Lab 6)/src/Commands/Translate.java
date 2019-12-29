package Commands;

import Figures.Figure;

import java.util.List;

public class Translate extends Command {
	private List<Figure> figures;
	private Figure figure;
	private Integer translateX;
	private Integer translateY;

	public Translate(List<Figure> figures, String... args) {
		this.figures = figures;
		if (args != null) {
			if (args.length == 3) {
				this.figure = getFigure(figures, args[0]);
				this.translateX = Integer.parseInt(args[1]);
				this.translateY = Integer.parseInt(args[2]);
			} else if (args.length == 2) {
				this.translateX = Integer.parseInt(args[0]);
				this.translateY = Integer.parseInt(args[1]);
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
			String translateX = -this.translateX + "";
			String translateY = -this.translateY + "";
			for (Figure figure : figures) {
				new Translate(figures, figure.getSignature(), translateX, translateY).execute();
			}
		} else {
			figure.translate(-this.translateX, -this.translateY);
		}
	}

	@Override
	public void execute() {
		if (figure == null) {
			String translateX = this.translateX.toString();
			String translateY = this.translateY.toString();
			for (Figure figure : figures) {
				new Translate(figures, figure.getSignature(), translateX, translateY).execute();
			}
		} else {
			figure.translate(this.translateX, this.translateY);
		}
	}

	@Override
	public String toString() {
		return "translate " + figure.getSignature() + " " + translateX + " " + translateY;
	}
}
