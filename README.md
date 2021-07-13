# Demo-OpenCart-AutomationTests

Automated tests made with Java programming language, Selenium framework, and Cucumber. Below you can find detailed instructions on how to run the project on your local machine. This project was built on Windows operating system and the instructions are based on that. For macOS users, the steps are very similar.

# Detail instructions for running on local machine

First of all, you need to download Java JDK 8 (8u291 is the version used at the time project was created). Next, you should install JDK you downloaded, and the most important thing is to add JAVA_HOME variable to your System Variables and Path. You will also need some kind of integrated development environment. 
In the time project was created, IntelliJ IDEA was used - Community version. Build automation tool that was used is Maven, and you will also need to download that and add it in System variable Path. After you installed java and maven, there is an easy way to check if you did it correctly. 

Go to command prompt and type "javac -version" & "mvn -version". If you did it correctly, versions of both java and maven should be printed in the console.

One of the prerequisites is to have Google Chrome installed on the default path. Tests are also supported to be run in Firefox, but small code adjustments would be necessary for that.

Depending on how you want to get the project from GitHub, you might have to configure Git on your local machine. In order you don't want to spend the time with that, you can simply download it by clicking on Code --> Download ZIP. If you downloaded the project as ZIP file, you will need to extract it to the desired location. If you want to use Git, go to command promt, place yourself in desired directory and execute this command: "git clone https://github.com/ihmelik/Demo-OpenCart-AutomationTests.git".

When you managed to download the project, open your IDE that you installed and open the project with it. In the beginning, feature files from Cucumber might look weird, but that's because you're missing Cucumber plugin, which you can easily install by going to Settings --> Plugins and there find Cucumber for Java plugin in the marketplace. Nevertheless, not having the Cucumber for the Java plugin will not disable you from executing the tests.

Also, you don't need to download any kind of web driver since the WebDriverManager library will do everything for you (check the version of your browser that is installed - download the matching version (if unknown it will download the latest available driver) & export proper WebDriver Java environment variable for Selenium). Show some love for the man who built it for us - https://github.com/bonigarcia/webdrivermanager

If you want to run tests from an integrated terminal in IntelliJ, simply open terminal and type: "mvn clean test", that command will freshly build the project and execute all the tests in one sequence. If you want to run it from your default terminal, open the command prompt, place yourself in the project directory, and run the same command as you would in the integrated terminal "mvn clean test".

There is the possibility to run tests in the HEADLESS mode, but first, you will need to uncomment that Chrome option in the BrowserInit class - src/main/java/driver/BrowserInit.java. If you don't like the terminal, you can also right-click on the TestRunner class place in src/test/java/TestRunner.java and simply click on Run 'TestRunner'.

When the tests are finished, you can check your terminal, there should be a section where you can find a link to the external report where you can exactly see which steps passed and which ones failed.

Enjoy.
