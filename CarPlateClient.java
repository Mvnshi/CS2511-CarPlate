// Munshi Abrar
// Chapter11 Individual Lab Assignment

import java.io.*;
import java.util.ArrayList;

public class CarPlateClient
{
	public static void main( String [] args )
	{
		// instantiate the objects
		CarPlate p1 = new CarPlate( "NY821000C", "New York", "Blue" );
		CarPlate p2 = new CarPlate( "FL391033D", "Florida", "White" );
		CarPlate p3 = new CarPlate( "CA31GH0Z", "California", "Black" );

		try
		{
			FileOutputStream fos = new FileOutputStream( "objects", false ); // false means we will write to objects
			ObjectOutputStream oos = new ObjectOutputStream( fos );

			// write the objects to the file
			oos.writeObject( p1 );
			oos.writeObject( p2 );
			oos.writeObject( p3 );

			// release resources associated with the objects file
			oos.close( );
		}

		catch ( FileNotFoundException fnfe )
		{
			System.out.println( "Unable to write to objects" );
		}

		catch ( IOException ioe )
		{
			ioe.printStackTrace( );
		}

		ArrayList<CarPlate> plates = new ArrayList<CarPlate>( );
		try
		{
			FileInputStream fis = new FileInputStream( "objects" );
			ObjectInputStream ois = new ObjectInputStream( fis );
			int objects = 0;
		try
		{
			while ( true )
			{
				// read object, type cast returned object to CarPlate
				CarPlate temp = ( CarPlate ) ois.readObject( );
				System.out.println(temp.toString());
				objects++;

				// add the CarPlate object read to plates
				plates.add( temp );
			}
		} // end inner try block

		catch ( EOFException eofe )
		{
			System.out.println( "End of the file reached" );
		}

		catch ( ClassNotFoundException cnfe )
		{
			System.out.println( cnfe.getMessage( ) );
		}

		catch ( FileNotFoundException fnfe )
		{
			System.out.println( "Unable to find objects" );
		}

		finally
		{
			System.out.println( "Closing file with a total of " + objects + " objects");
			ois.close( );
		}
		} // end outer try block

		catch ( IOException ioe )
		{
			ioe.printStackTrace( );
		}
	}
}
