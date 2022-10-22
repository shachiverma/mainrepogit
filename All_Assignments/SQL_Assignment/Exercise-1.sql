/*Exercise-1*/
Use AdventureWorks2008R2
Go

/*1. Display the number of records in the [SalesPerson] table. (Schema(s) involved: Sales)*/

SELECT COUNT(*) 
FROM AdventureWorks2008R2.Sales.SalesPerson;

/*2. Select both the FirstName and LastName of records from the Person table where the FirstName begins with the letter ‘B’. 
(Schema(s) involved: Person)*/

SELECT FirstName , LastName
FROM AdventureWorks2008R2.Person.Person
WHERE FirstName LIKE 'B%'

/*3.Select a list of FirstName and LastName for employees where Title is one of Design Engineer, Tool Designer or Marketing 
Assistant. (Schema(s) involved: HumanResources, Person)*/

SELECT P.FirstName,P.LastName
FROM AdventureWorks2008R2.Person.Person as P
INNER JOIN AdventureWorks2008R2.HumanResources.Employee as E
ON P.BusinessEntityID=E.BusinessEntityID
WHERE E.JobTitle IN ('Design Engineer','Tool Designer','Marketing Assistant')

/*4. Display the Name and Color of the Product with the maximum weight. (Schema(s) involved: Production)
*/

SELECT [Name],Color
FROM AdventureWorks2008R2.Production.Product
WHERE Weight=(SELECT MAX(Weight) FROM AdventureWorks2008R2.Production.Product)

/*5. Display Description and MaxQty fields from the SpecialOffer table. Some of the MaxQty values are NULL, in this case display 
the value 0.00 instead. (Schema(s) involved: Sales)
*/

Select [Description], COALESCE(MaxQty,0.00)
From AdventureWorks2008R2.Sales.SpecialOffer

/*6. Display the overall Average of the [CurrencyRate].[AverageRate] values for the exchange rate ‘USD’ to ‘GBP’ for the year 2005 
i.e. FromCurrencyCode = ‘USD’ and ToCurrencyCode = ‘GBP’. Note: The field [CurrencyRate].[AverageRate] is defined as 
'Average exchange rate for the day.' (Schema(s) involved: Sales)
*/
SELECT AVG(AverageRate) AS 'Average exchange rate for the day'
FROM AdventureWorks2008R2.Sales.CurrencyRate
WHERE FromCurrencyCode = 'USD' And ToCurrencyCode = 'GBP' And YEAR(CurrencyRateDate)=2011

SELECT * FROM AdventureWorks2008R2.Sales.Currency 

/*7. Display the FirstName and LastName of records from the Person table where FirstName contains the letters ‘ss’. Display an 
additional column with sequential numbers for each row returned beginning at integer 1. (Schema(s) involved: Person)*/

SELECT FirstName,LastName, ROW_NUMBER() OVER (ORDER BY FirstName) AS 'Row Number'
FROM AdventureWorks2008R2.Person.Person
WHERE FirstName LIKE '%ss%'

/*8. Sales people receive various commission rates that belong to 1 of 4 bands. (Schema(s) involved: Sales)
Display the [SalesPersonID] with an additional column entitled ‘Commission Band’ indicating the appropriate band as above.*/

SELECT BusinessEntityID AS SalesPersonID,
CASE WHEN CommissionPct=0.00 THEN 'Band-0'
WHEN CommissionPct>0.00 AND CommissionPct<=1.00 THEN 'Band-1'
WHEN CommissionPct>1.00 AND CommissionPct<=1.50 THEN 'Band-2'
ELSE 'Band-3'END AS [Commission Band]
FROM AdventureWorks2008R2.Sales.SalesPerson

/*9. Display the managerial hierarchy from Ruth Ellerbrock (person type – EM) up to CEO Ken Sanchez. Hint: use 
[uspGetEmployeeManagers] (Schema(s) involved: [Person], [HumanResources]) */

DECLARE @BID INT
SELECT @BID=P.BusinessEntityID
FROM AdventureWorks2008R2.Person.Person AS P 
INNER JOIN AdventureWorks2008R2.HumanResources.Employee AS E 
ON P.BusinessEntityID=E.BusinessEntityID
WHERE FirstName='Ruth' AND LastName='Ellerbrock'
EXEC AdventureWorks2008R2.dbo.uspGetEmployeeManagers @BID

/*10. Display the ProductId of the product with the largest stock level. Hint: Use the Scalar-valued function [dbo]. [UfnGetStock].
(Schema(s) involved: Production)
*/

SELECT ProductID, AdventureWorks2008R2.dbo.ufnGetStock(ProductID)  AS StockLevel
FROM AdventureWorks2008R2.Production.Product
WHERE AdventureWorks2008R2.dbo.ufnGetStock(ProductID)=(
SELECT MAX(AdventureWorks2008R2.dbo.ufnGetStock(ProductID))
FROM AdventureWorks2008R2.Production.Product)