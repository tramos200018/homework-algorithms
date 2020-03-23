package hwCode;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Block {

	public static void main(String[] args) {
		
		Integer numOfBlocks = 0; //holder for number of blocks
		ArrayList<BlockRep> blocks = new ArrayList<BlockRep>(); // list of blocks
		
		
		

		// ask for file name
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter'in' file: ");
		String in = scanner.nextLine();

		File file = new File(in);

		try {

			Scanner s = new Scanner(file);

			numOfBlocks = s.nextInt();
			// gets each block from output file
			while (s.hasNext()) {
				blocks.add(new BlockRep(s.nextInt(), s.nextInt(), s.nextInt()));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		OutputText ans = new OutputText();
		//print out tallest tower
		ans.outputText(blocks);
	}

}
