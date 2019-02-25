USE master;
GO

DROP DATABASE MovieDB;
GO

CREATE DATABASE MovieDB;
GO

USE MovieDB;
GO

CREATE TABLE [dbo].[Movies](
	[MovieID] [int] IDENTITY(1,1) NOT NULL,
	[MovieName] [varchar](120) NULL,
	[ReleaseDate] [date] NULL,
	[RunningTime] [int] NULL,
	[MovieDescription] [varchar](8000) NULL,
	[Genre] [varchar](1000) NULL,
	CONSTRAINT [PK_Movies] PRIMARY KEY CLUSTERED
	(
		[MovieID] ASC
	)
);
GO

CREATE TABLE [dbo].[Actors](
	[ActorID] [int] IDENTITY(1, 1) NOT NULL,
	[MovieID] [int] NULL,
	[FirstName] [varchar](120) NOT NULL,
	[LastName] [varchar](120) NOT NULL,
	[DateOfBirth] [date] NOT NULL,
	CONSTRAINT [PK_Actors] PRIMARY KEY CLUSTERED
	(
		[ActorID] ASC
	)
);
GO

ALTER TABLE dbo.Movies
ADD [MoviePoster] [varbinary](MAX) NULL;
GO

ALTER TABLE dbo.Actors
ADD [ActorImage] [varbinary](MAX) NULL, [PlaceOfBirth] [varchar] (120) NULL, [CountryOfBirth] [varchar] (120) NULL;
GO

CREATE TABLE [dbo].[Directors](
	[DirectorID] [int] IDENTITY(1, 1) NOT NULL,
	[MovieID] [int] NULL,
	[FirstName] [varchar](120) NOT NULL,
	[LastName] [varchar](120) NOT NULL,
	[DateOfBirth] [date] NOT NULL,
	[ProfileImage] [binary] NOT NULL,
	[PlaceOfBirth] [varchar] (120) NOT NULL,
	[CountyOfBitrth] [varchar] (120) NOT NULL,
	[DirectorImage] [varbinary](MAX) NULL,
	CONSTRAINT [PK_Directors] PRIMARY KEY CLUSTERED
	(
		[DirectorID] ASC
	),
	CHECK (
		[DateOfBirth] < GETDATE()
	)
);
GO

CREATE TABLE [dbo].[Writers](
	[WriterID] [int] IDENTITY(1, 1) NOT NULL,
	[MovieID] [int] NULL,
	[FirstName] [varchar](120) NOT NULL,
	[LastName] [varchar](120) NOT NULL,
	[DateOfBirth] [date] NOT NULL,
	[age] [int],
	[ProfileImage] [varbinary](MAX) NULL,
	[PlaceOfBirth] [varchar] (120) NULL,
	[CountyOfBitrth] [varchar] (120) NULL,
	CONSTRAINT [PK_Writers] PRIMARY KEY CLUSTERED(
		[WriterID] ASC
	),
	CHECK (
		[DateOfBirth] < GETDATE()
	)
);
GO

CREATE TABLE [dbo].[Producers](
	[ProducersID] [int] IDENTITY(1, 1) NOT NULL,
	[MovieID] [int] NULL,
	[FirstName] [varchar](120) NOT NULL,
	[LastName] [varchar](120) NOT NULL,
	[DateOfBirth] [date] NOT NULL,
	[ProfileImage] [varbinary](MAX) NULL,
	[PlaceOfBirth] [varchar] (120) NULL,
	[CountyOfBitrth] [varchar] (120) NULL,
	CONSTRAINT [PK_Producers] PRIMARY KEY CLUSTERED(
		[ProducersID] ASC
	),
	CHECK (
		[DateOfBirth] < GETDATE()
	)
);
GO

ALTER TABLE dbo.Writers DROP COLUMN [age];
GO

INSERT INTO [dbo].[Movies]
           ([MovieName]
           ,[ReleaseDate]
           ,[RunningTime]
           ,[MovieDescription]
           ,[Genre]
           )
VALUES	('Ghostbusters','8 June 1984',105,'','Comedy, Horror'),
	('Dances With Wolves','21 November 1990', 181,'', 'Drama, Western, Romance'),
	('Aliens','18 July 1986', 137,'', 'Action, Horror, Drama, Science Fiction'),
	('Bladerunner','25 June 1982', 117,'', 'Science Fiction, Drama'),
	('Prometheus','8 June 2012', 124,'', 'Drama, Science Fiction, Action, Horror'),
	('Alien','22 June 1979', 117,'', 'Horror, Suspense, Science Fiction'),
	('Groundhog Day','12 February 1993', 101,'', 'Comedy, Romance'),
	('The Matrix','31 March 1999', 136,'', 'Science Fiction, Action')
GO

INSERT INTO [dbo].[Actors]
	(
	[MovieID],
	[FirstName],
	[LastName],
	[DateOfBirth]
	)
	VALUES
	(1,'Bill','Murray','1950/09/21'),
	(1,'Dan','Aykroyd','1952/07/01'),
	(1,'Sigourney','Weaver','1949/10/08'),
	(1,'Harold','Ramis','1944/11/21'),
	(1,'Rick','Moranis','1953/04/18'),
	(1,'Ernie','Hudson','1945/12/17'),
	(2,'Kevin','Costner','1955/01/18'),
	(2,'Mary','McDonnell','1952/04/28'),
	(3,'Sigourney','Weaver','1949/10/08'),
	(3,'Michael','Biehn','1956/07/31'),
	(3,'Paul','Reiser','1957/03/30'),
	(3,'Lance','Henriksen','1940/05/05'),
	(3,'Bill','Paxton','1955/05/17'),
	(4,'Harrison','Ford','1942/07/13'),
	(4,'Rutger','Hauer','1944/01/23'),
	(4,'Sean','Young','1959/11/20'),
	(4,'Daryl','Hannah','1960/12/03'),
	(5,'Noomi','Rapace','1979/12/28'),
	(5,'Michael','Fassbender','1977/04/02'),
	(5,'Charlize','Theron','1975/08/07'),
	(5,'Idris','Elba','1972/09/06'),
	(5,'Guy','Pearce','1967/10/05'),
	(6,'Tom','Skerritt','1933/08/25'),
	(6,'Sigourney','Weaver','1949/10/08'),
	(6,'John','Hurt','1940/01/22'),
	(6,'Ian','Holm','1931/09/12'),
	(6,'Yaphet','Kotto','1939/11/15'),
	(7,'Bill','Murray','1950/09/21'),
	(7,'Andie','MacDowell','1958/04/21'),
	(7,'Chris','Elliott','1960/05/31'),
	(7,'Stephen','Tobolowsky','1951/05/30'),
	(7,'Harold','Ramis','1944/11/21'),
	(8,'Keanu','Reeves','1964/09/02'),
	(8,'Laurence','Fishburne','1961/07/30'),
	(8,'Carrie/Anne','Moss','1967/08/21'),
	(8,'Hugo','Weaving','1960/04/04'),
	(8,'Joe','Pantoliano','1951/09/12'),
	(8,'Matt','Doran','1976/03/30'),
	(6,'Veronica','Cartwright','1949/04/20');


UPDATE [dbo].[Movies] SET [MovieName] = 'Alien' WHERE [MovieName] = 'Aliens'

UPDATE [dbo].[Actors] SET [CountryOfBirth] = 'Australia', [PlaceOfBirth] = 'Sydney';

CREATE TABLE [dbo].[ActorUpdates](
	[ActorID] [int] IDENTITY(1, 1) NOT NULL,
	[MovieID] [int] NULL,
	[FirstName] [varchar](120) NOT NULL,
	[LastName] [varchar](120) NOT NULL,
	[DateOfBirth] [date] NOT NULL,
	CONSTRAINT [PK_ActorsUpdate] PRIMARY KEY CLUSTERED
	(
		[ActorID] ASC
	)
);
GO

ALTER TABLE dbo.ActorUpdates
ADD [ActorImage] [varbinary](MAX) NULL, [PlaceOfBirth] [varchar] (120) NULL, [CountryOfBirth] [varchar] (120) NULL;
GO

INSERT INTO [dbo].[ActorUpdates]
(
	[MovieID],
	[FirstName],
	[LastName],
	[DateOfBirth],
	[PlaceOfBirth],
	[CountryOfBirth]
) VALUES (1,'Bill','Murray','1950-09-21','Chicago','USA'),
	(1,'Dan','Aykroyd','1952-07-01','Ontario','Canada'),
	(1,'Sigourney','Weaver','1949-10-08','New York','USA'),
	(1,'Harold','Ramis','1944-11-21','Chicago','USA'),
	(1,'Rick','Moranis','1953-04-18','Ontario','Canada'),
	(1,'Ernie','Hudson','1945-12-17','Michigan','USA'),
	(2,'Kevin','Costner','1955-01-18','California','USA'),
	(2,'Mary','McDonnell','1952-04-28','Pennsylvania','USA'),
	(3,'Sigourney','Weaver','1949-10-08','New York','USA'),
	(3,'Michael','Biehn','1956-07-31','Alabama','USA'),
	(3,'Paul','Reiser','1957-03-30','New York','USA'),
	(3,'Lance','Henriksen','1940-05-05','New York','USA'),
	(3,'Bill','Paxton','1955-05-17','Texas','USA'),
	(4,'Harrison','Ford','1942-07-13','Chicago','USA'),
	(4,'Rutger','Hauer','1944-01-23','Utrecht','Netherlands'),
	(4,'Sean','Young','1959-11-20','Kentucky','USA'),
	(4,'Daryl','Hannah','1960-12-03','Chicago','USA'),
	(5,'Noomi','Rapace','1979-12-28','Hudiksvall','Sweden'),
	(5,'Charlize','Theron','1975-08-07','Benoni','South Africa'),
	(5,'Idris','Elba','1972-09-06','London','UK'),
	(5,'Guy','Pearce','1967-10-05','Cambridgeshire','UK'),
	(6,'Tom','Skerritt','1933-08-25','Michigan','USA'),
	(6,'Sigourney','Weaver','1949-10-08','New York','USA'),
	(6,'Veronica','Cartwright','1949-04-20','Bristol','UK'),
	(6,'John','Hurt','1940-01-22','Derbyshire','UK'),
	(6,'Ian','Holm','1931-09-12','Essex','UK'),
	(6,'Yaphet','Kotto','1939-11-15','New York','USA'),
	(7,'Bill','Murray','1950-09-21','Chicago','USA'),
	(7,'Andie','MacDowell','1958-04-21','South Carolina','USA'),
	(7,'Chris','Elliott','1960-05-31','New York','USA'),
	(7,'Stephen','Tobolowsky','1951-05-30','Dallas','USA'),
	(7,'Harold','Ramis','1944-11-21','Chicago','USA'),
	(8,'Keanu','Reeves','1964-09-02','Beirut','Lebanon'),
	(8,'Laurence','Fishburne','1961-07-30','Georgia','USA'),
	(8,'Carrie-Anne','Moss','1967-08-21','Vancouver','Canada'),
	(8,'Hugo','Weaving','1960-04-04','Ibadan','Nigeria'),
	(8,'Joe','Pantoliano','1951-09-12','New Jersey','USA'),
	(8,'Matt','Doran','1976-03-30','Sidney','Australia'),
	(5,'Michael','Fassbender','1977-04-02','Heidelberg','West Germany');


MERGE dbo.Writers
USING 
(
	SELECT	MovieID, 
			FirstName, 
			LastName, 
			BirthDate, 
			BirthPlace, 
			CountryOfBirth
	FROM
	(			
	VALUES	(1,'Dan','Aykroyd', '1 July 1952', 'New York','USA'),
			(1,'Harold','Ramis', '21 November 1944', 'Chicago','USA'),
			(2,'Michael','Blake', '5 July 1945', 'North Carolina','USA'),
			(3,'James','Cameron', '16 August 1954', 'Ontario','Canada'),
			(3,'David','Giler', '15 September 1948', 'New York','USA'),
			(4,'Hampton','Fancher', '18 July 1938', 'California','USA'),
			(4,'David','Peoples', '15 September 1940', 'Connecticut','USA'),
			(4,'Philip K','Dick', '16 December 1928', 'Chicago','USA'),
			(5,'Jon','Spaihts', '15 September 1959', 'New York','USA'),
			(5,'Damon','Lindelof', '24 April 1973', 'New Jersey','USA'),
			(6,'Dan','O''Bannon', '30 September 1946', 'Missouri','USA'),
			(6,'Ronald','Shusett', '15 September 1959', 'New York','USA'),
			(7,'Danny','Rubin', '15 September 1957', 'New York','USA'),
			(7,'Harold','Ramis', '21 November 1944', 'Chicago','USA'),
			(8,'Lana','Wachowski', '21 June 1965', 'Chicago','USA'),
			(8,'Lilly','Wachowski', '29 December 1967', 'Chicago','USA')
	) AS X (	MovieID, 
				FirstName, 
				LastName, 
				BirthDate, 
				BirthPlace, 
				CountryOfBirth
			) 
) AS WriterUpdates
ON Writers.FirstName = WriterUpdates.FirstName
AND Writers.LastName = WriterUpdates.LastName
AND Writers.MovieID = WriterUpdates.MovieID
WHEN NOT MATCHED BY TARGET THEN
  INSERT (	MovieID, 
			FirstName, 
			LastName, 
			DateOfBirth, 
			PlaceOfBirth, 
			CountyOfBitrth)
  VALUES (	WriterUpdates.MovieID, 
			WriterUpdates.FirstName, 
			WriterUpdates.LastName, 
			WriterUpdates.BirthDate, 
			WriterUpdates.BirthPlace, 
			WriterUpdates.CountryOfBirth);
GO
SELECT * FROM [dbo].Movies WHERE MovieName = 'Alien' OR RunningTime > 110;