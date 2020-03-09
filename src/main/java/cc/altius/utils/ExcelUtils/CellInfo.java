/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.utils.ExcelUtils;

import jxl.format.Alignment;
import jxl.write.DateFormat;
import jxl.write.NumberFormat;

/**
 *
 * @author akil
 */
public class CellInfo {

    public static final int TEXT = 0;
    public static final int INTEGER = 1;
    public static final int DOUBLE = 2;
    public static final int PERCENTAGE = 3;
    public static final int DATE_DDMMYYYY = 4;
    public static final int DATE_MMDDYYYY = 5;
    public static final int DATE_DDMMYYYYHHMMSS = 6;
    public static final int DATE_MMDDYYYYHHMMSS = 7;
    public static final NumberFormat IntegerFormat = new NumberFormat("0");
    public static final NumberFormat DecimalFormat = new NumberFormat("0.00");
    public static final NumberFormat PercFormat = new NumberFormat("0.00%");
    public static final DateFormat DateDDMMYYY = new DateFormat("dd/MM/yyyy");
    public static final DateFormat DateMMDDYYY = new DateFormat("MM/dd/yyyy");
    public static final DateFormat DateDDMMYYYHHMMSS = new DateFormat("dd/MM/yyyy HH:mm:ss");
    public static final DateFormat DateMMDDYYYHHMMSS = new DateFormat("MM/dd/yyyy HH:mm:ss");
    public static final DateFormat TimeHHMM = new DateFormat("HH:mm");
    private Object value;
    private int type;
    private Alignment align;
    private int size;

    public CellInfo(Object value, int type) {
        this.value = value;
        this.type = type;
        this.align = Alignment.GENERAL;
        this.size = 5000;
    }

    public CellInfo(Object value, int type, int size) {
        this.value = value;
        this.type = type;
        this.align = Alignment.GENERAL;
        this.size = size;
    }

    public CellInfo(Object value, int type, Alignment align) {
        this.value = value;
        this.type = type;
        this.align = align;
        this.size = 5000;
    }

    public CellInfo(Object value) {
        this.value = value;
        this.type = CellInfo.TEXT;
        this.align = Alignment.GENERAL;
        this.size = 5000;
    }

    public CellInfo(Object value, int type, Alignment align, int size) {
        this.value = value;
        this.type = type;
        this.align = align;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Alignment getAlign() {
        return align;
    }

    public void setAlign(Alignment align) {
        this.align = align;
    }
}
