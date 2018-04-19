package micron.rest.customermanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


//This class is used to create a users.dat file with few User object inside and will be used for testing
public class WriteUsers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		List<User> userList = null;
	      File file = new File("D:\\Javasamples-dev\\CustomerAPI\\WebContent\\Users.dat");
		     if (!file.exists()) 
		     {
		    	 //System.out.println("File Does not exist");
		    	 System.out.println("File does not exist hence creating a new file " + file.createNewFile());
		    	 userList = new ArrayList<User>();
			        User user1 = new User(1, "Raghav", "Teacher");
			        userList.add(user1);
			        User user2 = new User(2, "Madhu", "Engineer");
			        userList.add(user2);
			        User user3 = new User(3, "Velu", "Engineer");
			        userList.add(user3);
			        saveUserList(userList);
		     }
		     else
		     {
		    	System.out.println("File exist hence adding records");
		    	FileInputStream fis = new FileInputStream(file);
		        ObjectInputStream ois = new ObjectInputStream(fis);
		        try {
					userList = (List<User>) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        ois.close();
		    	
		        //userList = new ArrayList<User>();
		        User user1 = new User(4, "Dheeraj", "Teacher");
		        userList.add(user1);
		        User user2 = new User(5, "Anandan", "Engineer");
		        userList.add(user2);
		        User user3 = new User(6, "Fazul", "Engineer");
		        userList.add(user3);
		        saveUserList(userList);
		     }

	}
	
	private static void saveUserList(List<User> userList){
	      try {
	         File file = new File("D:\\Javasamples-dev\\CustomerAPI\\WebContent\\Users.dat");
	         FileOutputStream fos;

	         fos = new FileOutputStream(file);

	         ObjectOutputStream oos = new ObjectOutputStream(fos);
	         oos.writeObject(userList);
	         oos.close();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	   }   

}
