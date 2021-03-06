/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metadata;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Vector;

/**
 *
 * @author himos
 */
public class MultColumnSorter implements Comparator {
    
            int colIndex1;
            int colIndex2;
            boolean ascending;
    MultColumnSorter(int colIndex1, int colIndex2, boolean ascending) {
        this.colIndex1 = colIndex1;
        this.colIndex2 = colIndex2;
        this.ascending = ascending;
    }
    
    
    public int compare(Object a, Object b) {
        Vector v1 = (Vector)a;
        Vector v2 = (Vector)b;
        Object o1 = v1.get(colIndex1);
        Object o2 = v2.get(colIndex1);
         // Treat empty strains like nulls
        if (o1 instanceof String && ((String)o1).length() == 0) {
            o1 = null;
        }
        if (o2 instanceof String && ((String)o2).length() == 0) {
            o2 = null;
        }

        // Sort nulls so they appear last, regardless
        // of sort order
        double ax= Double.parseDouble(v1.elementAt(colIndex1).toString())+Double.parseDouble(v1.elementAt(colIndex2).toString());
        double ay= Double.parseDouble(v2.elementAt(colIndex1).toString())+Double.parseDouble(v2.elementAt(colIndex2).toString());
        o1=(Object) ax;
        o2=(Object) ay;
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return 1;
        } else if (o2 == null) {
            return -1;
        } else if (o1 instanceof Comparable) {
            if (ascending) {
                  return ((Comparable)o1).compareTo(o2);
            } else {
                return ((Comparable)o2).compareTo(o1);
            }
        } else {
            if (ascending) {
                return o1.toString().compareTo(o2.toString());
            } else {
                return o2.toString().compareTo(o1.toString());
            }
        }
           
           
            
        
    }
}
