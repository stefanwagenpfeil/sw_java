package uebungen.kapitel2.seite55;

public class TaschenrechnerLogger implements ITaschenrechner {
	private ITaschenrechner t;
	
	public void setITaschenrechner(ITaschenrechner t) {
		this.t = t;
	}
	
	public int add(int x, int y) {
		System.out.println("LOG: add " + x + "+" + y);
		int result = t.add(x, y);
		System.out.println("LOG: result " + result);
		return result;
	}

	public int sub(int x, int y) {
		System.out.println("LOG: sub " + x + "+" + y);
		int result = t.add(x, y);
		System.out.println("LOG: result " + result);
		return result;
	}
}
