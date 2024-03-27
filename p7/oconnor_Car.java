//done and compiles
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.*;

class oconnor_Car implements CarFunctions
{
	//step 6c not sure if this is the correct way
	private final int fuelEconomyInMilesPerGallon;
	private final int fuelCapacityInGallons;
	private Double currentFuelInGallons;
	private final String id;
	
	//I believe this is 6d
	public oconnor_Car(String id, int fuelEconomyInMilesPerGallon, int fuelCapacityInGallons, Double currentFuelInGallons)
	{
		this.id = id;
		this.fuelEconomyInMilesPerGallon = fuelEconomyInMilesPerGallon;
		this.fuelCapacityInGallons = fuelCapacityInGallons;
		this.currentFuelInGallons = currentFuelInGallons;
	}

	public String getId()
	{
		return id;
	}

	public int getFuelEconomyInMilesPerGallon()
	{
		return fuelEconomyInMilesPerGallon;
	}

	public int getFuelCapacityInGallons()
	{
		return fuelCapacityInGallons;
	}

	public double getCurrentFuelInGallons()
	{
		return currentFuelInGallons;
	}
	
	public void setCurrentFuelInGallons(double v)
	{
		currentFuelInGallons = v;
	}
	public String toString()
	{
		return getId() + "\t" + getFuelEconomyInMilesPerGallon() + "\t" + getFuelCapacityInGallons() + "\t" + getCurrentFuelInGallons() + "\t" + getTotalRangeInMiles() + "\t" + getRemainingRangeInMiles();
	}
}
