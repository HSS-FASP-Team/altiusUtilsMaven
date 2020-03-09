/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.utils.ExcelUtils;

import java.util.ArrayList;
import jxl.format.Colour;

/**
 *
 * @author akil
 */
public class BodyRow {

    private Colour rowColour;
    private ArrayList<CellInfo> values;

    public Colour getRowColour() {
        return rowColour;
    }

    public void setRowColour(Colour rowColour) {
        this.rowColour = rowColour;
    }

    public ArrayList<CellInfo> getValues() {
        return values;
    }

    public void setValues(ArrayList<CellInfo> values) {
        this.values = values;
    }
}
