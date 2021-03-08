import java.util.*;



 class Controller {
	Service service = new Service();
	public  boolean validate(String email,String password) throws Exception {
		return service.validate(email, password);
		
	}

}
class Service {
	public static boolean validate(String email, String password) throws Exception {
		DAO dao = new DAO();
		String regEmail= "[A-Za-z0-9_\\.]+[@][a-z]+[\\.]([a-z]{2,3})";
		System.out.println(email.matches(regEmail));
		if (email.matches(regEmail)) 
		{
			
			return dao.login(email, password);

		}

		else {
		
			throw new InvalidEmailException("please enter valid gmail account");
		}

	}
}

class DAO {

	public boolean login(String email, String password) throws Exception {
		// TODO Auto-generated method stub
		String regPass="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		if (password.matches(regPass)) {
			return true;
		} else {
			throw new InvalidPasswordException("password must be between 8 to 15 with minimum one special charcter ,number,capital ,small letter");
		}

	}

}



public class SignUpValidatioDemo {
	public static void main(String[] args) {
		String name, address, email, phone, password;
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		name = sc.nextLine();
		System.out.println("Enter age");
		age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter address(city name)");
		address = sc.nextLine();
		System.out.println("Enter email");
		email = sc.nextLine();
		System.out.println("Enter phone");
		phone = sc.nextLine();
		System.out.println("Enter password");
		password = sc.nextLine();
		Controller controller=new Controller();
		try {
			boolean isvalid=controller.validate(email,password);
			if(isvalid)
			{
				System.out.println("Signed up successsfully");
			}
			else
			{
				System.out.println("Wrong credentials");
			}
			
		}
		catch(InvalidEmailException e){
			System.out.println(e.getMessage());
		}
		catch(InvalidPasswordException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
