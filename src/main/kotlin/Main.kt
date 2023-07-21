fun main() {
    val runner= MyTestRunner()
    runner.runTest(Steps()){
        test01()
    }
}

fun test01(){
    println("Выполнение основного теста")
}