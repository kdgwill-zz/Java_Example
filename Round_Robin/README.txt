Operating System – CSCI-330-M01 - Spring 2011
CPU Scheduling
Project #1: README file

by Kyle Williams
on March 25, 2011

ID: 0668814
===============================================
ABOUT:
===============================================
Language:   Java
Focus: To keep the code as clean and as simple as possible yet abstract enough to be able to introduce new scheduling techniques in the future.
*Note: Please reference the file name OUTPUT for example output data
In this assignment, I submitted the following four files:

    README.txt
    OUTPUT.txt
    TestRoundRobin.java
    RoundRobin.java
    Scheduler.java
    Process.java
    CPU.java

To Run please add the requried APIs to your class path and run the TestRoundRobin.java class
====TestRoundRobin.java
For TestRoundRobin, I made the following assumptions:
    Keep as simple as possible while showing all library functionality
    Create and run scheduling algorithm as simple as possible
====CPU.java
For CPU, I made the following assumptions:
    A simple class that simulates a process by subtracting from a designated timer (CPU BURST)
    Should be able to query System Information
    NOTE: This is the class that uses the foreign API SIGAR
====Process.java
For Process, I made the following assumptions:
    A wrapped int class representing CPU burst
    Added Fields to help with information handling
    Present bulk of information in a pretty print style format
====Scheduler.java
For Scheduler, I made the following assumptions:
    Must be abstract and flexible enough to extend into any other scheduling algorithm
    Must retain the bulk or required calls
    Must Start the Processing Unit CPU.java  
====RoundRobin.java
For RoundRobin, I made the following assumption:
    Subclass of Scheduler
    Implement the round robin algorithm which is basically a queue
    create a list of unfinished and finished jobs
    Keep it simple
For RoundRobin, I used the following algorithm:
    While unfinished jobs is not empty
        pop next job from head
        subtract the remaining CPU_Burst time from the quantum time
        if the CPU_Burst time is equal to or less that 0
            place into the finished job list
        else
            add back to the queue            
    End
===============================================
PROJECT NOTES:
===============================================
  Due to a sever limitation of java native system information cannot be accessed unless done in a strenuous roundabout way, 
    the Sigar API was added in order to keep this library code pure java, though the project has been redone in other languages. 
        If another Language is desired please request at KyleDGWilliams@gmail.com
===============================================
REQUIRED API:
===============================================
                NAME:        WEBSITE:                                           DOWNLOAD LOCATION:                                                          
                SIGAR        http://support.hyperic.com/display/SIGAR/Home      http://sourceforge.net/projects/sigar/files/sigar/1.6/
DOWNLOAD NOTES: Some API are crossPlatform for the specific example please only add the jar file, usually found in the lib subfolder  

===============================================
KNOWN ISSUES OR BUGS:
===============================================     
    Due to java's optimization on some parts the total cpu usage will constantly deplete until it reaches 0.0 percent.