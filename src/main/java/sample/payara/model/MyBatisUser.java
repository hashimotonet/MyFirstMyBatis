/**
 *
 */
package sample.payara.model;

/**
 * @author hashi
 *
 */
public class MyBatisUser {

	private int id;

	private String name;

	/**
	 * @return id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public final void setId(int id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public final void setName(String name) {
		this.name = name;
	}
}
