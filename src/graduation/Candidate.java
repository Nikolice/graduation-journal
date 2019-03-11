/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation;

import graduation.test.Result;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author MVS19
 */
public class Candidate {
    private String name;
    private ArrayList<Result> results;
    private ArrayList<Result> resultsGood;
    private ArrayList<Result> resultsBad;
    
    Candidate(String name) {
        this.name = name;
        this.results = new ArrayList<>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the results
     */
    public ArrayList<Result> getResults() {
        return results;
    }

    /**
     * @param events the results to set
     */
    public void setResults(ArrayList<Result> events) {
        this.results = events;
    }
    
    /**
     * @return the resultsGood
     */
    public ArrayList<Result> getResultsGood() {
        return resultsGood;
    }

    /**
     * @param resultsGood the resultsGood to set
     */
    public void setResultsGood(ArrayList<Result> resultsGood) {
        this.resultsGood = resultsGood;
    }

    /**
     * @return the resultsBad
     */
    public ArrayList<Result> getResultsBad() {
        return resultsBad;
    }

    /**
     * @param resultsBad the resultsBad to set
     */
    public void setResultsBad(ArrayList<Result> resultsBad) {
        this.resultsBad = resultsBad;
    }
    
    public void sortByMarks() {
        this.results.sort(new Comparator<Result>() {
            @Override
            public int compare(Result t1, Result t2) {
                return (int) (t1.getMaximumMark() - t2.getMaximumMark());
            }
        });

    }
    
    public void divideTestsByPass() {
        this.resultsGood = new ArrayList<>();
        this.resultsBad = new ArrayList<>();
        for(Result t : this.getResults()) {
            if(t.isPassed()) {
                this.resultsGood.add(t);
            } else {
                this.resultsBad.add(t);
            }
            
        }
        
    }
    
    public void printSortedMarks() {
        System.out.println("Пройденные мероприятия:");
        for(Result r : this.getResultsGood()) {
            r.getTest().printInfo();
            r.printMarks();
        }
        
        System.out.println();
        
        System.out.println("Не пройденные мероприятия:");
        for(Result r : this.getResultsBad()) {
            r.getTest().printInfo();
            r.printMarks();
        }
        
    }
    
    public void printAboutLowMarks() {
        boolean hasLowMarks = false;
        for(Result t : this.getResults()) {
            if(t.isLowMark()) {
                hasLowMarks = true;
                System.out.println("Есть низкая отметка (4-5, из 10).");
                break;
            }
            
        }
        
        if (hasLowMarks == false) {
            System.out.println("Нет низких отметок (4-5, из 10).");
        }
        
    }
    
}
