# Natural Disasters Data Analyzer

A modular Java application designed to load, process, analyze, and generate statistical reports on historical natural disasters data. Developed as a team software engineering project following layered architecture principles and object-oriented design patterns.

## Key Features

* **Data Ingestion:** Parses and loads structured natural disaster records into domain objects.
* **Statistical Analysis:** Computes aggregated metrics and insights across disaster types, regions, and timeframes.
* **Multi-Format Reporting:** Exports analysis results into **HTML**, **Markdown (`.md`)**, and **Plain Text (`.txt`)** reports.
* **Unit Tested:** Includes a dedicated test suite under `src/test` to verify core engine and reporting functionality.

## Architecture & Project Structure

The codebase separates presentation, business logic, data loading, and reporting into distinct packages:

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
└── test/             # Unit tests
lib/                  # External dependencies (e.g., JUnit)
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

## Sample Output

The application generates structured summary reports in multiple formats:
* `report.html` – Styled web report
* `report.md` – GitHub-ready Markdown summary
* `report.txt` – Plain text tabular output
