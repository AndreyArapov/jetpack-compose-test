package online.arapov.jct

import android.content.Intent
import androidx.benchmark.macro.CompilationMode
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

private const val ITERATIONS = 50
private const val PACKAGE_NAME = "online.arapov.jct.composite"

@RunWith(Parameterized::class)
class StartupBenchmarkTest(
    private val startupMode: StartupMode
) {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startup() = benchmarkRule.measureRepeated(
        packageName = PACKAGE_NAME,
        metrics = listOf(StartupTimingMetric()),
        compilationMode = CompilationMode.Full(),
        iterations = ITERATIONS,
        startupMode = startupMode,
        setupBlock = {
            pressHome()
        }
    ) {
        startActivityAndWait()
    }

    @Test
    fun startupCompose() = benchmarkRule.measureRepeated(
        packageName = PACKAGE_NAME,
        metrics = listOf(StartupTimingMetric()),
        compilationMode = CompilationMode.Full(),
        iterations = ITERATIONS,
        startupMode = startupMode,
        setupBlock = {
            pressHome()
        }
    ) {
        val intent = Intent("$packageName.COMPOSE_ACTIVITY")
        startActivityAndWait(intent)
    }

    companion object {
        @Parameterized.Parameters(name = "mode={0}")
        @JvmStatic
        fun parameters(): List<Array<Any>> {
            return listOf(
                StartupMode.COLD,
                StartupMode.WARM
            ).map { arrayOf(it) }
        }
    }

}