# Natural Disasters Data Analyzer

A modular Java application designed to load, process, analyze, and generate statistical reports on historical natural disasters data. Developed as a team software engineering project following layered architecture principles and object-oriented design patterns.

Developed as part of the Object-Oriented Programming Techniques university course.
## Key Features

* **Data Ingestion:** Parses and loads structured natural disaster records into domain objects.
* **Statistical Analysis:** Computes aggregated metrics and insights across disaster types, regions, and timeframes.
* **Multi-Format Reporting:** Exports analysis results into **HTML**, **Markdown (`.md`)**, and **Plain Text (`.txt`)** reports.
* **Comprehensive Unit Testing:** Includes dedicated JUnit test suites covering data loading, domain creation, engine integration, statistics, and report generation.

## Architecture & Project Structure

The codebase separates presentation, business logic, data loading, reporting, and testing into distinct modules:

```text
src/
├── main/java/
│   ├── app/          # Application entry point and user interface
│   ├── dom2app/      # Data transfer models exposed to the client/UI
│   ├── dom2engine/   # Core engine interfaces and contracts
│   ├── domCreator/   # Factory classes for instantiating domain/engine components
│   ├── domain/       # Core business entities representing disaster events
│   ├── engine/       # Main controller orchestrating loading, stats, and exports
│   ├── load/         # File parsers and dataset loaders
│   ├── report/       # Report generators (HTML, Markdown, TXT)
│   └── statistics/   # Statistical calculation modules
└── test/
    ├── java/
    │   ├── TestDomainCreator.java
    │   ├── TestDomainEngineConnector.java
    │   ├── TestLoader.java
    │   ├── TestReport.java
    │   └── TestStatistics.java
    └── resources/
        ├── input/                # Sample disaster datasets for testing
        ├── output/               # Expected report outputs for test assertions
        └── analysisTests.xlsx    # Test cases design & specification
lib/                  # External dependencies (JUnit)
```

## Getting Started

### Prerequisites
* **Java JDK 11** or higher
* **Eclipse IDE** (or any Java IDE / CLI with `javac`)

### Running the Application
1. Clone the repository:
   ```bash
   git clone [https://github.com/](https://github.com/)<your-username>/natural-disasters-analyzer.git
   ```
2. Open the project in **Eclipse** (`File > Open Projects from File System...`) or compile via terminal including the libraries in `lib/`:
   ```bash
   javac -cp "lib/*" -d bin $(find src/main/java -name "*.java")
   java -cp "bin:lib/*" app.<MainClassName>
   ```
   *(Replace `<MainClassName>` with the main class inside the `app` package.)*

### Running the Tests
In **Eclipse**, right-click on `src/test/java` and select **Run As > JUnit Test** to execute all 5 test suites.

## Sample Output

The application generates structured summary reports in multiple formats:
* `report.html` – Styled web report
* `report.md` – GitHub-ready Markdown summary
* `report.txt` – Plain text tabular output
