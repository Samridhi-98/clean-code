package com.b.simple.design.business.student;

public class StudentHelperSolution {

    private final int EXTRA_LIMIT_FOR_MATH = 10;
    private final int GRADE_B_UPPER_LIMIT = 80;
    private final int GRADE_B_LOWER_LIMIT = 51;

    public boolean isGradeB(int marks, boolean isMaths) {
        int extraLimit = isMaths ? EXTRA_LIMIT_FOR_MATH : 0;
        int upperLimit = GRADE_B_UPPER_LIMIT + extraLimit;

        return marks >= GRADE_B_LOWER_LIMIT && marks <= upperLimit;
    }
}
