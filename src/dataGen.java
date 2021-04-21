// Cameron Meyer
// Assignment 5 - Exercise 6.9
// CS 4361.001


import java.awt.*;
import java.awt.event.*;
import java.nio.file.FileSystemNotFoundException;


public class dataGen
{
	public static void main(String [] args)
	{
		int numSteps = 1;
		int stepLength = 2;
		int stepWidth = 5;
		int stepHeight = 2;
		
		if(numSteps > 0)
		{
			// Create the 4 vertices that make up the base
			System.out.println("1 0 0 0");
			System.out.println("2 " + (stepLength*numSteps) + " 0 0");
			System.out.println("3 " + (stepLength*numSteps) + " " + stepWidth + " 0");
			System.out.println("4 0 " + stepWidth + " 0");
			
			for(int i = 1; i <= numSteps; i++)
			{
				// Create 4 vertices at a time for the top of each step
				int innerStepLength = (numSteps - i) * stepLength; 
				int outerStepLength = (numSteps - i) * stepLength + stepLength; 
				//float stepHeight = i*(height/numSteps);
				System.out.println(i*4+1 + " " + innerStepLength + " " + 0 + " " + (stepHeight*i));
				System.out.println(i*4+2 + " " + outerStepLength + " " + 0 + " " + (stepHeight*i));
				System.out.println(i*4+3 + " " + outerStepLength + " " + stepWidth + " " + (stepHeight*i));
				System.out.println(i*4+4 + " " + innerStepLength + " " + stepWidth + " " + (stepHeight*i));
			}
			
			System.out.println("Faces:");	
			
			// Bottom face
			System.out.println("1 4 3 2.");
			
			// First stair front
			System.out.println("2 3 7 6.");
			
			// First stair top
			System.out.println("5 6 7 8.");
			
			if(numSteps > 1)
			{
				for(int i = 2; i <= numSteps; i++)
				{
					// Stair Front
					System.out.println((4*i-3) + " " + (4*i) + " " + (4*i+3) + " " + (4*i+2) + ".");
					
					// Stair Top
					System.out.println((4*i+1) + " " + (4*i+2) + " " + (4*i+3) + " " + (4*i+4) + ".");
				}
			}
			
			// Back face
			System.out.println("1 " + (4*numSteps+1) + " " + (4*numSteps+4) + " 4.");
			
			// Left Side
			System.out.print("1 2");
			for(int i = 1; i <= numSteps; i++)
			{
				int point = 6 + (i - 1) * 4;
				System.out.print(" " + point + " " + (point-1));
			}
			System.out.print(".\n");
			
			// Right Side
			System.out.print("3 4");
			for(int i = 1; i <= numSteps; i++)
			{
				int point = 8 + (numSteps - i) * 4;
				System.out.print(" " + point + " " + (point-1));
			}
			System.out.print(".\n");
		}
	}
}
