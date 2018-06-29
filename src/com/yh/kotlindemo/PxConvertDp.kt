@file:JvmName("PxConvertDpUtil")
@file:JvmMultifileClass

package com.yh.kotlindemo

/**
 * Created by Clistery on 18-5-30.
 */
class Screen constructor(private val width: Int, private val height: Int, private val screenInch: Float) {

    private val mDensity by lazy {
        getDevicesDensity()
    }

    fun getDensity(): Float {
        return mDensity
    }

    private fun getDevicesDensity(): Float {
        return Math.sqrt((width * width + height * height).toDouble()).toFloat() / screenInch / 160f
    }
}

fun generateConversionTable(screen: Screen): Unit {
    val stringBuilder = StringBuilder()
    stringBuilder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<resources>\n")
    var px = 0
    while (px <= 1000) {
        //像素值除以density
        var dp = (px * 1.0f / screen.getDensity()).toString() + ""
        //拼接成资源文件的内容，方便引用
        if (dp.indexOf(".") + 4 < dp.length) {//保留3位小数
            dp = dp.substring(0, dp.indexOf(".") + 4)
        }
        stringBuilder.append("<dimen name=\"px").append(px).append("dp\">").append(dp).append("dp</dimen>\n")
        px += 2
    }
    stringBuilder.append("</resources>")
    println(stringBuilder.toString())
}