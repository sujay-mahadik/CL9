## Working
1. Compile .idl file

>idlj -fall ReverseModule.idl

2. Compile all Java files

> javac *.java

> javac ReverseModule/*.java

3. Start orbd

> orbd -ORBInitialPort 1050 -ORBInitialHost localhost

4. Run Server

> java ReverseServer -ORBInitialPort 1050 -ORBInitialHost localhost

5. Run Clien

> java ReverseClient -ORBInitialPort 1050 -ORBInitialHost localhost