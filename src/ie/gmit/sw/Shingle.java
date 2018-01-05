package ie.gmit.sw;

public class Shingle {
	private int docId;
	private int hashCode;
	
	public Shingle(int docId, int hashCode){
		this.docId = docId;
		this.hashCode = hashCode;
	}//Shingle

	public int getDocId() {
		return docId;
	}//getDocId

	public void setDocId(int docId) {
		this.docId = docId;
	}//setDocId

	public int getHashCode() {
		return hashCode;
	}//getHashCode

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}//setHashCode

	@Override
	public String toString() {
		return "Shingle [docId=" + docId + ", hashCode=" + hashCode + "]";
	}//toString
}//Shingle