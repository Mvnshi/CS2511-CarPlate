// Munshi Abrar
// Chapter11 Individual Lab Assignment

import java.io.Serializable;
import java.text.DecimalFormat;

public class CarPlate implements Serializable
{
	private String plateNumber;     // ex. = NY821000C
	private String state;           // Plate State; ex. = New Jersey
	private String color;      // Car Color; ex. = Yellow

	// Constructor
	public CarPlate( String plateNumber, String state, String color )
	{
		this.plateNumber = plateNumber;
		this.state = state;
		this.color = color;
	}

	// toString
	public String toString( )
	{
		return "Plate Number: " + plateNumber
			+ ", State: " + state
			+ ", Color: " + color;
	}
	// other accessors, mutators, and other methods
}
