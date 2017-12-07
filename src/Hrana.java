
public class Hrana {

	private String tipKuh;
	private String predjelo;
	private double cenaPredjela;
	private String dezert;
	private double cenaDezerta;
	public Hrana(String tipKuh, String predjelo, double cenaPredjela, String dezert, double cenaDezerta) {
		super();
		this.tipKuh = tipKuh;
		this.predjelo = predjelo;
		this.cenaPredjela = cenaPredjela;
		this.dezert = dezert;
		this.cenaDezerta = cenaDezerta;
	}
	public String getTipKuh() {
		return tipKuh;
	}
	public String getPredjelo() {
		return predjelo;
	}
	public double getCenaPredjela() {
		return cenaPredjela;
	}
	public String getDezert() {
		return dezert;
	}
	public double getCenaDezerta() {
		return cenaDezerta;
	}
	
	public String toString(){
		return tipKuh+";"+predjelo+";"+cenaPredjela+";"+dezert+";"+cenaDezerta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cenaDezerta);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(cenaPredjela);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((dezert == null) ? 0 : dezert.hashCode());
		result = prime * result + ((predjelo == null) ? 0 : predjelo.hashCode());
		result = prime * result + ((tipKuh == null) ? 0 : tipKuh.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hrana other = (Hrana) obj;
		if (Double.doubleToLongBits(cenaDezerta) != Double.doubleToLongBits(other.cenaDezerta))
			return false;
		if (Double.doubleToLongBits(cenaPredjela) != Double.doubleToLongBits(other.cenaPredjela))
			return false;
		if (dezert == null) {
			if (other.dezert != null)
				return false;
		} else if (!dezert.equals(other.dezert))
			return false;
		if (predjelo == null) {
			if (other.predjelo != null)
				return false;
		} else if (!predjelo.equals(other.predjelo))
			return false;
		if (tipKuh == null) {
			if (other.tipKuh != null)
				return false;
		} else if (!tipKuh.equals(other.tipKuh))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
