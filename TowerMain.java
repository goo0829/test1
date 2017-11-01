

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
public class TowerMain implements ActionListener
{
 JFrame jframe;
 Container con;
 Ground groundPan;
 RightPan rightPan;
 MyPanel topPan, bottomPan;
 Timer timer;
 int timeCount, time, level, live, gold, score;
 JLabel timeLabel, levelLabel, liveLabel, goldLabel, scoreLabel;
 JComponent selecTower;
 boolean select = false;
 JButton enemyBtn;
 
 
 public static void main(String arg[])
 {
  System.out.println("타워디펜스");
  TowerMain towerMain = new TowerMain();
  towerMain.start();
 }
 
 public void start()
 {
  jframe = new JFrame("타워디펜스");
  jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  jframe.setBounds(0,0,1010,724);
  jframe.setResizable(false);
  jframe.setVisible(true);
  
  con = jframe.getContentPane();
  con.setLayout(null);
    
  makeTopPan();
  rightPan = new RightPan();
  con.add(rightPan);
  bottomPan = new MyPanel(0,590,690,690);
  con.add(bottomPan);
  
  groundPan = new Ground(rightPan);
  groundPan.addMouseMotionListener(groundPan);
  groundPan.addMouseListener(groundPan);
  con.add(groundPan);
  rightPan.setGroundPan(groundPan);
  
  timer = new Timer(20,  this);
  timer.start();    
 }
 
 public void makeTopPan()
 {
  topPan = new MyPanel(0,0,690,100);
  //JLabel timeLabel, levelLabel, liveLabel, goldLabel, scoreLabel;
  timeLabel = new MyLabel("Time : " + String.valueOf(time), 50,10);
  levelLabel = new MyLabel("Level : " + String.valueOf(level), 150,10);
  liveLabel = new MyLabel("Live : " + String.valueOf(time), 250,10);
  goldLabel = new MyLabel("Gold : " + String.valueOf(time), 350,10);
  scoreLabel = new MyLabel("Score : " + String.valueOf(time), 450,10);
  topPan.add(timeLabel);
  topPan.add(levelLabel);
  topPan.add(liveLabel);
  topPan.add(goldLabel);
  topPan.add(scoreLabel);
  enemyBtn = new JButton("적 추가");
  enemyBtn.setBounds(540,60,100,20);
  enemyBtn.addActionListener(this);
  enemyBtn.setActionCommand("적추가");
  topPan.add(enemyBtn);
  
  
  con.add(topPan);
 }
 
 @Override
 public void actionPerformed(ActionEvent ae) {
  // TODO Auto-generated method stub
  if(ae.getSource() == enemyBtn )
  {  
   groundPan.addEnemy();   
  }
  else  
  {
   groundPan.play(timeCount);
   timeCount++;
   con.repaint();
  }
  
 }
}
