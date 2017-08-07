package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/*
 * Cracking the Code problem 9.9, print all 8-Queen configurations
 */
public class Print8QueenConfigurations {

	public static int GRID_SIZE = 8;
	
	public static void main(String[] args) {
		List<Integer[]> result = get8QueenConfigurations();
		System.out.println(result.size());
		for(Integer[] res : result) {
			for(int i = 0; i < res.length; i++) {
				if (i == res.length - 1) {
					System.out.println(res[i]);
				}
				else {
					System.out.print(res[i] + ", ");
				}
			}
		}
	}
	
	public static List<Integer[]> get8QueenConfigurations() {
		List<Integer[]> result = new ArrayList<>();
		Integer[] columns = new Integer[GRID_SIZE];
		
		rec8Queen(0, columns, result);
		
		return result;
	}
	
	private static void rec8Queen(int row, Integer[] columns, List<Integer[]> result) {
		if (row == GRID_SIZE) {
			result.add(columns.clone());
			return;
		}
		else {
			for(int col = 0; col < GRID_SIZE; col++) {
				columns[row] = col;
				if(checkConfiguration(row, columns)) {
					rec8Queen(row+1, columns, result);
				}
			}
		}
	}
	
	private static boolean checkConfiguration(int row, Integer[] columns) {
		int col = columns[row];
		//Check for same column
		for(int r = 0; r < row; r++) {
			if (columns[r] == col) {
				return false;
			}
		}
		
		//Check for the diagonals
		for(int r = 0; r < row; r++) {
			int rowDistance = row - r;
			int colDistance = Math.abs(col - columns[r]);
			if (rowDistance == colDistance) {
				return false;
			}
		}
		
		return true;
	}
}
