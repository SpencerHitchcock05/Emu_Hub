# Basic Java Swing Application

## What is Java Swing?

Java Swing is a GUI (Graphical User Interface) toolkit for Java. It's part of the Java Foundation Classes (JFC) and provides a set of "components" (buttons, text fields, labels, etc.) that you can use to build desktop applications with windows, menus, and interactive elements.

## Core Swing Concepts

### 1. **JFrame** - The Main Window
- The top-level container that represents a window
- Has a title bar, borders, and can be minimized/maximized/closed
- You set its size, position, and what happens when the user closes it

### 2. **JPanel** - A Container
- A general-purpose container for grouping other components
- Can have its own layout manager
- You can add multiple panels to organize your UI

### 3. **Components** - Interactive Elements
- **JLabel**: Displays text or images (non-interactive)
- **JTextField**: Allows user to enter text
- **JButton**: A clickable button
- **JTextArea**: Multi-line text input
- **JCheckBox**, **JRadioButton**, **JComboBox**, etc.

### 4. **Layout Managers** - Organizing Components
Layout managers control how components are positioned and sized:
- **FlowLayout**: Arranges components left-to-right, top-to-bottom (like words in a paragraph)
- **BorderLayout**: Divides container into 5 regions (North, South, East, West, Center)
- **GridLayout**: Arranges components in a grid of equal-sized cells
- **BoxLayout**: Arranges components in a single row or column
- **GridBagLayout**: Most flexible but complex

### 5. **Event Handling** - Responding to User Actions
- When a user clicks a button, types text, etc., an "event" is generated
- You add "listeners" to components to respond to events
- **ActionListener**: Responds to button clicks, Enter key presses
- **MouseListener**: Responds to mouse clicks, movements
- **KeyListener**: Responds to keyboard input

### 6. **Event Dispatch Thread (EDT)**
- Swing is not thread-safe
- All GUI updates should happen on the EDT
- Use `SwingUtilities.invokeLater()` to ensure this

## How the Code Works

```
BasicSwingApp
    └── creates JFrame (window)
        └── adds JPanel (container)
            ├── JLabel ("Enter your name:")
            ├── JTextField (input box)
            ├── JButton ("Submit")
            └── JLabel (result message)
```

**Flow:**
1. User types their name in the text field
2. User clicks "Submit" button (or presses Enter)
3. ActionListener's `actionPerformed()` method is called
4. Code reads the text from the field
5. Updates the result label with a greeting

## How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) installed (version 8 or higher)
- Check by running: `java -version` in terminal/command prompt

### Compilation

Open a terminal/command prompt in the directory containing `BasicSwingApp.java` and run:

```bash
javac BasicSwingApp.java
```

This creates a file called `BasicSwingApp.class` (the compiled bytecode).

### Running

```bash
java BasicSwingApp
```

A window should appear with the GUI!

### Common Issues

**Problem**: "javac: command not found"
- **Solution**: JDK is not installed or not in your PATH. Install JDK and add it to your system PATH.

**Problem**: "Error: Could not find or load main class BasicSwingApp"
- **Solution**: Make sure you're in the correct directory and that `BasicSwingApp.class` exists.

**Problem**: Window appears but is blank
- **Solution**: This can happen with some display managers. Try adding `frame.revalidate()` before `frame.setVisible(true)`.

## Next Steps to Learn More

1. **Try modifying the code:**
   - Change the window size
   - Add more buttons
   - Try different layout managers (BorderLayout, GridLayout)
   - Add more components (JTextArea, JCheckBox)

2. **Experiment with events:**
   - Add a MouseListener to detect mouse clicks
   - Add a KeyListener to detect key presses
   - Make buttons change colors when clicked

3. **Learn about more components:**
   - JMenu/JMenuBar for application menus
   - JTable for displaying tabular data
   - JList for displaying lists
   - JScrollPane for adding scrollbars

4. **Study layout managers:**
   - Try creating a calculator layout with GridLayout
   - Create a form with labels and fields using GridBagLayout

## Quick Reference

**Creating a component:**
```java
JButton button = new JButton("Click Me");
```

**Adding to a container:**
```java
panel.add(button);
```

**Adding an event listener:**
```java
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Code to execute when button is clicked
    }
});
```

**Getting/setting text:**
```java
String text = textField.getText();
label.setText("New text");
```
