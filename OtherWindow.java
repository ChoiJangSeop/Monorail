package MonoRail;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


//2019310036 ���強 �л��� �ۼ�
class ErrorWindow1 extends JFrame {
	
	ErrorWindow1() {
		setTitle("error!");
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));	
		JLabel label = new JLabel("Ÿ�� ������ �������ּ���!", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("Ȯ��");
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
		JLabel label = new JLabel("���̻� Ÿ���� ������ �����ϴ�", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("Ȯ��");
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
		JLabel label = new JLabel("Ÿ���� 1�� �̻� ��������", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("Ȯ��");
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
		JLabel label = new JLabel("������ Ÿ�ϰ� ������ ��ġ���ּ���", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("Ȯ��");
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
		JLabel label = new JLabel("Ÿ������ ���� ���� �����Դϴ�", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("Ȯ��");
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
		JLabel label = new JLabel("�̹� Ÿ���� ������ ��ġ�Դϴ�.", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("Ȯ��");
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
		JLabel label = new JLabel("Ÿ���� ������ �����մϴ�.", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("Ȯ��");
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
	
		
		JButton bt2 = new JButton("�׸�");
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
		JLabel label = new JLabel("�Ұ����� �����ϼ̽��ϴ�. ���θ� �ϼ������ּ���!", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt = new JButton("Ȯ��");
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
		JLabel label = new JLabel(loser + "P�� �Ұ��� ���� �����ϼ̽��ϴ�. " + winner + "P is winner!", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		JButton bt2 = new JButton("�׸�");
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
		JLabel label = new JLabel(winner + "P�� �Ұ��� ���� �����ϼ̽��ϴ�.\r" + winner + "P is winner!", JLabel.CENTER);
		label.setFont(new Font("", Font.BOLD, 20));
		label.setPreferredSize(new Dimension(700, 50));
		add(label);
		
		
		JButton bt2 = new JButton("�׸�");
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
