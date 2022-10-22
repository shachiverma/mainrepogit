/*Exercise-2*/
/*Write separate queries using a join, a subquery, a CTE, and then an EXISTS to list all AdventureWorks customers who have not placed 
an order.*/

/*JOIN*/
Select C.CustomerID
From AdventureWorks2008R2.Sales.Customer C
Left Join AdventureWorks2008R2.Sales.SalesOrderHeader S
On C.CustomerID=S.CustomerID
Where S.CustomerID IS Null

/*Subquery*/
Select CustomerID
From AdventureWorks2008R2.Sales.Customer
Where CustomerID NOT IN (
Select CustomerID
From AdventureWorks2008R2.Sales.SalesOrderHeader)

/*Common Table Expression(CTE)*/
With CustomerwithOrder(CustomerID)
As
(
	Select CustomerID
	From AdventureWorks2008R2.Sales.SalesOrderHeader
)
Select CustomerID
From AdventureWorks2008R2.Sales.Customer
Where CustomerID NOT IN (
Select CustomerID
From CustomerwithOrder)

/*Not Exists*/
Select C.CustomerID
From AdventureWorks2008R2.Sales.Customer C
Where NOT EXISTS (
Select CustomerID
From AdventureWorks2008R2.Sales.SalesOrderHeader S
Where C.CustomerID=S.CustomerID)