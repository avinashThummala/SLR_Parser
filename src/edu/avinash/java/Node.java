package edu.avinash.java;

//Representation of a ParseTree

public class Node {

	Node[] next;
	int numNext = 0;
	int rStmt = 0;
	String symbol;
	String prevRep =""; //Representation of the parse tree stack below this parse tree 

	Node() {
		this.symbol = "id";
	}

	Node(int rStmt, String symbol) {
		
		this.rStmt=rStmt;
		
		if(rStmt==1 || rStmt==3)
			numNext=2;
		else
			numNext=1;
		
		next = new Node[numNext];
		this.symbol = symbol;
	}		

	void setPrevRep(String prevRep) {
		this.prevRep = prevRep;
	}

	void setNextNode(Node node, int index) {
		next[index] = node;
	}

	//Returns the representation of this parse tree
	String getNodeRep() {
		if (rStmt==0)
				return symbol;
		else {
			
			String nextNodeRep = "";			
			
			if(rStmt==1)
				nextNodeRep = new String(" "+next[0].getNodeRep()+" + "+next[1].getNodeRep());
			else if(rStmt==3)
				nextNodeRep = new String(" "+next[0].getNodeRep()+" * "+next[1].getNodeRep());
			else if(rStmt==5)
				nextNodeRep = new String(" ( "+next[0].getNodeRep()+" )");
			else
				nextNodeRep = new String(" "+next[0].getNodeRep());

			return new String("["+symbol+nextNodeRep+" ]");
		}

	}

	//Returns the representation of the parse tree stack up until this point
	//Concatenate the representation of this parse tree with prevRep explained above	
	String getCompleteRep() {
		return getNodeRep().concat(" "+prevRep);
	}
	
	//Pretty print this parse tree to the output stream
	void printNode(String prefix)
	{
		System.out.println(prefix+symbol);
		
		for(int i=0;i<numNext;i++)
			next[i].printNode(prefix.concat("   "));
		
	}

}
