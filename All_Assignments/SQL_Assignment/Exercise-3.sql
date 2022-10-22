/*Exercise-3*/
/* Show the most recent five orders that were purchased from account numbers that have spent more than $70,000 with AdventureWorks. */
USE AdventureWorks2008R2
Go

SELECT TOP 5 * 
FROM AdventureWorks2008R2.Sales.SalesOrderHeader 
WHERE AccountNumber IN(
SELECT AccountNumber									
FROM AdventureWorks2008R2.Sales.SalesOrderHeader
GROUP BY AccountNumber 
HAVING SUM(TOTALDUE)>=70000)
ORDER BY OrderDate DESC