CREATE TABLE Student (
Id int IDENTITY(1,1) not null PRIMARY KEY,
LastName nvarchar(20) not null,
FirstName nvarchar(20) not null,
EnrollmentDate date not null
);

CREATE TABLE Course (
Id int IDENTITY(1,1) not null PRIMARY KEY,
Title nvarchar(20) not null,
Credits float not null
);

CREATE TABLE Enrollment (
Id int IDENTITY(1,1) not null PRIMARY KEY,
CourseId int not null,
StudentId int not null,
Grade float not null,

FOREIGN KEY (CourseId) REFERENCES Course(Id),
FOREIGN KEY (StudentId) REFERENCES Student(Id),
);

select TABLE_NAME, COLUMN_NAME, DATA_TYPE from INFORMATION_SCHEMA.COLUMNS;

INSERT INTO Student(LastName, FirstName, EnrollmentDate) VALUES ('?', '?', '?');
INSERT INTO Course(Title, Credits) VALUES ('?', '?');
INSERT INTO Enrollment(CourseId, StudentId, Grade) VALUES ('?', '?', '?');

INSERT INTO Student(LastName, FirstName, EnrollmentDate) VALUES ('Hanh', 'Hoang Thai', '2022-04-04');
INSERT INTO Student(LastName, FirstName, EnrollmentDate) VALUES ('A', 'Nguyen Van', '2022-06-06');
INSERT INTO Course(Title, Credits) VALUES ('Biology', '100');
INSERT INTO Course(Title, Credits) VALUES ('Physics', '200');
INSERT INTO Enrollment(CourseId, StudentId, Grade) VALUES ('1', '18', '7.7');
INSERT INTO Enrollment(CourseId, StudentId, Grade) VALUES ('2', '24', '8.6');


SELECT * FROM Student;
SELECT * FROM Course;
SELECT * FROM Enrollment;

UPDATE Student SET EnrollmentDate = '?' WHERE Id = '?';






