package MatrixProject;

import java.util.Scanner;

public class Test {
    
	    
    public static void main(String[] args){

        boolean repeat = false;
        do {

	    //prints initial instructions
	    printInstructionsPart1();
	    
	    //method sets bounds for random numbers stored in matrices
	    inputBounds();
	    
	    Matrix matrix1 = new Matrix();
	    matrix1 = create("first");
	  
	    Matrix matrix2 = new Matrix();
	    matrix2 = create("second");
             
	   /*method prints instructions and stores users choice of which mathematical
	    * operation they chose.     */
	   int choice = InstructionsPart2();
	   
	   /*3rd matrix created to store solution of mathematical operation conducted
	   between the first two matrices	*/
	   Matrix matrix3 = mathOperation(choice, matrix1, matrix2);
	   
	   System.out.println(matrix3.toString());
	   
	   System.out.println("Would you like to run this program again?\n" +
			   "Reply 1 for yes and 0 for no");
	   
        repeat = boolValidation();
	   	
        } while (repeat  == true);
		
        endProgram();

}// end of test method
  
    
   
    /*METHODS are listed in the order they are called in the main method.
     * Certain methods are not visible in the main method
     * because those methods are called within other methods. Those methods are listed
     * beneath the methods that call them	*/
    
    
  //prints initial instructions
    public static void printInstructionsPart1()    {
         System.out.println("You will be creating two matrices of custom size\n");
    }//end of method
    
  //receives and validates input from random number bounds
    public static void inputBounds(){
 	   int lowerBound = lowerBoundValidation();
 	    Matrix.setLowerBound(lowerBound);
 	    int upperBound = upperBoundValidation(lowerBound);
 	    Matrix.setUpperBound(upperBound);
    }//end of method
    
    
    //utilized in inputBounds method
    public static int lowerBoundValidation(){
    	System.out.println("Please enter the lower bound to be used"
                + " in generating random numbers for all matrices.");
    	int lowerBound;
		Scanner input = new Scanner(System.in);
       while (!input.hasNextInt())	{
               System.out.println("Invalid must enter a number, try again.");
               input.next();
       }//end of while
       lowerBound = input.nextInt();
       return lowerBound;
	}//end of method
    
    
    //utilized in inputBounds method
    public static int upperBoundValidation(int lowerBound){   
    	System.out.println("Please enter the upper bound to be used"
                + " in generating random numbers for all matrices.");
    	int upperBound;
    	Scanner input = new Scanner(System.in);
        do  {
           while (!input.hasNextInt())	{
                   System.out.println("Invalid must enter a number, try again.");
               input.next();
           }//end of inner while
           upperBound = input.nextInt();
           if(upperBound <= lowerBound)	{
        	   System.out.println("the upper bound must be greater than the lower bound, try again.");
           		}//end of if
           } while (upperBound <= lowerBound);//end of do while
       return upperBound;
    	}//end of method
    
    
    public static Matrix create(String place) {
 	   System.out.println("Enter specifications for the " + place + " matrix.");
 	   int rows = getRowOrCol("rows");
 	   int cols = getRowOrCol("collumns");
 	   Matrix matrix = new Matrix(rows, cols);
 	   return matrix;
    }
   
    /*utilized in create method.
    prompts user to enter value between 1 and 9, validates that value is between 1 and 9*/
    public static int getRowOrCol(String something){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number between 1 and 9 to represent"
                + " the number of " + something + " for the current Matrix");
        int number = inputValidation(1,9);
        return number;
    }//end of method
  
    
   //Method prints results of two matrices, utilizes toString method
   public static void printMatrices(Matrix matrix1, Matrix matrix2){
	   System.out.println("\n" + "Matrix#1");
	   System.out.println(matrix1.toString());
	   System.out.println("Matrix#2");
	   System.out.println(matrix2.toString());
   }//end of method
   
   
   /*method prints instructions and stores users choice of which mathematical
    * operation they chose.     */
   public static int InstructionsPart2(){
       System.out.println("Select the mathematical operation to be " +
  		"performed on these two matrices by enter the corresponding number.\n" +
		   "1. Addition\n" +
		   "2. Subtraction\n" +
		   "3. Multiplication\n" +
		   "4. Dot Product");
       
       int lowValue = 1;
       int highValue = 4;
       
       int choice = inputValidation(lowValue, highValue);
       return choice;
   } 
   
   
   //performs mathematical operation and prints result
   public static Matrix mathOperation(int choice, Matrix matrix1, Matrix matrix2){
	   Matrix matrix3 = new Matrix();
	   switch (choice){
            case 1: 
            	//addition
            	boolean valid = validationMath(matrix1, matrix2);
                while (valid == false){
                    System.out.println("Matrices must be the same size to perform addition.");
                  
            	    matrix1 = create("first");          	  
            	    matrix2 = create("second");
                    valid = validationMath(matrix1, matrix2);
                }
            	    
            	    
                //method prints matrices, toString method present inside printMatrices method.
                printMatrices(matrix1, matrix2);
        		
                matrix3 = matrix1.add(matrix2);
                System.out.println("You chose to add matrices 1 and 2.\n" +
                                "the resulting matrix is:");
                return matrix3;
	  
            case 2: 
			   //subtraction
				valid = validationMath(matrix1, matrix2);
		   		while (valid == false){
		
		    	    matrix1 = create("first");          	  
		    	    matrix2 = create("second");
		            valid = validationMath(matrix1, matrix2);
		   		    
		            valid = validationMath(matrix1, matrix2);
		   		}
	   	    
	            //method prints matrices, toString method present inside printMatrices method.
	            printMatrices(matrix1, matrix2);
	
	            matrix3 = matrix1.subtract(matrix2);
	            System.out.println("You chose to add matrices 1 and 2.\n" +
	                               "the resulting matrix is:");
	            
	            return matrix3;
                  
		   
		   case 3: 	
			   //multiplication
			   valid = validationMath(matrix1, matrix2);
		        
			   while (valid == false){
					System.out.println("Matrices must be the same size to perform multiplication");
		
		    	    matrix1 = create("first");          	  
		    	    matrix2 = create("second");
		            valid = validationMath(matrix1, matrix2);
		                
					valid = validationMath(matrix1, matrix2);  
		                
		         }
		   
		        printMatrices(matrix1, matrix2);
		        matrix3 = matrix1.multiply(matrix2);
		        System.out.println("You chose to multiply matrices 1 and 2.\n" +
		        "the resulting matrix is:");
		        
		        return matrix3;
		                    
			   
		   default:
		        //dot product
		        valid = validationForDot(matrix1, matrix2);
	        
	            while(valid == false){
	                 System.out.println("Number of rows in matrix 1 must match\n"
	                         + "the number of collumns in matrix 2 to use dot product."
	                         + " Try again");
	
	         	    matrix1 = create("first");          	  
	         	    matrix2 = create("second");
	
	                valid = validationForDot(matrix1, matrix2);
	             }
	            
	            //method prints matrices, toString method present inside printMatrices method.
	            printMatrices(matrix1, matrix2);
	
	            matrix3 = matrix1.dotProduct(matrix2);
	            System.out.println("You chose to dot product matrices 1 and 2.\n" +
	                   "The resulting matrix is: ");
	            
	            return matrix3;
	       
		   		}//end of switch	
	   }//end of math operation method
   
   public static boolean validationMath(Matrix matrix1, Matrix matrix2){
	   boolean check = true;
	   int value1 = matrix1.getCols();
	   int value2 = matrix2.getCols();
	   int value3 = matrix1.getRows();
	   int value4 = matrix2.getRows();
	   
	   if(value1 != value2){
		   check = false;
	   }
	   
	   else if (value3 != value4){
		   check = false;
	   }
	   return check;
	   
   }
   
   public static boolean validationForDot(Matrix matrix1, Matrix matrix2){
       int value1 = matrix1.getRows();
       int value2 = matrix2.getCols();
       
       boolean check = true;
       if(value1 != value2){
           check = false;
         }
        return check;
   }
   
   
   /*input validation method used when user is selecting options such as type
    * of matrix to create or selecting mathematical operations.
    */
   public static int inputValidation(int lowValue, int highValue){
   	Scanner input = new Scanner(System.in);
       int choice = 0;
       do  {
           while (!input.hasNextInt())	{
                   System.out.println("Invalid must enter a number, try again.");
                   input.next();
           }
           choice = input.nextInt();
           if(choice < lowValue || choice > highValue )	
		System.out.println("Your choice must be between " + lowValue + " and " + highValue);
       } while (choice < lowValue || choice > highValue);
       return choice;
   }//end of method
 
   public static boolean boolValidation(){
           int zero = 0;
           int one = 1;
            
	   int x = inputValidation(zero, one);
	   boolean value = true;
	   if (x == 0){
		   value = false;
	   }
	   else if (x == 1){
		   value = true;
	   }
	   return value;
   }
   
   public static void endProgram(){
       System.out.println("Program ending");
       System.exit(0);
   }
   

    
}// end of class