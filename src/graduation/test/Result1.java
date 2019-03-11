/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation.test;

/**
 *
 * @author MVS19
 */
public class Result1 extends Result {
    private int Mark1;
    private int Mark2;
    private int RequiredMarkSum;
    
    @Override
    public boolean isPassed() {
        return (getMark1() + getMark2() >= getRequiredMarkSum());
    }

    @Override
    public float getMaximumMark() {
        if (getMark1() >= getMark2()) return getMark1();
        else return getMark2();
    }

    /**
     * @return the Mark1
     */
    public int getMark1() {
        return Mark1;
    }

    /**
     * @param Mark1 the Mark1 to set
     */
    public void setMark1(int Mark1) {
        this.Mark1 = Mark1;
    }

    /**
     * @return the Mark2
     */
    public int getMark2() {
        return Mark2;
    }

    /**
     * @param Mark2 the Mark2 to set
     */
    public void setMark2(int Mark2) {
        this.Mark2 = Mark2;
    }

    /**
     * @return the RequiredMarkSum
     */
    public int getRequiredMarkSum() {
        return RequiredMarkSum;
    }

    /**
     * @param RequiredMarkSum the RequiredMarkSum to set
     */
    public void setRequiredMarkSum(int RequiredMarkSum) {
        this.RequiredMarkSum = RequiredMarkSum;
    }

    @Override
    public String getMarks() {
        StringBuilder SB = new StringBuilder();
        SB.append("Оценка №1: ").append(this.getMark1()).append("; ");
        SB.append("оценка №2: ").append(this.getMark2()).append(". ");
        return SB.toString();
    }
    
    
    @Override
    public boolean isLowMark() {
        float maxMark = this.getMaximumMark();
        return (maxMark >= 4 && maxMark <= 5);
    }
    
}
