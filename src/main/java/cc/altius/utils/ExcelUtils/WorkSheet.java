/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.utils.ExcelUtils;

import java.util.ArrayList;

/**
 *
 * @author akil
 */
public class WorkSheet {

    private String title;
    private ArrayList<Parameter> parameters;
    private ArrayList<BodyRow> bodyRows;

    public ArrayList<BodyRow> getBodyRows() {
        return bodyRows;
    }

    public void setBodyRows(ArrayList<BodyRow> bodyRows) {
        this.bodyRows = bodyRows;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getColumns() {
        int cols = 0;
        if (this.bodyRows != null) {
            if (this.bodyRows.get(0) != null) {
                if (this.bodyRows.get(0).getValues() != null) {
                    cols = this.bodyRows.get(0).getValues().size();
                }
            }
        }
        return cols;
    }

    public int getRows() {
        if (this.bodyRows != null) {
            return this.bodyRows.size();
        } else {
            return 0;
        }
    }

    public ArrayList<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(ArrayList<Parameter> parameters) {
        this.parameters = parameters;
    }

}
