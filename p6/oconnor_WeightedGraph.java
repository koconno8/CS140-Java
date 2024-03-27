import java.util.ArrayList;
import java.util.*;
import java.util.HashSet;
import java.util.ArrayDeque;

public class oconnor_WeightedGraph implements WeightedGraphFunctions
{
    private final ArrayList<Integer> vertices;
	private final ArrayList<EdgeWithWeight> edges;
	
	//private boolean debugOutput = false;

	private int[] parent; 
	private VertexWithWeight[] verticeCost; 
	private java.util.PriorityQueue<VertexWithWeight> minPriorityQueueByWeight;
	
	public oconnor_WeightedGraph()
	{
		vertices = new ArrayList<>();
		edges = new ArrayList<>();
		minPriorityQueueByWeight = new java.util.PriorityQueue<>(new VertexWithWeightWeightComparator());
	}

	public boolean hasPath(int fromVertex, int toVertex)
    {
        return (boolean) this.getPath(fromVertex,toVertex, WeightedGraphReturnType.HAS_PATH);
    }

	public double getMinimumWeight(int fromVertex, int toVertex)
    {
        return (double) this.getPath(fromVertex,toVertex, WeightedGraphReturnType.GET_MINIMUM_WEIGHT);
    }

	public EdgeWithWeight[] getPath(int fromVertex, int toVertex)
    {
        return (EdgeWithWeight[]) this.getPath(fromVertex, toVertex, WeightedGraphReturnType.GET_PATH);
    }

	public int getIndex(Integer v)
	{
		for(int i = 0; vertices.size() > i; i++)
		{
			if(v.intValue() == vertices.get(i))
			{
				return i;
			}
		}
		return -1;
	}

	private Object getPath(int fromVertex, int toVertex, WeightedGraphReturnType typeOfInfo)
	{
		int[] parent = new int[vertices.size()]; 
		verticeCost = new VertexWithWeight[vertices.size()];
		int fromVertexIndex = vertices.indexOf(fromVertex);

		for( int i = 0; i < vertices.size(); i++ )
    	{
			parent[i] = -1;
			verticeCost[i] = new VertexWithWeight(vertices.get(i), Double.POSITIVE_INFINITY);
   		}

    	parent[fromVertexIndex] = fromVertex;
    	verticeCost[fromVertexIndex] = new VertexWithWeight(vertices.get(fromVertexIndex), 0.0);

    	for(int i = 0; i < vertices.size(); i++)
   		{
        	minPriorityQueueByWeight.add(verticeCost[i]);
    	}

		boolean bool = false;
    	while(minPriorityQueueByWeight.size() > 0)
    	{
			VertexWithWeight wgt = minPriorityQueueByWeight.poll();
        	int v = wgt.getVertex();
			
			
        	if(parent[getIndex(v)] == -1)
        	{
				
        	    break;
				
        	}
       		else if(toVertex == v)
        	{
				bool = true;
        	    break;
        	}
        
        	for(int i = 0; edges.size() > i; i++)
        	{
				
				EdgeWithWeight currentEdge = edges.get(i);
            	if(currentEdge.getFromVertex() == v)
            	{
               		int u = currentEdge.getToVertex();
					if(verticeCost[vertices.indexOf(v)].getWeight() + currentEdge.getWeight() < verticeCost[vertices.indexOf(u)].getWeight())
					{
						
						minPriorityQueueByWeight.remove(verticeCost[getIndex(u)]);
						verticeCost[getIndex(u)].setWeight(wgt.getWeight() + currentEdge.getWeight());
						minPriorityQueueByWeight.add(verticeCost[getIndex(u)]);
						parent[getIndex(u)] = v;
					}
            	}
        	}
			/*if(parent[vertices.indexOf(toVertex)] == -1) //not sure if toVertex goes in there page 6 instructions
			{
				System.out.println("here");
				break;
			}
			*/
    	}
		
		if(bool)
		{
			ArrayList<Integer> reversePath = new ArrayList<>();
			ArrayList<Integer> forwardPath = new ArrayList<>();

			int p = toVertex;
			reversePath.add(p);
			while ( p != fromVertex )
			{
				p = parent[vertices.indexOf(p)];
				reversePath.add(p);
			}
			
			for( int i = reversePath.size() - 1; i >= 0; i-- )
			{
				forwardPath.add(reversePath.get(i));
			}

			
			EdgeWithWeight[] eww = new EdgeWithWeight[forwardPath.size() -1];
			for(int i=0; eww.length > i; i++)
			{
				//EdgeWithWeight currentEdge = edges.get(i);
				for(int j = 0; edges.size() > j; j++)
				{
					
					if(edges.get(j).getFromVertex() == forwardPath.get(i) && edges.get(j).getToVertex() == forwardPath.get(i+1))
					{
						
						eww[i] = edges.get(j);
					}
				}
			}
			
			if(WeightedGraphReturnType.HAS_PATH == typeOfInfo)
			{
				return true;
			}

			if(WeightedGraphReturnType.GET_MINIMUM_WEIGHT == typeOfInfo)
			{
				return verticeCost[getIndex(toVertex)].getWeight();
			}

			if(WeightedGraphReturnType.GET_PATH == typeOfInfo)
			{
			
				
				return eww;
			}
			return eww;
		}
		else
		{
			if(WeightedGraphReturnType.HAS_PATH == typeOfInfo)
			{
				return false;
			}
			if(WeightedGraphReturnType.GET_MINIMUM_WEIGHT == typeOfInfo)
			{
				return Double.NaN;
			}
			if(WeightedGraphReturnType.HAS_PATH == typeOfInfo)
			{
				return new EdgeWithWeight[0];
			}
		}
		return new EdgeWithWeight[0];
	}

	public boolean addVertex(int v) //throws GraphException
    {
        if(vertices.contains(v))
		{
			return false;
		}
		else
		{
			vertices.add(v);
		}
		return true;
    }


	public boolean addWeightedEdge(int from, int to, double weight) //throws GraphException
    {
        //EdgeWithWeight weightedEdge1 = new EdgeWithWeight(from, to, weight);

		//Your program should also throw a GraphException, and not add the edge, when adding edge (u, v) if either of the vertices u or v do not exist in the list of vertices.
		if(!(vertices.contains(from) && vertices.contains(to)))
		{
			return false;
		}

		else 
		{
			for(int j = 0; j < edges.size(); j++)
			{
				EdgeWithWeight currentEdge = edges.get(j);
				//put code here to work w current edge

				if(currentEdge.getFromVertex() == from && currentEdge.getToVertex() == to)
				{
					return false;
				}
			}
			edges.add(new EdgeWithWeight(from, to, weight));
			return true;
		}	
	}

	public String toString()
    {
        StringBuilder sb = new StringBuilder();
		//sb.append("G = (V, E)\n");
		
		/*sb.append("V = {");
		for(int i = 0; i < vertices.size() - 1; i++)
		{
			sb.append(vertices.get(i) + ",");
		}*/
		//since the last one does not have a comma after it, I added it outside
		//sb.append(vertices.get(vertices.size()-1) + "}\n");
		
		//sb.append("E = {");
		/*for(int i = 0; i < edges.size() - 1; i++)
		{
			sb.append(edges.get(i) + ",");
		}
		//since the last one does not have a comma after it, I added it outside
		sb.append(edges.get(edges.size() - 1) + "}\n");
		*/
		return sb.toString();
    }
	
}

