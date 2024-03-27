import java.util.*;
class VertexWithWeightWeightComparator implements java.util.Comparator<VertexWithWeight>
{
    public int compare(VertexWithWeight o1, VertexWithWeight o2)
    {
        if(o1.getWeight().doubleValue() < o2.getWeight().doubleValue())
        {
            return -1;
        }

        if(o1.getWeight().doubleValue() > o2.getWeight().doubleValue())
        {
            return 1;
        }

        if(o1.getWeight().doubleValue() == o2.getWeight().doubleValue())
        {
            if(o1.getVertex().intValue() < o2.getVertex().intValue())
            {
                return -1;
            }
        }

        if(o1.getWeight().doubleValue() == o2.getWeight().doubleValue())
        {
            if(o1.getVertex().intValue() > o2.getVertex().intValue())
            {
                return 1;
            }
        }

        if(o1.getWeight().doubleValue() == o2.getWeight().doubleValue())
        {
            if(o1.getVertex().intValue() == o2.getVertex().intValue())
            {
                return 0;
            }
        }
        return 0;
    }
}