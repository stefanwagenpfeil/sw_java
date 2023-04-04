package uebungen.kapitel2.seite55;

public class TaschenrechnerFactory {
	public static ITaschenrechner getITaschenrechner() {
		// Kette aus Interceptoren aufbauen
		Taschenrechner t = new Taschenrechner();
		TaschenrechnerLogger logger = new TaschenrechnerLogger();
		TaschenrechnerSecurityManager security = new TaschenrechnerSecurityManager();
		
		logger.setITaschenrechner(t);
		security.setITaschenrechner(logger);
		
		return security;
	}
}
