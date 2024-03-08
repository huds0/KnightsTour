package code;

public class LinkedGrid {
	 
	static Node start;   
	    
	 public LinkedGrid(int size) {
		 
	    	if(size > 0) {
	        start = new Node(0);
	        Node temp = start;
	        Node row = start;

	        	for(int x = 0; x < size-1; x++) {
	        		temp.setRight(new Node(0));
	        		temp.getRight().setLeft(temp);
	        		temp = temp.getRight();
	        	}
	        	for(int x = 0; x < size-1; x++) {
		        	row.setDown(new Node(0));
	        		row.getDown().setUp(row);
	        		row = row.getDown();  
	        		temp = row;
	        		
	        		for(int y = 0; y < size-1; y++) {
		        		temp.setRight(new Node(0));
		        		temp.getRight().setLeft(temp);
		        		temp.getRight().setUp(temp.getUp().getRight());
		        		temp.getRight().getUp().setDown(temp.getRight());
		        		temp = temp.getRight();
		        		}
		        } 
	    	}     
	    	paths();
	    }
	    
	    public void paths() {
	    	Node temp = start, temp2 = start;
	    
	         while(temp2 != null) {
	             while(temp != null) {
	            	 
	    	try {
	    	temp.setPath1(temp.getUp().getUp().getLeft());
	    	} catch(Exception e) {} 
	    
	    	try {
	    	temp.setPath2(temp.getUp().getUp().getRight());
	    	} catch(Exception e) {}
	  
	    	try {
	    	temp.setPath3(temp.getRight().getRight().getUp());
	    	} catch(Exception e) {}
	    	
	    	try {
	    	temp.setPath4(temp.getRight().getRight().getDown());
	    	} catch(Exception e) {}
	    	
	    	try {
	    	temp.setPath5(temp.getDown().getDown().getLeft());
	    	} catch(Exception e) {}
	    
	    	try {
	    	temp.setPath6(temp.getDown().getDown().getRight());
	    	} catch(Exception e) {}
	    	
	    	try {
	    	temp.setPath7(temp.getLeft().getLeft().getDown());
	    	} catch(Exception e) {}
	    	
	    	try {
	    	temp.setPath8(temp.getLeft().getLeft().getUp());
	    	} catch(Exception e) {}

	    	temp = temp.getRight();
	             }
	             temp = temp2.getDown();
	             temp2 = temp;
	         }
	    }
	    
	    public void display() {
	        Node temp = start, temp2 = start;
	        while(temp2 != null) {
	        	while(temp!= null && temp.getData() < 10) {
	        		System.out.print(temp.getData() + "  ");
	        		temp = temp.getRight();	
	        	}
	        	while(temp!= null && temp.getData() > 0) {
	        		System.out.print(temp.getData() + " ");
	        		temp = temp.getRight();	
	        	}
	        	System.out.println();
	        	temp = temp2.getDown();
	        	temp2 = temp;
	        }     
	   }
		
	    public void startTour()	{
	    	int numOfSolutions = tour(start,0,0);
	    	System.out.println();
	    	System.out.println("Number of solutions: " + numOfSolutions);
		}  
  
	   public int tour(Node position, int num, int count) {
		   	  num = num+1;
			  position.setData(num);
			 
			   if(num == 25) {
				   display();	
				   System.out.println();
				   count = count+1;
				   position.setData(0);
				   num--;
				   return count;
			   }
				   if(position.getPath1() != null && position.getPath1().getData() == 0) 
						   count = tour(position.getPath1(), num, count);
				   
				   if(position.getPath2() != null && position.getPath2().getData() == 0) 
						   count = tour(position.getPath2(), num, count);
		
				   if(position.getPath3() != null && position.getPath3().getData() == 0) 
						   count = tour(position.getPath3(), num, count);
	
				   if(position.getPath4() != null && position.getPath4().getData() == 0) 
						   count = tour(position.getPath4(), num, count);
				   
				   if(position.getPath5() != null && position.getPath5().getData() == 0) 
						   count = tour(position.getPath5(), num, count);
				
				   if(position.getPath6() != null && position.getPath6().getData() == 0) 
						   count = tour(position.getPath6(), num, count);
				   
				   if(position.getPath7() != null && position.getPath7().getData() == 0) 
						   count = tour(position.getPath7(), num, count);
				   
				   if(position.getPath8() != null && position.getPath8().getData() == 0) 
						   count = tour(position.getPath8(), num, count);
	
					   position.setData(0);
					   num--;
					   return count;
	   				}
			}



