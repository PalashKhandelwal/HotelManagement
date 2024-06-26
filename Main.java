import java.util.*;
import java.io.*;

class Food implements Serializable{
    int itemNo;
    int quantity;
    float price;

    Food(int itemNo, int quantity){
        this.itemNo = itemNo;
        this.quantity = quantity;
        switch(itemNo){
            case 1: price = quantity * 100;
                break;
            case 2: price = quantity * 180;
                break;
            case 3: price = quantity * 50;
                break;
            case 4: price = quantity * 150;
                break;
        }
    }
}

class SingleRoom implements Serializable{
    String name;
    String contact;
    String gender;

    ArrayList<Food> food = new ArrayList<>();

    SingleRoom(){
        this.name = "";
    }
    SingleRoom(String name, String contact, String gender){
        this.name = name;
        this.contact = contact;
        this.gender = gender;
    }
}

class DoubleRoom extends SingleRoom implements Serializable{
    String name2;
    String contact2;
    String gender2;

    DoubleRoom(){
        this.name = "";
        this.name2 = "";
   }
   DoubleRoom(String name, String contact, String gender, String name2, String contact2, String gender2){
        this.name = name;
        this.contact = contact;
        this.gender = gender;
        this.name2 = name2;
        this.contact2 = contact2;
        this.gender2 = gender2;
   }
}


class NotAvailable extends Exception{

    @Override
    public String toString(){
        return "Room not available";
    }
}


//Room Details in the Array for the no. of rooms available

class holder implements Serializable{
    DoubleRoom luxury_doubleroom [] = new DoubleRoom[10];
    DoubleRoom deluxe_doubleroom [] = new DoubleRoom[20];
    SingleRoom luxury_singleroom[]=new SingleRoom[10]; 
    SingleRoom deluxe_singleroom[]=new SingleRoom[20]; 
}

class Hotel{
    static holder hotel_ob = new holder();
    static Scanner sc = new Scanner(System.in);
    
    static void CustDetails(int i, int rn){
        String name, contact, gender;
        String name2 = null, contact2 = null, gender2 = null;
        System.out.print("\nEnter the Customer Name : ");
        name = sc.next();
        System.out.print("\nEnter the Contact Number : ");
        contact = sc.next();
        System.out.print("\nEnter the Gender : ");
        gender = sc.next().toLowerCase();
        if(i < 3){
            System.out.print("Enter second customer name: ");
            name2 = sc.next();
            System.out.print("Enter contact number: ");
            contact2=sc.next();
            System.out.print("Enter gender: ");
            gender2 = sc.next().toLowerCase();
        }
        switch(i){
            case 1 : hotel_ob.luxury_doubleroom[rn] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
                break;
            case 2 : hotel_ob.deluxe_doubleroom[rn] = new DoubleRoom(name, contact, gender, name2, contact2, gender2);
                break;
            case 3 : hotel_ob.luxury_singleroom[rn] = new SingleRoom(name, contact, gender);
                break;
            case 4 : hotel_ob.deluxe_singleroom[rn] = new SingleRoom(name, contact, gender);
                break;
            default : System.out.println("Incorrect Option!! Please try again");
                break;
        }
    }
    static void bookRoom(int i){
        int j; 
        int rn;
        System.out.println("\n Choose room no from : ");
        switch(i){
            case 1: 
                for(j=0; j<hotel_ob.luxury_doubleroom.length; j++){
                    if(hotel_ob.luxury_doubleroom[j] == null){
                        System.out.print(j+1+",");
                    }
                }
                System.out.println("\nEnter Room Number : ");
                try{
                    rn = sc.nextInt();
                    rn--;
                    if(hotel_ob.luxury_doubleroom[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                }
                catch(Exception e){
                    System.out.println("Incorrect option");
                    return;
                }
                break;

            case 2 : 
                for(j=0; j<hotel_ob.deluxe_doubleroom.length; j++){
                    if(hotel_ob.deluxe_doubleroom[j] == null){
                        System.out.println(j+11+",");
                    }
                }
                System.out.println("\nEnter Room Number : ");
                try{
                    rn = sc.nextInt();
                    rn -= 11;
                    if(hotel_ob.deluxe_doubleroom[rn]!=null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                }
                catch (Exception e){
                    System.out.println("Incorrect Option.");
                    return;
                }
                break;
            
            case 3:
                for(j=0;j<hotel_ob.luxury_singleroom.length;j++){
                  if(hotel_ob.luxury_singleroom[j]==null)
                  {
                      System.out.print(j+31+",");
                  }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-31;
                    if(hotel_ob.luxury_singleroom[rn]!=null)
                    throw new NotAvailable();
                    CustDetails(i,rn);
                }
                catch(Exception e){
                  System.out.println("Incorrect Option");
                  return;
                }
                break;

            case 4:
                for(j=0;j<hotel_ob.deluxe_singleroom.length;j++){
                    if(hotel_ob.deluxe_singleroom[j]==null){
                        System.out.print(j+41+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                    rn=sc.nextInt();
                    rn=rn-41;
                    if(hotel_ob.deluxe_singleroom[rn]!=null)
                        throw new NotAvailable();
                    CustDetails(i,rn);
                }
                catch(Exception e){
                    System.out.println("Incorrect Option");
                    return;
                }
              break;
            
            default : System.out.println("\n Please Enter valid option!");
                break;
        }
        System.out.println("Room Booked");
    }

    static void Features(int i){
        switch(i){
            case 1 : System.out.println("Number of double beds : 1\nAC : Yes\nFree Breakfast : Yes\nCharge per night : 4000");
                break;
            case 2:System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
                break;
            case 3:System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
                break;
            case 4:System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
                break;
            default : System.out.println("Enter valid option");
                break;
        }
    }

    static void Availability(int i){
        int j, count = 0;
        switch(i){
            case 1 :
                for(j=0; j<hotel_ob.luxury_doubleroom.length; j++){
                    if(hotel_ob.luxury_doubleroom[j] == null){
                        count++;
                    }
                }
                break;
            
            case 2 :
                for(j=0; j<hotel_ob.deluxe_doubleroom.length; j++){
                    if(hotel_ob.deluxe_doubleroom[j] == null){
                        count++;
                    }
                }
                break;

            case 3:
                for(j=0;j<hotel_ob.luxury_singleroom.length;j++){
                    if(hotel_ob.luxury_singleroom[j]==null){
                        count++;
                    }
                }
                break;

            case 4:
                for(j=0;j<hotel_ob.deluxe_singleroom.length;j++){
                    if(hotel_ob.deluxe_singleroom[j]==null){
                        count++;
                    }
                }
                break;
            
            default : System.out.println("\nEnter valid option");
                break;
        }
        System.out.println("No of rooms available : "+count);
    }

    //Bill Amount to Generate on the basis of Room and Food
    static void Bill(int rn, int rtype) {
        double roomCharge = 0;
        double foodCharge = 0;
        String[] list = {"Sandwich", "Pizza", "Coke", "Brownie with Ice Cream"};
    
        System.out.println("\n**********");
        System.out.println("Bill :-");
        System.out.println("**********");
    
        // Calculate room charge based on room type
        switch (rtype) {
            case 1:
                roomCharge = 4000; // Room charge for luxury double room
                break;
            case 2:
                roomCharge = 3000; // Room charge for deluxe double room
                break;
            case 3:
                roomCharge = 2200; // Room charge for luxury single room
                break;
            case 4:
                roomCharge = 1200; // Room charge for deluxe single room
                break;
            default:
                System.out.println("Invalid room type");
                return;
        }
    
        // Print room charge
        System.out.println("\nRoom Charge - " + roomCharge);
    
        // Calculate food charge by iterating over food items
        ArrayList<Food> foodList = null;
        switch (rtype) {
            case 1:
                foodList = hotel_ob.luxury_doubleroom[rn].food;
                break;
            case 2:
                foodList = hotel_ob.deluxe_doubleroom[rn].food;
                break;
            case 3:
                foodList = hotel_ob.luxury_singleroom[rn].food;
                break;
            case 4:
                foodList = hotel_ob.deluxe_singleroom[rn].food;
                break;
        }
    
        // Sum up food charges
        for (Food f : foodList) {
            foodCharge += f.price;
        }
    
        // Print food charges
        System.out.println("\nFood Charges:-");
        System.out.println("===============");
        System.out.println("Item\tQuantity\tPrice");
        System.out.println("-------------------------");
        for (Food f : foodList) {
            System.out.printf("%-10s%-10s%-10s%n", list[f.itemNo - 1], f.quantity, f.price);
        }
    
        // Calculate and print total bill amount
        double totalBill = roomCharge + foodCharge;
        System.out.println("\nTotal Bill: " + totalBill);
    }
    

    static void DeallocateRooms(int rn, int rtype){

        int j;
        char w;
        switch(rtype){
            case 1 : 
                if(hotel_ob.luxury_doubleroom[rn] != null){
                    System.out.println("\nRoom is used by "+hotel_ob.luxury_doubleroom[rn].name);
                }
                else{
                    System.out.println("\nEmpty Already");
                    return;
                }

                System.out.println("\nDo you want to Checkout ? (y/n)");
                w = sc.next().charAt(0);
                if(w == 'y' || w == 'Y'){
                    Bill(rn, rtype);
                    hotel_ob.luxury_doubleroom[rn] = null;
                    System.out.println("\nCheckedOut!");
                }
                break;

            case 2:
                if(hotel_ob.deluxe_doubleroom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.deluxe_doubleroom[rn].name);                
                else {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y'){
                    Bill(rn,rtype);
                    hotel_ob.deluxe_doubleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                 
                break;

            case 3:
                if(hotel_ob.luxury_singleroom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.luxury_singleroom[rn].name);                
                else {    
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y'){
                    Bill(rn,rtype);
                    hotel_ob.luxury_singleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                
                break;

            case 4:
                if(hotel_ob.deluxe_singleroom[rn]!=null)
                    System.out.println("Room used by "+hotel_ob.deluxe_singleroom[rn].name);                
                else {    
                    System.out.println("Empty Already");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y'){
                    Bill(rn,rtype);
                    hotel_ob.deluxe_singleroom[rn]=null;
                    System.out.println("Deallocated succesfully");
                }
                break;

            default: System.out.println("\nEnter valid option : ");
                break;
        }

        double roomCharge = 0;
    double foodCharge = 0;

    // Calculate room charge based on room type
    switch(rtype) {
        case 1:
            roomCharge = 4000; // Room charge for luxury double room
            break;
        case 2:
            roomCharge = 3000; // Room charge for deluxe double room
            break;
        case 3:
            roomCharge = 2200; // Room charge for luxury single room
            break;
        case 4:
            roomCharge = 1200; // Room charge for deluxe single room
            break;
        default:
            System.out.println("Invalid room type");
            return;
    }

    // Calculate food charge by iterating over food items
    ArrayList<Food> foodList = null;
    switch (rtype) {
        case 1:
            foodList = hotel_ob.luxury_doubleroom[rn].food;
            break;
        case 2:
            foodList = hotel_ob.deluxe_doubleroom[rn].food;
            break;
        case 3:
            foodList = hotel_ob.luxury_singleroom[rn].food;
            break;
        case 4:
            foodList = hotel_ob.deluxe_singleroom[rn].food;
            break;
    }

    // Sum up food charges
    for (Food f : foodList) {
        foodCharge += f.price;
    }

    // Calculate total bill amount
    double totalBill = roomCharge + foodCharge;

    // Display room and food charges along with total bill amount
    System.out.println("Room Charge: " + roomCharge);
    System.out.println("Food Charges: " + foodCharge);
    System.out.println("Total Bill: " + totalBill);
    }

    static void Order(int rn, int rtype){
        int i, q;
        char wish; 
        try{
            if(isRoomBooked(rn, rtype)){
            System.out.println("\n==========\n    Menu : \n\n1. Sandwich\tRs.100\n2.Pizza\tRs.180\n3.Coke\tRs.50\n4.Brownie with Ice Cream\tRs.150");
            do{
                i = sc.nextInt();
                System.out.println("\nQuantity : ");
                q = sc.nextInt();
                switch(rtype){
                    case 1 : hotel_ob.luxury_doubleroom[rn].food.add(new Food(i, q));
                        break;
                    case 2 : hotel_ob.deluxe_doubleroom[rn].food.add(new Food(i, q));
                        break;
                    case 3 : hotel_ob.luxury_singleroom[rn].food.add(new Food(i, q));
                        break;
                    case 4 : hotel_ob.deluxe_singleroom[rn].food.add(new Food(i, q)); 
                        break;
                }
                    System.out.println("\nDo you want to order anything else ? (y/n)");
                    wish = sc.next().charAt(0);
            }while(wish == 'y' || wish == 'Y');
        }else{
            System.out.println("\nThis Room is not booked, so can't order food for that room.");
            }
        }catch (NullPointerException e){
            System.out.println("\nRoom not Booked");
        }
        catch(Exception e){
            System.out.println("\nCannot be done");
        }
    }
  
// The method isRoomBooked checks  whether a particular room while ordering food has been booked or not.
    static boolean isRoomBooked(int rn, int rtype){
        switch (rtype) {
            case 1:
                return hotel_ob.luxury_doubleroom[rn] != null;
            case 2:
                return hotel_ob.deluxe_doubleroom[rn] != null;
            case 3:
                return hotel_ob.luxury_singleroom[rn] != null;
            case 4:
                return hotel_ob.deluxe_singleroom[rn] != null;
            default:
                return false;
        }
    }
}

class Write implements Runnable{
    holder hotel_ob;
    Write(holder hotel_ob){
        this.hotel_ob = hotel_ob;
    }
    @Override
    public void run(){
        try{
            FileOutputStream fout = new FileOutputStream("Backup");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            oos.writeObject(hotel_ob);
        }
        catch(Exception e){
            System.out.println("\nError in writing" +e);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        
        try{
            File f = new File("Backup");
            if(f.exists()){
                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Hotel.hotel_ob = (holder)ois.readObject();
            }
            Scanner sc = new Scanner(System.in);
            int ch, ch2;
            char wish;
            exitCode:
            do{
                System.out.println(" \n1.Display room details\n2.Display rooms available\n3.Book Room\n4.Order Food\n5.Checkout\n6.Exit\nEnter your Choice : ");
                ch = sc.nextInt();
                switch (ch) {

                    case 1:
                        System.out.println("\nChoose room type : \n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.Features(ch2);
                        break;
                
                    case 2:
                        System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.Availability(ch2);
                        break;

                    case 3:
                        System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookRoom(ch2);                     
                        break;
                    
                    case 4 : 
                        System.out.println("\nRoom Number - ");
                        ch2 = sc.nextInt();

                        if(ch2>60)
                            System.out.println("\nRoom does not exist!");

                        else if(ch2>40)
                            Hotel.Order(ch2-41, 4);

                        else if(ch2>30)
                            Hotel.Order(ch2-31,3);

                        else if(ch2>10)
                            Hotel.Order(ch2-11,2);

                        else if(ch2>0)
                            Hotel.Order(ch2-1,1);

                        else
                            System.out.println("Room doesn't exist");
                        break;
                    
                    case 5 : 
                        System.out.println("\nRoom Number -");
                        ch2 = sc.nextInt();
                        if(ch2>60)
                         System.out.println("Room doesn't exist");
                        else if(ch2>40)
                            Hotel.DeallocateRooms(ch2-41,4);
                        else if(ch2>30)
                            Hotel.DeallocateRooms(ch2-31,3);
                        else if(ch2>10)
                            Hotel.DeallocateRooms(ch2-11,2);
                        else if(ch2>0)
                            Hotel.DeallocateRooms(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                         break;
                    case 6 : break exitCode;
                }

                System.out.println("\nContinue : (y/n)");
                wish = sc.next().charAt(0);
                if(!(wish == 'y' || wish == 'Y' || wish == 'n' || wish == 'N')){
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish=sc.next().charAt(0);
                }
            }while(wish=='y'||wish=='Y');    
        
                Thread t=new Thread(new Write(Hotel.hotel_ob));
                t.start();
            }
            catch(Exception e){
                System.out.println("\nInvalid Input");
            }
    }   
}