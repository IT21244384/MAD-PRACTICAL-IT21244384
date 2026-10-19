# SE4041 – Lab Sheet 02: CEB Electricity Bill Calculator (Android, Kotlin)

Two screens: a splash/start screen with the CEB logo and a **Let's Start** button, and a
**BillCalculatorActivity** where you enter the units and tap **Calculate**.

## Open and run
Android Studio ▸ **File ▸ Open** ▸ select this folder ▸ Gradle sync ▸ ▶ Run.
(minSdk 26, compileSdk 35, Kotlin 2.0.21, package `com.example.madlab02`.)

## ⚠ Add the real CEB logo (step 1 of the sheet)
The sheet's logo link could not be downloaded when this project was prepared, so
`res/drawable/ceb_logo.xml` is a **placeholder** (white card with a bolt – not the CEB logo).

1. Download <https://www.ceb.lk/assets/frontend/images/mainlogo5.png>
2. Save it as `app/src/main/res/drawable/ceb_logo.png`
3. **Delete** `app/src/main/res/drawable/ceb_logo.xml` (both files use the name `ceb_logo`)

No code changes are needed.

## Sheet requirements → where
| Sheet step | Where |
|---|---|
| 2(b) background `E53935` | `res/values/colors.xml` → `ceb_red` |
| 2(c) button tint `FFEA00` | `ceb_yellow` |
| 2(d) button text colour `581929`, 2(e) size 24sp | `ceb_dark_red`, `activity_main.xml` |
| 3 BillCalculatorActivity (24sp, white label/input) | `activity_bill_calculator.xml`, `BillCalculatorActivity.kt` |
| 4 navigation Main → BillCalculator | `MainActivity.kt` (Intent) |
| 5 bill calculation function | `BillCalculator.kt` |
| 6 show result in "Electricity Bill:" | `BillCalculatorActivity.kt` |

## Bill formula
`Bill = Fixed Charge + Energy Charge + Service Charge + VAT`

- Fixed charge = 150 LKR
- Energy charge = units × 29 LKR
- Service charge = **not given on the sheet → set to 0** (`SERVICE_CHARGE` in `BillCalculator.kt`; change it if you are told a value)
- VAT = 15 % of (fixed + energy + service)

Example: 100 units → 150 + 2900 = 3050; VAT 457.50; **Bill = LKR 3507.50** (checked by running the function).
