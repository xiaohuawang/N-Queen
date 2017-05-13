package test;

public class Queen {

	int row;
	int col;
	int queenNum=4;
	//queens[col]=row
	int queens[]=new int[queenNum+1];
	boolean rowExist[]=new boolean[queenNum+1];
	boolean a[]=new boolean[queenNum*2];
	boolean b[]=new boolean[queenNum*2];
	
	public void inti(){
		
		for(int i=1;i<queenNum+1;i++){
			rowExist[i]=false;
		}
		
		for(int i=1;i<queenNum*2+1;i++){
			a[i]=false;
			b[i]=false;
		}
	}
	
	public boolean isExist(int row, int col){
		if(rowExist[row]==true||a[row+col-1]==true||b[queenNum+col-row]){
			return true;
		}else{
			return false;
		}
	}

	public void mark(int row, int col) {
		System.out.println("mark function"+"                row= "+row+" col= "+col);
		rowExist[row]=true;
		a[row+col-1]=true;
		b[queenNum+col-row]=true;
	}	
	
	public void unmark(int row, int col){
		rowExist[row]=false;
		a[row+col-1]=false;
		b[queenNum+col-row]=false;
	}
	//test
	
	public void testing(int col){
		for(int row=1;row<queenNum+1;row++){
			System.out.println("row= "+row+" col= "+col+" answer= "+isExist(row,col));
			if(!isExist(row,col)){
				//queens[row]=col;
				queens[col]=row;
				mark(row,col);
				if(col!=queenNum){
					testing(col+1);
				}else{
					for(col=1;col<queenNum+1;col++){
						System.out.print(" ("+queens[col]+","+col+") ");
					}
				}
				//backtrack 
				System.out.println("                             roll back");
				unmark(row,col);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Queen q=new Queen();
		// row=2 col=3
		q.queens[2]=3;
		q.row=2;
		q.col=3;
		
//		System.out.println(q.isExist(2, 2));
//		q.mark(q.row,q.col);
//		System.out.println(q.isExist(2, 2));
		q.testing(1);
		
	}

}














