import java.util.*;
class AcceptApplication
{
	String education,nationality;
	int age;
	
	
	public static boolean validate(int age,String education,String nationality) throws MinorAgeException,InvalidCountryException,EducationMinRequirementException
	{
		if(age<18)
		{
			throw new MinorAgeException("Age should be greater than 18");
		}
		if(!(nationality.equalsIgnoreCase("india")))
		{
			throw new InvalidCountryException("Nationality should be India");
		}
		if(!(education.equalsIgnoreCase("tenth")))
		{
			throw new EducationMinRequirementException("minimum education qualification should be tenth");
		}
		return true;
		
		
	}
	
}

public class TestLicenseApplication
{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name,nationality,education;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter name");
		name=sc.nextLine();
		System.out.println("Enter age");
		int age=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter nationality");
		nationality=sc.nextLine();
		System.out.println("Enter education(tenth)");
		education=sc.nextLine();
		AcceptApplication accept=new AcceptApplication();
		try {
			boolean result=accept.validate(age,education,nationality);
			if(result==true)
				System.out.println("license application submitted successfully");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
