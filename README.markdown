## Project: MP2  
**Course: ITM-411**  
**Author: Brian T. Bailey**

---------------------------------------------------------------------------------

#### Project Description:

The object of this project was to create an application that read in the sample 
data file, bank-data.csv, and perform some basic operations and analysis on the 
data. The data file needs to be parsed and stored in a BankRecord object model 
we defined. The objects need to be sorted by region and stored in lists of 
BankRecords which in turn need to be stored in a Map object using the region 
as the Key.

A PersistentObject class needs to be defined that will hold the Map object and 
a timestamp. This PersistentObject then needs to get serialized to a file. After 
5 seconds, that file needs to be deserialized back into the application. Once 
that is complete some basic data analytics need to be performed.

These analytics include the time difference between serialization and 
deserialization, average income per region, max and min age per region, number 
of females with a mortgage and savings account, number of males with a car and 
children. All output also needs to be displayed to the console and written to 
a text file.

#### Additional Information:

Please read the README.pdf file for a complete project description and write-up.

---------------------------------------------------------------------------------

Copyright (c) 2012 Brian T. Bailey  
The source code contained within this repository is released under the MIT License.