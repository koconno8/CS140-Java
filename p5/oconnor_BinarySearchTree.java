import java.util.ArrayList;
import java.util.*;
public class oconnor_BinarySearchTree implements BinarySearchTreeFunctions
{
	private Node root;
	private ArrayList<String> nodeList = new ArrayList<String>();
	
	/*I will be using my own copy of Node.java, so make sure that you are using the getters and setters 
	to access the fields. The fields of your Node class should all be private and should not be accessed 
	directly by any code outside of the Nodeclass.*/
	
	public oconnor_BinarySearchTree()
	{
		root = null;
	}
	
	public Node getRoot()
	{
		return root;
	}
	
	public void setRoot(Node root)
	{
		this.root = root;
	}
		
	public void insertNode(Node z)
	{
		Node x = getRoot();
		Node y = null;
		while(x != null)
		{
			y = x;
			if(z.getKey() < x.getKey())
			{
				x = x.getLeft();
			}
			else
			{
				x = x.getRight();
			}
		}
		z.setParent(y);
		if(y == null)
		{
			setRoot(z);
		}
		else
		{
			if(z.getKey() < y.getKey())
			{
				y.setLeft(z);
			}
			else
			{
				y.setRight(z);
			}
		}
		nodeList.add(z.toString());
	}
	
	public void updateNode(Node z)
	{
		if(nodeList.contains(z))
		{
			Node n = getNode(z, z.getKey());
		}
	}
	
	public void preOrderWalk(Node x)
	{
		if( x != null )
		{
			System.out.println(x.toString());
			preOrderWalk(x.getLeft());
			preOrderWalk(x.getRight());
		}
	}
	
	public void preOrderWalk(Node x, java.util.ArrayList<String> list)
	{
		if( x != null )
		{
			list.add(x.toString());
			preOrderWalk(x.getLeft(), list);
			preOrderWalk(x.getRight(), list);
		}
	}
	
	public void preOrderWalk(Node x, String id, java.util.ArrayList<String> result)
	{
		if( x != null )
		{
			System.out.println(x.toString() + " " + id);
			result.add(x.getKey() + " " + id);
			preOrderWalk(x.getLeft(), "0"+id, result);
			preOrderWalk(x.getRight(), "1"+id, result);
		}
	}
	
	public void inOrderWalk(Node x)
	{
		if(x != null)
		{
			inOrderWalk(x.getLeft());
			nodeList.add(x.toString());
			inOrderWalk(x.getRight());
		}
	}
	public void inOrderWalk(Node x, java.util.ArrayList<String> list)
	{
		if( x != null )
		{
			inOrderWalk(x.getLeft(), nodeList);
			nodeList.add(x.toString()); // for us, this will equate to nodeList.add(x.toString())
			inOrderWalk(x.getRight(), nodeList);
		}
	}
	
	public void postOrderWalk(Node x)
	{
		if(x != null)
		{
			postOrderWalk(x.getLeft());
			postOrderWalk(x.getRight());
			nodeList.add(x.toString());
		}
	}
	
	public void postOrderWalk(Node x, java.util.ArrayList<String> list)
	{
		if( x != null )
		{
			postOrderWalk(x.getLeft(), nodeList);
			postOrderWalk(x.getRight(), nodeList);
			nodeList.add(x.toString()); // for us, this will equate to nodeList.add(x.toString())
		}
	}
		
	public Node getMax(Node x)
	{
		while(x.getRight() != null)
		{
			x = x.getRight();
		}
		return x;
	}
	
	public Node getMin(Node x)
	{
		while(x.getLeft() != null)
		{
			x = x.getLeft();
		}
		return x;
	}
	
	public Node getSuccessor(Node x)
	{
		if(x.getRight() != null)
		{
			return getMin(x.getRight());
		}
		Node y = x.getParent();
		while((y != null) && (x ==y.getRight()))
		{
			x = y;
			y = y.getParent();
		}
		return y;
	}
	
	public Node getPredecessor(Node x)
	{
		if(x.getLeft()!=null)
		{
			return getMax(x.getLeft());
		}
		Node y = x.getParent();
		while((y!=null) && (x == y.getLeft()))
		{
			x = y;
			y = y.getParent();
		}
		return y;
	}
	
	public Node getNode(Node x, int key)
	{
		if((x==null) || (key == x.getKey()) )
		{
			return x; // we found the key or ran out of nodes
		}
		if(key < x.getKey())
		{
			return getNode(x.getLeft(),key); // search left subtree
		}
		else
		{
			return getNode(x.getRight(), key); // search right subtree
		}
	}
	
	public int getHeight(Node x)
	{
		if( x == null )
		{
			return -1;
		}
		int leftHeight = getHeight(x.getLeft());
		int rightHeight = getHeight(x.getRight());
		
		if( leftHeight > rightHeight )
		{
			return leftHeight + 1;
		}
		return rightHeight + 1; 

	}
	
	public void shiftNode(Node u, Node v)
	{
		if( u.getParent() == null ) // u is the root
		{
			setRoot(v); // make v the root
		}
		else
		{
			if( u == u.getParent().getLeft() )
			{
				u.getParent().setLeft(v); // u is left child
			}
			else
			{
				u.getParent().setRight(v); // u is right child
			}
		}

		if( v != null )
		{
			v.setParent(u.getParent()); // set v's parent
		}
	}
	
	public void deleteNode(Node z)
	{
		if(z.getLeft() == null)
		{
			shiftNode(z, z.getRight());
		}
		else
		{
			if(z.getRight() == null)
			{
				shiftNode(z,z.getLeft());
			}
			else
			{
				Node y = getSuccessor(z);
				if(y.getParent() != z)
				{
					shiftNode(y, y.getRight());
					y.setRight(z.getRight());
					y.getRight().setParent(y);
				}
				shiftNode(z,y);
				y.setLeft(z.getLeft());
				y.getLeft().setParent(y);
			}

		}
	}
}
