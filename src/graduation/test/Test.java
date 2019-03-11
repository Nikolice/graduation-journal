/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation.test;

import graduation.Candidate;
import java.util.ArrayList;

/**
 *
 * @author MVS19
 */
public class Test {
    private String title;
    private String description;
    private int type;
    private ArrayList<Candidate> candidates;
    private ArrayList<Result> results;
    
    public Test(String title, String description, int type) {
        this.setTitle(title);
        this.setDescription(description);
        this.setType(type);
        this.results = new ArrayList<>();
        this.candidates = new ArrayList<>();
    }
    
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void print() {
        System.out.println(this.getTitle());
        System.out.println(this.getDescription());
    }

    /**
     * @return the candidates
     */
    public ArrayList<Candidate> getCandidates() {
        return candidates;
    }

    /**
     * @param candidates the candidates to set
     */
    public void setCandidates(ArrayList<Candidate> candidates) {
        this.candidates = candidates;
    }

    /**
     * @return the results
     */
    public ArrayList<Result> getResults() {
        return results;
    }

    /**
     * @param results the results to set
     */
    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }
    
    public void printInfo() {
        StringBuilder SB = new StringBuilder();
        SB.append('\n');
        SB.append("Название мероприятия: ");
        SB.append(this.getTitle());
        SB.append('\n');
        SB.append("Описание мероприятия: ");
        SB.append(this.getDescription());
        System.out.println(SB);
    }
    
}
