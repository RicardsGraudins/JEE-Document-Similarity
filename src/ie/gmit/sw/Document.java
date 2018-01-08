package ie.gmit.sw;
/**
 * Document is a simple object class that stores the string ID of the document we're storing and
 * a string containing the document text.
 */
public class Document {
	
	/** Id of the document - title. */
	private String docId;
	
	/** Text string - text from the text document.  */
	private String document;
	
	/**
	 * Document Constructor.
	 * Instantiates a new document.
	 *
	 * @param docId = docId.
	 * @param document = document.
	 */
	public Document(String docId, String document){
		this.docId = docId;
		this.document = document;
	}//Document

	/**
	 * Get the docId.
	 *
	 * @return the docId.
	 */
	public String getDocId() {
		return docId;
	}//getDocId

	/**
	 * Set the docId.
	 *
	 * @param docId the new docId.
	 */
	public void setDocId(String docId) {
		this.docId = docId;
	}//setDocId

	/**
	 * Get the document.
	 *
	 * @return the document.
	 */
	public String getDocument() {
		return document;
	}//getDocument

	/**
	 * Set the document.
	 *
	 * @param document the new document.
	 */
	public void setDocument(String document) {
		this.document = document;
	}//setDocument

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Document [docId: " + docId + ", document content: " + document + "]";
	}//toString
}//Document