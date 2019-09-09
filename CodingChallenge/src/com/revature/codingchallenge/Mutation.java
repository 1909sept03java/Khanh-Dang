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
	public static void readFile()
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
		String temp = bank.get(2);
		banks = temp.split(",");

	}

	//Method to find minMutation with LinkedList and Hashset using BFS
	public static int minMutation(String start, String end, String[] bank) 
	{
		Queue<String> queue = new LinkedList<>();
		char[] chars = {'A', 'C', 'G', 'T'};
		Set<String> bankSet = new HashSet<>();

		int temp = 0;
		queue.offer(start);

		for (String b : bank) 
		{
			bankSet.add(b);
		}
		while(!queue.isEmpty()) 
		{
			int size = queue.size();
			while(size-- > 0) 
			{
				String currString = queue.poll();
				if (currString.equals(end)) return temp;
				for (int i = 0; i < currString.length(); i++) 
				{
					for (char ch: chars)
					{
						char[] currChars = currString.toCharArray();
						currChars[i] = ch;
						String modString = new String(currChars);
						if (bankSet.contains(modString)) 
						{
							queue.add(modString);
							bankSet.remove(modString);
						}
					}
				}
			}
			temp++;
		}
		return -1;
	}
}