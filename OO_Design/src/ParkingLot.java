/** Parking Lot: Design a parking lot using object-oriented principles */

class ParkingSpace {
	
	int timeIn;
	int timeOut;
	int price;
	boolean spaceOccupied;
	int spaceNumber;
	int parkingLevel;
	
	
	public ParkingSpace(int timeIn, int timeOut, int price, boolean spaceOccupied, int parkingLevel, int spaceNumber) {
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.spaceOccupied = spaceOccupied;
		this.parkingLevel = parkingLevel;
		this.spaceNumber = spaceNumber;
	}
	
}

public class ParkingLot {
	
	int parkingLotLevels = 5;
	int spaceNumbers = 100;
	ParkingSpace[][] parkingSpaces;
	
	public ParkingLot() {
		this.parkingSpaces = new ParkingSpace[parkingLotLevels][spaceNumbers];
	}
	
	public void createParkingLot() {
		for(int i = 0; i < parkingLotLevels; i++) {
			for(int j = 0; j < spaceNumbers; j++) {
				parkingSpaces[i][j] = new ParkingSpace(0,0,0,false,i,j);
				System.out.println("Parking Level "+parkingSpaces[i][j].parkingLevel+", Space "+parkingSpaces[i][j].spaceNumber+", Occupied = "+parkingSpaces[i][j].spaceOccupied);
			}
		}
	}
	
	public void setParking(int parkingLevel, int parkingSpace, int timeIn) {
		parkingSpaces[parkingLevel][parkingSpace].spaceOccupied = true;
		parkingSpaces[parkingLevel][parkingSpace].timeIn = timeIn;
	}
	
	public int payParking(int parkingLevel, int parkingSpace, int timeOut) {
		parkingSpaces[parkingLevel][parkingSpace].timeOut = timeOut;
		parkingSpaces[parkingLevel][parkingSpace].spaceOccupied = false;
		return parkingSpaces[parkingLevel][parkingSpace].price = (timeOut - parkingSpaces[parkingLevel][parkingSpace].timeIn);
	}
	
	public static void main(String[] args) {
		ParkingLot pl = new ParkingLot();
		pl.createParkingLot();
		pl.setParking(3, 84, 1235);
		System.out.println("Total price for parking floor 3, space 84 is "+pl.payParking(3, 84, 1425)+" cents");
	}

}
