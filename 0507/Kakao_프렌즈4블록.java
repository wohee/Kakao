package algo;

public class Kakao_프렌즈4블록 {
	
	static int[] dx = {0,0,1,1};
	static int[] dy = {0,1,0,1};
	static int row, col;
	
	public static void main(String[] args) {
		int m = 4;
		int n = 5;
		
		row = m;
		col = n;
		
		int answer = 0;
		String[] board = {
				"CCBDE", "AAADE", "AAABF", "CCBBF"
		};
		
		char[][] map = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = board[i].charAt(j);
			}
		}
		
		// 연속 4개가 있으면 계속 반복
ex:		while(true) {
			boolean[][] visited = new boolean[m][n];
			boolean check = false;
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					
					// 연속해서 4개가 동일한지 확인
					int num = 0;
					if(map[i][j] == '0') {
						continue;
					} else {
						for (int k = 0; k < dx.length; k++) {
							int newX = i + dx[k];
							int newY = j + dy[k];

							if(isIn(newX, newY) && map[i][j] == map[newX][newY]) {
								num++;
							}
						}
					}

					if(num == 4) {
						check = true;
						for (int k = 0; k < dx.length; k++) {
							int newX = i + dx[k];
							int newY = j + dy[k];
							
							visited[newX][newY] = true;
						}
					}
				}
			}
			
			// 연속하는 4개를 가진것은 방문했다고 표시했고
			// 그것을 0으로 바꿈
			if(check) {
				for (int i = 0; i < m; i++) {
					for (int j = 0; j < n; j++) {
						if(visited[i][j]) {
							map[i][j] = '0';
							answer++;
						}
					}
				}
			} else {
				break ex;
			}
			
			// 자리 바꿔주기
			for (int i = 0; i < n; i++) {
				int zero = 0;
				for (int j = m-1; j >= 0; j--) {
					if(map[j][i] == '0') {
						zero++;
					} else if(zero != 0) {
						map[j+zero][i] = map[j][i];
						map[j][i] = '0';
					}
				}
			}

		}
		
		System.out.println(answer);
		
	}// end of main

	private static boolean isIn(int a, int b) {
		return a >= 0 && b >= 0 && a < row && b < col;
	}

} // end of class
