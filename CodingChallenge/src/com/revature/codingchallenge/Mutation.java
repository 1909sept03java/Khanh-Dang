package com.revature.codingchallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Mutation
{
	//Declaring storing list
	static ArrayList<String>bank = new ArrayList<String>();
	static String start,end;
	static String[] banks;


	//Driver Method
	public static void main(String[]args) 
	{
		readFile();

		String[] geneBank = new String[] {"AACCGGTA"};
		System.out.println("Start:AACCGGTT\nEnd:AACCGGTA\nBank:AACCGGTA");
		System.out.println(minMutation("AACCGGTT","AACCGGTA",geneBank));
		System.out.print("\nFrom File (genebank.txt)\nStart: "+start+"\nEnd: "+end+"\nBank: ");
		
		for(String s : bank) System.out.print(s + " ");
		System.out.println("\n" + minMutation(start,end,banks));
	}
	
	
	//read gene bank from file
	public static void readFile() //throw exception again here?
	{
		StringBuilder sb = new StringBuilder();
		File file =  new File("src/com/revature/codingchallenge/genebank.txt");

		try {

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while (line != null) {

				bank.add(line);

				line = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("No gene bank txt file found, program will terminate !!!");
			
		}
		
		//br.close?
		start = bank.get(0);
		end = bank.get(1);
		String tempString = bank.get(2);
		banks = tempString.split(",");

	}

	//Method to find minMutation with LinkedList and Hashset using BFS to compare two nodes
	public static int minMutation(String start, String end, String[] bank) 
	{
		//Create the queue for the start string and create hashset for the banks 
		//Hash set doesn't allow duplicate entries
		Queue<String> queue = new LinkedList<>();
		char[] chars = {'A', 'C', 'G', 'T'};
		Set<String> bankSet = new HashSet<>();

		int temp = 0; // counter
		// the queue offer is a method that doen't throws an exception 
		//when the capacity of the container is full since it returns false
		
		queue.offer(start);

		for (String b : bank) 
		{
			bankSet.add(b);
		}
		while(!queue.isEmpty()) //starting BFS algorithm to search for the differences between two nodes
		{
			int size = queue.size();// returns the n of elements in the queue
			while(size-- > 0) 
			{
				String currString = queue.poll(); // removes and returns at the head of queue. Returns null if empty
				if (currString.equals(end)) return temp;
				for (int i = 0; i < currString.length(); i++) 
				{
					for (char ch: chars)// Checking between two nodes
					{
						char[] currChars = currString.toCharArray();// returns an Array of chars after converting a string to chars
						currChars[i] = ch;
						String modString = new String(currChars);
						if (bankSet.contains(modString)) // check to see if new mutate is in the bank, and not the original duplicate
						{
							queue.add(modString); //add the next gen into the queue
							bankSet.remove(modString); // prevent backtracking by removing the instance of mutation from the set
						}
					}
				}
			}
			temp++; //count for next gen
		}
		return -1; // when fail
	}
}