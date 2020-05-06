package kakaoblind2020

fun main() {

    fun rotate(key:Array<IntArray>) :Array<IntArray> {
        val rotated=Array(key.size){IntArray(key.size)}
        for (i in key.indices) {
            for (j in key.indices) {
                rotated[i][j] = key[j][key.size-1-i]
            }
        }
        return rotated
    }

    fun move(key:Array<IntArray>, row:Int, col:Int, lockSize:Int) :Array<IntArray> {
        val moved=Array(lockSize){IntArray(lockSize)}

        for (i in key.indices) {
            for (j in key.indices) {
                if (row+i in 0 until lockSize && col+j in 0 until lockSize) {
                    moved[row+i][col+j]=key[i][j]
                }
            }
        }
        return moved
    }

    fun canUnlock(moved:Array<IntArray>, lock:Array<IntArray>):Boolean {
        for (i in lock.indices) {
            for (j in lock.indices) {
                if (moved[i][j]+lock[i][j]!=1) {
                    return false
                }
            }
        }
        return true
    }

    fun check(key:Array<IntArray>, lock:Array<IntArray>):Boolean {
        for (i in 1-key.size until lock.size) {
            for (j in 1-key.size until lock.size) {
                val moved=move(key,i,j, lock.size)
                if (canUnlock(moved,lock)) {
                    return true
                }
            }
        }
        return false
    }

    fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {

        var rotated=key
        repeat(4) {
            if (check(rotated, lock)) {
                return true
            }
            rotated=rotate(rotated)
        }

        return false
    }

    println(solution(arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1)),
        arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))))
}