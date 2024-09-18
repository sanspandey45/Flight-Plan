import java.util.*;
import java.io.*;
//import java.

// Creates array of linked lists from data in FlightDataFile.

public class MyStack
{
    Stack<Node> stack;
    String sLine; // Whole read line
    String[] spltLine; // Line split by "|"
    int numInputs = 0;
    String city1;
    String city2;
    String tC;
    
    public MyStack(String inputFile, String requestFile)
    {
        String file1 = inputFile;
        String file2 = requestFile;
        ListofLists linkedList = new ListofLists(file1);
        
        try 
        {
            // BufferedReader faster & more efficient than FileReader
            BufferedReader flightData = new BufferedReader(new FileReader(file2));
            while((sLine = flightData.readLine()) != null)
            {
                spltLine = sLine.split("[|]");
                
                if(numInputs == 0) // means we're reading first line;
                {
                    numInputs = Integer.parseInt(sLine);
                    //strLine = flightData.readLine(); // read next line before to process nodes
                    //System.out.println(numRowsInFile);
                }
                
                else
                {
                   city1 = spltLine[0];
                   city1 = spltLine[1];
                   tC = spltLine[2]; // determines order of printing flights
                   
                   boolean[] visited = new boolean[linkedList.cityNodes.size()];
                   System.out.println(linkedList.cityNodes.size());
                   for(int i = 0 ; i < linkedList.cityNodes.size() ; i++)
                    {
                        if( linkedList.cityNodes.get(i).get(0).city.equals(city1) )
                        {
                            stack.push(linkedList.cityNodes.get(i).get(0));
                            break;
                        }
                    }
                }
            }
        }
        
        catch(Exception e) 
        {
            System.out.println("Exception found: " + e.toString());
        }
    }

    
}
    
    
    
