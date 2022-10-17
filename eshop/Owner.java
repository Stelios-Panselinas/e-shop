
public class Owner extends User 
{
    private static boolean isAdmin=true;
    private static String email;

    //constructor που αρχικοποιεί τις μεταβλητές 
    public Owner(String name,String mail){
        super(name,mail);

    }

    //επιστρέφει την τιμή της μεταβλητής isAdmin
    public static boolean getIsAdmin(){
        return isAdmin;
    }
}