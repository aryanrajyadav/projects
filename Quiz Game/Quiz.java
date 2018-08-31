import java.util.*;
class Quiz
{
	static Scanner scan;
	static LinkedList<Questions> questions;
	static  int cntQue;
	static
	{
		scan=new Scanner(System.in);
		questions=new LinkedList<Questions>();
		cntQue=1;
	}
	private boolean addQue()
	{
		Questions que=new Questions();
		que.setId(cntQue);
		System.out.println("\n\nEnter Questions : ");
		scan.nextLine();
		que.setQue(scan.nextLine());
		char choice;
		int i=1;
		do
		{
			Options op=new Options();
			op.setId(i);
			System.out.print("\nEnter Options ("+((char)(i+64))+") : ");
			op.setOption(scan.nextLine());
			que.options.add(op);
			System.out.println("Do you want to add more Options(y/n) : ");
			choice=scan.nextLine().charAt(0);
			i++;
		}while(choice=='y' || choice=='Y');
		System.out.println("Enter correct Answer (A/B/C/D) : ");
		que.setAnswer(scan.nextLine().charAt(0)-64);
		questions.add(que);
		cntQue++;
		return true;
	}
	private void play()
	{
		System.out.println("\n\n\n\n\n*************************************");
		System.out.println("Play Quiz");
		Iterator qIterator=questions.iterator();
		int queCnt=1;
		int crr=0;
		int wrg=0;
		scan.nextLine();
		while(qIterator.hasNext())
		{
			Questions que=(Questions)qIterator.next();
			System.out.println("\n\n\n\n\n*************************************");
			System.out.println("Que "+queCnt+": "+que.getQue());
			System.out.println("\n\n\n\n\n*************************************");
			System.out.println("Options are : \n\n");
			Iterator oIterator=que.options.iterator();
			while(oIterator.hasNext())
			{
				Options op=(Options)oIterator.next();
				System.out.println((char)(op.getId()+64)+")"+op.getOption());
			}
			System.out.print("Enter Choice : ");
			if((scan.nextLine().charAt(0)-64)==que.getAnswer())
			{
				crr++;
			}
			else
			{
				wrg++;
			}
		}
		System.out.println("\n\n Right answer : "+crr);
		System.out.println("Wrong answer : "+wrg);
		System.out.println("Avg : "+crr/(crr+wrg));
	}
	public static void main(String...s)
	{
		Quiz quiz=new Quiz();
		while(true)
		{
			System.out.println("1. Add Que");
			System.out.println("2. Play");
			System.out.println("0. Exit");
			System.out.println("Enter Choice : ");
			switch(scan.nextInt())
			{
				case 1:
					if(quiz.addQue())
					{
						System.out.println("\n\n\n************************");
						System.out.println(" Que Added");
						System.out.println("**********************");
					}
					break;
				case 2:
					quiz.play();
					break;
				case 0:
					System.exit(0);
					break;
			}
		}	
	}
}