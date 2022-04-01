# Example Shuffleboard 2019 Widgets

This repository is based on VorTX 3735 widget examples created by Nathan Leach. Below are instructions written by Nathan on how to use this code. More information can be found on his Github and YouTube channel.
Github: https://github.com/nleach999/Vortx3735.Shuffleboard.2019.WidgetTutorial
YouTube: https://www.youtube.com/channel/UCewEfD5OdPqBZHH31FJtCTA

# HOW-TO: Build, Debug, and Deploy Your Widget(s)

## Building

You may still use the FRC 2019 VSCode IDE and build the code using the *WPILib Command Palette*.  Steps:

1. Click the *WPILib Command Palette* button in the top right corner or press CTRL-SHIFT-P.
2. Type *WPILib: Build Robot Code*

Why would we be building Robot code?  We aren't - this command simply invokes the `build` task set up by Gradle.


You may alternately use the *WPILib: Run a command in Gradle* command:

1. Click the *WPILib Command Palette* button in the top right corner or press CTRL-SHIFT-P.
2. Type `WPILib: Run a command in Gradle`
3. Type `build` to execute the build task

Building only builds the project.  It does not deploy the resulting jar where it can be picked up by Shuffleboard automatically.

## Deploying

Deploying will copy the jar to the `%USERPROFILE%/Shuffleboard/plugins` (Windows) or `~/Shuffleboard/plugins` (Linux/Mac) folder on the local machine.  Shuffleboard will automatically make widgets in your jar available for use when it starts. Deploying is similar to building:

1. Click the *WPILib Command Palette* button in the top right corner or press CTRL-SHIFT-P.
2. Type `WPILib: Run a command in Gradle`
3. Type `deployWidget` to execute the deployment

Running the `deployWidget` task will automatically invoke the `build` task.

## Debugging

Once the `deployWidget` Gradle task copies your jar for automatic loading by Shuffleboard, you can perform some debugging.

### Non-Interactive Debugging
Using Java API methods to output text to [STDOUT](https://en.wikipedia.org/wiki/Standard_streams "Learn about standard streams") (i.e. `System.out.println()` or similar) will be captured in output log files.  Every time Shuffleboard runs, 
a log file may be found at `%USERPROFILE%/Shuffleboard` (Windows) or `~/Shuffleboard` (Linux/Mac).  

### Interactive Debugging
A tutorial about debugging in VSCode can be found [here](https://code.visualstudio.com/docs/java/java-debugging "Java Debuggin in VSCode") for those who are not familiar with interactive debugging.  I have included the file `.vscode/launch.json` that will automatically launch Shuffleboard when selecting **Debug->Start Debugging** (or **F5** as the keyboard shortcut).  You can then set breakpoints, inspect variables, and do all sorts of other things that make debugging this way superior to the old-school *log-to-stdout* method.


# Errors and Issues
During debugging, I noticed that some of the widget properties would cause the Shuffleboard to have an error when saving the layout.  It appears to be related to the way the properties are persisted when saving the Shuffleboard layout.  I noticed that providing the class explicitly to the API when setting up exported properties made things work better.

Example of BAD code:
```
propertyList.add(Group.of("Tick Lable Display"
		, Setting.of("Tick Label Orientation", _theGauge.tickLabelOrientationProperty())
		, Setting.of("Tick Label Color", _theGauge.tickLabelColorProperty(), Color.class)
		, Setting.of("Tick Lavel Location", _theGauge.tickLabelLocationProperty())
));

```

Example of GOOD code:
```
propertyList.add(Group.of("Tick Lable Display"
		, Setting.of("Tick Label Orientation", _theGauge.tickLabelOrientationProperty(), TickLabelOrientation.class)
		, Setting.of("Tick Label Color", _theGauge.tickLabelColorProperty(), Color.class)
		, Setting.of("Tick Lavel Location", _theGauge.tickLabelLocationProperty(), TickLabelLocation.class)
));

```