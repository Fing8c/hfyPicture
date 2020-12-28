package com.hfy.matisse.internal.entity;

/**
 * @author hfy
 * @description
 * @time 2020/7/17
 */
public class CaptureStrategy {
    public final boolean isPublic;
    public final String authority;

    public CaptureStrategy(boolean isPublic, String authority) {
        this.isPublic = isPublic;
        this.authority = authority;
    }
}
