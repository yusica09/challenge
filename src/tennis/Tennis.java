package tennis;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Tennis {

        public static void main(String[] args) {
                SwingUtilities.invokeLater(() -> {
                        JFrame frame = new JFrame("Tennis Match");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame.setSize(600, 500);
                        frame.setLocationRelativeTo(null);

                        JPanel mainPanel = new JPanel(new CardLayout());
                        JPanel startPanel = new JPanel();
                        startPanel.setLayout(new GridLayout(3, 1));

                        JLabel titleLabel = new JLabel("Tennis Match", JLabel.CENTER);
                        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

                        JButton singleButton = new JButton("단식");
                        JButton doubleButton = new JButton("복식");

                        startPanel.add(titleLabel);
                        startPanel.add(singleButton);
                        startPanel.add(doubleButton);

                        mainPanel.add(startPanel, "Start");

                        SingleMatchPanel singlePanel = new SingleMatchPanel(mainPanel);
                        DoubleMatchPanel doublePanel = new DoubleMatchPanel(mainPanel);

                        mainPanel.add(singlePanel, "Single");
                        mainPanel.add(doublePanel, "Double");

                        singleButton.addActionListener(e -> {
                                CardLayout cl = (CardLayout) mainPanel.getLayout();
                                cl.show(mainPanel, "Single");
                        });

                        doubleButton.addActionListener(e -> {
                                CardLayout cl = (CardLayout) mainPanel.getLayout();
                                cl.show(mainPanel, "Double");
                        });

                        frame.add(mainPanel);
                        frame.setVisible(true);
                });
        }
}

class SingleMatchPanel extends JPanel {
        public SingleMatchPanel(JPanel mainPanel) {
                setLayout(new GridLayout(8, 2));

                JLabel player1Label = new JLabel("플레이어 1 이름:");
                JTextField player1Name = new JTextField();
                JLabel player1GenderLabel = new JLabel("플레이어 1 성별:");
                JRadioButton male1 = new JRadioButton("남자");
                JRadioButton female1 = new JRadioButton("여자");
                ButtonGroup genderGroup1 = new ButtonGroup();
                genderGroup1.add(male1);
                genderGroup1.add(female1);

                JLabel player2Label = new JLabel("플레이어 2 이름:");
                JTextField player2Name = new JTextField();
                JLabel player2GenderLabel = new JLabel("플레이어 2 성별:");
                JRadioButton male2 = new JRadioButton("남자");
                JRadioButton female2 = new JRadioButton("여자");
                ButtonGroup genderGroup2 = new ButtonGroup();
                genderGroup2.add(male2);
                genderGroup2.add(female2);

                JLabel setLabel = new JLabel("세트 수 선택:");
                JComboBox<String> setComboBox = new JComboBox<>(new String[]{"3세트", "5세트"});

                JButton startMatchButton = new JButton("경기 시작");

                add(player1Label);
                add(player1Name);
                add(player1GenderLabel);
                add(createGenderPanel(male1, female1));

                add(player2Label);
                add(player2Name);
                add(player2GenderLabel);
                add(createGenderPanel(male2, female2));

                add(setLabel);
                add(setComboBox);
                add(new JLabel());
                add(startMatchButton);

                ActionListener genderListener = e -> {
                        if (female1.isSelected() || female2.isSelected()) {
                                setComboBox.setSelectedItem("3세트");
                                setComboBox.setEnabled(false);
                        } else {
                                setComboBox.setEnabled(true);
                        }
                };

                male1.addActionListener(genderListener);
                female1.addActionListener(genderListener);
                male2.addActionListener(genderListener);
                female2.addActionListener(genderListener);

                startMatchButton.addActionListener(e -> {
                        String name1 = player1Name.getText();
                        String name2 = player2Name.getText();
                        int setCount = setComboBox.getSelectedItem().equals("3세트") ? 3 : 5;

                        CardLayout cl = (CardLayout) mainPanel.getLayout();
                        MatchPanel matchPanel = new MatchPanel(mainPanel, name1, name2, setCount);
                        mainPanel.add(matchPanel, "Match");
                        cl.show(mainPanel, "Match");
                });
        }

        private JPanel createGenderPanel(JRadioButton male, JRadioButton female) {
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                panel.add(male);
                panel.add(female);
                return panel;
        }
}

class DoubleMatchPanel extends JPanel {
        public DoubleMatchPanel(JPanel mainPanel) {
                setLayout(new GridLayout(12, 2));

                JLabel team1Player1Label = new JLabel("1팀 - 플레이어 1 이름:");
                JTextField team1Player1Name = new JTextField();
                JLabel team1Player1GenderLabel = new JLabel("1팀 - 플레이어 1 성별:");
                JRadioButton team1Male1 = new JRadioButton("남자");
                JRadioButton team1Female1 = new JRadioButton("여자");
                ButtonGroup team1GenderGroup1 = new ButtonGroup();
                team1GenderGroup1.add(team1Male1);
                team1GenderGroup1.add(team1Female1);

                JLabel team1Player2Label = new JLabel("1팀 - 플레이어 2 이름:");
                JTextField team1Player2Name = new JTextField();
                JLabel team1Player2GenderLabel = new JLabel("1팀 - 플레이어 2 성별:");
                JRadioButton team1Male2 = new JRadioButton("남자");
                JRadioButton team1Female2 = new JRadioButton("여자");
                ButtonGroup team1GenderGroup2 = new ButtonGroup();
                team1GenderGroup2.add(team1Male2);
                team1GenderGroup2.add(team1Female2);

                JLabel team2Player1Label = new JLabel("2팀 - 플레이어 1 이름:");
                JTextField team2Player1Name = new JTextField();
                JLabel team2Player1GenderLabel = new JLabel("2팀 - 플레이어 1 성별:");
                JRadioButton team2Male1 = new JRadioButton("남자");
                JRadioButton team2Female1 = new JRadioButton("여자");
                ButtonGroup team2GenderGroup1 = new ButtonGroup();
                team2GenderGroup1.add(team2Male1);
                team2GenderGroup1.add(team2Female1);

                JLabel team2Player2Label = new JLabel("2팀 - 플레이어 2 이름:");
                JTextField team2Player2Name = new JTextField();
                JLabel team2Player2GenderLabel = new JLabel("2팀 - 플레이어 2 성별:");
                JRadioButton team2Male2 = new JRadioButton("남자");
                JRadioButton team2Female2 = new JRadioButton("여자");
                ButtonGroup team2GenderGroup2 = new ButtonGroup();
                team2GenderGroup2.add(team2Male2);
                team2GenderGroup2.add(team2Female2);

                JLabel setLabel = new JLabel("세트 수 선택:");
                JComboBox<String> setComboBox = new JComboBox<>(new String[]{"3세트", "5세트"});

                JButton startMatchButton = new JButton("경기 시작");

                add(team1Player1Label);
                add(team1Player1Name);
                add(team1Player1GenderLabel);
                add(createGenderPanel(team1Male1, team1Female1));

                add(team1Player2Label);
                add(team1Player2Name);
                add(team1Player2GenderLabel);
                add(createGenderPanel(team1Male2, team1Female2));

                add(team2Player1Label);
                add(team2Player1Name);
                add(team2Player1GenderLabel);
                add(createGenderPanel(team2Male1, team2Female1));

                add(team2Player2Label);
                add(team2Player2Name);
                add(team2Player2GenderLabel);
                add(createGenderPanel(team2Male2, team2Female2));

                add(setLabel);
                add(setComboBox);
                add(new JLabel());
                add(startMatchButton);

                ActionListener genderListener = e -> {
                        if (team1Female1.isSelected() || team1Female2.isSelected() || team2Female1.isSelected() || team2Female2.isSelected()) {
                                setComboBox.setSelectedItem("3세트");
                                setComboBox.setEnabled(false);
                        } else {
                                setComboBox.setEnabled(true);
                        }
                };

                team1Male1.addActionListener(genderListener);
                team1Female1.addActionListener(genderListener);
                team1Male2.addActionListener(genderListener);
                team1Female2.addActionListener(genderListener);
                team2Male1.addActionListener(genderListener);
                team2Female1.addActionListener(genderListener);
                team2Male2.addActionListener(genderListener);
                team2Female2.addActionListener(genderListener);

                startMatchButton.addActionListener(e -> {
                        String name1 = team1Player1Name.getText() + ", " + team1Player2Name.getText();
                        String name2 = team2Player1Name.getText() + ", " + team2Player2Name.getText();
                        int setCount = setComboBox.getSelectedItem().equals("3세트") ? 3 : 5;

                        CardLayout cl = (CardLayout) mainPanel.getLayout();
                        MatchPanel matchPanel = new MatchPanel(mainPanel, name1, name2, setCount);
                        mainPanel.add(matchPanel, "Match");
                        cl.show(mainPanel, "Match");
                });
        }

        private JPanel createGenderPanel(JRadioButton male, JRadioButton female) {
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                panel.add(male);
                panel.add(female);
                return panel;
        }
}

class MatchPanel extends JPanel {
        private Match match;
        private String player1;
        private String player2;
        private Set currentSet;
        private Game currentGame;

        public MatchPanel(JPanel mainPanel, String player1, String player2, int setCount) {
                this.player1 = player1;
                this.player2 = player2;
                this.match = new Match(setCount);
                this.currentSet = new Set(false);
                this.currentGame = new Game(false, false);

                setLayout(new BorderLayout());

                JLabel setScoreLabel = new JLabel("세트 점수: 0 - 0", JLabel.CENTER);
                JLabel gameScoreLabel = new JLabel("게임 점수: 0 - 0", JLabel.CENTER);
                JLabel currentGameScoreLabel = new JLabel("현재 게임 점수: 0 - 0", JLabel.CENTER);
                JLabel specialMessageLabel = new JLabel("", JLabel.CENTER);

                setScoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
                gameScoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
                currentGameScoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
                specialMessageLabel.setFont(new Font("Arial", Font.BOLD, 14));
                specialMessageLabel.setForeground(Color.RED);

                JPanel scorePanel = new JPanel(new GridLayout(4, 1));
                scorePanel.add(setScoreLabel);
                scorePanel.add(gameScoreLabel);
                scorePanel.add(currentGameScoreLabel);
                scorePanel.add(specialMessageLabel);

                JButton nextPointButton = new JButton("다음 포인트");

                nextPointButton.addActionListener(e -> {
                        currentGame.getPoint();

                        currentGameScoreLabel.setText(String.format("현재 게임 점수: %d - %d", currentGame.score[0], currentGame.score[1]));

                        if (currentGame.hasWinner()) {
                                currentSet.score[currentGame.whoIsWinner()]++;
                                gameScoreLabel.setText(String.format("게임 점수: %d - %d", currentSet.score[0], currentSet.score[1]));

                                if (currentSet.hasWinner()) {
                                        match.score[currentSet.whoIsWinner()]++;
                                        setScoreLabel.setText(String.format("세트 점수: %s %d - %s %d", player1, match.score[0], player2, match.score[1]));

                                        if (match.hasWinner()) {
                                                nextPointButton.setEnabled(false);
                                                specialMessageLabel.setText(String.format("%s 승리!", match.whoIsWinner() == 0 ? player1 : player2));
                                        } else {
                                                specialMessageLabel.setText("새 세트 시작!");
                                                currentSet = new Set(match.isLastSet);
                                        }
                                } else {
                                        specialMessageLabel.setText("새 게임 시작!");
                                        currentGame = new Game(currentSet.isTieBreak, match.isLastSet);
                                }
                        }
                });

                add(scorePanel, BorderLayout.CENTER);
                add(nextPointButton, BorderLayout.SOUTH);
        }


        /*
        public static void main(String[] args) {
                int setNum;
                //단식 예시
                Person[] p = new Person[2];

                Scanner scanner = new Scanner(System.in);

                System.out.print("> 첫번째 선수 이름 : ");
                String s1 = scanner.nextLine();
                System.out.print("> 첫번째 선수 성별 : ");
                String g1 = scanner.nextLine();
                Boolean b1 = g1.equals("여자") ? false : true;
                p[0] = new Person(s1, b1);

                System.out.print("> 두번째 선수 이름 : ");
                String s2 = scanner.nextLine();
                System.out.print("> 두번째 선수 성별 : ");
                String g2 = scanner.nextLine();
                Boolean b2 = g2.equals("여자") ? false : true;
                p[1] = new Person(s2, b2);

                if (b1 == true && b2 == true) {
                        System.out.print("> 3세트 / 5세트 선택 : ");
                        setNum = scanner.nextInt();
                } else {
                        System.out.println("> 3세트 고정입니다. ");
                        setNum = 3;
                }
                // 경기
                Match match = new Match(setNum);
                while (!match.hasWinner()) {
                        match.getSetScore();
                }

                System.out.printf("승자는 %s 입니다.\n", p[match.whoIsWinner()].name);
                System.out.println("게임 종료");
        */

        }





