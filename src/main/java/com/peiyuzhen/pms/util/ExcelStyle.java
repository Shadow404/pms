package com.peiyuzhen.pms.util;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import java.lang.annotation.*;

/**
 * @Author: sunsuhai
 * @Date: 2020/4/3 16:10
 */

@Target({ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelStyle {
    String fontName() default "宋体";

    short fontHeightInPoints() default 12;

    HorizontalAlignment horizontalAlignment() default HorizontalAlignment.LEFT;

    VerticalAlignment verticalAlignment() default VerticalAlignment.CENTER;
}