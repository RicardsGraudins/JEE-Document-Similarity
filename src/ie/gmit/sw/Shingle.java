package ie.gmit.sw;
/**
 * Shingle is a simple object class that stores the int ID of the Shingle we're storing and
 * the int hashCode.
 */
public class Shingle {
	
	/** Id of the Shingle */
	private int docId;
	
	/** The hash code. */
	private int hashCode;
	
	/**
	 * Shingle Constructor.
	 * Instantiates a new shingle.
	 *
	 * @param docId = docId.
	 * @param hashCode = hashCode.
	 */
	public Shingle(int docId, int hashCode){
		this.docId = docId;
		this.hashCode = hashCode;
	}//Shingle

	/**
	 * Get the docId.
	 *
	 * @return the docId.
	 */
	public int getDocId() {
		return docId;
	}//getDocId

	/**
	 * Set the docId.
	 *
	 * @param docId the new docId.
	 */
	public void setDocId(int docId) {
		this.docId = docId;
	}//setDocId

	/**
	 * Get the hashCode.
	 *
	 * @return the hashCode.
	 */
	public int getHashCode() {
		return hashCode;
	}//getHashCode

	/**
	 * Set the hashCode.
	 *
	 * @param hashCode the new hashCode.
	 */
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}//setHashCode

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Shingle [docId=" + docId + ", hashCode=" + hashCode + "]";
	}//toString
}//Shingle