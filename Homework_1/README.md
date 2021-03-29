Compiling java code from the command line

1. In the src folder (where the source files will be stored) create a TestClass file containing a class with the same name and main method. Save with .java extension

2. Create a bin folder for the compiled classes

3. To compile a class located in the src package you must invoke the command line from the root folder (Homework_1) and execute the command
javac -d bin ./src/TestClass.java

-d -  points to the folder where the compiled files should be placed (in this case - bin)
./src/ - path to source files,  * - compile all files in this directory

The compiled class TestClass.class will appeare in the bin/src folder

4. Use the following command to start 
java -classpath ./bin src.TestClass

-classpath - points the way to compiled classes указывает путь к скомпилированным классам
./bin - folder with compiled classes 
src.TestClass  - packageName.ClassName 


Creating a jar archive

1. In the root folder (Homework_1) create a manifest.mf file which will describe a jar file

2. Indicate in this file the version (manifest-version: 1.0), the path to the class with the main method (src.TestClass) and the path to the alredy compiled files (bin folder)

3. Create jar archive with the following command
jar -cmf manifest.mf TestClass.jar -C bin .

c - create a new archive
m - add existing manifest file (after the flags the path to this file is indicated) 
f - the name of the archive is indicated (TestClass.jar)
- C - flag indicates path to the compiled files (bin folder)
. - path to jar archive (in this case - root directory)

4. Create jar archive the following command
java -jar TestClass.jar

-jar - jar file launch 
TestClass.jar - path to archive (located in the root directory, so write only the name)









