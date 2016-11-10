package Logica;
 

public class HiloTimer extends Thread{

	public HiloTimer(){
		
	}
	
	public void run(){
		try {
			this.sleep(15000);
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
}
