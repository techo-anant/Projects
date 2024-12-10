package TicTacToe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;

public class tttJframe extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tttJframe frame = new tttJframe();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tttJframe() {
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, Color.GRAY, Color.GRAY, Color.GRAY));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		TicTacToe game = new TicTacToe();
		
		JButton Box1 = new JButton(" ");
		Box1.setBackground(Color.WHITE);
		Box1.setFont(new Font("Chalkboard", Font.BOLD, 60));
		Box1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Box1.getText().equals(" ")) return;
				if (game.gameOver) return; // Prevent action if game is over
				changeButtonText(Box1, game.getTextForButton(Box1.getText()));
				game.grid[0] = Box1.getText();
				winMessage(contentPane, game.hasWon(), game.winner, game);
			}
		});
		contentPane.add(Box1);
		
		JButton Box2 = new JButton(" ");
		Box2.setFont(new Font("Chalkboard", Font.BOLD, 60));
		Box2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Box2.getText().equals(" ")) return;
				if (game.gameOver) return; // Prevent action if game is over
				changeButtonText(Box2, game.getTextForButton(Box2.getText()));
				game.grid[1] = Box2.getText();
				winMessage(contentPane, game.hasWon(), game.winner, game);
			}
		});
		contentPane.add(Box2);
		
		JButton Box3 = new JButton(" ");
		Box3.setFont(new Font("Chalkboard", Font.BOLD, 60));
		Box3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Box3.getText().equals(" ")) return;
				if (game.gameOver) return; // Prevent action if game is over
				changeButtonText(Box3, game.getTextForButton(Box3.getText()));
				game.grid[2] = Box3.getText();
				winMessage(contentPane, game.hasWon(), game.winner, game);
			}
		});
		contentPane.add(Box3);
		
		JButton Box4 = new JButton(" ");
		Box4.setFont(new Font("Chalkboard", Font.BOLD, 60));
		Box4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Box4.getText().equals(" ")) return;
				if (game.gameOver) return; // Prevent action if game is over
				changeButtonText(Box4, game.getTextForButton(Box4.getText()));
				game.grid[3] = Box4.getText();
				winMessage(contentPane, game.hasWon(), game.winner, game);
			}
		});
		contentPane.add(Box4);
		
		JButton Box5 = new JButton(" ");
		Box5.setFont(new Font("Chalkboard", Font.BOLD, 60));
		Box5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Box5.getText().equals(" ")) return;
				if (game.gameOver) return; // Prevent action if game is over
				changeButtonText(Box5, game.getTextForButton(Box5.getText()));
				game.grid[4] = Box5.getText();
				winMessage(contentPane, game.hasWon(), game.winner, game);
			}
		});
		contentPane.add(Box5);
		
		JButton Box6 = new JButton(" ");
		Box6.setFont(new Font("Chalkboard", Font.BOLD, 60));
		Box6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Box6.getText().equals(" ")) return;
				if (game.gameOver) return; // Prevent action if game is over
				changeButtonText(Box6, game.getTextForButton(Box6.getText()));
				game.grid[5] = Box6.getText();
				winMessage(contentPane, game.hasWon(), game.winner, game);
			}
		});
		contentPane.add(Box6);
		
		JButton Box7 = new JButton(" ");
		Box7.setFont(new Font("Chalkboard", Font.BOLD, 60));
		Box7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Box7.getText().equals(" ")) return;
				if (game.gameOver) return; // Prevent action if game is over
				changeButtonText(Box7, game.getTextForButton(Box7.getText()));
				game.grid[6] = Box7.getText();
				winMessage(contentPane, game.hasWon(), game.winner, game);
			}
		});
		contentPane.add(Box7);
		
		JButton Box8 = new JButton(" ");
		Box8.setFont(new Font("Chalkboard", Font.BOLD, 60));
		Box8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Box8.getText().equals(" ")) return;
				if (game.gameOver) return; // Prevent action if game is over
				changeButtonText(Box8, game.getTextForButton(Box8.getText()));
				game.grid[7] = Box8.getText();
				winMessage(contentPane, game.hasWon(), game.winner, game);
			}
		});
		contentPane.add(Box8);
		
		JButton Box9 = new JButton(" ");
		Box9.setFont(new Font("Chalkboard", Font.BOLD, 60));
		Box9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!Box9.getText().equals(" ")) return;
				if (game.gameOver) return; // Prevent action if game is over
				changeButtonText(Box9, game.getTextForButton(Box9.getText()));
				game.grid[8] = Box9.getText();
				winMessage(contentPane, game.hasWon(), game.winner, game);
			}
		});
		contentPane.add(Box9);
	}
	
	public static void changeButtonText(JButton button, String newText) {
        button.setText(newText);
    }
	
	public static void winMessage(JPanel contentPane, boolean hasWon, String winner, TicTacToe game) {
		if(hasWon) {
			JOptionPane.showMessageDialog(contentPane,"Player "+ winner +", has won!!!", "Winner", JOptionPane.INFORMATION_MESSAGE);
			clearGrid(contentPane);
			game.clear();
			return;
		}else {
			if(game.isDraw()) {
				JOptionPane.showMessageDialog(contentPane,"Its a Draw... Next one!", "Draw", JOptionPane.INFORMATION_MESSAGE);
				clearGrid(contentPane);
				game.clear();
				return;
			}
		}
	}
	
	public static void clearGrid(JPanel contentPane) {
		int length = contentPane.getComponentCount();
		for(int i = 0; i < length; i++) {
			if(contentPane.getComponent(i) instanceof JButton) {
				((AbstractButton) contentPane.getComponent(i)).setText(" ");
			}
		}
	}

}
