# Dormitory Health Management System

**Introduction**   

We noticed that the NUPT’s supervisor of dorm still uses paper to record the result of checking dormitory hygiene and finally logs the date into Excel, then takes data analysis and statistics. This way bothers the supervisor of dorm more time and is not environment-friendly. So we designed the Dormitory Hygiene Management System. Its deducting scores function can help supervisors deduct points. At the same time, it has reason templates so that the supervisors can add the records of deducting scores quickly and conveniently.

What’s more, this system has a rank function to show the up-to-date result directly, which eliminates complex Excel operation. According to rank, we also create the low scores warning function. It can show the dormitories whose scores are lower than the warning line.

In order to make the system more convenient and practical, we designed the functions of changing password and adding administrator account.

In addition, we added student client program, which students can use to check room hygiene grades and the records of deducting scores. We set up the default password for the students and they can modify it after login. If their scores are too low, they will receive a warning from the administrator.

For practical purposes, we added the resetting function to reset dormitory grades to default value. 


To sum up, we have the functions of: 
1)  Logging in with a student or administration account.
2)	Deducting points with reason template.
3)	Generating rank order by points automatically.
4)	Generating Alert List automatically.
5)	Changing the student or administrator’s password. 
6)	Adding administrator account. 
7)	Querying record of deducting scores and grades (for students). 



eceiving low points warring (for students).








**Source Code:**  

Project released on Github:
[ https://github.com/LeonKwok0/Dormitory-Hygiene-System][1]
You can click Download ZIP button to download the whole source code. 
OR 
Use command: 
``` git
git clone https://github.com/LeonKwok0/Dormitory-Hygiene-System.git
```
to clone this project (read only)



**JAR File**  


1.	Google Drive:   
   https://drive.google.com/file/d/0B3Spyh7xfC_pMWMwc0dBLTFSZDg/view?usp=sharing  
   
2.	Baidu   Drive:  

   http://pan.baidu.com/s/1kUV8gBl  
   
(Those two URL also include source code, size 14MB)






**Mention:**   


 - This project has two version

   The Master Branch use remote database (can access until ); 
   The useLocaldatabas Branch use local database(need to install   MySQL).
   Meanwhile, the jar also have two version. 

 -  Our project depend on third-party JARs 
   the two JAR is put in folder /lib, please put jar and lib folder in same file catalog;

I
   
   


  [1]: https://github.com/LeonKwok0/Dormitory-Hygiene-System
