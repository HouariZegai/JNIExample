# JNI Example
Steps of using Java Native Interface (Call C/C++ methods from Java)

[![License MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Java 8](https://img.shields.io/badge/Java-8-red.svg)](https://www.java.com)
![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=102)

## Tools/Programs we need in this tutorial
* [JDK](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* [CodeBlocks](http://www.codeblocks.org/downloads)

### Step I: Make Java Code for calling C/C++ method
1. Create a Java Project
2. Create a class named **Hello.java**
3. Write the head of method contains **native** keyword that describe the functions/methods in C++ (like [this](src/Hello.java))
4. Compile the Hello.java class using the IDE or by typing this command in the folder that's contain the class:

       javac Hello.java
    **Note:** If **javac** is not recognized, you need to add the JDK path to the "system environment variable"

### Step II: C/C++ Part
1. Generate the C/C++ JNI header by typing this command:

       javah Hello
    And you will see the **Hello.h** file generated (like [this](native/Hello.h))
2. Create new project of type **Dynamic Link Library** on the CodeBlocks IDE
3. Import the Hello.h file
4. Create new file named **Hello.cpp** and make the implementation of the Hello.h method (like [this](native/Hello.cpp))
5. Add the **jni.h** support to C++ compiler:
    1. Right click on the project and click to **Build Options**
    2. Go to **Other compiler options**
    3. Add this two lines:
    
           -I"<JDK path>\include"
           -I"<JDK path>\include\win32"    
        In my case:
    
           -I"C:\Program Files\Java\jdk1.8.0_231\include"
           -I"C:\Program Files\Java\jdk1.8.0_231\include\win32"

6. Build the project

### Step III: Import the lib in Java & Execute the code
1. From C++ project go to the **bin\Debug** folder and copy the generated library (something like *.dll) and paste it in the java project for example under **src/cpplib** folder
2. Now, go to the Hello.java class and import the library using the **System.loadLibrary** method (see this example [here](src/Hello.java))
3. Create Main method, call the native java method & run the App

### Congratuations you called the C++ method from Java using the Java Native Interface :D

## Thank _You_!
If this tutorial helps you, please :star: this repo and share it with others
