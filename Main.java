import java.util.*;
import java.io.*;

public class Main
{
	public static void main (String [] args)
	{
	    //System.out.println(args.length);
	    String file1 = args[0];
	    String file2 = args[1];
	    String file3 = args[2];
	   
	    
	    // create ListofLists obj and pass first input file to its constructor.
        //ListofLists linkedList = new ListofLists(file1);
        MyStack stack = new MyStack(file1, file2);
	    
	}
}
