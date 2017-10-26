CREATE DATABASE webapp ON 
(
	NAME = 'webapp',
	FILENAME = 'E:\dev\Java\nbworkspace\WebServiceTask\db\webapp.mdf',
	SIZE = 5,
	MAXSIZE = 15,
	FILEGROWTH = 1
)
LOG ON
(
	NAME = 'webapp_log',
	FILENAME = 'E:\dev\Java\nbworkspace\WebServiceTask\db\webapp_log.mdf',
	SIZE = 1,
	MAXSIZE = 50,
	FILEGROWTH = 10%
)
GO
