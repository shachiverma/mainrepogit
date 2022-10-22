/*Exercise-6*/
/*6.Write a trigger for the Product table to ensure the list price can never be raised more than 15 Percent in a single change. Modify the 
above trigger to execute its check code only if the ListPrice column is updated (Use AdventureWorks Database)*/
Use AdventureWorks2008R2
Go

Create Trigger tr_Product_ForUpdate
On Production.Product
For Update
As
Begin
	
	Declare @OldListPrice Money
	Declare @NewListPrice Money
	Select  @OldListPrice =ListPrice from deleted
	Select	@NewListPrice =ListPrice from inserted
	/*Condition*/
	If(@NewListPrice>(@OldListPrice*1.15))
		Begin
			Update Production.Product Set ListPrice=@OldListPrice
			Print  'Can not update the ListPrice because it is more than 15 Percent in a Single Change' 
		End
End
/*Modifying the above Trigger*/
Alter Trigger Production.tr_Product_ForUpdate
On Production.Product
For Update
As
	If Update(ListPrice)
	Begin
	Declare @OldListPrice Money
	Declare @NewListPrice Money
	Select  @OldListPrice =ListPrice from deleted
	Select	@NewListPrice =ListPrice from inserted
	/*Condition*/
	If(@NewListPrice>(@OldListPrice*1.15))
		Begin
			Update Production.Product Set ListPrice=@OldListPrice
			Print  'Can not update the ListPrice because it is more than 15 Percent in a Single Change' 
		End 
	End			

	/*Query to check the working of above Triggers*/
	/*Select top 5 ListPrice From Production.Product Where ListPrice>1000*/
	
SELECT * FROM AdventureWorks2008R2.Production.Product Where ProductID=680
UPDATE Production.Product SET ListPrice=1700.00 WHERE ProductID=680
SELECT * FROM AdventureWorks2008R2.Production.Product WHERE ProductID=680

