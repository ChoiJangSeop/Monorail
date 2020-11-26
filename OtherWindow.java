package MonoRail;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//2019310036 최장섭 학생이 작성
class ErrorWindow1 extends JFrame {
	
	ErrorWindow1() {
		setTitle("error!");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel("타일 종류를 선택해주세요!", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("확인");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt);
		
		setSize(500,200);
		this.setLocation(225, 275);
		setVisible(true);
	}
}

class ErrorWindow2 extends JFrame {
	
	ErrorWindow2() {
		setTitle("error!");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel("더이상 타일을 놓을수 없습니다", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("확인");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt);
		
		setSize(500,200);
		this.setLocation(225, 275);
		setVisible(true);
	}
}

class ErrorWindow3 extends JFrame {

	ErrorWindow3() {
		setTitle("error!");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel("타일을 1개 이상 놓으세요", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("확인");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt);
		
		setSize(500,200);
		this.setLocation(225, 275);
		setVisible(true);
	}
}

class ErrorWindow4 extends JFrame {

	ErrorWindow4() {
		setTitle("error!");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel("기존의 타일과 붙혀서 배치해주세요", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("확인");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt);
		
		setSize(500,200);
		this.setLocation(225, 275);
		setVisible(true);
	}
}
class ErrorWindow5 extends JFrame {

	ErrorWindow5() {
		setTitle("error!");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel("타당하지 않은 선로 연결입니다", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("확인");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt);
		
		setSize(500,200);
		this.setLocation(225, 275);
		setVisible(true);
	}
}

class ErrorWindow6 extends JFrame {

	ErrorWindow6() {
		setTitle("error!");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel("이미 타일이 놓여진 위치입니다.", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("확인");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt);
		
		setSize(500,200);
		this.setLocation(225, 275);
		setVisible(true);
	}
}
class ErrorWindow7 extends JFrame {

	ErrorWindow7() {
		setTitle("error!");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel("타일의 개수가 부족합니다.", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("확인");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt);
		
		setSize(500,200);
		this.setLocation(225, 275);
		setVisible(true);
	}
}

class WinnerWindow extends JFrame {

	WinnerWindow(Player p1, Player p2) {
		
		int winner;
		
		if(p1.isMyTurn) { winner = p1.number; }
		else { winner = p2.number; }
		
		setTitle("Game end");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel(winner + "P is Winner!", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
	
		
		JButton bt2 = new JButton("그만");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt2);
		
		setSize(500,200);
		this.setLocation(225, 275);
		setVisible(true);
	}
}

class ImpossibleWindow extends JFrame {

	ImpossibleWindow() {
		
		setTitle("Impossible!");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel("불가능을 선언하셨습니다. 선로를 완성시켜주세요!", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("확인");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt);
		
		setSize(700,200);
		this.setLocation(125, 275);
		setVisible(true);
	}
}

class ImpWinnerWindow1 extends JFrame {

	ImpWinnerWindow1(Player p1, Player p2) {
		
		int winner;
		int loser;
		
		if(p1.isMyTurn) { winner = p1.number; loser = p2.number;}
		else { winner = p2.number; loser = p1.number; }
		
		
		setTitle("Game end");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel(loser + "P가 불가능 선언에 실패하셨습니다. " + winner + "P is winner!", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt2 = new JButton("그만");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt2);
		
		setSize(700,200);
		this.setLocation(125, 275);
		setVisible(true);
	}
}

class ImpWinnerWindow2 extends JFrame {

	ImpWinnerWindow2(Player p1, Player p2) {
		
		int winner;

		if(p1.isMyTurn) { winner = p1.number; }
		else { winner = p2.number; }
		
		
		setTitle("Game end");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel(winner + "P가 불가능 선언에 성공하셨습니다.\r" + winner + "P is winner!", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		
		JButton bt2 = new JButton("그만");
		bt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(bt2);
		
		setSize(500,200);
		this.setLocation(225, 275);
		setVisible(true);
	}
}

public class OtherWindow {

}
