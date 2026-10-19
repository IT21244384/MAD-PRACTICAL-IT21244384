# SE4041 – Lab Sheet 01 (Kotlin)

SLIIT · BSc (Hons) IT – Interactive Media · Year 4 Semester 2 · Mobile Application Design and Development

One Kotlin file per question, each with its own `main`:

| Question | File | Main class |
|---|---|---|
| Part 01 – Q1 `whoAmI` | `part1/q1/WhoAmI.kt` | `lab01.part1.q1.WhoAmIKt` |
| Part 01 – Q2 circle circumference & area | `part1/q2/Circle.kt` | `lab01.part1.q2.CircleKt` |
| Part 01 – Q3 `greetings` + driving licence check | `part1/q3/Greetings.kt` | `lab01.part1.q3.GreetingsKt` |
| Part 01 – Q4 five names with index | `part1/q4/Names.kt` | `lab01.part1.q4.NamesKt` |
| Part 02 – Q1 `Employee` / `TemporaryStaff` / `PermanentStaff` | `part2/q1/Employees.kt` | `lab01.part2.q1.EmployeesKt` |
| Part 02 – Q2 `Shape` interface | `part2/q2/Shapes.kt` | `lab01.part2.q2.ShapesKt` |

All sources are in `src/main/kotlin/lab01/`.

## Run
- **IntelliJ IDEA:** open this folder as a Gradle project, open a file and click the green ▶ next to `fun main`.
- **Command line (JDK 17+):** `./gradlew run -PmainClass=lab01.part1.q1.WhoAmIKt` (use `gradlew.bat` on Windows).
- **Single file without Gradle:** `kotlinc src/main/kotlin/lab01/part1/q2/Circle.kt -include-runtime -d circle.jar && java -jar circle.jar`

Each question lives in its own package so that every file can have its own `main` (Kotlin does not allow two top-level `main` functions in one package).
