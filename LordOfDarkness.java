package aluno;
import robocode.*;
import java.awt.Color;
/**
 * LordOfDarkness - a class by (Erick D Silva)
 */
public class LordOfDarkness extends Robot {
	public void run() {
		setColors(Color.red,Color.yellow,Color.green);
		while(true) {
			ahead(100);
			turnLeft(90);
		}	
	}
	//tank robo inimigo detectado
	public void onScannedRobot(ScannedRobotEvent e) {
		String robotank = e.getName();
		Double distancia = e.getDistance();
		System.out.println(robotank + " distancia " + distancia);
		if(distancia < 135) {
			fire(3);
		} else  {
		fire(1);
		}
	}
	//Colisão na parede
	public void onHitWall(HitWallEvent e) {
		back(50);
		turnLeft(90);
	}
	
	
}
