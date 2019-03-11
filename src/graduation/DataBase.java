/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graduation;

import graduation.test.Result;
import graduation.test.Result1;
import graduation.test.Result2;
import graduation.test.Result3;
import graduation.test.Test;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MVS19
 */
public final class DataBase {
    private Path path;
    private Scanner scanner;
    private String title;
    private ArrayList<Candidate> candidates;
    private ArrayList<Test> tests;
    
    public DataBase(String filePath) throws IOException {
        this.path = Path.of(filePath);
        this.scanner = new Scanner(this.getPath());
        this.title = this.scanner.nextLine();
        
        this.scanner.nextLine();
        this.scanner.nextLine();
        
        readCandidates();
        readTests();
        
        System.out.println("Данные готовы к работе!");
    }
    
    public void readCandidates() {
        var list = new ArrayList<Candidate>();
        Pattern p = Pattern.compile("(\\d*)\\.\\s(\\W+)");
        String line = this.scanner.nextLine();
        while(line.equals("") == false) {
            Matcher m = p.matcher(line);
            if(m.matches()) {
                String name = m.group(2);
                list.add(new Candidate(name));
            }
            
            line = this.scanner.nextLine();
        }
        
        this.candidates = list;
        
    }
    
    public int findCandidateIndex(String name) {
        int count = this.candidates.size();
        for(int i = 0; i < count; i++) {
            if(this.candidates.get(i).getName().equals(name)) {
                return i;
            }
        }

        return -1;
    }

    public void readTests() {
        this.tests = new ArrayList<Test>();
        while(this.scanner.hasNextLine()) {
            String line = this.scanner.nextLine();
            if(line.equals("") == false) {
                String title = line;
                line = this.scanner.nextLine();
                
                // Read event type
                Pattern p = Pattern.compile("^\\W*\\:\\s\\№(\\d+).*$");
                Matcher m = p.matcher(line);
                if(m.matches()) {
                    String description = line;
                    int blockType = Integer.parseInt(m.group(1));
                    this.tests.add(readTest(title, description, blockType));
                }
                
            } 
            
        }
        
    }
    
    public Test readTest(String title, String description, int type) {
        Test t = new Test(title, description, type);
        switch (type) {
            case 1: {
                // Read required marks sum
                String line = this.scanner.nextLine();
                Pattern p = Pattern.compile("^.*:\\s(\\d+)$");
                Matcher m = p.matcher(line);
                if(m.matches()) {
                    int requiredMarkSum = Integer.parseInt(m.group(1));
                    
                    // Read marks
                    p = Pattern.compile("(.+) - (\\d), (\\d)");
                    while(line.equals("") == false) {
                        m = p.matcher(line);
                        if(m.matches()) {
                            String name = m.group(1);
                            int index = findCandidateIndex(name);
                            Candidate c = this.candidates.get(index);
                            
                            int mark1 = Integer.parseInt(m.group(2));
                            int mark2 = Integer.parseInt(m.group(3));

                            Result1 r = new Result1();
                            r.setTest(t);
                            r.setCandidate(c);
                            r.setMark1(mark1);
                            r.setMark2(mark2);
                            r.setRequiredMarkSum(requiredMarkSum);

                            c.getResults().add(r);
                            t.getResults().add(r);
                            t.getCandidates().add(c);
                        }

                        if(this.scanner.hasNextLine()) {
                            line = this.scanner.nextLine();
                        } else {
                            break;
                        }

                    }
                    
                }
                
                break;
            }
            
            case 2: {
                // Read required minimum for a mark
                String line = this.scanner.nextLine();
                Pattern p = Pattern.compile("^.*:\\sпо\\s(\\d+\\.\\d)$");
                Matcher m = p.matcher(line);
                if(m.matches()) {
                    float requiredMinimalMark = Float.parseFloat(m.group(1));
                
                    // Read marks
                    p = Pattern.compile("(.+) - (\\d\\.\\d|\\d), (\\d\\.\\d|\\d)");
                    while(line.equals("") == false) {
                        m = p.matcher(line);
                        if(m.matches()) {
                            String name = m.group(1);
                            int index = findCandidateIndex(name);
                            Candidate c = this.candidates.get(index);
                            
                            float mark1 = Float.parseFloat(m.group(2));
                            float mark2 = Float.parseFloat(m.group(3));

                            Result2 r = new Result2();
                            r.setTest(t);
                            r.setCandidate(c);
                            r.setMark1(mark1);
                            r.setMark2(mark2);
                            r.setRequiredMinimalMark(requiredMinimalMark);
                            
                            c.getResults().add(r);
                            t.getResults().add(r);
                            t.getCandidates().add(c);
                        }

                        if(this.scanner.hasNextLine()) {
                            line = this.scanner.nextLine();
                        } else {
                            break;
                        }

                    }
                    
                }
            
                break;
            }
            
            case 3: {
                // Read required minimal mark
                String line = this.scanner.nextLine();
                Pattern p = Pattern.compile("^.*:\\s(\\d+)$");
                Matcher m = p.matcher(line);
                if(m.matches()) {
                    int requiredMinimalMark = Integer.parseInt(m.group(1));
                
                    // Read marks
                    p = Pattern.compile("(.+) - (сдано|не сдано), (сдано|не сдано), (\\d*)");
                    while(line.equals("") == false) {
                        m = p.matcher(line);
                        if(m.matches()) {
                            String name = m.group(1);
                            int index = findCandidateIndex(name);
                            Candidate c = this.candidates.get(index);

                            boolean mark1 = false;
                            if (m.group(2).equals("сдано")) {
                                mark1 = true;
                            } else if (m.group(2).equals("не сдано")) {
                                mark1 = false;
                            }

                            boolean mark2 = false;                        
                            if (m.group(3).equals("сдано")) {
                                mark2 = true;
                            } else if (m.group(3).equals("не сдано")) {
                                mark2 = false;
                            }   

                            int mark3 = Integer.parseInt(m.group(4));

                            Result3 r = new Result3();
                            r.setTest(t);
                            r.setCandidate(c);
                            r.setMark1(mark1);
                            r.setMark2(mark2);
                            r.setMark3(mark3);
                            r.setRequiredMinimalMark3(requiredMinimalMark);
                            
                            c.getResults().add(r);
                            t.getResults().add(r);
                            t.getCandidates().add(c);
                        }

                        if(this.scanner.hasNextLine()) {
                            line = this.scanner.nextLine();
                        } else {
                            break;
                        }

                    }
                    
                }

                break;
            }
            
        }
        
        return t;
        
    }

    /**
     * @return the path
     */
    public Path getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(Path path) {
        this.path = path;
    }

    /**
     * @return the scanner
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * @param scanner the scanner to set
     */
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * @return the databaseTitle
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the databaseTitle to set
     */
    public void setTitle(String title) {
        this.title = title;
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
     * @return the tests
     */
    public ArrayList<Test> getTests() {
        return tests;
    }

    /**
     * @param tests the tests to set
     */
    public void setTests(ArrayList<Test> tests) {
        this.tests = tests;
    }
    
    public void printTestsAndMarks(ArrayList<Test> list) {
        for(Test t : list) {
            System.out.println();
            System.out.println(t.getTitle());
            System.out.println(t.getDescription());
            for(Result r : t.getResults()) {
                StringBuilder SB = new StringBuilder();
                SB.append(r.getCandidate().getName());
                SB.append(" - ");
                SB.append(r.getMarks());
                System.out.println(SB);
            }
            
        }
        
    }
    
    public void printCandidates(ArrayList<Candidate> list) {
        int i = 0;
        for(Candidate c : list) {
            i++;
            System.out.println(i + ". " + c.getName());
        }
        
    }
    
}
