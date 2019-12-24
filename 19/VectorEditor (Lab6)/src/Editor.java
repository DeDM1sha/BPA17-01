import Commands.Command;
import Commands.Rotate;
import Commands.Scale;
import Commands.Translate;
import Figures.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Editor {
	List<Command> commands = new ArrayList<>();
	List<Figure> figures = new ArrayList<>();

	public void parseFigures(String filename) throws Exception {
		Scanner scanner = new Scanner(new File(filename));
		while (scanner.hasNextLine()) {
			String figureSignature = scanner.next();
			String[] args = scanner.nextLine().trim().split(" ");
			System.out.println(Arrays.asList(args));
			for (Figure figure : figures) {
				if (figure.getSignature().equals(figureSignature)) {
					throw new Exception("Element already exist");
				}
			}

			if (figureSignature.contains(Figure.RECT)) {
				Point fPoint = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
				Point sPoint = new Point(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
				figures.add(new Rect(figureSignature, fPoint, sPoint));
			} else if (figureSignature.contains(Figure.LINE)) {
				Point fPoint = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
				Point sPoint = new Point(Integer.parseInt(args[2]), Integer.parseInt(args[3]));
				figures.add(new Line(figureSignature, fPoint, sPoint));
			} else if (figureSignature.contains(Figure.ELLIPSE)) {
				Point fPoint = new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
				int widthRadius = Integer.parseInt(args[2]);
				int heightRadius = Integer.parseInt(args[3]);
				figures.add(new Ellipse(figureSignature, fPoint, widthRadius, heightRadius));
			} else {
				throw new Exception();
			}
		}
	}

	public void parseCommands(String filename) throws Exception {
		Scanner scanner = new Scanner(new File(filename));
		while (scanner.hasNextLine()) {
			String command = scanner.next();
			String[] args = null;
			try {
				args = scanner.nextLine().trim().split(" ");
			} catch (NoSuchElementException ignored) {}

			switch (command) {
				case Command.TRANSLATE:
					commands.add(new Translate(figures, args));
					break;
				case Command.SCALE:
					commands.add(new Scale(figures, args));
					break;
				case Command.ROTATE:
					commands.add(new Rotate(figures, args));
					break;
				case Command.UNDO:
					commands.get(commands.size() - 1).undo();
					break;
				default:
					throw new Exception();
			}
		}
	}

	public void execute() {
		for (Command command : commands) {
			command.execute();
		}
	}

	public void save(String filename) {
		FileWriter writer;
		try {
			writer = new FileWriter(filename, false);

			for (Figure figure : figures) {
				writer.write(figure.toString() + "\n");
			}

			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
