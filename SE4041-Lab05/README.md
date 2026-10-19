# SE4041 – Lab Sheet 05: Sensors (Android, Kotlin)

The Android image (an `ImageView`) starts in the centre of the screen and **moves when you pan and tilt the phone**,
using the **accelerometer**.

## Open and run
Android Studio ▸ **File ▸ Open** ▸ select this folder ▸ Gradle sync ▸ ▶ Run on a **physical phone** (best) or the emulator.
(minSdk 26, compileSdk 35, Kotlin 2.0.21, package `com.example.madlab05`.)

- **Phone:** tilt it left/right and forward/back and the image slides that way.
- **Emulator:** ⋯ (Extended controls) ▸ **Virtual sensors** ▸ *Device pose* – drag the phone or change Roll/Pitch.

## How it works (`app/src/main/java/com/example/madlab05/`)
| File | Role |
|---|---|
| `MainActivity.kt` | Registers the accelerometer in `onResume`, unregisters in `onPause`; moves the image via `translationX/Y` |
| `TiltMapper.kt` | Turns a reading (±9.81 m/s²) into a pixel offset, clamped so the image never leaves the screen, plus a smoothing filter |

- The screen is locked to portrait so the axes always mean the same thing.
- The image's offset is `reading / 9.81 × (free space)`, so a full tilt reaches the screen edge; a low-pass filter removes jitter.
- If a device has no accelerometer, the app shows a message instead of crashing.
