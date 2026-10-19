package com.example.madlab05

/** Converts accelerometer readings into an image offset (pure maths, no Android classes). */
object TiltMapper {
    const val GRAVITY = 9.81f

    /**
     * @param axisValue accelerometer reading on one axis (m/s², about -9.81 .. +9.81)
     * @param maxOffset farthest the image may move from the centre, in pixels
     * @return offset in pixels, clamped to -maxOffset .. +maxOffset
     */
    fun offsetFor(axisValue: Float, maxOffset: Float): Float {
        val fraction = (axisValue / GRAVITY).coerceIn(-1f, 1f)
        return fraction * maxOffset
    }

    /** Low-pass filter: smaller alpha = smoother but slower. */
    fun smooth(previous: Float, target: Float, alpha: Float = 0.15f): Float =
        previous + alpha * (target - previous)
}
