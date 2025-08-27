# superSWING

A classic Mario-like 2D platformer built in pure Java using Swing/AWT. This project demonstrates game loops, sprite animation, tile-based maps, collision detection, and basic input handling, all with zero external dependencies.

## Highlights
- Built with core Java (Swing/AWT). Yup! No game engine. LITERALLY! 
- Full-screen rendering and game loop
- Tile map system with multiple levels (maps/mapN.txt)
- Sprites, animations, and simple enemies (Fly, Grub)
- Collectibles and goal mechanics (coins, heart)
- Keyboard input and basic physics

## Project Structure
- src/com/tilegame — Main game loop, map loading, and drawing
- src/com/graphics — Animation, Sprite, and screen utilities
- src/com/input — Input mapping and actions
- src/com/Sprites — Player, enemies, and power-ups
- images — All textures and sprite sheets
- maps — ASCII tile maps

## Controls
- Left/Right arrows: Move
- Space or Up: Jump
- P: Pause/Resume
- R: Restart current level
- Esc: Quit

## Quick Start (IntelliJ IDEA)
1. Open the project in IntelliJ IDEA (File > Open > select the project folder).
2. Ensure SDK is set (JDK 8+ recommended; tested with JDK 8–17).
3. Right-click src/com/tilegame/Main.java and Run 'Main'.

## Run from Command Line (Windows/PowerShell)
Prerequisites: Java JDK installed (java, javac, jar in PATH).

Use the included build script
- From project root, run: ./build-jar.ps1
- This produces out/jar/superSWING.jar with images and maps included.
- Run the game: java -jar .\out\jar\superSWING.jar

Note on resources: The game currently loads images and maps from relative paths (images/, maps/). The build script packages these folders into the JAR so they’re available at runtime.


## Screenshot. Enjoy!!! 
![Screenshot 2024-09-22 022650](https://github.com/user-attachments/assets/658b35d1-ac51-48d2-afa7-66e09489e37e)

## License
This project is licensed under the Apache License 2.0. See LICENSE for details.
