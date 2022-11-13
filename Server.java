/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classwork;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author suraj
 */
public class Server {
 public static DatagramSocket ds;  
    public static byte buffer[]=new byte[1024]; 
    public static int clientport=789,serverport=790;
    public static void main(String args[])throws Exception { 
        ds=new DatagramSocket(clientport); 
        System.out.println("press ctrl+c to quit the program"); 
        BufferedReader dis=new BufferedReader(new InputStreamReader(System.in)); 
        InetAddress ia=InetAddress.getByName("localhost");
        while(true){ 
            DatagramPacket p=new DatagramPacket(buffer,buffer.length);
            ds.receive(p); 
            String psx=new String(p.getData(),0,p.getLength()); 
            System.out.println("Client:" + psx); 
            System.out.print("Server:");
            String str=dis.readLine();
            if(str.equals("end"))  
            break;  
            buffer=str.getBytes(); 
            ds.send(new DatagramPacket(buffer,str.length(),ia,serverport)); 
        } 
    } 

    
}
