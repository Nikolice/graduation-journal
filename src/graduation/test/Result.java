/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation.test;

import graduation.Candidate;

/**
 *
 * @author MVS19
 */
public abstract class Result {
    private Test test;
    private Candidate candidate;
    public abstract boolean isPassed();
    public abstract float getMaximumMark();
    public abstract String getMarks();
    public abstract boolean isLowMark();
    
    public void printMarks() {
        System.out.println(this.getMarks());
    }

    /**
     * @return the test
     */
    public Test getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(Test test) {
        this.test = test;
    }

    /**
     * @return the candidate
     */
    public Candidate getCandidate() {
        return candidate;
    }

    /**
     * @param candidate the candidate to set
     */
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
    
}
