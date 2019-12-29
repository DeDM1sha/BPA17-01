import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Exception {
		Editor editor = new Editor();

		System.out.println("Введенные данные по фигурам: ");
		editor.parseFigures("figures.txt");

		System.out.println("-------------");
		System.out.println("Введенные команды: ");
		editor.parseCommands("commands.txt");
		System.out.println();

		editor.execute();
		System.out.println("-------------");
		System.out.println("Измененные фигуры: ");
		editor.save("output.txt");
	}
}
