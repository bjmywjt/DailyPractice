/**
 * Copyright(c) 2011-2015 by HeXin Inc.
 * All Rights Reserved
 */
package com.daily.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 精度的位数16，相当于DECIMAL64，默认舍入模式RoundingMode.HALF_UP .
 * new MoneyCalculator(1000).add(new BigDecimal()).divide().toResult(2)
 * 
 * @author zhishuo 金额计算器
 */
public class MoneyCalculator {

    public static final int FEN_SCALE = 2;

    private static String zero = "0.00";

    private static final MathContext MC_CONTEXT = MathContext.DECIMAL128;

    private static final int SCALE16 = 16;

    private BigDecimal result;

    public static void main(String[] args) {
        // BigDecimal a = new MoneyCalculator(new BigDecimal("200.1231231203123123")).getScaleRightNumber();
        // System.out.println(a);
        //
        // BigDecimal b = new MoneyCalculator(new BigDecimal("223.232323232323")).downToResult().getInstance();
        // System.out.println(b);
        //
        // int c = new MoneyCalculator(b).getInstance().scale();
        // System.out.println(c);
        System.out.println(new MoneyCalculator(new BigDecimal("200.1291231203123123")).toFloor());

    }

    public MoneyCalculator(double val) {
        this.result = new BigDecimal(val, MC_CONTEXT);
    }

    public MoneyCalculator(int val) {
        this.result = new BigDecimal(val, MC_CONTEXT);
    }

    public MoneyCalculator(long val) {
        this.result = new BigDecimal(val, MC_CONTEXT);
    }

    public MoneyCalculator(String val) {
        this.result = new BigDecimal(val, MC_CONTEXT);
    }

    public MoneyCalculator(BigDecimal val) {
        this.result = val;
    }

    public MoneyCalculator add(BigDecimal augend) {
        return new MoneyCalculator(this.result.add(augend, MC_CONTEXT));
    }

    public MoneyCalculator subtract(BigDecimal subtrahend) {
        return new MoneyCalculator(this.result.subtract(subtrahend, MC_CONTEXT));
    }

    public MoneyCalculator multiply(BigDecimal multiplicand) {
        return new MoneyCalculator(this.result.multiply(multiplicand, MC_CONTEXT));
    }

    public MoneyCalculator divide(BigDecimal divisor) {
        return new MoneyCalculator(this.result.divide(divisor, MC_CONTEXT));
    }

    public MoneyCalculator pow(int n) {
        return new MoneyCalculator(this.result.pow(n, MC_CONTEXT));
    }

    /**
     * 返回四舍五入结果
     * 
     * @see RoundingMode#HALF_UP
     * @param scale 保留小数点几位
     * @return
     */
    public BigDecimal toResult(int scale) {
        return this.result.setScale(scale, RoundingMode.HALF_UP);
    }

    /**
     * 返回四舍五入结果
     *
     * @see RoundingMode#HALF_UP
     * @return
     */
    public BigDecimal toResult() {
        return this.result.setScale(FEN_SCALE, RoundingMode.HALF_UP);
    }

    /**
     * 返回大于或者等于结果的最小整数(分制)
     *
     * @see RoundingMode#CEILING
     * @return
     */
    public BigDecimal toCeil() {
        return this.toCeil(MoneyCalculator.FEN_SCALE);
    }

    /**
     * 返回小于或者等于结果的最大整数(分制)
     *
     * @see RoundingMode#FLOOR
     * @return
     */
    public BigDecimal toFloor() {
        return this.toFloor(MoneyCalculator.FEN_SCALE);
    }

    /**
     * 返回大于或者等于结果的最小整数
     *
     * @see RoundingMode#CEILING
     * @param scale 保留小数点几位
     * @return
     */
    public BigDecimal toCeil(int scale) {
        return this.result.setScale(scale, RoundingMode.CEILING);
    }

    /**
     * 返回小于或者等于结果的最大整数
     *
     * @see RoundingMode#FLOOR
     * @param scale 保留小数点几位
     * @return
     */
    public BigDecimal toFloor(int scale) {
        return this.result.setScale(scale, RoundingMode.FLOOR);
    }

    public BigDecimal getInstance() {
        if (this.result.scale() > SCALE16) {
            return this.result.setScale(SCALE16, RoundingMode.HALF_EVEN);
        }
        return this.result;

    }

    /**
     * 舍弃分后面的所有位值
     * 
     * @author tiejiuzhou
     * @return
     */
    public MoneyCalculator downToResult() {
        return new MoneyCalculator(this.result.setScale(2, RoundingMode.DOWN));
    }

    /**
     * 返回四舍五入Money对象
     *
     * @return
     */
    public MoneyCalculator upToResult() {
        return new MoneyCalculator(this.result.setScale(2, RoundingMode.HALF_UP));
    }

    /**
     * 返回舍掉的字符串
     * 
     * @return
     */
    public String downToResultToString() {
        return this.downToResult().getInstance().toString();
    }

    /**
     * 返回四舍五入的字符串
     *
     * @return
     */
    public String upToResultToString() {
        return this.upToResult().getInstance().toString();
    }

    /**
     * 获取厘账户数据(元)
     * 
     * @author dongzhijie
     * @return
     */
    public static BigDecimal getDecimalMoney(BigDecimal val) {
        return new MoneyCalculator(val).subtract(new MoneyCalculator(val).downToResult().getInstance()).getInstance();
    }

    /**
     * 返回小数点后2位以后的数字 并转为数字
     * 
     * @return
     */
    public BigDecimal getScaleRightNumber() {
        String number = zero;
        if (this.result.scale() > 2) {
            String str = this.getInstance().toPlainString();
            int index = str.indexOf(".");
            number = number + str.substring(index + 3);
        }
        return new BigDecimal(number);
    }

    /**
     * 是否大于0
     * 
     * @author wangjiangtao
     * @return
     */
    public static boolean isBiggerThanZero(BigDecimal val) {
        if (val == null) {
            return false;
        }
        return val.compareTo(BigDecimal.ZERO) == 1;
    }

    /**
     * 是否小于0
     * 
     * @author wangjiangtao
     * @param val
     * @return
     */
    public static boolean isLessThanZero(BigDecimal val) {
        if (val == null) {
            return false;
        }
        return val.compareTo(BigDecimal.ZERO) == -1;
    }

    /**
     * 是否等于0
     * 
     * @author wangjiangtao
     * @param val
     * @return
     */
    public static boolean isEqualZero(BigDecimal val) {
        if (val == null) {
            return false;
        }
        return val.compareTo(BigDecimal.ZERO) == 0;
    }

    /**
     * val1 > val2 返回 true 否则 false
     * 
     * @author dongzhijie
     * @param val1
     * @param val2
     * @return
     */
    public static boolean isBiggerThan(BigDecimal val1, BigDecimal val2) {
        return val1.compareTo(val2) == 1;
    }

    /**
     * val1 < val2 返回 true 否则 false
     * 
     * @author dongzhijie
     * @param val1
     * @param val2
     * @return
     */
    public static boolean isLessThan(BigDecimal val1, BigDecimal val2) {
        return val1.compareTo(val2) == -1;
    }

    /**
     * val1 != val2 返回 true 否则 false
     * 
     * @author tiejiuzhou
     * @param val1
     * @param val2
     * @return
     */
    public static boolean isNotEqual(BigDecimal val1, BigDecimal val2) {
        return val1.compareTo(val2) != 0;
    }

    /**
     * 判断两个值是否相等
     * 
     * @param val
     * @param val1
     * @return boolean
     */
    public static boolean isEqual(BigDecimal val, BigDecimal val1) {
        return val.compareTo(val1) == 0;
    }

    public static boolean ge(BigDecimal val, BigDecimal val1) {
        return val.compareTo(val1) >= 0;
    }

    public static boolean le(BigDecimal val, BigDecimal val1) {
        return val.compareTo(val1) <= 0;
    }

    /**
     * bigDecimal类型的Object数据转成BigDecimal
     * 
     * @param object
     * @return
     */
    public static BigDecimal objectConvertToDecimal(Object object) {
        BigDecimal resultBigDecimal = (BigDecimal) object;
        return resultBigDecimal;
    }
}
