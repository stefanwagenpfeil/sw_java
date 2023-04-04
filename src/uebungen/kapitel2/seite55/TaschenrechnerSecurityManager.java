package uebungen.kapitel2.seite55;

public class TaschenrechnerSecurityManager implements ITaschenrechner {
	private ITaschenrechner t;
	
	public void setITaschenrechner(ITaschenrechner t) {
		this.t = t;
	}
	
	public int add(int x, int y) {
		String user = SecurityManager.getCurrentUser();
		int result = 0;
		if (SecurityManager.hasAccessToMethod(user, "add")) {
			result = t.add(x, y);
		}
		else {
			throw new RuntimeException("Benutzer nicht berechtigt");
		}
		return result;
	}

	public int sub(int x, int y) {
		String user = SecurityManager.getCurrentUser();
		int result = 0;
		if (SecurityManager.hasAccessToMethod(user, "sub")) {
			result = t.add(x, y);
		}
		else {
			throw new RuntimeException("Benutzer nicht berechtigt");
		}
		return result;
	}
}


class SecurityManager {
	public static String getCurrentUser() {
		System.out.println("getCurrentUser");
		// kommt normalerweise aus dem Backend
		return "Stefan";
	}
	
	public static boolean hasAccessToMethod(String user, String method) {
		System.out.println("hasAccessToMethod");
		// kommt ebenfalls aus dem Backend
		return true;
	}
}
