package com.qtmtax.sdk.common.util;

/**
 * DebugUtil
 *
 * @author Hamm.cn
 */
public class DebugUtil {
    /**
     * 调试模式
     */
    public static boolean debug = true;

    /**
     * 显示日志
     *
     * @param log 日志
     */
    public static void show(String key, Object log) {
        if (debug) {
            System.out.println("\n🥵" + key);
            System.out.println(log);
        }
    }
}
