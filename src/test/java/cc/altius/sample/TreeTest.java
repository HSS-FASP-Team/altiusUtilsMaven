/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.sample;

import cc.altius.utils.TreeUtils.Node;
import cc.altius.utils.TreeUtils.Tree;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author akil
 */
public class TreeTest {

    public static void main(String[] args) throws Exception {
        new TreeTest().run();
    }

    private void run() throws Exception {
        List<Category> list = new LinkedList<>();
        list.add(new Category(1, "All Product Categories", null));
        list.add(new Category(2, "Heaters", 1));
        list.add(new Category(3, "Pumps", 1));
        list.add(new Category(4, "Water Purifiers", 1));
        list.add(new Category(5, "Bajaj Water Heater", 2));
        list.add(new Category(6, "Havels Water Heater", 2));
        list.add(new Category(7, "3M Water purifier", 4));
        list.add(new Category(8, "Model 3M100121", 7));
        list.add(new Category(9, "Model 3MB23465", 7));
        list.add(new Category(10, "Crompton pump", 3));
        list.add(new Category(11, "Usha pump", 3));

        Tree<Category> t = null;
        boolean isFirst = true;
        for (Category c : list) {
            Node n = new Node(c.getCategoryId(), c.getParentCategoryId(), c, c.getCategoryId());
            if (isFirst) {
                t = new Tree<>(n);
                isFirst = false;
            } else {
                t.addNode(n);
            }
        }

        System.out.println("");
        System.out.println("");
        t.getTreeFullList().forEach((node) -> {
            System.out.println(pad(node.getLevel() * 4) + node);
        });
        
        System.out.println("");
        System.out.println("");
        t.getTreeSubList(1, false, 1).forEach((node) -> {
            System.out.println(pad(node.getLevel() * 4) + node);
        });
        
        System.out.println("");
        System.out.println("");
        t.getTreeSubList(4, false, 1).forEach((node) -> {
            System.out.println(pad(node.getLevel() * 4) + node);
        });
        
        System.out.println("");
        System.out.println("");
        t.getTreeSubList(7, false, 1).forEach((node) -> {
            System.out.println(pad(node.getLevel() * 4) + node);
        });
        
        System.out.println("");
        System.out.println("");
        t.getPayloadSubList(7, true, -1).forEach((c) -> {
            System.out.println(c);
        });
        
    }

    private class Category implements Serializable {

        private int categoryId;
        private String categoryName;
        private Integer parentCategoryId;

        public Category() {
        }

        public Category(int categoryId, String categoryName, Integer parentCategoryId) {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
            this.parentCategoryId = parentCategoryId;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public Integer getParentCategoryId() {
            return parentCategoryId;
        }

        public void setParentCategoryId(Integer parentCategoryId) {
            this.parentCategoryId = parentCategoryId;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 13 * hash + this.categoryId;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Category other = (Category) obj;
            if (this.categoryId != other.categoryId) {
                return false;
            }
            return true;
        }

        @Override
        public String toString() {
            return "Category{" + "categoryId=" + categoryId + ", categoryName=" + categoryName + ", parentCategoryId=" + parentCategoryId + '}';
        }

    }

    private String pad(int count) {
        String tmpString = "";
        for (int x = 0; x < count; x++) {
            tmpString += " ";
        }
        return tmpString;
    }

}
