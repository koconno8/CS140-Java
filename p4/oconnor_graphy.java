/*import java.util.ArrayList;

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
			throw GraphException("duplicate vertices");
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
			throw GraphException("Not in list");
		}

		if(isDirected)
		{
			for(int j = 0; j < edges.size(); j++)
			{
				Edge currentEdge = edges.get(j);
				//put code here to work w current edge

				if(currentEdge.fromVertex() == from && currentEdge.toVertex() == to)
				{
					throw GraphException("duplicate edge");
				}

				else
				{
					edges.add(edge1);
				}
			}
		}
		else 
		{
			for(int j = 0; j < edges.size(); j++)
			{
				Edge currentEdge = edges.get(j);
				//put code here to work w current edge

				if(currentEdge.fromVertex() == from && currentEdge.toVertex() == to)
				{
					throw GraphException("duplicate edge");
				}

				//because undirected and the second point could be the first
				else if(currentEdge.fromVertex() == to && currentEdge.toVertex == from)
				{
					throw GraphException("duplicate edge");
				}

				else
				{
					edges.add(edge1);
				}
			}
		}	
	}


	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("G = (V, E) \n");
		
		sb.append("V = {");
		for(int i = 0; i < vertices.size() - 1; i++)
		{
			sb.append(vertices.get(i) + ",");
		}
		//since the last one does not have a comma after it, I added it outside
		sb.append(vertices.get(vertices.size()) + "}\n");
		
		sb.append("E = {")
		for(int i = 0; i < edges.size() - 1; i++)
		{
			sb.append(edges.get(i) + ",");
		}
		//since the last one does not have a comma after it, I added it outside
		sb.append(edges.get(edges.size()) + "}\n");

		return sb.toString();
	}

	//if (isDirected()) call isConnected(edges) 
	//private call isConnected(reverseEdges) 
	//the private one make the reverse edges list by looping through edges and making every fromVertex the toVertex	


	private boolean isConnected(ArrayList<Edge> edges)
	{
		java.util.HashSet<Integer> connectedSubset = new java.util.HashSet<>();
		connectedSubset.add(vertices.get(0));
		java.util.ArrayDeque<Integer> newlyAddedVertices = new java.util.ArrayDeque<>();
		newlyAddedVertices.add(vertices.get(0));

		while(newlyAddedVertices.size() != 0)
		{
			//get the first element from newlyAddedVertices and also remove it from newlyAddedVertices
			int currentVertex = newlyAddedVertices.pollFirst()

			for(int i = 0; i < edges.size(); i++)
			{
				//to get the current edge
				Edge e  = Edge.get(i);

				if(isDirected())
				{
					if(e.fromVertex() == currentVertex)
					{
						//check if the other vertex of the edge is in connectedSubset
						if(connectedSubset.contains(e.toVertex()))
						{
							return "";
						}
						//If it is not contained in connectedSubset add it to connectedSubset and to newlyAddedVertices
						else
						{
							connectedSubset.add(e.toVertex());
							newlyAddedVertices.add(e.toVertex());
						}
					}
				}
				else
				{
					if(e.toVertex == currentVertex)
					{
						if(connectedSubset.contains(e.fromVertex()))
						{
							return "";
						}
						else
						{
							connectedSubset.add(e.fromVertex());
							newlyAddedVertices.add(e.fromVertex());
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
		//1a -To create an initially empty HashSet<Integer>
		//java.util.HashSet<Integer> connectedSubset = new java.util.HashSet<>();

		//2a - I used the vertex at index 0 in the ArrayList<Integer> vertices as my starting vertex
		//connectedSubset.add(vertices.get(0));

		//3a - I also used an ArrayDeque<Integer>, as a queue, to keep track of when vertices were initially added to the connected vertices set
		//java.util.ArrayDeque<Integer> newlyAddedVertices = new java.util.ArrayDeque<>();

		//I used the vertex at index 0 in the ArrayList<Integer> vertices as my starting vertex
		//newlyAddedVertices.add(vertices.get(0));

		/*while(newlyAddedVertices.size() != 0)
		{
			//get the first element from newlyAddedVertices and also remove it from newlyAddedVertices
			int currentVertex = newlyAddedVertices.pollFirst()

			for(int i = 0; i < edges.size(); i++)
			{
				//to get the current edge
				Edge e  = Edge.get(i);

				//if currentVertex is one of the vertices contained in the current edge
				if(e.fromVertex() == currentVertex)
				{
					//check if the other vertex of the edge is in connectedSubset
					if(connectedSubset.contains(e.toVertex()))
					{
						return "";
					}
					//If it is not contained in connectedSubset add it to connectedSubset and to newlyAddedVertices
					else
					{
						connectedSubset.add(e.toVertex());
						newlyAddedVertices.add(e.toVertex());
					}
				}*/

				//For a directed graph, if currentVertex is the from vertex contained of the current edge 

				//if (isDirected()) call isConnected(edges) 
				//private call isConnected(reverseEdges) 
				//the private one make the reverse edges list by looping through edges and making every fromVertex the toVertex	



				//in public check to see if the graph is connected if it is call private is connected, then reverse the edges and call private is connected with the reversed edges again
/*
				if(isDirected())
				{
					isConnected(edges);
				}

				if(e.fromVertex() == currentVertex)
				{
					//then check if the to vertex of the edge is in connectedSubset
					if(connectedSubset.contains(e.toVertex()))
					{
						return true;
					}
					else
					{
						//If it is not contained in connectedSubset add it to connectedSubset and to newlyAddedVertices
						connectedSubset.add(e.toVertex);
						newlyAddedVertices.add(e.toVertex);
					}
				}

				//Check if the connected vertices set, connectedSubset, contains all of the vertices of the graph	
				if(connectedSubset.size() == vertices.size())
				{
					return true;
				}
				else
				{
					return false;
				}
				//For an undirect graph, the above pseudo code will tell you if the graph is connected, by simply checking if connectedSubset contains all of the vertices of the graph

				/*Use the above pseudo code to see if there is a forward path from the starting vertex, the one initially added to connectedSubset, to every other vertex in the graph
				for(i=0; i < connectedSubset.size(); i++)
				{
					conn = connectedSubset[i]
					if(conn.isConnected() && conn.isDirected())
					{

					}
				}*/
			}
		}
/*
		return false;
	}

}
