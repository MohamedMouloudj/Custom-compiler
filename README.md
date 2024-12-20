# Compiler Design project

In this this project we designed a simple compiler as a solution  for the [topic](https://drive.google.com/file/d/1PjQpPrHv1PUj_BMvAVJs2d3RHTlGgJxs/view?usp=drive_link) raised by the professor of this academic module.

## Why did we choose ANTLR?

ANTLR (ANother Tool for Language Recognition) is a powerful parser generator that we can use to read, process, execute or translate structured text or binary files. It uses an LL(*) algorithm for parsing. ANTLR is the successor to the Purdue Compiler Construction Tool Set (PCCTS), first developed in 1989, and is under active development. It is widely used in academia and industry to create all kinds of languages, tools and frameworks.

## How to run

### Prerequisites

- **Maven** installed and added to your `PATH`.
- **ANTLR 4 Plugin** configured in your IDE (e.g., IntelliJ IDEA).
- Mark the `gen` folder as the "Generated Source Root" in your IDE. 
  > **Note**: If you modify the `*.g4` grammar files, you need to regenerate the code:
  > 1. Reconfigure the `*.g4` files: In IntelliJ IDEA, by righ click on each file, select configure ANTLR Tool 4.13.2 for MinINGParser/Lexer.g4
  > 2. Use the ANTLR tool or plugin to regenerate the `gen` folder: Right click, select generate ANTLR recognizer.
  > 3. Mark the gen Folder: In IntelliJ IDEA, right-click on the gen folder, select Mark Directory as, and choose Generated Sources Root

### Steps to Compile and Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/MohamedMouloudj/Custom-compiler.git
   cd Custom-compiler
   ```
2. **Run Maven Clean**:
   ```bash
   mvn clean
   ```
3. **Run main method**

## Team
- Mohamed Mouloudj
- Boudjelida Yanis
- Haddadi Chakib
- Brahim Djelloul Antri Hichem
- Hadj Kaddour Islem

## Links
[Drive link](https://drive.google.com/drive/folders/1X8Xcp-dkqTFIZspenp84avATVt8Qq8Ot?usp=drive_link)
