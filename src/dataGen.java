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
		int length = 3;
		int width = 3;
		int height = 3;
		
		if(numSteps > 0)
		{
			System.out.println("1 0 0 0");
			System.out.println("2 " + length + " 0 0");
			System.out.println("3 " + length + " " + width + " 0");
			System.out.println("4 0 " + width + " 0");
			
			for(int i = 1; i <= numSteps; i++)
			{
				// Create 4 vertices at a time
				int stepHeight = i*(height/numSteps);
				System.out.println(i*4+1 + " " + ((length/numSteps)+(numSteps-i-1)*(length/numSteps)) + " " + 0 + " " + stepHeight);
				System.out.println(i*4+2 + " " + ((length/numSteps)+(numSteps-i)*(length/numSteps)) + " " + 0 + " " + stepHeight);
				System.out.println(i*4+3 + " " + ((length/numSteps)+(numSteps-i)*(length/numSteps)) + " " + width + " " + stepHeight);
				System.out.println(i*4+4 + " " + ((length/numSteps)+(numSteps-i-1)*(length/numSteps)) + " " + width + " " + stepHeight);
				
				// I THINK THE ABOVE INTEGER MATH IS GETTING TRUNCATED TO 0 FOR OTHER TESTED VALUES
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
