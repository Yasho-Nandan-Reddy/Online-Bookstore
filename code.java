import java.util.*;
public class Main
{
	private static Scanner sc=new Scanner(System.in);
    public void showbook(ArrayList <String> author,ArrayList <String> Books,ArrayList <Integer> price,ArrayList <Integer> avail,String name,String email,String pass,String phone,ArrayList <Double> ratings)
    {
        System.out.println("The list of Books are:");
        for(int i=0;i<author.size();i++)
        {
            System.out.println("Author Name: "+author.get(i)+"  Book Name: "+Books.get(i)+"  Price: "+price.get(i)+"  Stock Available: "+avail.get(i)+" Ratings: "+ratings.get(i));
        }
    }
    public String buybook(int op,ArrayList <String> author,ArrayList <String> Books,ArrayList <Integer> price,ArrayList <Integer> avail,Main show,String name,String email,String pass,String phone,int ui,ArrayList <Double> ratings)
    {
        int c=0;
        String che="";
        while(op!=2)
        {
            show.showbook(author,Books,price,avail,name,email,pass,phone,ratings);
            System.out.print("Specify Book Name: ");
            che=sc.nextLine();
            for(int i=0;i<Books.size();i++)
            {
                if(che.equals(Books.get(i)))
                {
                    System.out.println(che+" is Available");
                    op=2;
                    break;
                }
                else
                {
                    c++;
                }
            }
            if(c==Books.size() && op!=2)
            {
                System.out.println("Specified Book is not Available");
                System.out.println("Try for another another Book");
                System.out.println("Available Books are: ");
                // show.showbook(author,Books,price,avail,name,email,pass,phone,ratings);
                return show.buybook(op,author,Books,price,avail,show,name,email,pass,phone,ui,ratings);
            }
            else
            {
                break;
            } 
        }
        return che;
    }
    public int payment(ArrayList <String> author,ArrayList <String> Books,ArrayList <Integer> price,ArrayList <Integer> avail,Main show,ArrayList <String> oncart,String name,String email,String pass,String phone,int ui,ArrayList <Double> ratings)
    {
        int yu=oncart.size();
        int p=0,i=0,pri=0;
        if(yu<=0)
        {
            System.out.println("There is no books in your cart to purchase ");
            return -1;
        }
        else
        {
            while(yu!=p)
            {
                if(Books.get(i).equals(oncart.get(p)))
                {
                    pri+=price.get(i);
                    p++;
                    i=0;
                }
                i++;
            }
            System.out.println("Total Payable Amount is: "+pri);
            System.out.print("To proceed with the payment provide us your email id and password to make sure it is "+name+" ");
            System.out.println("Provide us the Email: ");
            String em=sc.nextLine();
            System.out.println("Provide us the Password: ");
            String pap=sc.nextLine();
            if(email.equals(em))
            {
                if(pass.equals(pap))
                {
                    yu--;
                    while(yu!=-1)
                    {
                        System.out.println("Now "+oncart.get(yu)+" Book is your's "+name);
                        yu--;
                    }
                    return 1;
                }
                else
                {
                    System.out.println("Password specified is invlaid Try Again");
                    show.payment(author,Books,price,avail,show,oncart,name,email,pass,phone,ui,ratings);
                    return -1;
                }
            }
            else
            {
                System.out.println("Sorry email id specified is incorrect  Try Again");
                show.payment(author,Books,price,avail,show,oncart,name,email,pass,phone,ui,ratings);
                return -1;
            }
        }
    }
    public void cart(ArrayList <String> author,ArrayList <String> Books,ArrayList <Integer> price,ArrayList <Integer> avail,Main show,String hjj,ArrayList <String> oncart,int op,String name,String email,String pass,String phone,int ui,ArrayList <Double> ratings)
    {
        System.out.println("Do you want to add this book to your Cart: ");
        System.out.print("If yes press 1 else press any Character");
        String sel=sc.nextLine();
        if(sel.equals("1"))
        {
            System.out.println(hjj+" Is now in your Cart ");
            oncart.add(hjj);
            System.out.println("Your Cart has Follwing Books: ");
            System.out.println(oncart);
            System.out.println("Do you want to Add more books to your cart...");
            System.out.print("If yes press 1 else press any Character ");
            String ko=sc.nextLine();
            if(ko.equals("1")==false)
            {
                System.out.println("Proceed with Payment");
                ui=show.payment(author,Books,price,avail,show,oncart,name,email,pass,phone,ui,ratings);
                if(ui==1)
                {
                    System.out.print(" Payment is Succesfull ");
                }
                else
                {
                    ui=10;
                }
            }
        }
        // else
        // {
        if(ui!=1)
        {
            // show.showbook(author,Books,price,avail,name,email,pass,phone,ratings);
            String kjk=show.buybook(op,author,Books,price,avail,show,name,email,pass,phone,ui,ratings);
            show.cart(author,Books,price,avail,show,kjk,oncart,op,name,email,pass,phone,ui,ratings);
        }
        // }
    }
    public static void main(String[] args)
    {
        int c=0,op=0;
        ArrayList<Integer>al=new ArrayList<Integer>();
        Main obj=new Main();
        System.out.println("*************Welcome to Online Bookstore**********");
        System.out.println("Signup Before you proceed further");
        System.out.println("            -------------------------------");
        System.out.println("                       Signup");
        System.out.print("Name: ");
        String name= sc.nextLine();
        System.out.print("Email: ");
        String email=sc.nextLine();
        System.out.print("Mobile Number: ");
        String phone=sc.nextLine();
        System.out.print("Password: ");
        String pass=sc.nextLine();
        System.out.println("------------------------Data Fetched Succesfully---------------------");
        System.out.println();
        System.out.println("Welcome to the Online Bookstore "+name);
        int ui=90;
        ArrayList <String> author=new ArrayList<String>(Arrays.asList(new String[]{"JK Rowling","Ruskin Bond","James Joyce","William Golding"}));
        ArrayList <String> Books=new ArrayList<String>(Arrays.asList(new String[]{"Harry Potter","The night train at Deoil","The Dead","William Golding"}));
        ArrayList <Double> ratings=new ArrayList<Double>(Arrays.asList(new Double[]{4.7,3.6,3.4,4.0}));
        ArrayList <Integer> price=new ArrayList<Integer>(Arrays.asList(new Integer[]{2250,2000,1200,879}));
        ArrayList <Integer> avail=new ArrayList<Integer>(Arrays.asList(new Integer[]{3,5,7,6}));
        Main show=new Main();
        ArrayList <String> oncart=new ArrayList <String>();
        // show.showbook(author,Books,price,avail,name,email,pass,phone,ratings);
        System.out.print("Which book Do you want to Buy: ");
        String hjj=show.buybook(op,author,Books,price,avail,show,name,email,pass,phone,ui,ratings);
        show.cart(author,Books,price,avail,show,hjj,oncart,op,name,email,pass,phone,ui,ratings);
	}
}
