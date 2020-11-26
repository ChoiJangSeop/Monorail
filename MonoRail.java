package MonoRail;

// -1 : wall, 0 : disconnect, 1 : connect, 2 : None
// 이페이지는 전부 2019310036 최장섭 학생이 작성


class Tile {
	
	int label = -1;
	
	int up = 2;
	int down = 2;
	int left = 2;
	int right = 2;
	
	//Tile t_up = new Tile();
	//Tile t_down = new Tile();
	//Tile t_left = new Tile();
	//Tile t_right = new Tile();
	
	
	int[] position = new int[2];
	static Tile[][] pos_board = new Tile[17][11];
	
	
	
	Tile() {

	}
	
	boolean Connectable() {
		boolean result = true;
		
		Tile LTile = pos_board[position[0]-1][position[1]];
		Tile RTile = pos_board[position[0]+1][position[1]];
		Tile UTile = pos_board[position[0]][position[1]-1];
		Tile DTile = pos_board[position[0]][position[1]+1];
		
		
		if (position[1] > 0 && UTile != null && up + UTile.down == -1)
			result = false;
		if (position[1] < 10 && DTile != null && down + DTile.up == -1)
			result = false;
		if (position[0] > 0 && LTile != null && left + LTile.right == -1)
			result = false;
		if (position[0] < 16 && RTile != null && right + RTile.left == -1)
			result = false;
		
		if (result == true) {
			if (position[1] > 0 && UTile != null && up + UTile.down == 0) {
				UTile.down = 1; 
				up = 1;
				System.out.println(position[0] + " " + position[1] + " -- " + UTile.position[0] + " " + UTile.position[1]);
			}
			
				
			if (position[1] < 10 && DTile != null && down + DTile.up == 0) {
				DTile.up = 1;
				down = 1;
				System.out.println(position[0] + " " + position[1] + " -- " + DTile.position[0] + " " + DTile.position[1]);
			}
			
			
			if (position[0] > 0 && LTile != null && left + LTile.right == 0) {
				LTile.right = 1; 
				left = 1;
				System.out.println(position[0] + " " + position[1] + " -- " + LTile.position[0] + " " + LTile.position[1]);
			}
			
			if (position[0] < 16 && RTile != null && right + RTile.left == 0) {
				RTile.left = 1; 
				right = 1;
				System.out.println(position[0] + " " + position[1] + " -- " + RTile.position[0] + " " + RTile.position[1]);
			}
		}
		
		return result;
		
	}
	
	void seePosBoard() {
		for (int i=0; i<11; i++) {
			for (int j=0; j<17; j++) {
				if (pos_board[j][i] == null)
					System.out.print("0 ");
				else
					System.out.print("1 ");
			}
			System.out.println();
		}
	}
	
	boolean isAllConnect() {
		
		boolean result = true;
		
		for (int i=0; i<11; i++) {
			for (int j=0; j<17; j++) {
				System.out.println(j + " " + i);
				if (pos_board[j][i] == null) {}
				else {
					
					if (pos_board[j][i].up == 0 ) {
						result = false;
						System.out.println(j + " " + i + " up");
						break;
					}
					if (pos_board[j][i].down == 0 ) {
						result = false;
						System.out.println(j + " " + i + " down");
						break;
					}
					if (pos_board[j][i].left == 0 ) {
						result = false;
						System.out.println(j + " " + i + " left");
						break;
					}
					if (pos_board[j][i].right == 0 ) {
						result = false;
						System.out.println(j + " " + i + " right");
						break;
					}	
				}
			}
			if (result == false) { break; }
		}
		
		return result;
	}
	
	
}

class UpDown extends Tile {
	
	UpDown() {
		this.left = -1;
		this.right = -1;
		this.up = 0;
		this.down = 0;
		label = 1;
	}
	UpDown(int x, int y) {
		
		this.left = -1;
		this.right = -1; 
		this.up = 0;
		this.down = 0;
		label = 1;
		position[0] = x;
		position[1] = y;
		pos_board[x][y] = this;
	}
}

class LeftRight extends Tile {
	
	LeftRight() {
		this.up = -1;
		this.down = -1;
		this.left = 0;
		this.right = 0;
		label = 0;
	}
	LeftRight(int x, int y) {
		
		this.up = -1;
		this.down = -1; 
		this.left = 0;
		this.right = 0;
		
		label = 0;
		position[0] = x;
		position[1] = y;
		pos_board[x][y] = this;
	}
}

class UpLeft extends Tile {
	
	UpLeft() {
		this.down = -1;
		this.right = -1;
		this.up = 0;
		this.left = 0;
		label = 3;
	}
	UpLeft(int x, int y) {
		
		this.down = -1;
		this.right = -1; 
		this.up = 0;
		this.left = 0;
		
		label = 3;
		position[0] = x;
		position[1] = y;
		pos_board[x][y] = this;
	}
}

class UpRight extends Tile {
	
	UpRight() {
		this.down = -1;
		this.left = -1;
		this.up = 0;
		this.right = 0;
		
		label = 2;
	}
	
	UpRight(int x, int y) {
		
		this.down = -1;
		this.left = -1; 
		this.up = 0;
		this.right = 0;
		
		label = 2;
		position[0] = x;
		position[1] = y;
		pos_board[x][y] = this;
	}
}

class DownLeft extends Tile {
	
	DownLeft() {
		this.up = -1;
		this.right = -1;
		this.down = 0;
		this.left = 0;
		
		label = 4;
	}
	
	DownLeft(int x, int y) {
		
		this.up = -1;
		this.right = -1; 
		this.down = 0;
		this.left = 0;
		
		label = 4;
		position[0] = x;
		position[1] = y;
		pos_board[x][y] = this;
	}
}

class DownRight extends Tile {
	
	DownRight() {
		this.up = -1;
		this.left = -1;
		this.down = 0;
		this.right = 0;
		
		label = 5;
	}
	
	DownRight(int x, int y) {
		
		this.up = -1;
		this.left = -1; 
		this.down = 0;
		this.right = 0;
		
		label = 5;
		position[0] = x;
		position[1] = y;
		pos_board[x][y] = this;
	}
}

class TileSet {
	
	Tile[] TSet = new Tile[3];
	int num = 0;
	
	TileSet() {}
	
	void push_tile(Tile t) {
		TSet[num] = t;
		num++;
	}
	
	
	boolean is_one_line() {
		boolean result = true;
		
		if (num == 2) {
			int x_diff = TSet[0].position[0] - TSet[1].position[0];
			int y_diff = TSet[0].position[1] - TSet[1].position[1];
			
			if (x_diff == 0) {
				if (y_diff != 1 && y_diff != -1)
					result = false;
			}
			else if (x_diff == 1 || x_diff == -1) {
				if (y_diff != 0)
					result = false;
			}
			else if (y_diff == 0) {
				if (x_diff != 1 && x_diff != -1)
					result = false;
			}
			else if (y_diff == 1 || y_diff == -1) {
				if (x_diff != 0)
					result = false;
			}
			else { result = false; }
			
		}
		
		if (num == 3) {
			int x_diff = TSet[0].position[0] - TSet[1].position[0];
			int y_diff = TSet[0].position[1] - TSet[1].position[1];
			
			if (x_diff == 0) {
				
				int y_diff0 = TSet[2].position[1] - TSet[0].position[1];
				int y_diff1 = TSet[2].position[1] - TSet[1].position[1];
				
				if (TSet[2].position[0] != TSet[0].position[0]) { result = false; }
				else if (y_diff == 1 || y_diff == -1) {
				
					if (y_diff0 == 1 || y_diff0 == -1) {}
					else if (y_diff1 == 1 || y_diff1 == -1) {}
					else { result = false; }
				}
					
				else if (y_diff == 2) {
					if (y_diff0 != 1) { result = false; }
				}
				else if (y_diff == -2) {
					if (y_diff1 != 1) { result = false; }
				}
				else { result = false; }
			}
			
			if (y_diff == 0) {
				
				int x_diff0 = TSet[2].position[0] - TSet[0].position[0];
				int x_diff1 = TSet[2].position[0] - TSet[1].position[0];
				
				if (TSet[2].position[1] != TSet[0].position[1]) { result = false; }
				else if (x_diff == 1 || x_diff == -1) {
				
					if (x_diff0 == 1 || x_diff0 == -1) {}
					else if (x_diff1 == 1 || x_diff1 == -1) {}
					else { result = false; }
				}
					
				else if (x_diff == 2) {
					if (x_diff0 != -1) { result = false; }
				}
				else if (x_diff == -2) {
					if (x_diff1 != -1) { result = false; }
				}
				else { result = false; }
			}
			
		}
		
		
		return result;
	}
}

class RailRoad {
	
	Tile[] Road = new Tile[16];
	int num = 0;
	RailRoad() {}
	
	void push_tile(Tile t) {
		Road[num] = t;
		num++;
	}
}

class Player {
	
	boolean isMyTurn;
	int number;
	
	Player(int n, boolean x) {
		number = n;
		isMyTurn = x;
	}
}
public class MonoRail {

}
