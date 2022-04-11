——————README——————

This project was completed with efforts of all four team members. The goal of the project is to create a software that assists trader managers to more efficiently monitor and manage their clients.

—————— FOR TEST PURPOSE——————

You can click cryptoTrader.jar on Windows and Mac OS 
or you can type command line: cd to the folder that contain userDB.txt and transactionDB.txt;
java -jar cryptoTrader.jar on Unix/Linux to run this program.
if you typed the correct username and password and the main UI not showing by some random error, please try run it in IDE, after running the LoginUI.java, a login window would pop up asking for credentials. We have two sets of login username and passwords.

username: kk
password: king

username: tt
password: queeen

After the credentials have been successfully verified against the record in the “userDB.txt”, the main UI would pop up. There will be one row  automatically generated on the right half of the window. In the empty row, user can fill in the name of the client, interested coin list, and strategy name.

After the information has been entered, the software would automatially check of correctnesss of input format. Furthermore, the program does not allow duplicated trading clients’ names in the “trading client actions” table. 

After the formats have been verified, the user has the choice to either add another row for additional inputs or remove the selected row. 

Then, the user will click on “Perform Trade” button. The past transactions and strategy counts will be visualized in the left part. Transaction history is stored in the transactionDB.txt. All new changes should be reflected on the table and the diagram.




Due to the limitations of external APIs, sometime the website might can't handle too  many requests at the same time(the trading price might be 0.0). in this case, try to decrease the amount of rows and trade again.




