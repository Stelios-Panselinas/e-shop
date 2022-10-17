
public abstract class User
{
    private static String name;
    protected  String email;
  
    //constructor χωρίς ορίσματα
    public User(){}

    //constructor με ορίσματα
    public User(String nam,String mail){
        name=nam;
        email=mail;
    }

    //επιστρέφει την τιμή της μεταβλητής name
    public static String getName(){
        return name;
    }

    //ορίζει την τιμή της μεταβλητής name
    public static void setName(String nam){
        name=nam;
    }

    //επιστρέφει την τιμή της μεταβλητής email
    public  String getEmail(){
        return email;
    }

    //ορίζει την τιμή της μεταβλητής email
    public  void setEmail(String mail){
        email=mail;
    }
}
