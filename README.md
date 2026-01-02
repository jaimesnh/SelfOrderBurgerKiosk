# SelfOrderBurgerKiosk

A Java-based self-order kiosk application for a burger restaurant, developed as a university coursework project.

## Overview
This project demonstrates a simple kiosk system with multilingual support, product and menu management, and order processing. It is intended for educational use and classroom demonstration.

## Features
- Multilingual interface (Spanish, Basque, English, Portuguese)
- Product, menu, and order management
- Multiple UI screens for browsing, selecting, and purchasing
- Example data files for orders and products

## Project Structure
- `src/` - Java source code
  - `manager/` - application entry point and managers
  - `products/` - product and menu models
  - `screens/` - UI screens
- `data/` - sample order files
- `PRODUCTOS/` - product assets
- `idioms/` - language files
- `build.xml` - Ant build script

## Requirements
- Java 8 or later
- Apache Ant (optional, for building outside an IDE)

## Build & Run
1. Build with Ant:
   ```bash
   ant
   ```
   The build will produce a JAR file in the `dist/` directory.

2. Run the application:
   ```bash
   java -jar dist/SelfOrderBurgerKiosk.jar
   ```
   Or run the main class `manager.BurgerKioskApplication` from your IDE.

## License
This software was developed as part of a university course. See the LICENSE file for permitted uses and attribution requirements.

## Contributing
This repository is intended for educational use. For changes, open an issue or pull request and mention your course/instructor if relevant.

---
