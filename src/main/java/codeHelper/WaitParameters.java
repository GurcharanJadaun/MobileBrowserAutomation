package codeHelper;

public class WaitParameters {
	private String xpath;
	private int time;
	private boolean log;
	public WaitParameters(){
		log=true;
	}
	public void setTime(int time) {
		this.time = time;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}
	public void setLog(boolean log) {
		this.log = log;
	}

	public boolean getLog() {
		return this.log;
	}
	public int getTime() {
		return this.time;
	}

	public String getXpath() {
		return this.xpath;
	}
}
