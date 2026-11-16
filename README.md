# Natural Disasters Data Analyzer

A modular Java application designed to load, process, analyze, and generate statistical reports on historical natural disasters data[cite: 1, 3]. Developed as a team software engineering project following layered architecture principles and object-oriented design patterns[cite: 1, 3].

## Key Features

* **Data Ingestion:** Parses and loads structured natural disaster records into domain objects.
* **Statistical Analysis:** Computes aggregated metrics and insights across disaster types, regions, and timeframes[cite: 3].
* **Multi-Format Reporting:** Exports analysis results into **HTML**, **Markdown (`.md`)**, and **Plain Text (`.txt`)** reports.
* **Unit Tested:** Includes a dedicated test suite under `src/test` to verify core engine and reporting functionality[cite: 2].

## Architecture & Project Structure

The codebase separates presentation, business logic, data loading, and reporting into distinct packages[cite: 3]:

```text
src/
├── main/java/
│   ├── app/          # Application entry point and user interface[cite: 3]
│   ├── dom2app/      # Data transfer models exposed to the client/UI[cite: 3]
│   ├── dom2engine/   # Core engine interfaces and contracts[cite: 3]
│   ├── domCreator/   # Factory classes for instantiating domain/engine components[cite: 3]
│   ├── domain/       # Core business entities representing disaster events[cite: 3]
│   ├── engine/       # Main controller orchestrating loading, stats, and exports[cite: 3]
│   ├── load/         # File parsers and dataset loaders[cite: 3]
│   ├── report/       # Report generators (HTML, Markdown, TXT)[cite: 1, 3]
│   └── statistics/   # Statistical calculation modules[cite: 3]
└── test/             # Unit tests[cite: 2]
lib/                  # External dependencies (e.g., JUnit)
