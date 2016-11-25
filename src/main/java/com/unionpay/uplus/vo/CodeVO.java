package com.unionpay.uplus.vo;

/**
 * date: 2016/11/26 01:38
 * author: yueqi.shi
 */
public class CodeVO {
    public static final CodeVO SUCCESS = new CodeVO(1);

    public static final CodeVO ERROR = new CodeVO(0);

    private int code;

    public CodeVO() {
    }

    public CodeVO(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
