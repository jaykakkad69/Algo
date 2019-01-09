import java.io.*;
import java.util.*;

class Sub implements Comparable<Sub>{
    int score,num;
    public Sub(int score){
	this.score = score;
        //this.num = num;
    }
    
    public void setNum(int num){
	this.num = num;
    }
    public int getS(){
	return this.score;
    }
    public int getN(){
	return this.num;
    }
    public int compareTo(Sub s){
	int a = this.score, b = s.getS();
	int cmp = a > b ? +1 : a < b ? -1 : 0;
	return cmp;
    }
}

class Problem implements Comparable<Problem>{
    int i,d;
    ArrayList<Sub> s = new ArrayList<Sub>();
    public Problem(int i){
	this.i = i;
    }

    public int getDiff(){
	return this.d;
    }
    public int getI(){
	return this.i;
    }
    public int getD(){
	return this.d;
    }
    public int compareTo(Problem p){
	int a = this.d, b = p.getDiff();
	int cmp = a > b ? +1 : a < b ? -1 : 0;
	return cmp;
    }

    public void diff(){
	Collections.sort(s);
	for(int i=0; i<s.size()-1; i++){
	    if(s.get(i).getN() > s.get(i+1).getN())
		this.d++;
	}
    }
}

public class Problems{
    public static void main(String[] arg){
	Scanner scan = new Scanner(System.in);
	int noOfProblems = scan.nextInt();
	int noOfSubProblems = scan.nextInt();

	ArrayList<ArrayList<Integer>> f = new ArrayList<ArrayList<Integer>>();
	for(int i=0; i<30; i++)
	    f.add(new ArrayList<Integer>());

	for(int i=0; i<noOfProblems; i++){
	    Problem temp = new Problem(i+1);
	    for(int j=0; j<noOfSubProblems; j++)
		temp.s.add(new Sub(scan.nextInt()));

	    for(int j=0; j<noOfSubProblems; j++)
		temp.s.get(j).setNum(scan.nextInt());

	    temp.diff();
	    f.get(temp.getD()).add(temp.getI());
	}

	for(int i=0; i<30; i++){
	    if(!f.get(i).isEmpty())
		for(int j=0; j<f.get(i).size(); j++)
		    System.out.println(f.get(i).get(j));
	}
    }
}

