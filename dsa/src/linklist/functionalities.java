package linklist;
import java.util.Scanner;
public class functionalities {

	 public static void main(String args[])
	 {
		 Linklist<String> list=new Linklist<String>();
	        
	         String data;
	         int position=0;
	         String conti;
	         Scanner sc = new Scanner(System.in); 
	     
	        
	          
	            do {
	            	System.out.println("1: Insert in linklist");
	  	          System.out.println("2: Insert at position in linklist");
	  	          System.out.println("3: Delete in linklist");
	  	          System.out.println("4: Delete at position in linklist");
	  	          System.out.println("5: Center in linklist");
	  	          System.out.println("6: Reverse linklist");
	  	          System.out.println("7: Size of linklist");
	  	          System.out.println("8: Iterate linklist");
	  	          System.out.println("9: Print linklist");
	            	 int ch=0;
	            	while (ch <= 0) {
	            		
	    				System.out.println("ENTER CHOICE:");
	    				String input = sc.nextLine();
	    				
	    				//exception handling
	    				try {
	    					ch = Integer.parseInt(input);
	    					if(ch<=0) {
	    						System.out.println("Enter your choice Between 1-9");
	    					}

	    				} catch (NumberFormatException e) {
	    					System.out.println("ERROR!!! enter only numbers");
	    				}
	    			}
	             
	             
	              switch (ch)
	              {
	                case 1: 
	                 System.out.println("Enter the data to be inserted \n");
		             data = sc.nextLine();
	                 list.insert(data);
	                 break;
	                 
	                case 2: 
	                	
	                	while (position <= 0) {
		    				System.out.println("Enter the position be inserted at \n");
		    				String input = sc.nextLine();
		    				//exception handling
		    				try {
		    					position = Integer.parseInt(input);

		    				} catch (NumberFormatException e) {
		    					System.out.println("ERROR!!! enter only numbers");
		    				}
		    			}
		                 
		                 System.out.println("Enter data to be inserted at this position \n");
		                 data = sc.nextLine();
		                 list.insert_at_position(position,data);
		                 position=0;
		                 break;
		                 
	                case 3: 
		                 
			             data = sc.nextLine();
		                 list.delete();
		                 break;
		                 
	                case 4: 
	                	
	                	while (position <= 0) {
		    				System.out.println("Enter the position from where data is to be deleted at \n");
		    				String input = sc.nextLine();
		    				//exception handling
		    				try {
		    					position = Integer.parseInt(input);

		    				} catch (NumberFormatException e) {
		    					System.out.println("ERROR!!! enter only numbers");
		    				}
		    			}
		                 
		                 list.delete_at_position(position);
		                 position=0;
		                 break;
		                 
	                case 5: 
		                 
		                 list.center();
		                 break;
		                 
	                case 6: 
		                
		                 list.reverse();
		                 break;
		                 
	                case 7: 
		                
		                 list.size();
		                 break;
		                 
	                case 8: 
		                
	                	for (String string : list)
	    		            System.out.println(string);
	    				break;
		                 
	                case 9: 
		                
		                 list.print();
		                 break;
		                 
	                
	                default:
	                 System.out.println("Invalid choice! Please make a valid choice. \n\n");
	               }
		          
	              System.out.println("Do you want to continue (y/n):");
	  			conti = sc.nextLine();
	  			conti = conti.toUpperCase().trim();
		          }
	 while (conti.equals("Y"));
	 } 
	     }
	
	

