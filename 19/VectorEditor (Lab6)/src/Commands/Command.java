package Commands;


import Figures.Figure;

import java.util.List;
import java.util.NoSuchElementException;

public abstract class Command {
	public static final String TRANSLATE = "translate";
	public static final String ROTATE = "rotate";
	public static final String SCALE = "scale";
	public static final String UNDO = "undo";

	public Figure getFigure(List<Figure> figures, String signature) {
		for (Figure figure : figures) {
			if (figure.getSignature().equals(signature)) {
				return figure;
			}
		}

		throw new NoSuchElementException("Figures.Figure with signature '" + signature + "' is not initialized");
	}

	public abstract void undo();

	public abstract void execute();
}