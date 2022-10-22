/*Exercise-5*/
/*5.Write a Procedure supplying name information from the Person.Person table and accepting a filter for the first name. Alter the above 
Store Procedure to supply Default Values if user does not enter any value. ( Use AdventureWorks)*/

USE AdventureWorks2008R2
Go

Create Procedure spSupplyFirstName
@FirstNameFilter nvarchar(20)
As
Begin
	Select FirstName,MiddleName,LastName
	From AdventureWorks2008R2.Person.Person
	Where FirstName=@FirstNameFilter
End


/*Creation of Alter Procedure if user does not supply any value then default value would show up*/
Alter Procedure spSupplyFirstName
@FirstNameFilter nvarchar(20)='Aaron'
As
Begin
	Select FirstName,MiddleName,LastName
	From AdventureWorks2008R2.Person.Person
	Where FirstName = @FirstNameFilter
End


/*Checking the working of the created procedure*/
Execute spSupplyFirstName --For Default
Exec spSupplyFirstName 'Syed'

