package javaapplication1;
public class Dice {

	public int toss() {
		return 1 + (int) (6 * Math.random());
	}
        
        public int fuel_toss() {
            return 1 + (int) (3 * Math.random());
        }
        
        public int randomFuel() {
             return 1 + (int) (120 * Math.random());
        }
        
        

}
