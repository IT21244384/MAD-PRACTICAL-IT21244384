# SE4041 – Lab Sheet 03: Fragment Calculator (Android, Kotlin)

Calculator with two inputs and the four basic operations (+, −, ×, ÷), built with **fragments**.
The answer is shown on a **dedicated screen** (`AnswerFragment`) with a Back button, as in the sheet's mock-up.

## Open and run
Android Studio ▸ **File ▸ Open** ▸ select this folder ▸ Gradle sync ▸ ▶ Run.
(minSdk 26, compileSdk 35, Kotlin 2.0.21, package `com.example.madlab03`.)

## Structure (`app/src/main/java/com/example/madlab03/`)
| File | Role |
|---|---|
| `MainActivity.kt` | Hosts the fragments in `fragment_container` |
| `InputFragment.kt` | Main screen: 2 inputs + 4 operator buttons, validation, opens the answer screen |
| `AnswerFragment.kt` | Answer screen: "Answer: …" and Back (pops the back stack, inputs are kept) |
| `Calculator.kt` | Pure arithmetic logic (no Android classes) |

## UI / design choices
- Same flow as the mock-up (Enter Number 1/2, 2 × 2 operator buttons, Answer + Back), with larger touch targets (72 dp), one accent colour and generous spacing.
- Input validation with short messages: empty fields, invalid numbers, **division by zero** ("Cannot divide by zero").
- The answer is passed to `AnswerFragment` through fragment arguments, and the back stack means Back returns to the filled-in inputs.
