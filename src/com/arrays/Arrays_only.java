package com.arrays;
import java.util.*;
import java.io.*;

public class Arrays_only {public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String decision = "V";
    String[] hotel = new String[8];
    String[][] guest = new String[8][3];

    for (int x = 0; x < 8; x++ ){hotel[x] = "empty";};
    while(decision.equals("V")|| decision.equals("A") || decision.equals("E") || decision.equals("D") || decision.equals("F") || decision.equals("S") || decision.equals("L") || decision.equals("O") || decision.equals("G") || decision.equals("P")){
        if(decision.equals("V")|| decision.equals("A") || decision.equals("E") || decision.equals("D") || decision.equals("F") || decision.equals("S") || decision.equals("L") || decision.equals("O") || decision.equals("G") || decision.equals("P")){
            System.out.println(" V to view all the rooms \n A to add customers to rooms \n E to view empty rooms \n D to delete customer from room \n F to find room from customer name \n S to store customer rooms to file \n L to load customer rooms from file \n O to order customers alphabetically \n G to view guests in each customer's room \n P to paying and add guest \n or any other letter to stop: ");
            decision=input.next();
            if (decision.equals("V"))view(hotel);
            else if(decision.equals("A"))add(hotel);
            else if(decision.equals("E"))viewempty(hotel);
            else if(decision.equals("D"))delete(hotel);
            else if(decision.equals("F"))find(hotel);
            else if(decision.equals("S"))store(hotel);
            else if(decision.equals("L"))load(hotel);
            else if(decision.equals("O"))order(hotel);
            else if(decision.equals("G"))viewguests(guest);
            else if(decision.equals("P"))addguest(guest);}}
    System.out.println("process quited");}

    public static void view(String hotel[]){for (int x = 0; x < 8; x++ )
    {Scanner input = new Scanner(System.in);
        System.out.println("room " + x + " is occupied by "+ hotel[x]);}
    }


    public static void add(String hotel[]){
        Scanner input = new Scanner(System.in);
        String roomName;
        int roomNum = 0;
        while(roomNum<8){System.out.println("Enter room number (0-7) or any other number to stop:" );
            roomNum = input.nextInt();
            if (roomNum<8)
            {if (hotel[roomNum].equals("empty")){
                input.nextLine();
                System.out.println("Enter name of the customer for room " + roomNum +" :" ) ;
                roomName = input.nextLine();
                hotel[roomNum] = roomName ;
            }else{
                System.out.println("room " + roomNum + " is already occupied by " + hotel[roomNum]);}}
            System.out.println("process finished");}
    }


    public static void viewempty(String hotel[]){
        Scanner input = new Scanner(System.in);
        for (int x = 0; x < 8; x++ ){if (hotel[x].equals("empty")){System.out.println("Room no " + x + " is empty");}}
    }


    public static void delete(String hotel[]){
        Scanner input = new Scanner(System.in);
        int deletenum=0;
        while(deletenum<8){if(deletenum<8){
            System.out.println("Type the room number(0-7) you want to delete the customer from or any other number to cancel:");
            deletenum= input.nextInt();
            {if(deletenum<8){
                if (hotel[deletenum].equals("empty")){System.out.println("Room no " + deletenum + " is already empty");}
                else {hotel[deletenum]="empty"; System.out.println("Successfully deleted customer from room no. " + deletenum);}
            }else {System.out.println("process finished");}}
        }}
    }


    public static void find(String hotel[]){
        Scanner input = new Scanner(System.in);
        String customer;
        System.out.println("What is the name of the customer:");
        customer=input.nextLine();
        for(int y=0; y<8; y++){if(hotel[y].equals(customer)){System.out.println(customer+ " is in room number " + y);}}
    }

    public static void store(String hotel[])
    {Scanner input = new Scanner(System.in);

        try{FileWriter output= new FileWriter("outputtext.txt");
            for (int x = 0; x < 8; x++ )output.write("room " + x + " is occupied by "+ hotel[x] + "\n");output.close();System.out.println("Successfully written into text file");}
        catch(Exception e){System.out.println("Error writing into text");}
    }

    public static void load(String hotel[])
    {try{BufferedReader reader=new BufferedReader(new FileReader("src/inputtext.txt"));
        String row=reader.readLine();
        String textinfo="";
        while(row != null){
            textinfo += row;
            row=reader.readLine();
        }hotel[0]=textinfo.substring(22,41);
        hotel[1]=textinfo.substring(63,67);
        hotel[2]=textinfo.substring(89,93);
        hotel[3]=textinfo.substring(115,118);
        hotel[4]=textinfo.substring(140,144);
        hotel[5]=textinfo.substring(166,173);
        hotel[6]=textinfo.substring(195,199);
        hotel[7]=textinfo.substring(221,226);
        System.out.println("Data successfully loaded from file can check by viewing all rooms");}

    catch(Exception e){System.out.println("Error getting data from text file");}
    }

    public static void order(String hotel[]){
        String swap;
        for(int n=0; n<7; n++){if (hotel[n].compareTo(hotel[n+1])>0){swap=hotel[n+1];
            hotel[n+1]=hotel[n];
            hotel[n]=swap;}}
        for(int k=0; k<8; k++){System.out.println(hotel[k]);}
    }

    public static void viewguests(String guest[][]){for(int r=0; r<8; r++){for(int t=0; t<3; t++){if (guest[r][t]!=null){System.out.println("guest "+ t + " in room "+ r +" is " + guest[r][t]);}
    else{System.out.println("guest"+ t + " in room "+ r +" is empty");}}}

    }

    public static void addguest(String guest[][]){
        int p;
        int num=1;
        Scanner input = new Scanner(System.in);
        System.out.println("For which room number(0-7) do you want to add the guest for / type any other number to stop:");
        p=input.nextInt();
        if(p<7){for(int y=0; y<3; y++){if (num<3){
            System.out.println("To continue enter 1 to exit type any other number:");
            num=input.nextInt();
            if(num==1){System.out.println("What is the guest " + y +"'s first name:");
                guest[p][y]=input.next();
                String details;
                System.out.println("What is the guest " + y +"'s second name:");
                details= input.next();
                int number;
                System.out.println("What is the guest " + y +"'s credit card number:");
                number= input.nextInt();}}}System.out.println("Process finished");}

    }
}
