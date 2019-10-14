/******************************************************************************
 *  Purpose: implementation of addressbook mention all the functionality of AddressBook


 *  @author  swapna khairnar
 *    
 *******************************************************************************/
package com.bridgelabz.controller;

import java.io.IOException;
import java.util.Scanner;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;

import com.bridgelabz.Service.AddressBookMethod;
 

public class AddressBookMain 
{

	
	public static void main(String[] args)throws InterruptedException, JsonParseException, JsonMappingException, IOException 
	{
		 
		AddressBookMethod AddrBookutil = new AddressBookMethod();
	     AddrBookutil.readJson();
		Scanner scanner = new Scanner(System.in);
        int choice;
		 do
		 {
			System.out.println("******Select Menu*****");
			System.out.println("1.Create Address_Book Record\n2.Open Address_Book\n3.Save Address_Book \n4.SaveAs Address_Book\n5.Exit");
			System.out.println("Enter your choice:");
		    choice = scanner.nextInt();
			switch (choice) 
			{
			case 1:
				
				 AddrBookutil.createNewAddressBook();  

				break;
			case 2:
				
				 AddrBookutil.openAddressBook();

				break;
			case 3:
				 AddrBookutil.save();
				break;
			case 4:
				 AddrBookutil.saveAs();  
				break;
			case 5:
				 
				System.out.println("Thank you for using address book!!!!");
				System.exit(0);

				break;
			default:
				
				System.out.println("please enter valid option from menu");
				break;

			}
			
		}while(choice!=6);

		scanner.close();
	}
	
	// getting file if exist and if it is json the reading it again
	// and getting all the objects and lists of json into program

}
