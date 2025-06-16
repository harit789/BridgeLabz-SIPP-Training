public class DivideEqually{
	public static void main (String [] args){
		int pens = 14;
		int students = 3;
		int remaining_Pens = 14%3;
		int pens_Given = (pens-remaining_Pens)/students;
		System.out.println("Pens equally divided:" +pens_Given);
		System.out.println("Pens remaining :" +remaining_Pens);
	}
}
