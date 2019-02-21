package Java;

/**
 * The Class Car.
 */
public class Cars {

	private String carName, model;
	private int year;


	/**
	 * Instantiates a new Car.
	 *
	 * @param carName the carName
	 * @param modell  the model
	 * @param year    the year
	 */
	public Cars(String carName, String model, int year) {
		this.carName = carName;
		this.model = model;
		this.year = year;
	}


	/**
	 * Gets the carName.
	 *
	 * @return carName
	 */
	public String getcarName() {
		return carName;
	}

	/**
	 * Sets the carName.
	 *
	 * @param carName the new carName
	 */
	public void setcarName(String carName) {
		this.carName = carName;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets the year.
	 *
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Sets the year.
	 *
	 * @param year the new year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Bilar [carName=" + carName + ", model=" + model + ", year=" + year + "]";
	}

}
