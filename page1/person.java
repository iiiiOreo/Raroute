package page1;

import java.util.Scanner;

public class person {
    public Scanner input = new Scanner(System.in);

    protected String fname;
    protected String lname;
    protected String username;
    protected String password;
    protected String phonenumber;

  person()
  {
        System.out.println("enter first name");
      this.fname=input.next();
        System.out.println("enter last name");
      this.lname=input.next();
      System.out.println("enter username");
      this.username=input.next();
        System.out.println("enter password");
      this.password=input.next();
      System.out.println("enter phonenumber");
      this.phonenumber=input.next();
  }
  person(String f , String l , String u  ,String p , String n)
  {
      this.fname=f;
      this.lname=l;
      this.username=u;
      this.password=p;
      this.phonenumber=n;
  }
  // Getter methods
  public String getFirstName() {
    return fname;
  }

  public String getLastName() {
    return lname;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getPhonenumber() {
    return phonenumber;
  }
}