package online.arapov.jct

import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.FrameTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Direction
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

private const val ITERATIONS = 10
private const val PACKAGE_NAME = "online.arapov.jct.compose"


@RunWith(AndroidJUnit4::class)
class ComposeFrameTimingBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun scrollListWarm() {
        benchmarkRule.measureRepeated(
            packageName = PACKAGE_NAME,
            metrics = listOf(FrameTimingMetric()),
            compilationMode = CompilationMode.Full(),
            startupMode = StartupMode.WARM,
            iterations = ITERATIONS,
            setupBlock = {
                startActivityAndWait()
            }
        ) {
            val column = device.findObject(By.res("lazyColumn"))
            column.setGestureMargin(device.displayWidth / 5)
            repeat(3) { column.fling(Direction.DOWN) }
        }
    }

    @Test
    fun scrollListHot() {
        benchmarkRule.measureRepeated(
            packageName = PACKAGE_NAME,
            metrics = listOf(FrameTimingMetric()),
            compilationMode = CompilationMode.Full(),
            startupMode = StartupMode.HOT,
            iterations = ITERATIONS,
            setupBlock = {
                startActivityAndWait()
            }
        ) {
            val column = device.findObject(By.res("lazyColumn"))
            column.setGestureMargin(device.displayWidth / 5)
            repeat(3) { column.fling(Direction.DOWN) }
        }
    }

    @Test
    fun scrollListCold() {
        benchmarkRule.measureRepeated(
            packageName = PACKAGE_NAME,
            metrics = listOf(FrameTimingMetric()),
            compilationMode = CompilationMode.Full(),
            startupMode = StartupMode.COLD,
            iterations = ITERATIONS,
            setupBlock = {
                startActivityAndWait()
            }
        ) {
            val column = device.findObject(By.res("lazyColumn"))
            column.setGestureMargin(device.displayWidth / 5)
            repeat(3) { column.fling(Direction.DOWN) }
        }
    }
}