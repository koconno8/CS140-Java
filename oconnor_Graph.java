import java.util.ArrayList;
import java.util.*;
import java.util.HashSet;
import java.util.ArrayDeque;

public class oconnor_Graph implements ConnectedGraphFunctions
{
	private final ArrayList<Integer> vertices;
	private final ArrayList<Edge> edges;
	private final boolean isDirected;
	
	oconnor_Graph()
	{
		this(false);
	}
	
	oconnor_Graph(boolean isDirected)
	{
		this.isDirected = isDirected;
		vertices = new ArrayList<>();
		edges = new ArrayList<>();
	}
	public int getNumberOfVertices()
	{
		return vertices.size();
	}
	public int getNumberOfEdges()
	{
		return edges.size();
	}
	public boolean isDirected()
	{
		 return isDirected;
	}
	public void addVertex(int v) throws GraphException
	{
		//avoids duplicate vertices
		if(vertices.contains(v))
		{
			throw new GraphException("duplicate vertices");
		}
		else
		{
			vertices.add(v);
		}
	}
	public void addEdge(int from, int to) throws GraphException
	{
		Edge edge1 = new Edge(from, to);

		//Your program should also throw a GraphException, and not add the edge, when adding edge (u, v) if either of the vertices u or v do not exist in the list of vertices.
		if(!(vertices.contains(from) && vertices.contains(to)))
		{
			throw new GraphException("Not in list");
		}

		if(isDirected)
		{
			for(int j = 0; j < edges.size(); j++)
			{
				Edge currentEdge = edges.get(j);
				//put code here to work w current edge

				if(currentEdge.fromVertex() == from && currentEdge.toVertex() == to)
				{
					throw new GraphException("duplicate edge");
				}
			}
			edges.add(edge1);
		}
		else 
		{
			for(int j = 0; j < edges.size(); j++)
			{
				Edge currentEdge = edges.get(j);
				//put code here to work w current edge

				if(currentEdge.fromVertex() == from && currentEdge.toVertex() == to)
				{
					throw new GraphException("duplicate edge");
				}

				//because undirected and the second point could be the first
				else if(currentEdge.fromVertex() == to && currentEdge.toVertex() == from)
				{
					throw new GraphException("duplicate edge");
				}
			}
			edges.add(edge1);
		}	
	}


	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("G = (V, E)\n");
		
		sb.append("V = {");
		for(int i = 0; i < vertices.size() - 1; i++)
		{
			sb.append(vertices.get(i) + ",");
		}
		//since the last one does not have a comma after it, I added it outside
		sb.append(vertices.get(vertices.size()-1) + "}\n");
		
		sb.append("E = {");
		for(int i = 0; i < edges.size() - 1; i++)
		{
			sb.append(edges.get(i) + ",");
		}
		//since the last one does not have a comma after it, I added it outside
		sb.append(edges.get(edges.size() - 1) + "}");

		return sb.toString();
	}

	private boolean isConnected(ArrayList<Edge> edges)
	{
		java.util.HashSet<Integer> connectedSubset = new java.util.HashSet<>();
		connectedSubset.add(vertices.get(0));
		java.util.ArrayDeque<Integer> newlyAddedVertices = new java.util.ArrayDeque<>();
		newlyAddedVertices.add(vertices.get(0));

		while(newlyAddedVertices.size() != 0)
		{
			//get the first element from newlyAddedVertices and also remove it from newlyAddedVertices
			int currentVertex = newlyAddedVertices.pollFirst();

			for(int i = 0; i < edges.size(); i++)
			{
				//to get the current edge
				Edge e  = edges.get(i);

				if(isDirected())
				{
					if(e.fromVertex() == currentVertex)
					{
						//check if the other vertex of the edge is in connectedSubset
						if(!(connectedSubset.contains(e.toVertex())))
						{
							connectedSubset.add(e.toVertex());
							newlyAddedVertices.add(e.toVertex());
						}
					}
				}
				else
				{
					if(e.toVertex() == currentVertex)
					{
						if(!(connectedSubset.contains(e.fromVertex())))
						{
							connectedSubset.add(e.fromVertex());
							newlyAddedVertices.add(e.fromVertex());
						}
					}
					
					else if(e.fromVertex() == currentVertex)
					{
						//check if the other vertex of the edge is in connectedSubset
						if(!(connectedSubset.contains(e.toVertex())))
						{
							connectedSubset.add(e.toVertex());
							newlyAddedVertices.add(e.toVertex());
						}
					}
				}
			}
		}

		if(connectedSubset.size() == vertices.size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	public boolean isConnected()
	{
		//in public check to see if the graph is connected if it is call private is connected, then reverse the edges and call private is connected with the reversed edges again

		boolean forward = isConnected(edges);

		if(!(isDirected()))
		{
			return forward;
		}

		if(isDirected())
		{
			ArrayList<Edge> reverseEdges = new ArrayList <>();
			for(int i = 0; i < edges.size(); i++)
			{
				Edge currentEdge = edges.get(i);
				Edge newEdge = new Edge(currentEdge.toVertex(), currentEdge.fromVertex());
				reverseEdges.add(newEdge);
			}
			boolean reverse = isConnected(reverseEdges);
			return reverse && forward;
		}
		return false;
	}
}
