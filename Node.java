
import java.util.*;
import java.io.*;

//Will store nodes of city, cost and time in the inner linked list

public class Node
{
    String city;
    int cost;
    int time;
    Node next;
    
    public Node(String city, int cost, int time)
    {
        this.city = city;
        this.cost = cost;
        this.time = time;
        this.next = null;
    }
    
    /*
    public void append(String[] newData)
    {
        Node newNode = new Node(newData);
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            Node current = head;
            while (current.next != null)
            {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    */
    
}


