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

class AntibodyCollection implements Serializable
{

	public ArrayList<Antibody> arrayList;

	public AntibodyCollection()
	{
		arrayList = new ArrayList<Antibody>();
	}
		
	public void add(Antibody antibody)
	{
		arrayList.add(antibody);
	}

}

class Behaviour
{
	public static int angle = 5;
	public static int dist = 5;
	public static int safeDistance = 10;
	public static int safeDistanceDiagonal = 20;
public static int executeBehaviour(int behaviour, LejosJavaInterface robot)
{	/*
	0: Move forward 10 steps
	1: Move backward
	2: Rotate X degrees
	3: Rotate -X degrees
	4: No operartion
	*/
	switch(behaviour)
	{
	
	//static UltrasonicSensor sonar = new UltrasonicSensor(SensorPort.S3);//-----fixed ultrasonic sensor
	// 22-3$
	//static Pilot pilot = new TachoPilot(5.6f, 14.0f, Motor.A, Motor.B, false);

	case 0: 
	{
		try
		{
		int x = 100000;
		System.out.print("0 : ");
		/*sonar.ping();
		for(int i = 0; i < 20; i++) // i steps chalana he
		{
			sonar.ping();
		if(sonar.getDistance()<safeDistance)
		{
			pilot.stop(); //3-A$ 3-B$
			return -1;
		}
			pilot.setMoveSpeed(7);
			pilot.travel(2); //0-A-20$ 0-B-20$
		}*/
		
		int distance = robot.readUltrasonic(2);
		distance = robot.readUltrasonic(2);
		distance = robot.readUltrasonic(2);
		
		robot.rotate_nxt('C', (45-(int)(45 / x)), 'A');
		Thread.sleep(100);
		int leftForward = robot.readUltrasonic(3);
		Thread.sleep(100);
		
		robot.rotate_nxt('C', (90-(int)(90 / x)), 'C');
		Thread.sleep(100);
		int rightForward = robot.readUltrasonic(3);
		Thread.sleep(100);
			
			
		robot.rotate_nxt('C', (45-(int)(45 / x)), 'A');
		
		for(int i = 0; i < 2; i++)
		{
			robot.move_backward_nxt('A', 'B', 40);
			if((distance < safeDistance) || (leftForward < safeDistanceDiagonal) || (rightForward < safeDistanceDiagonal))
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				System.out.print(" returning... ");			
				return -1;
			}
			for(int j = 0; j < 10; j++)
			{
				try
				{
					Thread.sleep(100);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				/*if(robot.readColor(4) == 0)
				{
					robot.stop_nxt('A', 'B'); //3-A$ 3-B$
					return 2;
				}*/
			}
			
			distance = robot.readUltrasonic(2);
			distance = robot.readUltrasonic(2);
			distance = robot.readUltrasonic(2);
			if(distance < safeDistance)
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				return -1;
			}
			/*if(robot.readColor(4) == 0)
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				return 2;
			}*/
			

			robot.rotate_nxt('C', (45-(int)(45 / x)), 'A');
			Thread.sleep(100);
			leftForward = robot.readUltrasonic(3);
			leftForward = robot.readUltrasonic(3);
			Thread.sleep(100);

			
			distance = robot.readUltrasonic(2);
			distance = robot.readUltrasonic(2);
			distance = robot.readUltrasonic(2);
			
			if(distance < safeDistance)
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				robot.rotate_nxt('C', (45-(int)(45 / x)), 'C');
				return -1;
			}
			
			/*if(robot.readColor(4) == 0)
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				return 2;
			}*/
			
			robot.rotate_nxt('C', (90-(int)(90 / x)), 'C');
			Thread.sleep(100);
			rightForward = robot.readUltrasonic(3);
			rightForward = robot.readUltrasonic(3);
			Thread.sleep(100);
			
			
			distance = robot.readUltrasonic(2);
			distance = robot.readUltrasonic(2);
			distance = robot.readUltrasonic(2);
			
			if(distance < safeDistance)
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				robot.rotate_nxt('C', (45-(int)(45 / x)), 'A'); //Back to original position
				return -1;
			}
			
			/*if(robot.readColor(4) == 0)
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				return 2;
			}*/
			
			
			robot.rotate_nxt('C', (45-(int)(45 / x)), 'A'); //Back to original position
			
			System.out.println("\nDistances: " + distance + " " + leftForward + " " + rightForward);
	
		}
		robot.stop_nxt('A', 'B'); //3-A$ 3-B$
		/*Motor.A.setSpeed(100);
		Motor.B.setSpeed(100);
		Motor.A.forward();
		Motor.B.forward();
		Motor.A.stop();
		Motor.B.stop();*/
		break;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	}
	case 1: 
	{
		System.out.print("1 ");
		/*pilot.setMoveSpeed(7);
		pilot.travel(-20); //1-A-20$ 1-B-20$*/
		for(int i = 0; i < 3; i++)
		{
			int distance = robot.readUltrasonic(1);
			distance = robot.readUltrasonic(1);
			distance = robot.readUltrasonic(1);
			
			if(distance < safeDistance)
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				return -1;
			}
			
			/*if(robot.readColor(4) == 0)
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				return 2;
			}*/
			
			robot.move_forward_nxt('A', 'B', 50);
			
			for(int j = 0; j < 10; j++)
			{
				try
				{
					Thread.sleep(100);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				/*if(robot.readColor(4) == 0)
				{
					robot.stop_nxt('A', 'B'); //3-A$ 3-B$
					return 2;
				}*/
			}
			distance = robot.readUltrasonic(1);
			distance = robot.readUltrasonic(1);
			distance = robot.readUltrasonic(1);
		}
		robot.stop_nxt('A', 'B'); //3-A$ 3-B$
		/*Motor.A.setSpeed(100);
		Motor.B.setSpeed(100);
		Motor.A.backward();
		Motor.B.backward();
		Motor.A.stop();
		Motor.B.stop();*/
		break;
	}
	case 2: 
	{
		System.out.print("2 ");
		/*pilot.rotate(angle); // 4-B-60-C$*/
		//speed 20, 2 ms -> 5 degrees
		robot.move_forward_nxt('A', 60);
		robot.move_backward_nxt('B', 60);
		for(int i = 0; i < 10; i++)
		{
			try
			{
				Thread.sleep(200);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			/*if(robot.readColor(4) == 0)
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				return 2;
			}*/
		}
		robot.stop_nxt('A', 'B'); //3-A$ 3-B$
		break;
	}
	case 3: 
	{
		System.out.print("3 ");
		/*pilot.rotate(-1 * angle); //4-B-60-A$*/
		robot.move_backward_nxt('A', 60);
		robot.move_forward_nxt('B', 60);
		for(int i = 0; i < 10; i++)
		{
			try
			{
				Thread.sleep(200);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			/*if(robot.readColor(4) == 0)
			{
				robot.stop_nxt('A', 'B'); //3-A$ 3-B$
				return 2;
			}*/
		}
		robot.stop_nxt('A', 'B'); //3-A$ 3-B$
		break;
	}
	
	}
	return 0;
}

public static int executeLineFollowingBehaviour(int behaviour, LejosJavaInterface robot)
{
	switch(behaviour)
	{
		case 0:
		case 1:
		case 2:
			{
				System.out.print(behaviour + " ");
				int distance = robot.readUltrasonic(2);
				if(distance < safeDistance)
				{
						robot.stop_nxt('A', 'B');
						return -1;
				}
				//Follow right edge.
				robot.move_backward_nxt('A', 'B', 60);
				for(int i = 0; i < 10; i++)
				{
					robot.move_backward_nxt('A', 'B', 60);
					distance = robot.readUltrasonic(2);
					if(distance < safeDistance)
					{
						robot.stop_nxt('A', 'B');
						return -1;
					}
					int color = robot.readColor(4);
					if(color == 0) //black
					{
						if(i != 9) //To ensure that the final iteration puts the robot on black.
						{
							robot.stop_nxt('B');
							while(robot.readColor(4) == 0);
							//robot.move_backward_nxt('A', 'B', 60);
						}
					}
					else if((color == 5) || (color == 6))
					{
						//If yellow found, line has ended; Move some steps forward.
						robot.move_backward_nxt('A', 'B', 60);
						try
						{
							Thread.sleep(2000);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						robot.stop_nxt('A', 'B');
						return 2;
					}
					else
					{
						robot.stop_nxt('A');
						color = robot.readColor(4);
						while(((robot.readColor(4)) != 0) && (robot.readColor(4) != 5) && (robot.readColor(4) != 6));
						if((color == 5) || (color == 6))
						{
							//If yellow found, line has ended; Move some steps forward.
							robot.move_backward_nxt('A', 'B', 60);
							try
							{
								Thread.sleep(2000);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							robot.stop_nxt('A', 'B');
							return 2;
						}
						//robot.move_backward_nxt('A', 'B', 60);
					}
				}
				robot.stop_nxt('A', 'B');
				break;
			}
		//case 2:
		case 3:
			{
				System.out.print(behaviour + " ");
				int distance = robot.readUltrasonic(1);
				if(distance < safeDistance)
				{
					robot.stop_nxt('A', 'B');
					return -1;
				}
				//Follow right edge.
				robot.move_forward_nxt('A', 'B', 60);
				for(int i = 0; i < 10; i++)
				{
					robot.move_forward_nxt('A', 'B', 60);
					distance = robot.readUltrasonic(1);
					if(distance < safeDistance)
					{
						robot.stop_nxt('A', 'B');
						return -1;
					}
					int color = robot.readColor(4);
					if(color == 0) //black
					{
						if(i != 9)
						{
							robot.stop_nxt('A');
							while(robot.readColor(4) == 0);
							//robot.move_forward_nxt('A', 'B', 60);
						}
					}
					else if((color == 5) || (color == 6))
					{
						//If yellow found, line has ended; Move some steps forward.
						robot.move_forward_nxt('A', 'B', 60);
						try
						{
							Thread.sleep(2000);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						robot.stop_nxt('A', 'B');
						return 2;
					}
					else
					{
						robot.stop_nxt('B');
						color = robot.readColor(4);
						while(((robot.readColor(4)) != 0) && (robot.readColor(4) != 5) && (robot.readColor(4) != 6));
						if((color == 5) || (color == 6))
						{
							//If yellow found, line has ended; Move some steps forward.
							robot.move_forward_nxt('A', 'B', 60);
							try
							{
								Thread.sleep(2000);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							robot.stop_nxt('A', 'B');
							return 2;
						}
						//robot.move_forward_nxt('A', 'B', 60);
					}
				}
				robot.stop_nxt('A', 'B');
				break;
			}
	}
	return 0; //Success
}


}

class Antigen implements Serializable
{

public Antigen()
{
}

public Antigen(int v1, int v2, int v3, int v4, int v5, int v6, int v7, boolean color)//, int v8, int v9)
{

	fields[0] =v1;
	fields[1] =v2;
	fields[2] =v3;
	fields[3] =v4;
	fields[4] =v5;
	fields[5] =v6;
	fields[6] =v7;
	isBlack = color;
	//fields[7] =v8;
	//fields[8] =v9;

/*	obstacleLeft = v1;
	obstacleRight = v2;
	obstacleFront1 = v3;
	obstacleFront2 = v4;
	obstacleBack = v5;
	obstacleleftFront = v6;
	obstaclerightFront = v7;
	//obstacleleftBack = v8;
	//obstaclerightBack = v9;
*/
}
public int fields[] = new int[7];
public boolean isBlack = false;
/*int obstacleLeft;
int obstacleRight;
int obstacleFront1;
int obstacleFront2;
int obstacleBack;
int obstacleleftFront;
int obstaclerightFront;
int obstacleleftBack;
int obstaclerightBack;
*/
}

class Antibody implements Serializable
{
Antigen antigenValues;
int concentration = 1;
boolean eligible = true;
String action;  //This string contains a permutation of actions to be performed

public Antibody()
{
	antigenValues = new Antigen();
}

public int performAction(LejosJavaInterface robot)
{
	int result = 0;
	for(int i = 0; i < action.length(); i++)
	{
		int behaviour = Integer.parseInt(action.substring(i, i + 1));
		//if(!this.antigenValues.isBlack) //If the color in the antibody (= color in antigen) isBlack
		result = Behaviour.executeBehaviour(behaviour, robot);
		//else
			//result = Behaviour.executeLineFollowingBehaviour(behaviour, robot);
		if(result == -1)
		{
			//this.eligible = false;
			System.out.print("Logging Negative feedback...");
			return -1;
		}
		else if(result == 2)
		{
			return 0;
		}
	}
	return 0;
	
}

public void getFeedback(double pain, double newPain, int result)
{
	if(result == -1)
	{
		--this.concentration;
		if(this.concentration == 0)
		{
			this.eligible = false;
		}
		return;
	}
	if(pain >= newPain)
		this.concentration++;
	else
	{
		--this.concentration;
		if(this.concentration == 0)
		{
			this.eligible = false;
		}
	}
}

}

class Main
{
	public static AntibodyCollection antibodyCollection = null;
	public static void main(String args[])
	{
	antibodyCollection = getObject();
	System.out.println("Enter 0 to generate antibodies, 1 to learn and 2 to execute...");
	int answer = 1;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try
	{
		
		try
		{
			answer = Integer.parseInt(br.readLine());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	if(answer == 2)
	{
		LejosJavaInterface robot = new LejosJavaInterface(args[0], Integer.parseInt(args[1]));
		Antigen antigen = getAntigen(robot);
		double pain = calculatePain(antigen);
		while(true)
		{
			//AntibodyAndIndex antibodyAndIndex = getEligibleAntibody(antigen);
			//Antibody antibody = antibodyAndIndex.antibody;
			int index = getEligibleAntibody(antigen);
			System.out.println("Executing action sequence: " + antibodyCollection.arrayList.get(index).action);
			antibodyCollection.arrayList.get(index).performAction(robot);
			antigen = getAntigen(robot);
			double newPain = calculatePain(antigen);
			System.out.println("New Pain: " + newPain);
			//if(antibodyCollection.arrayList.get(index).eligible)//--------if true then take feedback and means it has peformed action completely
				//antibodyCollection.arrayList.get(index).getFeedback(pain, newPain);
			pain = newPain;
			//writeObject(getObject());
			//writeObject(antibodyCollection);
			
		}
	}
	
	if(answer == 0)
	{
		if(antibodyCollection == null)
		{
			//The object doesn't yet exist on the disk. Create the object.
			antibodyCollection = new AntibodyCollection();
		}
		System.out.print("Enter number of random strings to be generated: ");

		Random rand = new Random();
		int number = 1;
		try
		{
			number = Integer.parseInt(br.readLine());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int i = 0; i < number;i++)
		{
			int r = rand.nextInt(5);
			String actString = "";
			Antibody antb = new Antibody();
			for(int j = 0; j<5 ; j++)//-------------for action string
			{
				actString+= rand.nextInt(4);
			}
			for(int j = 0; j<antb.antigenValues.fields.length ; j++)//---------for antibodies fields
			{
				if((j != 3) && (j!= 2))
					antb.antigenValues.fields[j]= (rand.nextInt(175)) / 5;
				else
					antb.antigenValues.fields[j]= (rand.nextInt(175));
			}
			//antb.antigenValues.fields[2] = antb.antigenValues.fields[3] + (5 - rand.nextInt(11)); //Since the values of fixed1 and fixed2 must be close to each other.
			int colorCode = rand.nextInt(2);
			if(colorCode == 0)
				antb.antigenValues.isBlack = true;
			else
				antb.antigenValues.isBlack = false;
			antb.action = actString;
			antb.concentration = 2; //Initial concentration
			
		//generate random string and add to a new antibody object and add this object to the collection.	
		antibodyCollection.arrayList.add(antb);
		//System.out.println(antb.action);
		}
		writeObject(antibodyCollection);
		
		return;
	}
	LejosJavaInterface robot = new LejosJavaInterface(args[0], Integer.parseInt(args[1])); //----> CHANGE THE ROBOTNAME HERE
	Antigen antigen = getAntigen(robot);
	double pain = calculatePain(antigen);
	while(true)
	{
		//AntibodyAndIndex antibodyAndIndex = getEligibleAntibody(antigen);
		//Antibody antibody = antibodyAndIndex.antibody;
		int index = getEligibleAntibody(antigen);
		System.out.println("Executing action sequence: " + antibodyCollection.arrayList.get(index).action);
		int result = antibodyCollection.arrayList.get(index).performAction(robot);
		antigen = getAntigen(robot);
		double newPain = calculatePain(antigen);
		System.out.println("New Pain: " + newPain);
		//if(antibodyCollection.arrayList.get(index).eligible)//--------if true then take feedback and means it has peformed action completely
		antibodyCollection.arrayList.get(index).getFeedback(pain, newPain, result);
		pain = newPain;
		//writeObject(getObject());
		writeObject(antibodyCollection);
		
	}
}

public static double calculatePain(Antigen antigen)
{
	double MULTIPLIER = 300;
	double MAX = 500;
	double pain = 0;
	for(int i = 0; i < antigen.fields.length; i++)
	{
		if(antigen.fields[i] == 0)
			pain += MAX;
		else
			pain += (MULTIPLIER / antigen.fields[i]);
	}
	/*if(!antigen.isBlack)
		pain += 400;*/
		//front1: fields[2], front2 = fields[3]
	if(antigen.fields[2] > antigen.fields[3])
	{
		//The object is moving closer. Increase the pain appropriately.
		pain += ((10 * MULTIPLIER) / antigen.fields[3]);
	}
	return pain;
}

public static Antigen getAntigen(LejosJavaInterface robot)
{
	/*
	1: Back
	2: Front
	3: Fixed
	*/
	try
	{
	int fixed1 = robot.readUltrasonic(2);
	fixed1 = robot.readUltrasonic(2);
	fixed1 = robot.readUltrasonic(2);
	
	int x = 100000;
	
	robot.rotate_nxt('C', (90-(int)(90 / x)), 'A');
	Thread.sleep(100);
	int left = (robot.readUltrasonic(3) / 5);
	left = (robot.readUltrasonic(3) / 5);
	Thread.sleep(100);
	
	robot.rotate_nxt('C', (45-(int)(45 / x)), 'C');
	
	Thread.sleep(100);
	int leftForward = (robot.readUltrasonic(3) / 5);
	leftForward = (robot.readUltrasonic(3) / 5);
	Thread.sleep(100);
	//int leftBackward = robot.readUltrasonic(3);
	
	//robot.rotate_nxt('C', 45, 'C');
	robot.rotate_nxt('C', (45-(int)(45 / x)), 'C');
	Thread.sleep(100);
	int backward = (robot.readUltrasonic(1) / 5);
	backward = (robot.readUltrasonic(1) / 5);
	Thread.sleep(100);
	
	//robot.rotate_nxt('C', 45, 'C');
	robot.rotate_nxt('C', (45-(int)(45 / x)), 'C');
	//int rightBackward = robot.readUltrasonic(3);
	Thread.sleep(100);
	int rightForward = (robot.readUltrasonic(3) / 5);
	rightForward = (robot.readUltrasonic(3) / 5);
	Thread.sleep(100);
	
	//robot.rotate_nxt('C', 45, 'C');
	robot.rotate_nxt('C', (45-(int)(45 / x)), 'C');
	Thread.sleep(100);
	int right = (robot.readUltrasonic(3) / 5);
	right = (robot.readUltrasonic(3) / 5);
	Thread.sleep(100);

	//robot.rotate_nxt('C', 180, 'A');
	robot.rotate_nxt('C', (90-(int)(90 / x)), 'A');
	Thread.sleep(100);
	int fixed2 = robot.readUltrasonic(2);
	fixed2 = robot.readUltrasonic(2);
	Thread.sleep(100);
	
	int colorCode = robot.readColor(4);
	boolean isBlack;
	if(colorCode == 0)
		isBlack = true;
	else
		isBlack = false;

	Antigen anti = new Antigen(left,right,fixed1,fixed2,backward,leftForward,rightForward, isBlack);//,leftBackward,leftForward);
	System.out.println();
	for(int k = 0; k < anti.fields.length; k++)
		System.out.print(anti.fields[k] + " ");
	
	if(anti.isBlack)
		System.out.println("Black");
	else
		System.out.println("Not Black");
	
	return anti;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return null;
}


public static int getEligibleAntibody(Antigen antigen)
{	
	//AntibodyCollection abc = getObject();
	//Antibody closestAntibody = antibodyCollection.arrayList.get(0);//abc.arrayList.next();//----------it is the first antibody
	
	int closestAntibodyIndex = 0;
	Antibody closestAntibody = null;
	for(int i = 0; i < antibodyCollection.arrayList.size(); i++)
	{
		if((antibodyCollection.arrayList.get(i).eligible))// && (antibodyCollection.arrayList.get(i).antigenValues.isBlack == antigen.isBlack))
		{
			closestAntibody = antibodyCollection.arrayList.get(i);
			closestAntibodyIndex = i;
			break;
		}
	}
	
	//int closestAntibodyIndex = 0, 
	int i = 0;
	double smallestDistance = difference(antigen, closestAntibody);
	
	for(Antibody ab : antibodyCollection.arrayList)
	{
		if((ab.eligible) && (ab.antigenValues.isBlack == antigen.isBlack))
		{
			double result = difference(antigen, ab);
			if(result < smallestDistance)
			{
				closestAntibody = ab;
				closestAntibodyIndex = i;
				smallestDistance = result;
			}
		}
		i++;
	}
	return closestAntibodyIndex;
	//return antibodyAndIndex;
}

public static AntibodyCollection getObject()//-------------deserialize
{
	AntibodyCollection ac = null;
	try
      {
         FileInputStream fileIn = new FileInputStream("antibodies.ser");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         ac = (AntibodyCollection) in.readObject();
         in.close();
         fileIn.close();
      }
	  catch(IOException i)
      {
		 ac = new AntibodyCollection();
         return ac;
      }
	  catch(ClassNotFoundException c)
      {
         System.out.println("Employee class not found");
         c.printStackTrace();
         return null;
      }
	  
	  return ac ;

}

public static void writeObject(AntibodyCollection ac)
{
	try
      {
         FileOutputStream fileOut = new FileOutputStream("antibodies.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(ac);
         out.close();
         fileOut.close();
      }catch(IOException i)
      {
         i.printStackTrace();
      }
}

public static double difference(Antigen antigen, Antibody antibody)
{
	double diff = 0;
	for(int i = 0; i < antigen.fields.length; i++)
	{
		diff += (antigen.fields[i] - antibody.antigenValues.fields[i]) * (antigen.fields[i] - antibody.antigenValues.fields[i]);
	}
	diff = diff / (1 + Math.log(antibody.concentration));
	return diff;
}

} //End of class
