### 📘 Week 1 – Java Practice

#### ✅ Topics Covered:
- Java `record` class
- `Optional` usage for null safety
- Java `Streams` for processing data
- Reading from and writing to `.csv` files
- Basic file operations with `java.nio.file`
- Conditional checks and data filtering

---

#### 📁 Practice Files:
- `EmployeeRecordApp.java` — Reads employee data from a CSV and demonstrates the use of `record`, `Optional`, and `Stream`.
- `managers.csv` — Sample employee data used for testing.
- `AddEmployeeToCSV.java` — Adds a new employee entry into the `managers.csv` file using Java file IO.

---

#### 🔍 Learnings:
- When and how to use `Optional` to handle potential `null` values.
- Use of `.filter()` and `.map()` with `Optional` and Streams.
- Grouping and filtering CSV records with `Collectors.groupingBy()`.
- Avoiding `ArrayIndexOutOfBoundsException` by safely checking field length.
- Clean and readable Java code by using functional programming features.

---

#### 🛠 Sample Snippet:
```java
Optional<Integer> salary = Optional.ofNullable(fields.length > 3 ? fields[3] : "")
                                   .filter(s -> !s.isEmpty())
                                   .map(Integer::parseInt);
```

---

#### 🚀 Next Week:
- Start integrating with JSON files.
- Build CLI-based mini tools using Java.
- Explore Spring Boot basics.