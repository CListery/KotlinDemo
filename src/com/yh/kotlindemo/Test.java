package com.yh.kotlindemo;

/**
 * Created by Clistery on 18-5-29.
 */
class Test {
    
    public static void main(String[] args) {
        
        //        System.out.println(CalKt.max(1, 2));
        
        int width = 750;//屏幕宽度
        int height = 1334;//屏幕高度
        float screenInch = 4.7f;//屏幕尺寸
        PxConvertDpUtil.generateConversionTable(new Screen(width, height, screenInch));
    }
    
}
