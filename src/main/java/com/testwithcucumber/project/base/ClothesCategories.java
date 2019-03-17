package com.testwithcucumber.project.base;

public enum ClothesCategories {
    TSHIRTS("T-shirts", "Tops"),
    BLOUSES("Blouses", "Tops"),
    CASUALDRESSES("Casual Dresses", "Dresses"),
    EVENINGDRESSES("Evening Dresses", "Dresses"),
    SUMMERDRESSES("Summer Dresses", "Dresses");

    private String subcategoryName;
    private String categoryName;

    ClothesCategories(String subcategoryName, String categoryName) {
        this.subcategoryName = subcategoryName;
        this.categoryName = categoryName;
    }

    /** Getter for Subcategory name */
    public String getSubcategoryName() {
        return subcategoryName;
    }

    /** Getter for Category name */
    public String getCategoryName() {
        return categoryName;
    }
}
