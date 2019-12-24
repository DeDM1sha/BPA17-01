import java.io.IOException;

public class Main {

	public static void main(String[] args) throws Exception {
		Editor editor = new Editor();
		editor.parseFigures("figures.txt");
		editor.parseCommands("commands.txt");
		editor.execute();
		editor.save("output.txt");
	}
}
