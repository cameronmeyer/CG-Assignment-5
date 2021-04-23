// Cameron Meyer
// Assignment 5 - Exercise 6.9
// CS 4361.001


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class dataGen
{
	public static void main(String [] args)
	{
		int numSteps = 0;
		int stepLength = 0;
		int stepWidth = 0;
		int stepHeight = 0;
		
        if(args.length == 4)
        {
            try
            {
            	numSteps = Integer.parseInt(args[0]);
            	stepLength = Integer.parseInt(args[1]);
            	stepWidth = Integer.parseInt(args[2]);
            	stepHeight = Integer.parseInt(args[3]);
            }
            catch(Exception E)
            {
            	System.out.println("Could not convert all arguments to integers. Please ensure numSteps, stepLength, stepWidth, stepHeight are all integers.");
            	System.exit(-1);
            }
        }
        else
        {
        	System.out.println("Incorrect number of arguments. Expected 4 arguments, but found " + args.length + ". Please include only numSteps, stepLength, stepWidth, stepHeight.");
        	System.exit(-1);
        }

		
		if(numSteps > 0)
		{
			try
			{
				File output = new File("stairsObj.dat");
				if (output.createNewFile())
				{
					System.out.println("File created: " + output.getName());
				}
				else
				{
					System.out.println("File \"" + output.getName() + "\" already exists.");
				}
				
			    BufferedWriter writer = new BufferedWriter(new FileWriter(output));
			    
			    // Create the 4 vertices that make up the base
			    writer.write("1 0 0 0\n");
			    writer.write("2 " + (stepLength*numSteps) + " 0 0\n");
			    writer.write("3 " + (stepLength*numSteps) + " " + stepWidth + " 0\n");
			    writer.write("4 0 " + stepWidth + " 0\n");
			    
			    for(int i = 1; i <= numSteps; i++)
				{
					// Create 4 vertices at a time for the top of each step
					int innerStepLength = (numSteps - i) * stepLength; 
					int outerStepLength = (numSteps - i) * stepLength + stepLength; 

					writer.write(i*4+1 + " " + innerStepLength + " " + 0 + " " + (stepHeight*i) + "\n");
					writer.write(i*4+2 + " " + outerStepLength + " " + 0 + " " + (stepHeight*i) + "\n");
					writer.write(i*4+3 + " " + outerStepLength + " " + stepWidth + " " + (stepHeight*i) + "\n");
					writer.write(i*4+4 + " " + innerStepLength + " " + stepWidth + " " + (stepHeight*i) + "\n");
				}
				
			    writer.write("Faces:\n");	
				
				// Bottom face
			    writer.write("1 4 3 2.\n");
				
				// First stair front
			    writer.write("2 3 7 6.\n");
				
				// First stair top
				writer.write("5 6 7 8.\n");
				
				if(numSteps > 1)
				{
					for(int i = 2; i <= numSteps; i++)
					{
						// Stair Front
						writer.write((4*i-3) + " " + (4*i) + " " + (4*i+3) + " " + (4*i+2) + ".\n");
						
						// Stair Top
						writer.write((4*i+1) + " " + (4*i+2) + " " + (4*i+3) + " " + (4*i+4) + ".\n");
					}
				}
				
				// Back face
				writer.write("1 " + (4*numSteps+1) + " " + (4*numSteps+4) + " 4.\n");
				
				// Left Side
				writer.write("1 2");
				for(int i = 1; i <= numSteps; i++)
				{
					int point = 6 + (i - 1) * 4;
					writer.write(" " + point + " " + (point-1));
				}
				writer.write(".\n");
				
				// Right Side
				writer.write("3 4");
				for(int i = 1; i <= numSteps; i++)
				{
					int point = 8 + (numSteps - i) * 4;
					writer.write(" " + point + " " + (point-1));
				}
				writer.write(".\n");
			    
			    writer.close();
			}
			catch(IOException e)
			{
				System.out.println("An error occurred while writing to the output file.");
			}
		}
	}
}
