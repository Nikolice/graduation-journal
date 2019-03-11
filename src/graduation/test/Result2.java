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
public class Result2 extends Result {

    /**
     * @return the Mark1
     */
    public float getMark1() {
        return Mark1;
    }

    /**
     * @param Mark1 the Mark1 to set
     */
    public void setMark1(float Mark1) {
        this.Mark1 = Mark1;
    }

    /**
     * @return the Mark2
     */
    public float getMark2() {
        return Mark2;
    }

    /**
     * @param Mark2 the Mark2 to set
     */
    public void setMark2(float Mark2) {
        this.Mark2 = Mark2;
    }

    /**
     * @return the RequiredMinimalMark
     */
    public float getRequiredMinimalMark() {
        return RequiredMinimalMark;
    }

    /**
     * @param RequiredMinimalMark the RequiredMinimalMark to set
     */
    public void setRequiredMinimalMark(float RequiredMinimalMark) {
        this.RequiredMinimalMark = RequiredMinimalMark;
    }
    private float Mark1;
    private float Mark2;
    private float RequiredMinimalMark;
    
    @Override
    public boolean isPassed() {
        return 
                (
                    (getMark1() >= getRequiredMinimalMark()) 
                && 
                    (getMark2() >= getRequiredMinimalMark())
                );
    }
    
    @Override
    public float getMaximumMark() {
        if (getMark1() >= getMark2()) return getMark1();
        else return getMark2();
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
