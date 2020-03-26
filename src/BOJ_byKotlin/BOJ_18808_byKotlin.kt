package BOJ_byKotlin

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (row, col, stickerNum) = br.readLine()!!.split(' ').map { it.toInt() }

    val notebook = Array(row) { BooleanArray(col) { false } }

    fun isPossible(notebookRow: Int, notebookCol: Int, sticker: Array<IntArray>): Boolean {

        if (notebookRow + sticker.size > notebook.size || notebookCol+sticker[0].size > notebook[0].size) {
            return false
        }

        for (i in notebookRow until notebookRow+sticker.size) {
            for (j in notebookCol until notebookCol+sticker[0].size) {
                if (notebook[i][j] && sticker[i-notebookRow][j-notebookCol]==1) {
                    return false
                }
            }
        }
        return true
    }

    fun putSticker(sticker: Array<IntArray>, startRow: Int, startCol: Int) {
        for (i in startRow until startRow+sticker.size) {
            for (j in startCol until startCol+sticker[0].size) {
                notebook[i][j] = notebook[i][j] || sticker[i-startRow][j-startCol]==1
            }
        }
    }

    fun rotateSticker(sticker: Array<IntArray>): Array<IntArray> {
        val newSticker = Array(sticker[0].size) { IntArray(sticker.size) }

        for (i in sticker[0].indices) {
            for (j in sticker.indices) {
                newSticker[i][j] = sticker[sticker.size - 1 - j][i]
            }
        }
        return newSticker
    }

    for (i in 0 until stickerNum) {
        val (stickerRow, stickerCol) = br.readLine()!!.split(" ").map { it.toInt() }
        var sticker = Array(stickerRow) { br.readLine()!!.split(" ").map { it.toInt() }.toIntArray() }
        var isPut = false

        for (j in 0 until 4) {
            for (notebookRow in 0 until row) {
                for (notebookCol in 0 until col) {
                    if (isPossible(notebookRow,notebookCol,sticker)) {
                        putSticker(sticker, notebookRow, notebookCol)
                        isPut = true
                        break
                    }
                }
                if (isPut) {
                    break
                }
            }
            if (isPut) {
                break
            }
            sticker = rotateSticker(sticker)
        }
    }

    println(notebook.sumBy { it -> it.count { it } })
}

