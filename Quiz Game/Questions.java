import java.util.*;
public class Questions
{
	private int id;
	private String que;
	public LinkedList<Options> options;
	private int answer;
	public Questions()
	{
		options=new LinkedList<Options>();
	}
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setQue(String que)
	{
		this.que=que;
	}
	public String getQue()
	{
		return que;
	}
	public void setAnswer(int answer)
	{
		this.answer=answer;
	}
	public int getAnswer()
	{
		return answer;
	}
}