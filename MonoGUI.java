package MonoRail;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.applet.*;



public class MonoGUI {

	public static void main(String[] args) {
		PlayMode monorail = new PlayMode();

	}

}

/* <실행 과정 설명>
 
 1. 타일을 두겠습니다를 선택  
 2. 새로 생긴 창에서 새로 놓을 타일 선택함. 타일을 선택하면 nexticon의 값이 rail에서 그 타일을 가르키는 인덱스로 바뀜.
 3. 이후 타일 선택창이 닫힌다.
 4. 그후 그타일을 어디에 둘지  선택한다.
 5. 둘곳의 버튼을 선택하면 그 버튼이 선택한 타일로 변경됨에 동시에 nexticon이 6으로 바뀐다.
 (만약 버튼을 한번 눌러서 원하는  버튼의 이미지를 바꾼다음에, 다른 버튼을 누른다면 nexticon은 6이기 때문에 예외처리가 된다. )
 
 
 
 */

class PlayMode extends JFrame{	//게임 구동 클래스
	
	JButton[] GrdBt = new JButton[188];
	JButton[] deco = new JButton[17];
	JButton Turn = new JButton();
	JButton AddTile = new JButton();
	JButton Impossible = new JButton();
	JButton complete = new JButton();
	JButton TileNum = new JButton("잔여타일 : " + 16);
	
	JButton[] imp_bt = new JButton[188];
	JButton imp_go = new JButton();
	JButton imp_end = new JButton();
	JButton imp_complete = new JButton();

	
	
	ImageIcon[] rail = new ImageIcon[6];
	ImageIcon[] t_rail = new ImageIcon[6];
	//Tile[] TList = new Tile[6];
	ImageIcon Ground;
	ImageIcon RailInputImg;
	ImageIcon ImpossibleImg;
	ImageIcon CompleteImg;
	ImageIcon P1Img;
	ImageIcon P2Img;
	
	ImageIcon ImpRailInputImg;
	ImageIcon ImpImpossibleImg;
	ImageIcon ImpCompleteImg;
	
	PutTileAction PutTile = new PutTileAction();
	SelectTileAction SelectTile = new SelectTileAction();
	CompleteAction Complete = new CompleteAction();
	
	
	Font font = new Font("consolas", Font.BOLD, 22);
	
	Tile tile;
	int[] tile_location = new int[3];
	//RailRoad MRoad;
	int action_btn_idx=0;
	boolean is_impossible = false;
	
	TileSet T_Set = new TileSet();
	Player Player1 = new Player(1,true);
	Player Player2 = new Player(2,false);
	int remain_tile = 16;
	
	int tile_num = 6; // 이 수가 0~5 사이가 아닐 때 puticon 을 실행하면 err 발생하도록 예외처리 해야함 
	
	void setIcon(){
		// rail 그림을 button 크기에 맞도록 수정  ( rail[0~1] = 직선레일, rail[2~5] = 곡선 레일 )
		// 경로가 지금 내 컴퓨터에 맞춰져 있어서 여기 경로만 수정해서 디버깅하면 될듯!
		// 버튼들은 class내에 선언안 rail이라는 이미지 배열에저장 
		
		ImageIcon originIcon = new ImageIcon("/Users/username/Desktop/img/t_rail0.png"); //이 경로들 자신에 맞게 수정 
		Image originImg = originIcon.getImage(); 
		Image changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		t_rail[0] = new ImageIcon(changedImg);
		//TList[0] = new LeftRight(); 
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/t_rail1.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		t_rail[1] = new ImageIcon(changedImg);
		//TList[1] = new UpDown();
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/t_rail2.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		t_rail[2] = new ImageIcon(changedImg);
		//TList[2] = new UpRight();
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/t_rail3.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		t_rail[3] = new ImageIcon(changedImg);
		//TList[3] = new UpLeft(); 
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/t_rail4.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		t_rail[4] = new ImageIcon(changedImg);
		//TList[4] = new DownLeft(); 
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/t_rail5.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		t_rail[5] = new ImageIcon(changedImg);
		//TList[5] = new DownRight();
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/rail0.png"); //이 경로들 자신에 맞게 수정 
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[0] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/rail1.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[1] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/rail2.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[2] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/rail3.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[3] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/rail4.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[4] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/rail5.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		rail[5] = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/ground.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH );
		Ground = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/rail_input.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH );
		RailInputImg = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/impossible.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH );
		ImpossibleImg = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/complete.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH );
		CompleteImg = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/1P.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH );
		P1Img = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/2P.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH );
		P2Img = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/imp_rail_input.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH );
		ImpRailInputImg = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/imp_complete.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH );
		ImpCompleteImg = new ImageIcon(changedImg);
		
		originIcon = new ImageIcon("/Users/username/Desktop/img/imp_impossible.png");  
		originImg = originIcon.getImage(); 
		changedImg= originImg.getScaledInstance(150, 150, Image.SCALE_SMOOTH );
		ImpImpossibleImg = new ImageIcon(changedImg);
		// 이미지 생성 끝. 앞으로 이 이미지로 모두 사용할 예정
	}
	
	
	void SetDeco() {
		
		for (int i=0; i<17; i++) {
			deco[i] = new JButton();
			deco[i].setPreferredSize(new Dimension(50, 50));
			deco[i].setBackground(new Color(129, 193, 71));
			deco[i].setFont(font);
			add(deco[i]);
		}
		
		deco[2].setText("M");
		deco[3].setText("O");
		deco[4].setText("N");
		deco[5].setText("O");
		deco[6].setText("R");
		deco[7].setText("A");
		deco[8].setText("I");
		deco[9].setText("L");
		deco[10].setText("-");
		deco[11].setText("G");
		deco[12].setText("A");
		deco[13].setText("M");
		deco[14].setText("E");

	}
	
	
	PlayMode(){
		
		setIcon(); //이미지 제작  
		SetDeco();
		setTitle("-- MONORAIL GAME --");
		setBackground(Color.green);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 3, 3)); // 새로 add 했을때 중앙정렬, 버튼간 좌우 상하간격 3
		
		//가로 17개, 세로 11개의 버튼 생성 
		
		for(int i=0;i<187;i++) {
			GrdBt[i] = new JButton();
			GrdBt[i].setPreferredSize(new Dimension(50, 50));
			GrdBt[i].addActionListener(PutTile);
			add(GrdBt[i]);
			
			if (i != 93 && i != 92)
				GrdBt[i].setIcon(Ground);		//나머진 다 일반땅
			else {
				GrdBt[i].setIcon(rail[0]); 	//시작부분이미지
				tile.pos_board[i%17][i/17] = new LeftRight(i%17, i/17);
				tile.pos_board[i%17][i/17].Connectable();
			}
		}
		// 게임 진행 버튼 맨 밑에 3개 생성 
		
		Turn.setPreferredSize(new Dimension(150, 150));
		Turn.setIcon(P1Img);
		add(Turn);
		
		AddTile.setPreferredSize(new Dimension(150, 150));
		AddTile.addActionListener(SelectTile);
		AddTile.setIcon(RailInputImg);
		add(AddTile);
		
		Impossible.setPreferredSize(new Dimension(150, 150));
		Impossible.addActionListener(new ImpossibleMode());
		Impossible.setIcon(ImpossibleImg);
		add(Impossible); 
		
		complete.setPreferredSize(new Dimension(150, 150));
		complete.addActionListener(Complete);
		complete.setIcon(CompleteImg);
		add(complete); 
		
		TileNum.setPreferredSize(new Dimension(150, 150));
		TileNum.setBackground(new Color(150, 75, 0)); 	//갈색
		add(TileNum); 
		
		setSize(950,900);
		setBackground(Color.black);
		setVisible(true);
	}
	
	class SelectMode extends JFrame{
		
		SelectMode(){
			setTitle("타일 선택");
			//setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));			
			setLayout(new GridLayout(0,3));
			//JLabel label = new JLabel("어떤 타일을 선택하실 건가요?", JLabel.CENTER);
			//label.setFont(new Font("", Font.BOLD, 20));
			//label.setPreferredSize(new Dimension(700, 50));
			//add(label);
			JButton[] TileOption = new JButton[7];
			
			for(int i=0;i<6;i++) {
				TileOption[i] = new JButton(""+ i);
				TileOption[i].setIcon(rail[i]);
				
				//새로운 창에서 버튼을 눌렀을 때 새로운창 꺼지고 nexticon 값 변화 
				
				TileOption[i].addActionListener(new ActionListener() {
					public void actionPerformed (ActionEvent e) {
					JButton b = (JButton)e.getSource();
					int from = Integer.parseInt(b.getText());
					tile_num = from;
					dispose();
					}
				});
				//add(temp[i]);
			}
			
			
			add(TileOption[0]);
			add(TileOption[1]);
			add(TileOption[2]);
			add(TileOption[3]);
			add(TileOption[4]);
			add(TileOption[5]);
			
			setSize(500,200);
			setVisible(true);
		}
	}

	boolean canPutTile() {
		return (tile_num > 0);
	}
	//버튼을 누르면 nexticon의 값에 따라 버튼의 아이콘이 바뀜. 단 버튼을 한개만 누르게 하기위해 한번 사용 후 nexticon을 6으로 변경.
	
	class PutTileAction implements ActionListener {
		
		public void actionPerformed (ActionEvent e) {
			
			JButton b = (JButton)e.getSource();
			
			
			if (tile_num == 6) {
				new ErrorWindow1();
			}
			else {
				
				
				for (int j=1;j<188;j++) {
					if (GrdBt[j] == b) {
						tile_location[action_btn_idx] = j;
						//T_Set.push_tile(TList[nexticon]);
						
						int x = j%17;
						int y = j/17;					
						
						if (tile.pos_board[x][y] != null) {
							new ErrorWindow6();
							break;
						}
						
						if (tile_num == 0) 
							T_Set.push_tile(new LeftRight(x, y));
						else if (tile_num == 1)
							T_Set.push_tile(new UpDown(x, y));
						else if (tile_num == 2)
							T_Set.push_tile(new UpRight(x, y));
						else if (tile_num == 3)
							T_Set.push_tile(new UpLeft(x, y));
						else if (tile_num == 4)
							T_Set.push_tile(new DownLeft(x,y));
						else
							T_Set.push_tile(new DownRight(x, y));
						
						//T_Set.TSet[T_Set.num-1].see_pos_board();
						
						if (T_Set.TSet[T_Set.num-1].pos_board[x+1][y] != null) {}
						else if (T_Set.TSet[T_Set.num-1].pos_board[x-1][y] != null) {}
						else if (T_Set.TSet[T_Set.num-1].pos_board[x][y+1] != null) {}
						else if (T_Set.TSet[T_Set.num-1].pos_board[x][y-1] != null) {}
						else {
							System.out.println("error!");
							new ErrorWindow4();
							T_Set.TSet[T_Set.num-1].pos_board[x][y] = null;
							T_Set.num--;
							break;
						}
						
						b.setIcon(t_rail[tile_num]);
						
						action_btn_idx++;
						tile_num = 6;
						
						System.out.println(j);
						break;
					}
				}
				
				
			}
			// 6으로 바꾸는 이유는 6일때는 위에 말한 예외처리가 되기 때문. setnexticon을 통해 nexticon의 값을 생성하는데
			// 이건 버튼 한개의 그림만 바꿔야하기때문에  한번쓰고 버려야함.
		}
		
	}
	
	
	//타일을 두겠습니다 를 선택했을 때 어떤 타일을 선택할지 고르는 창이 뜬다. 타일을 고르면 그에 맞게 nexticon이 변경된다.
	
	class SelectTileAction implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (action_btn_idx == 3) { new ErrorWindow2(); }
			else { 
				//TSet = new TileSet();
				new SelectMode(); 
			}	
		}
	}

	
	
	class CompleteAction implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
			if (action_btn_idx == 0) {
				new ErrorWindow3();
			}
			
			else { 
				
				//타일 위치 지정
				//여기서 조건이 부합하는지 판단하여 valid 판단하는것은 2019310036 최장섭 학생이 작성
				boolean valid = true;
				
				for (int i=0; i<T_Set.num; ++i) {
					//System.out.println(T_Set.TSet[i].position[0] + " " + T_Set.TSet[i].position[1]);
					valid = T_Set.TSet[i].Connectable();
					if (valid == false) break;
					
				}
				
				if (remain_tile - T_Set.num < 0) { 
					new ErrorWindow7();
					valid = false;
				}
				
				
				if (valid == true) 
					valid = T_Set.is_one_line();
				//여기서 조건이 부합하는지 판단하여 valid 판단하는것은 2019310036 최장섭 학생이 작성 여기까지
				
				if (valid) {
					for (int i=0; i<T_Set.num; ++i) 
						GrdBt[tile_location[i]].setIcon(rail[T_Set.TSet[i].label]);
					
					remain_tile -= T_Set.num;
					TileNum.setText("잔여타일 : " + remain_tile);
				
					if (T_Set.TSet[0].isAllConnect()) {
						
						new WinnerWindow(Player1, Player2);
						
					}
					else { System.out.println("Nope"); }
					
					if (Player1.isMyTurn) {
						Turn.setIcon(P2Img);
						
					}
					else {
						Turn.setIcon(P1Img);
					}
					
					Player1.isMyTurn = !Player1.isMyTurn;
					Player2.isMyTurn = !Player2.isMyTurn;
					
					
				}
				else {
					for (int i=0; i<T_Set.num; ++i) {
						GrdBt[tile_location[i]].setIcon(Ground);
						tile.pos_board[tile_location[i]%17][tile_location[i]/17] = null;
					}
					new ErrorWindow5();
				}
				T_Set.num = 0;
				action_btn_idx = 0; 
			}
		
		}
	}
	

	

	
//*****************************************
//여기 아래는 2019310036 최장섭 학생이 코드 작성
	
	class ImpossibleMode implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
			if (Player1.isMyTurn) {
				Turn.setIcon(P2Img);
				
			}
			else {
				Turn.setIcon(P1Img);
			}
			
			Player1.isMyTurn = !Player1.isMyTurn;
			Player2.isMyTurn = !Player2.isMyTurn;
			
			new ImpossibleWindow();
			impossibleDeco();
			is_impossible = true;
			
			for(int i=0;i<187;i++) {
				
				GrdBt[i].removeActionListener(PutTile);
				GrdBt[i].addActionListener(new ImpPutTileAction());			
				
			}
			// 게임 진행 버튼 맨 밑에 3개 생성 
			AddTile.removeActionListener(SelectTile);
			AddTile.addActionListener(new ImpChooseTileAction());
			AddTile.setIcon(ImpRailInputImg);


			Impossible.setIcon(ImpImpossibleImg);
 
			complete.removeActionListener(Complete);
			complete.addActionListener(new ImpCompleteAction());
			complete.setIcon(ImpCompleteImg);
			// 아이콘 색 바꾸기
		}
	}
	void impossibleDeco() {
		
		for (int i=0; i<17; i++) {
			deco[i].setBackground(new Color(255, 0, 0));
			//decoBt[i].setFont(font);
		}
		
		deco[2].setText("");
		deco[3].setText("I");
		deco[4].setText("M");
		deco[5].setText("P");
		deco[6].setText("O");
		deco[7].setText("S");
		deco[8].setText("S");
		deco[9].setText("I");
		deco[10].setText("B");
		deco[11].setText("L");
		deco[12].setText("E");
		deco[13].setText("!");
		deco[14].setText("");

	}
	
	
	class ImpChooseTileAction implements ActionListener {
		public void actionPerformed (ActionEvent e) {
				new SelectMode(); 
		}
	}
	class ImpPutTileAction implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			
			JButton b = (JButton)e.getSource();
			
			
			if (tile_num == 6) {
				new ErrorWindow1();
			}
			
			else if (remain_tile == 0) {
				new ErrorWindow7();
			}
			
			else {
				for (int j=1;j<188;j++) {
					if (GrdBt[j] == b) {
						
						Tile imp_t;
						Tile imp_temp = new Tile();
						int x = j%17;
						int y = j/17;
						System.out.println(x + " " + y);
						
						if (imp_temp.pos_board[x][y] != null) {
							new ErrorWindow6();
							break;
						}
						
						if (tile_num == 0) 
							imp_t = (new LeftRight(x, y));
						else if (tile_num == 1)
							imp_t = (new UpDown(x, y));
						else if (tile_num == 2)
							imp_t = (new UpRight(x, y));
						else if (tile_num == 3)
							imp_t = (new UpLeft(x, y));
						else if (tile_num == 4)
							imp_t = (new DownLeft(x,y));
						else
							imp_t = (new DownRight(x, y));
						
						imp_t.Connectable();
						imp_temp.pos_board[x][y] = imp_t;
						imp_temp.seePosBoard();
						b.setIcon(rail[tile_num]);
						remain_tile--;
						TileNum.setText("잔여타일 : " + remain_tile);
						tile_num=6;
						break;
						
					}
				}
			}
			
		}
	}
	
	class ImpCompleteAction implements ActionListener {
		public void actionPerformed (ActionEvent e) {

			Tile imp_temp = new Tile();
			
			if (imp_temp.isAllConnect()) { new ImpWinnerWindow1(Player1, Player2); }
			else {
				Player1.isMyTurn = !Player1.isMyTurn;
				Player2.isMyTurn = !Player2.isMyTurn;
				new ImpWinnerWindow2(Player1, Player2);
			}

		}
	}
}
