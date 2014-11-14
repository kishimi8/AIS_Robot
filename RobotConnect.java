/**********************************************************
 * @author1  Aakash Bharti
 * @author2  Mayank Gupta
 * @author2  Pulkit Verma
 * @year	2014
 
 This was written to be executed on a LEGO NXT Mindstorm 
 Video: https://www.youtube.com/watch?v=Xss32LPafUM
 **********************************************************/

import java.io.*;
import java.util.*;
import java.net.InetAddress;
import java.net.Socket;

class RobotConnect
{
	public Socket socket;
	public ObjectInputStream in;
	public OutputStream os;
	public OutputStreamWriter osw;
	public BufferedWriter bw;
	
	public RobotConnect(String name, int port)
	{
		  String command = "\"C:\\Program Files (x86)\\leJOS NXJ\\bin\\nxj\" -b -n " + name + " nxtbin";
		  try
		  {
			  ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "nxj -b -n " + name + " nxtbin");
			  builder.redirectErrorStream(true);
			  System.out.println("Starting...");
		      Process p = builder.start();
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  try
        {
		//String number = "22-3$";//"#6-C$";//"4-C-60-C$";//"-0A20!";
		// "22-3$" --> initialize ultrasonic
		//"#-26-3$" --> read ultrasonic
		
            String host = "localhost";
            //int port = 8688;
            InetAddress address = InetAddress.getByName(host);
            socket = new Socket(address, port);
			in = new ObjectInputStream(socket.getInputStream());
			
			os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
			
			command = "22-" + 1 + "$"; //"22-3$"
			executeOpCode(command);
			
			command = "22-" + 2 + "$"; //"22-3$"
			executeOpCode(command);
			
			command = "22-" + 3 + "$"; //"22-3$"
			executeOpCode(command);
			
			//Ultrasonic sensors initialized. Now read 2 values to stabilize the sensor.
			
			readUltrasonic(1);
			readUltrasonic(1);
			
			readUltrasonic(2);
			readUltrasonic(2);
			
			readUltrasonic(3);
			readUltrasonic(3);
			
			command = "48-" + 4 + "$"; //"48-4$"
			executeOpCode(command);
			
			readColor(4);
			readColor(4);
			
		}
		catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
	}	  
	public String executeOpCode(String number)
	{
		  try
		  {		
            //String number = "22-3$";//"22-3$";//"4-C-60-C$";
            String sendMessage = number;// + "\n";
            bw.write(sendMessage);
            bw.flush();
            
            //Get the return message from the server
            
			Object ob = in.readObject();
            }
			catch(Exception e)
			{
				return e.getMessage();
			}
			return "success";
		}

public String readUltrasonic(int port)
	{
		try
		{
			//System.out.println("Reading on port no. " + port);
			//"#-26-3$"
            String sendMessage = "#-26-" + port + "$";//number;// + "\n";
            bw.write(sendMessage);
            bw.flush();
            
            //Get the return message from the server
            Object ob = in.readObject();
			ob = in.readObject();
            
			StringTokenizer tok = new StringTokenizer(ob.toString(), "X");
			tok.nextToken();
			String distance = tok.nextToken();
			
			if(isNumeric(distance))
				return distance;
			
			while(!(isNumeric(distance)))
			{
				ob = in.readObject();
            
				tok = new StringTokenizer(ob.toString(), "X");
				tok.nextToken();
				distance = tok.nextToken();
			}
			return distance;

		}
		catch (Exception exception)
        {
            exception.printStackTrace();
        }
		return "ERROR";
	}

		
	public String readUltrasonicWorking(int port)
	{
		try
		{
			System.out.println("Reading on port no. " + port);
			//"#-26-3$"
            String sendMessage = "#-26-" + port + "$";//number;// + "\n";
            bw.write(sendMessage);
            bw.flush();
            
            //Get the return message from the server
            Object ob = in.readObject();
			ob = in.readObject();
            
			System.out.println("Message received: " + ob.toString());
			
			bw.write(sendMessage);
            bw.flush();
            
            //Get the return message from the server
            ob = in.readObject();
			ob = in.readObject();
			ob = in.readObject();
            
			StringTokenizer tok = new StringTokenizer(ob.toString(), "X");
			tok.nextToken();
			String distance = tok.nextToken();
			return distance;

		}
		catch (Exception exception)
        {
            exception.printStackTrace();
        }
		return "ERROR";
	}
	
	public void end()
	{
		try
		{
			//number = "#6-C$";//"22-3$";//"4-C-60-C$";
			String number = "@";//"#6-C$";//"22-3$";//"4-C-60-C$";
 
            String sendMessage = number;// + "\n";
            bw.write(sendMessage);
            bw.flush();
            System.out.println("Message sent to the server : "+sendMessage);
 
            //Get the return message from the server
			Object ob = in.readObject();
            System.out.println("Message received from the server : " + ob.toString());// +message);*/
			//---------------------------
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            //Closing the socket
            try
            {
                socket.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
	
		}
	}
	
	public static boolean isNumeric(String str)  
	{  
	try  
	{  
		double d = Double.parseDouble(str);  
	}  
	catch(NumberFormatException nfe)  
	{  
		return false;  
	}  
	return true;  
	}
	
	public String readColor(int port)
	{
		try
		{
			//System.out.println("Reading on port no. " + port);
			//"#-51-4$"
            String sendMessage = "#-51-" + port + "$";//number;// + "\n";
            bw.write(sendMessage);
            bw.flush();
            
            //Get the return message from the server
            Object ob = in.readObject();
			ob = in.readObject();
            
			StringTokenizer tok = new StringTokenizer(ob.toString(), "X");
			tok.nextToken();
			String distance = tok.nextToken();
			
			if(isNumeric(distance))
				return distance;
			
			while(!(isNumeric(distance)))
			{
				ob = in.readObject();
            
				tok = new StringTokenizer(ob.toString(), "X");
				tok.nextToken();
				distance = tok.nextToken();
			}
			return distance;

		}
		catch (Exception exception)
        {
            exception.printStackTrace();
        }
		return "ERROR";
	}
	

}
