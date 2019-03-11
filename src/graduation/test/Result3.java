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
public class Result3 extends Result {
    private boolean Mark1;
    private boolean Mark2;
    private int Mark3;
    private int RequiredMinimalMark3;

    @Override
    public boolean isPassed() {
        return (isMark1() && isMark2() && (getMark3() >= getRequiredMinimalMark3()));
    }
    
    @Override
    public float getMaximumMark() {
        return (getMark3() / 10);
    }

    /**
     * @return the Mark1
     */
    public boolean isMark1() {
        return Mark1;
    }
    
    public String getMark1() {
        if (this.Mark1 == true) {
            return "сдано";
        } else {
            return "не сдано";
        }
        
    }

    /**
     * @param Mark1 the Mark1 to set
     */
    public void setMark1(boolean Mark1) {
        this.Mark1 = Mark1;
    }

    /**
     * @return the Mark2
     */
    public boolean isMark2() {
        return Mark2;
    }

    public String getMark2() {
        if (this.Mark2 == true) {
            return "сдано";
        } else {
            return "не сдано";
        }
        
    }
    
    /**
     * @param Mark2 the Mark2 to set
     */
    public void setMark2(boolean Mark2) {
        this.Mark2 = Mark2;
    }

    /**
     * @return the Mark3
     */
    public int getMark3() {
        return Mark3;
    }

    /**
     * @param Mark3 the Mark3 to set
     */
    public void setMark3(int Mark3) {
        this.Mark3 = Mark3;
    }

    /**
     * @return the RequiredMinimalMark3
     */
    public int getRequiredMinimalMark3() {
        return RequiredMinimalMark3;
    }

    /**
     * @param RequiredMinimalMark3 the RequiredMinimalMark3 to set
     */
    public void setRequiredMinimalMark3(int RequiredMinimalMark3) {
        this.RequiredMinimalMark3 = RequiredMinimalMark3;
    }
    
    @Override
    public String getMarks() {
        StringBuilder SB = new StringBuilder();
        SB.append("Оценка №1: ").append(this.getMark1()).append("; ");
        SB.append("оценка №2: ").append(this.getMark2()).append("; ");
        SB.append("оценка №3: ").append(this.getMark3()).append(". ");
        return SB.toString();
    }
    
    @Override
    public boolean isLowMark() {
        float maxMark = this.getMaximumMark();
        return (maxMark >= 4 && maxMark <= 5);
    }
    
}
