package chapter17;



//This program shows the method countempty


class IntTreeNode

{
public int data;
public IntTreeNode left;
public IntTreeNode right;

public IntTreeNode (int data)
{
this(data, null, null);
}

public IntTreeNode (int data, IntTreeNode left, IntTreeNode right)
{
this.data = data;
this.left = left;
this.right = right;
}
}




class IntTree
{
private IntTreeNode overallRoot;
public IntTree (int max)
{
if (max <= 0)
{
throw new IllegalArgumentException("max: " +max) ;
}
overallRoot = buildTree(1, max);
}
private IntTreeNode buildTree (int n, int max)
{
if (n > max)
{
return null;
}
else
{
return new IntTreeNode (n, buildTree(2 * n,max) , buildTree(2 * n + 1, max));
}
}
public void printPreorder ()
{
System.out.print("Preorder:");
printPreorder(overallRoot);
System.out.println();
}
private void printPreorder(IntTreeNode root)
{
if (root != null)
{

System.out.print(" "+ root.data);
printPreorder(root.left);
printPreorder(root.right);
}
}
public void printInorder()
{
System.out.print("Inorder:");
printInorder(overallRoot);
System.out.println();
}
private void printInorder (IntTreeNode root)
{
if (root !=null)
{
	printInorder(root.left);
	System.out.print(" " +  root.data);
	printInorder(root.right);
}
}
public void printPostorder()
{
System.out.print("Postorder:");
printPostorder(overallRoot);
System.out.println();
}
private void printPostorder (IntTreeNode root)
{
if(root !=null)
{
printPostorder(root.left);
printPostorder(root.right);
System.out.print(" "+ root.data);
}
}
public void printSideways()
{
printSideways(overallRoot, 0);
}
private void printSideways(IntTreeNode root, int level)
{
if (root !=null)
{
printSideways(root.right,level+1);
for (int i = 0; i < level; i++)
{
System.out.print("   ");
}
System.out.println(root.data);
printSideways(root.left, level+ 1);
}
}
public int countEmpty()
{
return countEmpty(overallRoot);
}
int count = 0;
private int countEmpty(IntTreeNode root)
{
if(root== null)
{
return 1;
}
else
{
if(root.left != null)
{
if(root.left.left    !=    null    || root.left.right != null)
{
countEmpty(root.left);
}



else
{
count = count + 2;
}
}
else
{
count = count + 1;
}
if(root.right !=null)
{
if(root.right.left   !=   null   || root.right.right  !=null)
{
countEmpty(root.right);
}
else
{
count = count + 2;
}
}
else
{
count = count + 1;
}
}
return count;
}
}



public class IntTreeDemo
{
public static void main(String[] args)
{
IntTree btree = new IntTree (12);
System.out.println("Elements in the tree are: "); btree.printInorder();
int emptyBranches = btree.countEmpty();
System.out.println();
System.out.println("Number of empty branches in the tree is: "+ (emptyBranches));
}
}

