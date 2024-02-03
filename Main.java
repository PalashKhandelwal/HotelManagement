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
    static void Bill(int rn, int rtype){
        double amt = 0;
        String list[] = {"Sandwich", "Pizza", "Coke", "Brownie with Ice Cream"};
        System.out.println("\n**********");
        System.out.println("\nBill :- ");
        System.out.println("\n**********");

        switch(rtype){
            case 1 : 
                amt += 4000;
                    System.out.println("\nRoom Charge - "+4000);
                    System.out.println("\n================");
                    System.out.println("\nFood Charges - ");;
                    System.out.println("\n================");
                    System.out.println("\nItem Quantity Price - ");
                    System.out.println("\n-------------------------");
                    for(Food f:hotel_ob.luxury_doubleroom[rn].food ){
                        amt += f.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format, list[f.itemNo-1], f.quantity, f.price);
                    }
                break;
            
            case 2 : 
                amt += 3000;
                    System.out.println("Room Charge - "+3000);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                     System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb:hotel_ob.deluxe_doubleroom[rn].food)
                    {
                        amt+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price );
                    }
                break;

            case 3:
                amt+=2200;
                    System.out.println("Room Charge - "+2200);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");

                    for(Food obb:hotel_ob.luxury_singleroom[rn].food)
                    {
                        amt+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price );
                    }
                break;

            case 4:
                amt+=1200;
                    System.out.println("Room Charge - "+1200);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");

                    for(Food obb: hotel_ob.deluxe_singleroom[rn].food)
                    {
                        amt+=obb.price;
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.itemNo-1],obb.quantity,obb.price );
                    }
                break;

            default : System.out.println("\nNot Valid");
        }
    }
}
public class Main {

    
}