package MatrixProject;

import java.util.Random;
import java.util.Scanner;

public class Matrix {
    private int col;
    private int row;
    private int [][] elements;
    //lower and upper bound variables used in random number generation.
    private static int lowerBound = 0;
    private static int upperBound = 0;


//default constructor
public Matrix(){
    this.row = 2;
    this.col = 2;
    this.elements = new int[2][2];
    this.populate();
    }
    
    
public Matrix(int row, int col){
    this.row = row;
    this.col = col;
    this.elements = new int[row][col];
    this.populate();
    }


public Matrix(int [][] otherElements){
    this.row = otherElements.length;
    this.col = otherElements[0].length;
    this.elements = otherElements.clone();
    }
    
    
/*method used to populate matrices
 * arguments lowerBound and upperBound added to set bounds 
 * for randomly generated numbers.
 */
public void populate(){
    Random rand = new Random();
    for (int i = 0; i < row; i += 1){
        for (int j = 0; j < col; j+= 1){
            this.elements[i][j] = rand.nextInt(upperBound - lowerBound + 1) + lowerBound;
            }
        }
    }//end of Matrix.populate method

    
//method used to add matrices
Matrix add(Matrix OM){
    int[][] result = new int[row][col];
    for (int i = 0; i < row; i += 1){
        for (int j = 0; j < col; j+= 1){
            result[i][j] = elements[i][j] + OM.elements[i][j];
            }
        }
        return new Matrix(result);
    }//end of Matrix.add method
    
Matrix subtract(Matrix OM){
    int[][] result = new int[row][col];
    for (int i = 0; i < row; i += 1){
        for (int j = 0; j < col; j+= 1){
            result[i][j] = elements[i][j] - OM.elements[i][j];
            }
        }
        return new Matrix(result);
    }//end of Matrix.subtract method
        
Matrix multiply(Matrix OM){
    int[][] result = new int[row][col];
    for (int i = 0; i < row; i += 1){
        for (int j = 0; j < col; j+= 1){
            result[i][j] = elements[i][j] * OM.elements[i][j];
            }
        }
        return new Matrix(result); 
    }//end of Matrix.multipy method

Matrix dotProduct(Matrix OM){
    int[][] result = new int[row][OM.col];
        for (int i = 0; i < this.row; i+= 1){
            for (int j = 0; j < OM.col; j+= 1){
                for (int k = 0; k < this.col; k+= 1){
                    result [i][j] += (this.elements[i][k] + OM.elements[k][j]);
                }
            }
        }
        return new Matrix(result);
    }//end of Matrix.dotProduct method


//extra credit equals method
String equals(Matrix OM){
    String result = "not equal values";
    if (this.row == OM.row && this.col == OM.col){
        for (int i = 0; i < row; i += 1){
            for (int j = 0; j < col; j+= 1){
            if (elements[i][j] != OM.elements[i][j]){
                return result;
                }
            }
        }
        result = "equal values";
        return result;
    }
    
    else    {
        return result;
    }
}

@Override
public String toString(){
	String str = "";
	for (int[] u : elements){
		for (int elem : u){
			String value = String.valueOf(elem) + " ";
			str += value;
		}
		str += "\n";
	}
	return str;
}


@Override
public Matrix clone(){
   return new Matrix(this.elements);     
    }//end of Matrix.clone method



//SETTER METHODS
public static void setLowerBound(int newLowerBound){
	lowerBound = newLowerBound;
}


public static void setUpperBound(int newUpperBound){
	upperBound = newUpperBound;
}

public void setRows(int newRows){
    this.row = newRows;
}

public void setCols(int newCols){
    this.row = newCols;
}

//GETTER METHODS
public int getRows(){
    return row;
}

public int getCols(){
    return col;
}




}//end of class
    
