import java.util.*;
import java.io.*;
// import java.

// Creates array of linked lists from data in FlightDataFile.

public class ListofLists
{
    LinkedList<LinkedList<Node>> cityNodes;
    
    public ListofLists(String infile)
    {
        String file1 = infile;
    
        //System.out.println(file1);
        int numRowsInFile=0;
        boolean found0 = false;
        boolean found1 = false;
        String strLine; // Whole read line
        String[] splitLine; // Line split by "|"
        
        // Now read data and store ?
        try
        {
            // BufferedReader faster & more efficient than FileReader
            BufferedReader flightData = new BufferedReader(new FileReader(file1));
            cityNodes = new LinkedList<LinkedList<Node>>();
            
            while((strLine = flightData.readLine()) != null)
            {
                splitLine = strLine.split("[|]");
                // System.out.println(Arrays.toString(splitLine)); ///////////////
                if(numRowsInFile == 0) // means we're reading first line;
                {
                    numRowsInFile = Integer.parseInt(strLine);
                    //strLine = flightData.readLine(); // read next line before to process nodes
                    //System.out.println(numRowsInFile);
                }
                
                else if(cityNodes.size() == 0) // if first element (aka second line)
                {
                    //System.out.println("Hey");
                    LinkedList<Node> innerList = new LinkedList<Node>();
                    
                    // creating 2 nodes (city 1 to city 2)
                    Node node1 = new Node( splitLine[0], 0, 0 );
                    //System.out.println(Arrays.toString(cityInfo));
                    innerList.add(node1);
                    Node node2 = new Node( splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]) );
                    //myNode.next = myNode2;
                    innerList.add(node2);
                    cityNodes.add(innerList);
                    node1.next = node2;
                    
                    
                    // now do same but from city 2 to city 1:
                    Node node3 = new Node( splitLine[1], 0, 0 );
                    //System.out.println(Arrays.toString(cityInfo));
                    LinkedList<Node> innerList2 = new LinkedList<Node>();
                    innerList2.add(node3);
                    Node node4 = new Node( splitLine[0], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]) );
                    //myNode.next = myNode2;
                    innerList2.add(node4);
                    cityNodes.add(innerList2);
                    node3.next = node4;
                }
                
                else
                {
                    for(int i = 0 ; i < cityNodes.size() ; i++)
                    {
                        //System.out.println("Node" + cityNodes.get(i).get(0));
                        //System.out.println("New" + splitLine[0]);
                        if( cityNodes.get(i).get(0).city.equals(splitLine[0]) )
                        {
                            // found splitLine[0] in the i'th linked list, so add splitLine[1] to it
                            //System.out.println("EQUAL");
                            //System.out.println( cityNodes.get(i).get(0).city);
                            found0 = true;
                            Node newNode = new Node( splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]) );
                            cityNodes.get(i).add(newNode); // We found 0th elem., so connect 1st to it
                            int x = cityNodes.get(i).indexOf(newNode);
                            cityNodes.get(i).get(x).next = newNode;
                            //System.out.println("YEAAA" + cityNodes.get(i).get(x).city);
                            i++;
                        }
                    }
                        
                    if (found0 == false)
                    {
                        LinkedList<Node> innerList = new LinkedList<Node>();
                        Node newNode = new Node( splitLine[0], 0, 0 );
                        innerList.add(newNode);
                        
                        Node newNode2 = new Node( splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]) );
                        innerList.add(newNode2);
                        
                        cityNodes.add(innerList);
                        
                        newNode.next = newNode2;
                        
                    }
                        
                    // again but flipped because undirected graph:
                        
                    for(int i = 0 ; i < cityNodes.size() ; i++)
                    {
                        //System.out.println("Node" + cityNodes.get(i).get(0));
                        //System.out.println("New" + splitLine[0]);
                        if( cityNodes.get(i).get(0).city.equals(splitLine[1]) )
                        {
                            // found splitLine[0] in the i'th linked list, so add splitLine[1] to it
                            //System.out.println("EQUAL");
                            //System.out.println( cityNodes.get(i).get(0).city );
                            found1 = true;
                            Node newNode = new Node( splitLine[0], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]) );
                            cityNodes.get(i).add(newNode); // We found 0th elem., so connect 1st to it
                            cityNodes.get(i).get(0).next = newNode;
                            i++;
                        }
                    }
                        
                    if (found1 == false)
                    {
                        LinkedList<Node> innerList = new LinkedList<Node>();
                        Node newNode = new Node( splitLine[1], 0, 0 );
                        innerList.add(newNode);
                        
                        Node newNode2 = new Node( splitLine[0], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]) );
                        innerList.add(newNode2);
                        
                        cityNodes.add(innerList);
                        
                        newNode2.next = newNode2;
                    }
                    
                    found0 = false;
                    found1 = false;
                    
                }
            }
            printLinked(cityNodes);
            
            //System.out.println("LinkedList of LinkedLists:\n" + cityNodes);
        }
        
        catch(Exception e) 
        {
            System.out.println("Exception found:" + e.toString());
        }
        
    }
    
    void printLinked(LinkedList<LinkedList<Node>> cityNodes)
    {
        
        for (LinkedList<Node> innerList : cityNodes)
        {
            for (Node node : innerList)
            {
                System.out.println(node.city + node.cost + node.time);
            }
            System.out.println();
        }
        
        //System.out.println(cityNodes.get(2).get(1).next.city);
    }
    
}

