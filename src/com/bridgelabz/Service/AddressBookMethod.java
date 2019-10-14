package com.bridgelabz.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import com.bridgelabz.model.Address;
import com.bridgelabz.model.AddressBookModel;
import com.bridgelabz.model.Person;
import com.bridgelabz.utility.Jsonutil;
 

public class AddressBookMethod implements IAddressBook
{
	    public static int choice;
		Scanner scanner = new Scanner(System.in);
		int counter = 0;
		//String path = "/home/admin-1/eclipse-workspace/AddrssBook/src/com/bridgelabz/json/AddressBook1.json";
		String path="/home/admin-1/eclipse-workspace/AddrssBook/src/com/bridgelabz/jsonfile/AddressBook1.json";
		String statename = "";
		
		static AddressBookModel model = new AddressBookModel();   //creating object of Addressbook Model
		
		static ArrayList<Person> persons = new ArrayList<Person>();

		//String search;
		 

		 
		 
		/**
		 * Purpose: creating new address book
		 */
		@Override
		public void createNewAddressBook() 
		{
			System.out.println("*******New Address Book******");
			System.out.println("Please Enter state name: ");
			statename = scanner.next();

			boolean isFoundState = false;
			for (int i = 0; i < persons.size(); i++) 
			{
				if (persons.get(i).getAddressObj().getState().equals(statename))
				{
					isFoundState = true;
					break;
				
				}
			}
			if (!isFoundState) 
			{

				System.out.println("State is added....");
				//boolean close = false;
				do 
				{
					System.out.println("\n1.Add record\n2.Save.\n3.print record\n4.exit");
					System.out.println("Enter your choice:");
					choice = scanner.nextInt();
					switch (choice) 
					{
					case 1:
			 
						addPerson();
						break;
 
					case 2:
						save();
						System.out.println("records saved...");
						break;
						
					case 3:
						// print

						if (counter > 0) 
						{
							System.out.println("address book records...");
							AddressBookMethod.PrintPersonDetails(persons, statename);

						}
						else
							System.out.println("There is no record to print...");

						break;
						
						default:
						System.out.println("please Enter the valid option");
					}
				
				}while(choice!=4);
			} else
				System.out.println("State exist please try again");
 
	 
		}

		/**
		 * Purpose: method for opening address book
		 */
		@Override
		public void openAddressBook() 
		{
			System.out.println("***Open Address Book***");
			
		    HashMap<String, String> map = new HashMap<>();
			for (int i = 0; i < persons.size(); i++) 
			{
			
				map.put(persons.get(i).getAddressObj().getState(), persons.get(i).getAddressObj().getState());
			}
			System.out.println("states available in Address Book " + map.keySet());//if state is available*/
			
			System.out.println("Enter state");
			statename = scanner.next();
			boolean isFoundState = false;
			for (int i = 0; i < persons.size(); i++) 
			{
				if (persons.get(i).getAddressObj().getState().equals(statename)) 
				{
					isFoundState = true;
					break;
				}
			}
			if (isFoundState) 
			{
				System.out.println("State is found in AddressBook");
				
				
				   do
				   {
					   System.out.println("\n1.Add Record\n2.edit Record\n3.delete Record\n4.sort by last name\n5.sort by zip\n6.print Address_Book\n7.save_record\n8.exit");
					   System.out.println("Enter your choice:");
					   choice=scanner.nextInt();
					   switch (choice) 
					   {
					
					   	case 1:
					          //add person
					   		addPerson();
						break;
					   	case 2:
					         //edit Person 
					   		editPerson();
						break;
					   	case 3:
					   		deletePerson();
						break;
					   	case 4:
					   		sortByLastName();

						break;
					   	case 5:
							sortByZip();

						break;
					   	case 6: 
					   			// print
								if (counter > 0) 
								{
									System.out.println("----------------ADDRESS BOOK------------");
								 
									AddressBookMethod.PrintPersonDetails(persons, statename);
		
								} else
									System.out.println("There is no record to print...");

						break;
					   	
					   	case 7 :   save(); 
					   		       break;
					   	case 8:
										// close
									//	close2 = true;
										System.out.println("Closing...");
										break;
						default:
										System.out.println("Please Enter Valid option....");
					}
				}while(choice!=8);

			} else
				System.out.println("Please create new state of that name\nelse try new state name");

		 

		}

		/**
		 * Purpose: method for save object into json file
		 */
		@Override
		public void save() 
		{
			 

			System.out.println("Saving address book into json file!!!");
			model.setPersons(persons);
			try 
			{
				Jsonutil.writeMapper(path, model);
			} catch (IOException e) {

				e.printStackTrace();
			}
			
		}

		/**
		 * Purpose: method for save as which will save object into json file
		 */
		@Override
		public void saveAs() throws FileNotFoundException  
		{
			 

				System.out.println("*****Save as*****");
				String Inputpath = "/home/admin-1/eclipse-workspace/AddrssBook/src/com/bridgelabz/jsonfile/";
				System.out.println("Enter filename u want to save");
				Inputpath += scanner.next();
			    Inputpath+= ".json";
				//pathInput += ".txt";
				
				if (new File(Inputpath).exists()) 
				{
					throw new FileNotFoundException("You cannot rewrite existing file");
				} 
				else 
				{
					// writing into file
					System.out.println("Saving address book into file....");
					model.setPersons(persons);///////////////////////////////
					
					try {
						Jsonutil.writeMapper(Inputpath, model);
					} catch (IOException e) {

						e.printStackTrace();
					}
					 
				}
			//}

			 

		}
		
		 
  
		 
		@Override
		public void addPerson() 
		{
			System.out.println("*****Add person details****");
			Person person = new Person();
			System.out.println("Enter phone Number");
			Long mobile= scanner.nextLong();
			// validating mobile is not taken by anyone
			boolean isMobileTaken = false;
			
			for (int i = 0; i < persons.size(); i++) 
			{
				long getmobile=persons.get(i).getMobileNO();
				if (mobile.equals(getmobile))  //is equal
				{
					isMobileTaken = true;
					break;
				}
			}
			if (isMobileTaken) 
			{
				System.out.println("This mobile number is already in record");
			} 
			else 
			{ 
				
				person.setMobileNO(mobile);
				System.out.println("Enter person first name: ");
			
				//String name=scanner.next().toLowerCase();
			    // System.out.println(name.isEmpty()+"please Enter valid string");
			   //if(name.isEmpty()){System.out.println("please Enter valid string");}
			  
			    person.setFirstname(scanner.next().toLowerCase());
				System.out.println("Enter person last name: ");
				person.setLastname(scanner.next().toLowerCase());
				System.out.println("Enter address Details: ");
				Address address = new Address();//////creating addressbook object
				System.out.println("Enter address: ");
				address.setAddrss(scanner.next());
				System.out.println("Enter city: ");
				address.setCity(scanner.next());
				address.setState(statename);
				System.out.println("Enter zip: ");
				address.setZipcode(scanner.nextInt());
				person.setAddressObj(address);
				persons.add(person);
                System.out.println();
				System.out.println("Person added");
				counter++;


			}

		}
		
		/**
		 * Purpose: method for reading json from json files
		 */
		@Override
		public void readJson() 
		{
			// checking whether it is empty or not
			File file = new File(path);
			if (file.exists() && file.length() != 0) 
			{
				try 
				{
					model = (AddressBookModel) Jsonutil.readMapper(path, model);
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				
				persons.addAll(model.getPersons());
			    counter = persons.size();   //getting size of counter

			}

		}


		 /**
		  * 
		  */
		@Override
		public void editPerson() 
		{
			if (counter > 0) 
			{
				System.out.println("Enter Persons mobile number you want to Edit:");
				Long Mobile = scanner.nextLong();
			    for (int i = 0; i < persons.size(); i++) 
				{	 
					if(Mobile.equals(persons.get(i).getMobileNO()))
					{
				
						System.out.println("Enter new address you want edit");
						persons.get(i).getAddressObj().setAddrss(scanner.next());
						System.out.println("Enter new city name");
						persons.get(i).getAddressObj().setCity(scanner.next());
						System.out.println("Enter new zip");
						persons.get(i).getAddressObj().setZipcode(scanner.nextInt());
                        persons.get(i).setMobileNO(Mobile);
						System.out.println();
						//
						save();
						System.out.println("Editing done!!!! ");
						break;
					}
					else
					System.out.println("There is no record for this Number");
					break;
				}
			 
			} else
				System.out.println("There is no record..");

		}
 
		@SuppressWarnings("unused")
		@Override
		public void deletePerson() 
		{
			if (counter > 0) 
			{
				System.out.println("Enter Persons Mobile number you want to delete from Address Book:");
				Long Mobilesearch = scanner.nextLong();
				 
				for (int i = 0; i < persons.size();i++) 
				{
					long mobile=(persons.get(i).getMobileNO());

					if (Mobilesearch.equals(mobile))
					{
						  
						persons.remove(i);
						counter--;
						System.out.println();
						System.out.println("data deleted Sucessfully!!");
					}
					else
					  System.out.println("There is record found of this number");
                      break;						
					
				}
			 
			} else
				System.out.println("No records to delete");

		}
		
		/**
		 * Purpose: Printing person detail
		 * @param persons 
		 * @param statename input from user
		 */
		public static void PrintPersonDetails(ArrayList<Person> persons, String statename) {
		 
			persons.forEach(i -> {
				if (!statename.isEmpty() && statename.equals(i.getAddressObj().getState())) 
				{
					System.out.println(i.getFirstname() + " " + i.getLastname() + " " + i.getAddressObj().getAddrss()
							+ " " + i.getAddressObj().getCity() + " " + i.getAddressObj().getState() + " "
							+ i.getAddressObj().getZipcode() + " " + i.getMobileNO());
				}

			});
 
		}

		

		/**
		 * Purpose: method for sorting object by the last name
		 */
		@Override
		public void sortByLastName() 
		{
			if (counter > 1) 
			{
				System.out.println("Sorting by Last name is.....");
 
				Collections.sort(persons, (e1, e2) -> e1.getLastname().compareTo(e2.getLastname()));
				
				/*printing after sorting the data*/
				AddressBookMethod.PrintPersonDetails(persons, statename);
				 
			} else
				System.out.println("Less records to sort");

		}

		/**
		 * Purpose: method for sorting object by zip
		 */
		@Override
		public void sortByZip() {
			if (counter > 1) {
				System.out.println("Sorting by zipcode");
				
				Collections.sort(persons, (e1, e2) -> String.valueOf(e1.getAddressObj().getZipcode())
						.compareTo(String.valueOf(e2.getAddressObj().getZipcode())));
				
				AddressBookMethod.PrintPersonDetails(persons, statename);
				 
			 
			} else
				System.out.println("Less records to sort");

		}
}
