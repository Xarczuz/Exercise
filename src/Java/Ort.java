package Java;

/**
 * The Class Ort.
 */
public class Ort {
	
	/** The systembolag. */
	private String ort, stad, hotell, landskap, systembolag;
	
	/** The population. */
	private long population;

	/**
	 * Instantiates a new ort.
	 *
	 * @param ort         the ort
	 * @param stad        the stad
	 * @param hotell      the hotell
	 * @param landskap    the landskap
	 * @param systembolag the systembolag
	 * @param population the population
	 */
	public Ort(String ort, String stad, String hotell, String landskap, String systembolag,long population) {

		this.ort = ort;
		this.stad = stad;
		this.setHotell(hotell);
		this.landskap = landskap;
		this.systembolag = systembolag;
		this.setPopulation(population);
	}

	/**
	 * Gets the hotell.
	 *
	 * @return the hotell
	 */
	public String getHotell() {
		return hotell;
	}

	/**
	 * Sets the hotell.
	 *
	 * @param hotell the new hotell
	 */
	public void setHotell(String hotell) {
		this.hotell = hotell;
	}

	/**
	 * Gets the ort.
	 *
	 * @return the ort
	 */
	public String getOrt() {
		return ort;
	}

	/**
	 * Sets the ort.
	 *
	 * @param ort the ort to set
	 */
	public void setOrt(String ort) {
		this.ort = ort;
	}

	/**
	 * Gets the stad.
	 *
	 * @return the stad
	 */
	public String getStad() {
		return stad;
	}

	/**
	 * Sets the stad.
	 *
	 * @param stad the stad to set
	 */
	public void setStad(String stad) {
		this.stad = stad;
	}

	/**
	 * Gets the landskap.
	 *
	 * @return the landskap
	 */
	public String getLandskap() {
		return landskap;
	}

	/**
	 * Sets the landskap.
	 *
	 * @param landskap the landskap to set
	 */
	public void setLandskap(String landskap) {
		this.landskap = landskap;
	}

	/**
	 * Gets the systembolag.
	 *
	 * @return the systembolag
	 */
	public String getSystembolag() {
		return systembolag;
	}

	/**
	 * Sets the systembolag.
	 *
	 * @param systembolag the systembolag to set
	 */
	public void setSystembolag(String systembolag) {
		this.systembolag = systembolag;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ort: " + ort + ", stad: " + stad + ", hotell: " + hotell + ", landskap: " + landskap + ", systembolag: "
				+ systembolag + ", population: " + population;
	}

	/**
	 * Gets the population.
	 *
	 * @return the population
	 */
	public long getPopulation() {
		return population;
	}

	/**
	 * Sets the population.
	 *
	 * @param population the new population
	 */
	public void setPopulation(long population) {
		this.population = population;
	}
	public void printF() {
		System.out.printf("Ort: %-15s Stad: %-15s Hotell: %-15s Landskap: %-15s Systembolag: %-15s Invånare: %-15s\n",ort,stad,hotell,landskap,systembolag,population);
	}

	
}
