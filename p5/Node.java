public class Node implements NodeFunctions
{
	private final int key;
	private Node parent;
	private Node left;
	private Node right;
	private Object data;
	
	public Node(int key, Object data)
	{
		this.key = key;
		parent = null;
		left = null;
		right = null;
		this.data = data;
	}
	
	public Node(int key)
	{
		this(key, null);
	}
	
	public int getKey()
	{
		return 0;
	}
	
	public Node getParent()
	{
		return null;
	}
	
	public Node getLeft()
	{
		return null;
	}
	
	public Node getRight()
	{
		return null;
	}
	
	public void setLeft(Node n)
	{
	}
	
	public void setRight(Node n)
	{
	}
	
	public void setParent(Node n)
	{
	}
	
	public String toString()
	{
		String left = "";
		String right = "";
		String parent = "";
		String current = "";
		if(this.getParent() != null)
		{
			parent += this.getParent().getKey();
		}
		if(this.getLeft() != null)
		{
			left += this.getLeft().getKey();
		}
		if(this.getRight() != null)
		{
			right += this.getRight().getKey();
		}
		return "(" + this.getKey() + "," + parent + "," + left + "," + right + ")";
	}

	public boolean equals(Object o)
	{
		if(o instanceof Node)
		{
			Node nodey = (Node) o;
			if(nodey.getKey() == key)
			{
				return true;
			}
		}
		return false;
	}
	
	public Object getData()
	{
		return null;
	}
	
	public void setData(Object o)
	{
		this.data = o;
	}
}
