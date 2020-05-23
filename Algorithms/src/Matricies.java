
public class Matricies {

	public static void main(String[] args) {

		Matricies matricies = new Matricies();

		int mat[][] = { { 4, 0, 0, 0 }, { 0, 7, 0, 0 }, { 0, 0, 5, 0 }, { 0, 0, 1, 1 } };
		System.out.println("\nis this a diaganol matrix? ");
		matricies.printIntMatricy(mat);

		if (matricies.isDiagonalMatrix(mat, 4)) {
			System.out.println("Yes\n");
		} else {
			System.out.println("No\n");
		}

		int[][] hourGlassArray = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 2, 4, 4, 0 }, { 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
		int[][] hourGlassArray2 = { { -9, -9, -9, 1, 1, 1 }, { 0, -9, 0, 4, 3, 2 }, { -9, -9, -9, 1, 2, 3 },
				{ 0, 0, 8, 6, 6, 0 }, { 0, 0, 0, -2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
		System.out.println("Largest sum of Hour glass = " + matricies.hourGlass(hourGlassArray2));

		/** ROTATE MATRIX counter clockwise */
		System.out.println("\nRotate matrix");
		int matty[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int N = 4;

		matricies.printIntMatricy(matty);
		matricies.rotateMatrix(N, matty);

		matricies.rotateImage();
		
		matricies.staircase(5);

	}

	public void printIntMatricy(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + ", ");
			}
			System.out.println();
		}
	}

	/** Returns true if is a diagonal matrix */
	public boolean isDiagonalMatrix(int mat[][], int N) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i != j) && (mat[i][j] != 0)) {
					return false;
				}
			}
		}
		return true;
	}

	/** Return highest sum with an hour glass shape */
	public int hourGlass(int[][] hourGlass) {

		int currentSum = 0, highestSum = 0;

		for (int i = 0; i < hourGlass.length - 2; i++) {
			for (int j = 0; j < hourGlass.length - 2; j++) {

				currentSum += hourGlass[i][j];
				currentSum += hourGlass[i][j + 1];
				currentSum += hourGlass[i][j + 2];
				currentSum += hourGlass[i + 1][j + 1];
				currentSum += hourGlass[i + 2][j];
				currentSum += hourGlass[i + 2][j + 1];
				currentSum += hourGlass[i + 2][j + 2];

				if (currentSum > highestSum) {
					highestSum = currentSum;
				}
				currentSum = 0;
			}
		}
		return highestSum;
	}

	// An Inplace function to rotate a N x N matrix
	// by 90 degrees in anti-clockwise direction
	public void rotateMatrix(int N, int mat[][]) {

		// Consider all squares one by one
		for (int x = 0; x < N / 2; x++) {

			// Consider elements in group of 4 in
			// current square
			for (int y = x; y < N - x - 1; y++) {

				// store current cell in temp variable
				int temp = mat[x][y];

				// move values from right to top
				mat[x][y] = mat[y][N - 1 - x];

				// move values from bottom to right
				mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];

				// move values from left to bottom
				mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];

				// assign temp to left
				mat[N - 1 - y][x] = temp;
			}
		}
		
		System.out.println("Rotate matrix Result");
		printIntMatricy(mat);

	}

	/**
	 * Given an image represented by an NxN matrix, where each pixel in the image is
	 * 4 bytes. This function rotates the image by 90 degrees.
	 */

	/**
	 * NOTES - first loop, (for i = 0; i < len/2; i++) i = first, last = len-1-i
	 * 
	 * second loop, for(j = first; j < last; ++j) offset = j-first;
	 * 
	 * SAVE top left top left = bottom left bottom left = bottom right, etc
	 */
	public void rotateImage() {

		int[][] hey = new int[8][8];
		int length = hey.length;

		System.out.println("\nOriginal Image to Rotate");
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				hey[i][j] = j;
				System.out.print(hey[i][j] + ", ");
			}
			System.out.println();
		}

		System.out.println("Reversed Image");

		for (int i = 0; i < length / 2; i++) {

			int first = i;
			int last = length - 1 - i;

			for (int j = first; j < last; ++j) {

				int offset = j - first;

				// save top left
				int top = hey[first][j];

				// top left = bottom left
				hey[first][j] = hey[last - offset][first];

				// bottom left = bottom right
				hey[last - offset][first] = hey[last][last - offset];

				// bottom right = top right
				hey[last][last - offset] = hey[j][last];

				// top right = top left
				hey[j][last] = top;

				// System.out.println("TL: "+hey[first][j]+ ", BL: "+hey[last-offset][first]+ ",
				// BR: "+hey[last][last-offset]+ ", TR: "+hey[j][last]+ ", OFFSET: "+offset);
			}
			// System.out.println();
		}

		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(hey[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	/** Print staircase, given staircase size */
	public void staircase(int n) {

		System.out.println("\nPrinting staircase of size " + n);
		for (int i = 0; i < n; i++) {

			int spaces = n - i;
			while (spaces > 0) {
				System.out.print(" ");
				spaces--;
			}

			int stairs = i;
			while (stairs >= 0) {
				System.out.print("#");
				stairs--;
			}
			System.out.println();
		}
	}
}
