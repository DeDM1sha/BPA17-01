package Commands;


import Figures.Figure;

import java.util.Arrays;
import java.util.List;

public class Rotate extends Command {
	private List<Figure> figures;
	private Figure figure;
	private int degree;

	public Rotate(List<Figure> figures, String... args) {
		this.figures = figures;
		System.out.println(Arrays.asList(args));
		if (args != null) {
			if (args.length == 2) {
				this.figure = getFigure(figures, args[0]);
				this.degree = Integer.parseInt(args[1]);
			} else if (args.length == 1) {
				this.degree = Integer.parseInt(args[0]);
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
			String degree = -this.degree + "";
			for (Figure figure : figures) {
				new Rotate(figures, figure.getSignature(), degree).execute();
			}
		} else {
			figure.rotate(-this.degree);
		}
	}

	@Override
	public void execute() {
		if (figure == null) {
			String degree = this.degree + "";
			for (Figure figure : figures) {
				new Rotate(figures, figure.getSignature(), degree).execute();
			}
		} else {
			figure.rotate(this.degree);
		}
	}
}
