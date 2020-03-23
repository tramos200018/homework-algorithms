package hwCode;

import java.util.ArrayList;
import java.util.Collections;

public class OutputText {

	ArrayList<BlockRep> rotations = new ArrayList<BlockRep>(); // list of rotations for each block
	ArrayList<BlockRep> tower = new ArrayList<BlockRep>(); // tower of blocks for output

	// produces output text and takes in arrayList of blocks
	public void outputText(ArrayList<BlockRep> l) {

		int ans = 0;

		for (int i = 0; i < l.size(); i++) {

			BlockRep current = l.get(i);

			// original block
			rotations.add(new BlockRep(Math.max(current.length, current.width), Math.min(current.length, current.width),
					current.height));

			// first rotation
			rotations.add(new BlockRep(Math.max(current.height, current.width), Math.min(current.height, current.width),
					current.length));

			// second rotation
			rotations.add(new BlockRep(Math.max(current.height, current.length),
					Math.min(current.height, current.length), current.width));
		}

		Collections.sort(rotations);

		int rotSize = rotations.size();

		// array for different tower sizes
		int[] heights = new int[rotSize];

		// add all heights of blocks
		for (int i = 0; i < rotSize; i++)
			heights[i] = rotations.get(i).height;

		// pointers
		BlockRep towerB = null;
		BlockRep remove = null;
		BlockRep block = null;
		BlockRep prevBlock = null;

		// DP for finding max height
		for (int i = 0; i < rotSize; i++) {
			heights[i] = 0;
			block = rotations.get(i);
			int val = 0;

			for (int j = 0; j < i; j++) {
				prevBlock = rotations.get(j);
				// if length and width of block is less than prevBlock, value is max between
				// itself and new height and set pointers to respective blocks
				if (block.length < prevBlock.length && block.width < prevBlock.width) {
					val = Math.max(val, heights[j]);
					towerB = block;
					remove = prevBlock;
				}

			}
			// add potential height to array
			heights[i] = val + block.height;
			tower.add(towerB);
			tower.remove(remove);

		}

		// find max height and return it
		for (int i = 0; i < rotSize; i++) {
			ans = Math.max(ans, heights[i]);
		}

		// output text
		System.out.println("The tallest tower has " + tower.size() + " blocks and a height of " + ans);
		System.out.println();
		System.out.println(tower.size());

		for (int i = 1; i < tower.size(); i++)
			System.out.println(tower.get(i));

	}
}
