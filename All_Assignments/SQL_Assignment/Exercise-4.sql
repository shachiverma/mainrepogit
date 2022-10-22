--Exercise -4
/*4.Create a function that takes as inputs a SalesOrderID, a Currency Code, and a date, and returns a table of all the SalesOrderDetail rows 
for that Sales Order including Quantity, ProductID, UnitPrice, and the unit price converted to the target currency based on the end of 
day rate for the date provided. Exchange rates can be found in the Sales.CurrencyRate table. (Use AdventureWorks)*/

Use AdventureWorks2008R2
Go


Create Function fn_ConvertedCurrency(@UnitPrice MONEY, @CurrencyCode NCHAR(3), @DATE DATE)
Returns Money
As
Begin
	DECLARE @ConvertedCurrency MONEY
	SET @ConvertedCurrency=@UnitPrice*(
		Select EndOfDayRate 
		From AdventureWorks2008R2.Sales.CurrencyRate 
		Where ToCurrencyCode=@CurrencyCode AND CurrencyRateDate=@DATE)
	Return @ConvertedCurrency
END

/* Creation of SalesDetail Function which Returns a Table with required details*/
--Inline Table Valued Function
Create Function fn_SalesDetails(@SalesOrderID INT, @CurrencyCode NCHAR(3), @DATE DATE)
Returns Table
As
Return(
	Select OrderQty,ProductID,UnitPrice,AdventureWorks2008R2.dbo.fn_ConvertedCurrency(UnitPrice,@CurrencyCode,@DATE) As ConvertedCurrency
	From AdventureWorks2008R2.Sales.SalesOrderDetail
	Where SalesOrderID=@SalesOrderID)

/*Query to show the working */
Select * From dbo.fn_SalesDetails(43659,'AUD','2011-05-31 00:00:00.000')
Select * From dbo.fn_SalesDetails(43659,'ARS','2011-05-31')
Select * From AdventureWorks2008R2.Sales.SalesOrderDetail
Select * From AdventureWorks2008R2.Sales.CurrencyRate
