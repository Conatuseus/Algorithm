package BOJ_byKotlin

fun main() {
    val N = readLine()!!.toInt()
    val arr = IntArray(101)
    var added = 3
    arr[0] = 2
    arr[1] = 4
    for (i in 2 until N) {
        arr[i] = arr[i - 1] + added
        if ((i + 1) % 3 != 0) {
            added++
        }
    }
    println(arr[N-1])
}