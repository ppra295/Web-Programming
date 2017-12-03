package Midterm;

public class Bean {
int op1, op2;
char op;
int currectAnswer;

public Bean(){
	int Oprations = (int)(Math.random()* 10 % 4);
	op1 = (int)(Math.random()* 10 + 5);
	op2 = (int)(op1 * Math.random()* 10 % 5 );
	
	 
	
	switch(Oprations){
		case 0 : op = '+'; currectAnswer = op1 + op2; break;
		case 1 : op = '-'; currectAnswer = op1 - op2; break;
		case 2 : op = '*'; currectAnswer = op1 * op2; break;
		case 3 : op = '/'; currectAnswer = op1 / op2; break;
	}
}

public int getOp1() {
	return op1;
}

public void setOp1(int op1) {
	this.op1 = op1;
}

public int getOp2() {
	return op2;
}

public void setOp2(int op2) {
	this.op2 = op2;
}

public char getOp() {
	return op;
}

public void setOp(char op) {
	this.op = op;
}

public int getCurrectAnswer() {
	return currectAnswer;
}

public void setCurrectAnswer(int currectAnswer) {
	this.currectAnswer = currectAnswer;
}

}
