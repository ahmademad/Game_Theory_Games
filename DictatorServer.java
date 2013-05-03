/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmademad
 */
import java.net.*;
import java.io.*;
import java.net.*;
import java.io.*;
import java.util.*;
public class DictatorServer extends Thread {
    static int tokens;
    static LinkedList <Integer> wait = new LinkedList <Integer>();
    ServerSocket ss;
  Socket s[];
	Thread t[];
	BufferedReader br[];
	PrintWriter pw[];
	String st;
        String IP[];
        String name[];
	int num=0;
        Random generator = new Random();
	public DictatorServer()
	    {
	 	    //setLayout(newFlowLayout(0));
	    s=new Socket[100];
	    t=new Thread[100];
	    br=new BufferedReader[100];
	    pw=new PrintWriter[100];
            IP = new String[100];
            name = new String[100];
           
	   try  {ss=new ServerSocket(4444);
	    while(true)	        {
	        s[num]=ss.accept();
	        br[num]=new BufferedReader(new InputStreamReader(s[num].getInputStream()));
	        pw[num]=new PrintWriter(s[num].getOutputStream(),true);
                IP[num]=s[num].getInetAddress().getHostAddress();
           //     try {
           //name[num] = br[num].readLine();}
           //catch(Exception e) {}
	        t[num]=new Thread(this);
	        t[num].start();
	        num++;
	        }
	 
	    }
	  catch(Exception ee)
	    {
	    System.out.println("1"+ee);
	    }
	    }        
 
        
 
    public void run() {
           int random1=0;
           int random2=0;
           
        
        if(num>=2) {
            do {
             random1 = generator.nextInt( num );
             random2 = generator.nextInt(num);
             
            }
            while(random1==random2 || (wait.indexOf(random1)!=-1 || wait.indexOf(random2)!=-1) || IP[random1] != IP[random2]);
            
            synchronized(this)
            {
            wait.add(random1);
            wait.add(random2);
                    }
            
            try {
            playGame(random1, random2);
            }
            catch (Exception e) {}
        }
    }
    public void playGame(int i, int j) throws Exception
    
     
      {
         // String player1 = br[i].readLine();
          //String player2 = br[j].readLine();
          //pw[i].println("garbage");
         // pw[j].println("garbage");
     pw[i].println("You have been paired with a random player. One of you will be asked to make an "
             + " offer on how to split "+tokens+" tokens. The other player has no choice");
     
     pw[j].println("You have been paired with a random player. One of you will be asked to make an "
             + " offer on how to split "+tokens+" tokens. The other player has no choice");
     Integer.parseInt(br[i].readLine());
     Integer.parseInt(br[j].readLine());
     pw[i].println("You have been chosen to split the tokens. Please enter the number of tokens"
             + " you want to give the other player and then press enter. Your payoffs will be "
             + " the remaining number of tokens.");
     pw[j].println("The other player has been chosen to split the tokens. Please wait for their"
             + " offer.");
     int n = Integer.parseInt(br[i].readLine());
     pw[i].println("You offered "+ n + " tokens. Your payoffs are "+ (tokens-n) +" tokens.");
     pw[j].println("You were offered "+ n + " tokens. Your payoffs are "+n+" tokens.");
     

     
     //String l="Player 1: "+ player1 + "  Player2 : +"+player2 + "Sum offered: "+n;
     //System.out.println(l);
    }
    
    
    public static void main(String arg[])
	    {
                tokens = 100;
	    new DictatorServer();
	    }
}

