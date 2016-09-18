package net.aretx.test.asdJOC;

import java.util.Scanner;

public class Joc {
private int dimensions  = 6;
private int[][] map = new int[dimensions][dimensions]; //map[x][y]
protected static Scanner sc = new Scanner(System.in);
private	int x = -1;
private int y = -1;
private int[][] hits = new int[dimensions][dimensions];
private int torn = 0;

//
//BORING SHET
//AretX

public void run(){

System.out.println(",.   ,.             .  .      ");
System.out.println("`|  / ,-. . . , ,-. |  |  ,-.");
System.out.println(" | /  ,-| |  X  |-' |  |  `-.");
System.out.println(" `'   `-^ ' ' ` `-' `' `' `-'");
System.out.println("Dimensions del mapa 5x5 ,\nEls dos jugadors compartiu mapa.");
torn = 0;
loopTorn();
}

public void loopTorn(){
	if(torn == 0){
		torn = 1;
		setTurn(1);
	}else if(torn == 1){
		torn = 2;
		setTurn(2);
	}else{
		System.out.println("Error, revisar");
	}
}

public void setTurn(int trn){ // si el torn es 1 torn= 1 , si es do = 2 ||| 
	if (trn == 0) { //           SI EL TORN ES 3 ATACA EL CONTRINCANT 2! , SI EL TORN ES 4 ATACA EN CONTRINCANT 1!
		System.out.println("Error , revisar");
	}else{
		blankSpace(6);
		System.out.println("Es el torn " + torn);
		setShip(trn);
	}
}

public void setShip(int ply){
	if (ply == 1) {
	System.out.println("1-Introdueix la coord x del teu vaixell : ");
	int xp1 = sc.nextInt();
	
	System.out.println("1-Introdueix la coord y del teu vaixell : ");
	int yp1 = sc.nextInt();
	getShip(xp1,yp1,1);
	torn = 3;
	
	if (torn == 3) {
		torn = 4;
	}else{
		
	}
	checkTorn();
	}else{
		System.out.println("2-Introdueix la coord x del teu vaixell : ");
		int xp1 = sc.nextInt();
		
		System.out.println("2-Introdueix la coord y del teu vaixell : ");
		int yp1 = sc.nextInt();
		getShip(xp1,yp1,2);
		torn = 3;
		checkTorn();
	}
}


public void getShip(int x1 , int y2,int plye){

	for(int i = 0; i < (map.length); i++) {
		if(i == x1){
			x = x1;
		}
		if (i == y2) {
			y = y2;
			}		
		
	}
		
		if(x != -1 && y != -1 && plye == 1 ) {
			map[x][y] = 1; //ADD AL MAPA EL BAIXELL ES A DIR EL 1 o 2 depen
			hits[x][y] = 1;// YA VAIG FICANT A LA SUPOSTA POSICIO EN EL QUE ESTA EL VAIXELL PER A DISPARAR
		}else{
			map[x][y] = 2; //ADD AL MAPA EL BAIXELL ES A DIR EL 1 o 2 depen
			hits[x][y] = 2;// YA VAIG FICANT A LA SUPOSTA POSICIO EN EL QUE ESTA EL VAIXELL PER A DISPARAR
		}
	
	
	}


public void checkTorn(){
	if (torn == 3) {
		blankSpace(50);
		System.out.println("Torn del jugador 1");
		ShipHit(1);
	}else if (torn == 4){
		blankSpace(50);
		System.out.println("Torn del jugador 2");
		setShip(2);
	}else{
		blankSpace(50);
		System.out.println("Torn del jugador 1");
		ShipHit(1);
	}
}


public void ShipHit(int plyr){
	
	System.out.println("Canó >> coordenada X : ");
	int hitx = sc.nextInt();
	
	System.out.println("Canó >> coordenada Y : ");
	int hity = sc.nextInt();
	
	if (map[hitx][hity] == plyr) {
		blankSpace(50);
		System.out.println("Te ha disparat a tu mateixa !!!");
		sleepTime(1000);
		blankSpace(50);
		if(plyr == 1){
			torn = 4;
			System.out.println("Torn del jugador 2");
			ShipHit(2);
		}else{
			System.out.println("Torn del jugador 1");
			ShipHit(1);
		}
	}else{
		hitShip(hitx,hity,plyr);
	}
	
}


public void hitShip(int x1, int y2, int plyer){
if(hits[x1][y2] == 1 || hits[x1][y2] == 2){
	blankSpace(50);
	System.out.println("Vaixell esfonsat! Guanyador jugador " + plyer);
	reloadGame();
		}else{
			blankSpace(50);
			System.out.println("Aigua!");//@TODO añadir codic de reinici!
			sleepTime(500);
			if (plyer == 1) {
				blankSpace(50);
				System.out.println("Torn del jugador 2");
				ShipHit(2);
			}else{
				blankSpace(50);
				System.out.println("Torn del jugador 1");
				ShipHit(1);
			}
			
		}
	}


private void blankSpace(int blanks){
	for (int i = 0; i < blanks; i++) {
		System.out.println();
	}
}

private void sleepTime(int sleepT){
	try {
		Thread.sleep(sleepT);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

public void reloadGame(){
	sleepTime(20000);
	blankSpace(1000);
	System.out.println("Reiniciant joc ... ");
	sleepTime(2000);
	blankSpace(1000);
	run();
	
}
}

