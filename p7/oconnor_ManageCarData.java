import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.*;

class oconnor_ManageCarData implements ManageCarDataFunctions
{
	//7c
	private final ArrayList<CarFunctions> carList;
	private final PriorityQueue<CarFunctions> carListByTotalRange;
	private final PriorityQueue<CarFunctions> carListByRemainingRange;
	
	//7d?
	public oconnor_ManageCarData() 
	{
		carList = new ArrayList<CarFunctions>();
		carListByTotalRange = new PriorityQueue<>(new TotalRangeComparator());
		carListByRemainingRange = new PriorityQueue<>(new RemainingRangeComparator());
	}
	
	//7e.1
	public void readData(String filename)
	{
		try 
		{
			java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
			String inn;
			while( (inn = input.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(inn, "\t");
				
				//
				String id = st.nextToken();
				Integer fuelEconomy = Integer.parseInt(st.nextToken());
				Integer fuelCapacity = Integer.parseInt(st.nextToken());
				Double remainingFuel = Double.parseDouble(st.nextToken());
				//			
				
				CarFunctions c = new oconnor_Car(id, fuelEconomy, fuelCapacity, remainingFuel);
				carList.add(c);
				carListByTotalRange.add(c);
				carListByRemainingRange.add(c);
			}
		}
      	catch (Exception e) 
     	{
        	System.out.println(e);
      	}
	}

	//7e.2
	public ArrayList<CarFunctions> getCarList()
	{
		ArrayList<CarFunctions> tempCarList = new ArrayList<>();

		for( int i = 0; i < carList.size(); i++ )
		{
			tempCarList.add(carList.get(i));
		}
		return tempCarList;
	}

	//7e.3
	public PriorityQueue<CarFunctions> getCarListByTotalRange()
	{
		PriorityQueue<CarFunctions> newCarListByTotalRange = new PriorityQueue<>(new TotalRangeComparator());

		for( int i = 0; i < carList.size(); i++ )
		{
			newCarListByTotalRange.add(carList.get(i));
		}
		return newCarListByTotalRange;
	}

	//7e.4
	public ArrayList<CarFunctions> getCarListByTotalRangeUsingIterator()
	{
		ArrayList<CarFunctions> newCarListByTotalRangeIterator = new ArrayList<>();
		Iterator<CarFunctions> carListIterator = carListByTotalRange.iterator();

		while(carListIterator.hasNext())
		{
			newCarListByTotalRangeIterator.add(carListIterator.next());
		}
		return newCarListByTotalRangeIterator;
	}

	//7e.5
	public PriorityQueue<CarFunctions> getCarListByRemainingRange()
	{
		PriorityQueue<CarFunctions> newCarListByRemainingRange = new PriorityQueue<>(new RemainingRangeComparator());
		for( int i = 0; i < carList.size(); i++ )
		{
			newCarListByRemainingRange.add(carList.get(i));
		}
		return newCarListByRemainingRange;
	}

	//7e.6
	public ArrayList<CarFunctions> getCarListByRemainingRangeUsingIterator()
	{
		ArrayList<CarFunctions> newCarListByRemainingRangeIterator = new ArrayList<>();
		Iterator<CarFunctions> carListIterator = carListByRemainingRange.iterator();

		while(carListIterator.hasNext())
		{
			newCarListByRemainingRangeIterator.add(carListIterator.next());
		}
		return newCarListByRemainingRangeIterator;
	}

	//7e.7
	public ArrayList<String> getCarListByTotalRangeViaPoll(double minTotalRange, double maxTotalRange)
	{
		ArrayList<String> str = new ArrayList<>();

		while(carListByTotalRange.size() > 0)
		{
			//not sure what to add the poll to
			CarFunctions element = carListByTotalRange.poll();
			if( element.getTotalRangeInMiles() >= minTotalRange && element.getTotalRangeInMiles() <= maxTotalRange)
			{
				//7e.7.2.1
				//not sure if its a double
				CarFunctions currentCar = element;
				String currentCarString = currentCar.toString();
				
				for(int i=0; i < carList.size(); i++)
				{
					//7e.7.2.1.3.1
					//do I use get(i) or carList[i]?
					if(carList.get(i).equals(currentCar))
					{
						currentCarString += "\t" + i;
					}
				}

				for(int j = 0; j < carList.size(); j++)
				{
					if(carList.get(j).getFuelEconomyInMilesPerGallon() == currentCar.getFuelEconomyInMilesPerGallon())
					{
						currentCarString += "\t" + j;
					}
				}
				str.add(currentCarString);
			}

		}

		for(int k=0; k < carList.size(); k++)
		{
			//7e.7.2.6
			//not sure if its right
			carListByTotalRange.add(carList.get(k)); 
		}
		return str;
	}
	public ArrayList<String> getCarListByRemainingRangeViaPoll(double minRemainingRange, double maxRemainingRange)
	{
		ArrayList<String> str = new ArrayList<>();

		while(carListByRemainingRange.size() > 0)
		{
			//not sure what to add the poll to
			//not sure if its a double
			CarFunctions element1 = carListByRemainingRange.poll();

			if( element1.getRemainingRangeInMiles() >= minRemainingRange && element1.getRemainingRangeInMiles() <= maxRemainingRange)
			{
				CarFunctions currentCar = element1;
				String currentCarString = currentCar.toString();

				for(int i=0; i < carList.size(); i++)
				{
					if(carList.get(i).equals(currentCar))
					{
						currentCarString += "\t" + i;
					}
				}

				for(int j = 0; j < carList.size(); j++)
				{
					if(carList.get(j).getFuelEconomyInMilesPerGallon() == currentCar.getFuelEconomyInMilesPerGallon())
					{
						currentCarString += ("\t" + j);
					}
				}
				str.add(currentCarString);
			}
		}
		for(int k=0; k < carList.size(); k++)
		{
			carListByRemainingRange.add(carList.get(k)); 
		}
		return str;

	}
}
