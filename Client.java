/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
public class Client {
    public static DatagramSocket ds;  
    public static int clientport=789,serverport=790;  
    public static void main(String args[])throws Exception { 
        byte buffer[]=new byte[1024]; 
        ds=new DatagramSocket(serverport); 
        BufferedReader dis=new BufferedReader(new InputStreamReader(System.in)); 
        System.out.println("server waiting");
        InetAddress ia=InetAddress.getByName("192.168.56.1"); 
        while(true){ 
            System.out.print("Client:"); 
            String str=dis.readLine(); 
            if(str.equals("end")) 
            break;
            buffer=str.getBytes(); 
            ds.send(new DatagramPacket(buffer,str.length(),ia,clientport));
            DatagramPacket p=new DatagramPacket(buffer,buffer.length); 
            ds.receive(p);
            String psx=new String(p.getData(),0,p.getLength()); 
            System.out.println("Server:" + psx); 
        } 
    } 


    /**
     * @param args the command line arguments
     */
   
    
}
