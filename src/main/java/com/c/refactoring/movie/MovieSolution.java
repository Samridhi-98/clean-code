package com.c.refactoring.movie;

import com.c.refactoring.StringUtils;

import java.util.Arrays;
import java.util.List;

public class MovieSolution {
    private String rating;
    private final List<String> VALID_B_RATINGS_LIST = Arrays.asList("B1","B2","B3","B4");

    public MovieSolution(String rating) {
        super();
        this.rating = rating;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public boolean isValidRating() {
        if (this.getRating() == null) {
            return false;
        }

        if (isValidARating()){
            return true;
        }

        if (isValidBRating()) {
            return true;
        }

        return false;
    }

    private boolean isValidBRating() {
        return VALID_B_RATINGS_LIST.contains(rating);
    }

    private boolean isValidARating() {
        return this.getRating().substring(0, 1).equalsIgnoreCase("A") && this.getRating().length() == 3 && StringUtils.isNumeric(this.getRating().substring(1, 3));
    }

}
