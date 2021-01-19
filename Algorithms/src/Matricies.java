import javax.sound.midi.SysexMessage;
import java.util.*;

public class Matricies {

	public static void main(String[] args) {

		Matricies matricies = new Matricies();

		int mat[][] = { { 4, 0, 0, 0 }, { 0, 7, 0, 0 }, { 0, 0, 5, 0 }, { 0, 0, 1, 1 } };
		System.out.println("\nis this a diaganol matrix? ");
		matricies.printIntArrayMatricy(mat);

		if (matricies.isDiagonalMatrix(mat, 4)) {
			System.out.println("Yes\n");
		} else {
			System.out.println("No\n");
		}
		System.out.println("Rotate Clockwise");
		matricies.rotateNewClockwise(mat);
		System.out.println("\nRotate CounterClickwise");
		matricies.rotateNewCounterClockwise(mat);
		System.out.println("");

		int[][] hourGlassArray = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0, 0 },
				{ 0, 0, 2, 4, 4, 0 }, { 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
		int[][] hourGlassArray2 = { { -9, -9, -9, 1, 1, 1 }, { 0, -9, 0, 4, 3, 2 }, { -9, -9, -9, 1, 2, 3 },
				{ 0, 0, 8, 6, 6, 0 }, { 0, 0, 0, -2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };
		System.out.println("Largest sum of Hour glass = " + matricies.hourGlass(hourGlassArray2));

		/** ROTATE MATRIX counter clockwise */
		System.out.println("\nRotate matrix");
		int matty[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int N = 4;

		matricies.printIntArrayMatricy(matty);
		matricies.rotateMatrix(N, matty);

		matricies.rotateImage();

		matricies.staircase(5);

		List<List<Integer>> diagonalDiff = new ArrayList();
		diagonalDiff.add(new ArrayList<Integer>(Arrays.asList(11, 2, 4)));
		diagonalDiff.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
		diagonalDiff.add(new ArrayList<Integer>(Arrays.asList(10, 8, -12)));
		System.out.println("\nDiff of Diagonal matrix");
		matricies.printIntListMatricy(diagonalDiff);
		System.out.println("Diff of Diagonal matrix Resule -> 11+5+-12=4 and 4+5+10=19 = "
				+ matricies.diagonalDifference(diagonalDiff));

		matricies.setToZero();

		matricies.rotateClockwise(matty);
	}

	public void printIntListMatricy(List<List<Integer>> thisList) {
		for (int i = 0; i < thisList.size(); i++) {
			for (int j = 0; j < thisList.get(i).size(); j++) {
				System.out.print(thisList.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public void printIntArrayMatricy(int[][] mat) {
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
	// by 90 degrees in counter-clockwise direction
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
		printIntArrayMatricy(mat);

	}

	public void rotateClockwise(int[][] matrix) {
		int n = matrix.length;
		int temp = 0;
		System.out.println("New rotate");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < n/2; ++i) {
			for (int j = i; j < n-1-i; ++j) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = tmp;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
		
		/** https://www.youtube.com/watch?v=SA867FvqHrM */
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n/2; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = temp;
			}
		}
		System.out.println();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + ", ");
			}
			System.out.println();
		}
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

	/**
	 * Return the difference between the difference of left to right diagonal and
	 * right to left diagonal
	 */
	public int diagonalDifference(List<List<Integer>> arr) {

		int leftToRight = 0, rightToLeft = 0;

		for (int i = 0; i < arr.size(); i++) {

			for (int j = 0; j < arr.size(); j++) {

				if (i == j) {
					leftToRight += arr.get(i).get(j);
				}

				if (j + i == arr.size() - 1) {
					rightToLeft += arr.get(i).get(j);
				}
			}
		}
		return Math.abs(leftToRight - rightToLeft);
	}

	/**
	 * If an element in an MxN matrix is zero, set entire row and column of that
	 * position to all zeros.
	 */
	public void setToZero() {

		int[][] uhh = { { 2, 2, 3, 4, 5 }, { 4, 5, 6, 7, 8 }, { 2, 0, 3, 5, 6 }, { 3, 4, 5, 4, 3 }, { 2, 3, 7, 0, 9 } };
		boolean[] col = new boolean[uhh.length];
		boolean[] row = new boolean[uhh.length];

		System.out.println("\nOriginal - If Number is Zero, Set All in Column And Row to Zero!");

		for (int m = 0; m < uhh.length; m++) {

			for (int n = 0; n < uhh.length; n++) {
				if (uhh[m][n] == 0) {
					row[m] = true;
					col[n] = true;
				}
				System.out.print(uhh[m][n] + " ");
			}
			System.out.println();
		}

		System.out.println("Result - If Number is Zero, Set All in Column And Row to Zero!");
		int a, b = 0;

		for (a = 0; a < uhh.length; a++) {

			if (row[a]) {
				for (b = 0; b < uhh.length; b++) {
					uhh[a][b] = 0;
					System.out.print(uhh[a][b] + " ");
				}
			} else {
				for (int c = 0; c < uhh.length; c++) {
					if (col[c]) {
						uhh[a][c] = 0;
						System.out.print(uhh[a][c] + " ");
					} else {
						System.out.print(uhh[a][c] + " ");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	public void rotateNewClockwise(int[][] mat) {

		int N = mat.length;
		// Transpose the matrix
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		// swap columns
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N / 2; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][N - j - 1];
				mat[i][N - j - 1] = temp;
			}
		}
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j]+", ");
			}
			System.out.println();
		}
	}

	public void rotateNewCounterClockwise(int[][] mat) {
		final int N = mat.length;

		// Transpose the matrix
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				// swap mat[i][j] with mat[j][i]
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		// swap rows
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N; j++) {
				// swap mat[i][j] with mat[N-i-1][j]
				int temp = mat[i][j];
				mat[i][j] = mat[N-i-1][j];
				mat[N-i-1][j] = temp;
			}
		}
		for(int i = 0; i < mat.length; i++) {
			for(int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j]+", ");
			}
			System.out.println();
		}
	}

}
