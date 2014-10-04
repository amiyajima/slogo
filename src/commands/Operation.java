package commands;

public interface Operation {
	public int evaluate(int arg0);
	public int evaluate(int arg0, int arg1);
	public int evaluate(int arg0, Command arg1);
}
