/**********************************************************
 * @author1  Aakash Bharti
 * @author2  Mayank Gupta
 * @author2  Pulkit Verma
 * @year	2014
 
 This was written to be executed on a LEGO NXT Mindstorm 
 Video: https://www.youtube.com/watch?v=Xss32LPafUM
 **********************************************************/

public class LejosJavaInterface
{
	RobotConnect device;
	public LejosJavaInterface(String deviceName, int port)
	{
		device = new RobotConnect(deviceName, port);
	}
	public boolean move_forward_nxt(char port,int speed)
	{
		String opCode = "0-"+port+"-"+speed+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean move_forward_nxt(char port1,char port2,int speed)
	{
		move_forward_nxt(port1,speed);
		move_forward_nxt(port2,speed);
		
		return true;
	}

	public boolean move_backward_nxt(char port,int speed)
	{
		String opCode = "1-"+port+"-"+speed+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean move_backward_nxt(char port1,char port2,int speed)
	{
		move_backward_nxt(port1,speed);
		move_backward_nxt(port2,speed);
		
		return true;
	}

	public boolean flt_nxt(char port)
	{
		String opCode = "2-"+port+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean flt_nxt(char port1, char port2)
	{
		flt_nxt(port1);
		flt_nxt(port2);
		
		return true;
	}

	public boolean stop_nxt (char port)
	{
		String opCode = "3-"+port+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean stop_nxt(char port1, char port2)
	{
		stop_nxt(port1);
		stop_nxt(port2);
		
		return true;
	}

	public boolean rotate_nxt(char port,int angle, char direction)
	//direction = + (clockwise) OR - (anti-clockwise)
	{
		String opCode = "4-"+port+"-"+angle+"-"+direction+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean rotateto_nxt(char port,int angle, char sign)
	//direction = + (clockwise) OR - (anti-clockwise)
	{
		String opCode = "61-"+port+"-"+angle+"-"+sign+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean set_motorspeed_nxt(char port, int speed)
	{
		String opCode = "64-"+port+"-"+speed+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean set_motorspeed_nxt(char port1, char port2, int speed)
	{
		set_motorspeed_nxt(port1,speed);
		set_motorspeed_nxt(port2,speed);
		
		return true;
	}

	public boolean set_acceleration_nxt(char port,int accel)
	{
		String opCode = "65-"+port+"-"+accel+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean set_acceleration_nxt(char port1,char port2,int accel1,int accel2)
	{
		set_acceleration_nxt(port1,accel1);
		set_acceleration_nxt(port2,accel2);
		
		return true;
	}

	public boolean reverse_nxt(char port)
	{
		String opCode = "5-"+port+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean reverse_nxt(char port1,char port2)
	{
		reverse_nxt(port1);
		reverse_nxt(port2);
		
		return true;
	}

	public boolean write_lcd_nxt(int corx,int cory,String string)
	{
		String opCode = "7-"+corx+"-"+cory+"-"+string+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean clear_lcd_nxt()
	{
		String opCode = "8-"+" "+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean wait_nxt(int time)
	{
		String opCode = "10-"+time+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean exec_nxt(String program)
	{
		String opCode = "11-"+program+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean del_nxt(String program)
	{
		String opCode = "13-"+program+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean exists_nxt(String program,String res)
	{
		String opCode = "#-12-"+program+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public boolean download_nxt(String file,String path)
	{
		String opCode = "14-"+file+"-"+path+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	//check_res_nxt(Name,T)
	//read_res_nxt(Name,T)

	public boolean ismoving_nxt(int port,String res)
	{
		String opCode = "#-6-"+port+"$";
		String opResult = executeOpCode(opCode);

		if(!opResult.equals("success"))
			return false;

		return true;
	}

	public int readUltrasonic(int port)
	{
		String distance = device.readUltrasonic(port);
		return Integer.parseInt(distance);
	}
	
	public int readColor(int port)
	{
		String color = device.readColor(port);
		return Integer.parseInt(color);
	}
	
	public String executeOpCode(String opCode)
	{
		String result = device.executeOpCode(opCode);
		return result;
	}
	
	public void endConnection()
	{
		device.end();
	}
	
	public void rotate(char port, int angle)
	{//for 45 degrees -> rotate for 2 seconds at speed 20
	//for 15 degrees -> rotate for 2 seconds at speed 10
		if(angle > 0)
		{
		move_forward_nxt(port, 20);
		try
			{
				Thread.sleep(2000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			stop_nxt(port);
		}
		else
		{
		move_backward_nxt(port, 20);
		try
			{
				Thread.sleep(2000);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			stop_nxt(port);
		}
	}
}
