class RemainingRangeComparator implements java.util.Comparator<CarFunctions>
{
	//You need to implement this class. You should use TotalRangeComparator.java as a guide as to what to do for this file
	public int compare(CarFunctions o1, CarFunctions o2)
	{
		if( o1.getRemainingRangeInMiles() < o2.getRemainingRangeInMiles() )
		{
			return -1;
		}
		
		if( o1.getRemainingRangeInMiles() > o2.getRemainingRangeInMiles() )
		{
			return 1;
		}
		
		return o1.getId().compareTo(o2.getId());
	}
}
