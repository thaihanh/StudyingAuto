CREATE TABLE Trainee (
trainee_id int IDENTITY(1,1) NOT NULL PRIMARY KEY,
account varchar(30) UNIQUE NOT NULL,
full_name varchar(100) NOT NULL,
gender bit DEFAULT null,
birth_date date,
phone_number varchar(30),
gpa nchar(10),
status varchar(10) DEFAULT 'active'
);

INSERT INTO [dbo].[Trainee] ([account] ,[full_name], [gender], [birth_date], [phone_number], [gpa])
     VALUES ('?','?','?','?','?','?');

INSERT INTO [dbo].[Trainee] ([account] ,[full_name], [gender], [birth_date], [phone_number], [gpa])
     VALUES ('A','Nguyen Van A',0, '1997-04-04','0123456789','6'); 

INSERT INTO [dbo].[Trainee] ([account] ,[full_name], [gender], [birth_date], [phone_number], [gpa])
     VALUES ('B','Nguyen Van B',1, '1997-05-04','0123456789','8');

INSERT INTO [dbo].[Trainee] ([account] ,[full_name], [gender], [birth_date], [phone_number], [gpa])
     VALUES ('C','Nguyen Van C',0, '1997-04-04','0123456789','4');
