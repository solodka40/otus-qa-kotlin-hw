import kotlin.reflect.full.functions

interface TestRunner {
    fun <T> runTest(steps: T, test: () -> Unit)
}

class MyTestRunner : TestRunner {
    override fun <T> runTest(steps: T, test: () -> Unit) {
        runSteps(steps, "before")
        println("----------------Начало выполнения основного теста------------------")
        test()
        println("----------------Завершение выполнения основного теста--------------")
        runSteps(steps, "after")

    }

    private fun <T> runSteps(steps: T, stepsName: String) {
        steps!!::class.functions
            .filter { it.name.startsWith(stepsName) }
            .forEach {
                println("----Start step ${it.name}----")
                it.call(steps)
                println("----End step ${it.name}----")
            }
    }
}

class Steps{
    fun beforeSteps(){
        println("Начальный шаг 1")
    }

    fun afterSteps(){
        println("Заключительный шаг 1")
    }

    fun test(){
        println("Тестовый шаг")
    }

    fun beforeTest(){
        println("Начальный шаг 2")
    }

    fun afterTest(){
        println("Заключительный шаг 2")
    }

    fun beforeEach(){
        println("Начальный шаг 3")
    }
    fun afterEach(){
        println("Заключительный шаг 3")
    }


}