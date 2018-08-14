import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import outils.Stats;

public class EntityGenerator {
	/**
	 * Générateur d'entitée
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("---Enter the name of your entity---");
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine();
		System.out.println("---Enter the name of the heritaded class---");
		String extended = sc.nextLine();
		System.err.println("Your class " + name + " will heritate from " + extended);
		System.out.println("---Do you want to make it abstract? (Y/N)---");
		String abstracted = sc.nextLine().equals("Y") ? " abstract" : "";
		File f = new File("D:\\Eclipse-workspace\\KyuTyr\\src\\entitees\\" + name + ".java");
		try {
			System.out.println(f.getPath());
			f.createNewFile();
			FileWriter writer = new FileWriter(f);
			writer.write("package entitees;\r\n" + 
					"\r\n" + 
					"import java.awt.Color;\r\n" + 
					"import java.awt.Graphics;\r\n" + 
					"\r\n" + 
					"import constantes.Constantes;\r\n" + 
					"\r\n" + 
					"public" + abstracted + " class " + name + " extends " + extended + " {\r\n" +  
					"	\r\n" + 
					"	public " + name + "(Stats sts) {\r\n" + 
					"		super(sts);\r\n" + 
					"	}\r\n" + 
					"	\r\n" + 
					"	@Override\r\n" + 
					"	public void draw(Graphics g) {\r\n" + 
					"	}\r\n" + 
					"\r\n" + 
					"}\r\n");
			writer.close();
			System.err.println("Done");
		} catch (IOException e) {
			System.err.println("Error in file creation");
			e.printStackTrace();
		}
	}

}
