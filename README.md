## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Running the exercises

Both exercises define a class named `Main`, so run the unguided exercise using its package-qualified class name:

```bash
rm -rf bin/lw01
javac -d bin $(find lw01 -name "*.java")
mkdir -p bin/lw01/unguided
cp lw01/unguided/washes.txt bin/lw01/unguided/
java -cp bin lw01.unguided.Main
```

In VS Code, open `lw01/unguided/Main.java` and use **Run Java** above that file's `main` method. The package declaration (`lw01.unguided`) keeps it separate from `lw01.prelab.Main`.
