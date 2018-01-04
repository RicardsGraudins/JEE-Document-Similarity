package ie.gmit.sw;
/* Document is a simple object class that stores the ID of the document we're storing and
 * a string containing the document text.
 */
public class Document {
	private String docId;
	private String document;
	
	public Document(String docId, String document){
		this.docId = docId;
		this.document = document;
	}//Document

	public String getDocId() {
		return docId;
	}//getDocId

	public void setDocId(String docId) {
		this.docId = docId;
	}//setDocId

	public String getDocument() {
		return document;
	}//getDocument

	public void setDocument(String document) {
		this.document = document;
	}//setDocument

	@Override
	public String toString() {
		return "Document [docId: " + docId + ", document content: " + document + "]";
	}//toString
}//Document