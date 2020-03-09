/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.utils.ExcelUtils;

import jxl.format.Alignment;


/**
 *
 * @author akil
 */
public class Parameter {

    private CellInfo label;
    private CellInfo value;

    public Parameter(String label, String value) {
        this.label = new CellInfo(label, CellInfo.TEXT);
        this.value = new CellInfo(value, CellInfo.TEXT, Alignment.RIGHT);
    }


    public CellInfo getLabel() {
        return label;
    }

    public void setLabel(CellInfo label) {
        this.label = label;
    }

    public CellInfo getValue() {
        return value;
    }

    public void setValue(CellInfo value) {
        this.value = value;
    }
}
