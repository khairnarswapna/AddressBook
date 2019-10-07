package com.bridgelabz.Service;
//interface for declaration of Method

//Encapsulation
import java.io.FileNotFoundException;

public interface IAddressBook {

	void createNewAddressBook();
	
	void openAddressBook();

	void addPerson();
	
	void deletePerson();

	void editPerson();
	
	void sortByLastName();
    
	void sortByZip();
	
	void readJson();

	void save();

	void saveAs() throws FileNotFoundException;
}
