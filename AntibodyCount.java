/**********************************************************
 * @author1  Aakash Bharti
 * @author2  Mayank Gupta
 * @author2  Pulkit Verma
 * @year	2014
 
 This was written to be executed on a LEGO NXT Mindstorm 
 Video: https://www.youtube.com/watch?v=Xss32LPafUM
 **********************************************************/
 
import java.io.*;
class AntibodyCount
{

	public static void main(String args[])
	{
		int count = 0;
		AntibodyCollection abc = getObject();
		for(Antibody ab : abc.arrayList)
	{
		//if(ab.action.equals("02302"))
		//if(ab.concentration != 1)
		if((ab.eligible))// && (!ab.antigenValues.isBlack))
		//if(ab.action.equals("32222"))
		{
			count++;
			//count += ab.concentration;
			//System.out.println(ab.concentration);
			//System.out.print(ab.action + " ");
		}
		
	
	}

	System.out.println("Eligible: " + count);
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
}
