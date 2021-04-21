// Cameron Meyer
// Assignment 5 - Exercise 6.9
// CS 4361.001


import java.awt.*;
import java.awt.event.*;


public class dataGen
{
	public static void main(String [] args)
	{
		int numSteps = 3;
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
			}
			
			System.out.println("Faces:");	
		}
	}
}
