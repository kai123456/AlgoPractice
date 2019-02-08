
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class tt {
  public static void main(String[] args) throws Exception{
    Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    //int t = scan.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.

    int sizeOfWorld = Integer.parseInt(scan.nextLine());
    int numberOfEvents = Integer.parseInt(scan.nextLine());
    int ne = numberOfEvents;
    HashMap<Integer, String> coors = new HashMap<Integer, String>();
    HashMap<Integer, PriorityQueue> prices = new HashMap<Integer, PriorityQueue>();
    PriorityQueue<String> queue;
    while(numberOfEvents > 0){
    	String eventLine = scan.nextLine();
    	String[] events = eventLine.split(" ");
    	int id = Integer.parseInt(events[0]);
    	coors.put(id, events[1]+events[2]);
    	queue = new PriorityQueue<String>();
    	for(int i=3; i<events.length; i++){
    		queue.add(events[i]);
    	}
    	prices.put(id, queue);
    	numberOfEvents--;
    }

    int numberOfBuyers = Integer.parseInt(scan.nextLine());
    int nb = numberOfBuyers;
    HashMap<Integer, String> buyers = new HashMap<Integer, String>();
    int n = 1;
    while(numberOfBuyers > 0){
    	String buyerLine = scan.nextLine();
    	buyers.put(n, (buyerLine.substring(0,1) + buyerLine.substring(2)));
    	n++;
    	numberOfBuyers--;
    }

    int distance = Integer.MAX_VALUE;
    int price = Integer.MAX_VALUE;
    int ID = 1;
    for(int i=1; i<=nb; i++){
    	for(int j=1; j<=ne; j++){
    		//System.out.println(prices.get(j).size());
    		if(prices.get(j).size() == 0)
    			continue;
    		// System.out.println("test");
    		int x1 = Integer.valueOf(buyers.get(i).charAt(0));
    		int x2 = Integer.valueOf(buyers.get(i).charAt(1));
    		int y1 = Integer.valueOf(coors.get(j).charAt(0));
    		int y2 = Integer.valueOf(coors.get(j).charAt(1));
    		int d = calculateManhattanDistance(x1, y1, x2, y2);
			if(distance > d){
				price = Integer.parseInt((String) prices.get(j).peek());
    			distance = d;
    			ID = j;
    		}
    		if(distance == d){
    			if(prices.get(j).size() != 0){
	    			if(Integer.parseInt((String)prices.get(j).peek()) < price){
	    				price = (int) prices.get(j).peek();
	    				ID = j;
	    			}
    			}

    		}
    		distance = Integer.MAX_VALUE;
    	}
    	prices.get(ID).poll();
    	System.out.println(ID + " " + price);
    }

    //String eventLine = scan.nextLine();
    //System.out.println(eventLine);

    // for (int i = 1; i <= t; ++i) {
    // 	int n = in.nextInt();
    // 	int forbidden = in.nextInt();

    // 	System.out.println("Case #" + n + ": " + forbidden);
    // }
  }

  public static int calculateManhattanDistance(int x1, int y1, int x2, int y2){
  	return Math.abs(x1 - y1) + Math.abs(x2 - y2);
  }
}