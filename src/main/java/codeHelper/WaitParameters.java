package codeHelper;

public class WaitParameters {
	private String xpath;
	private int time;

	public void setTime(int time) {
		this.time = time;
	}

	public void setXpath(String xpath) {
		this.xpath = xpath;
	}

	public int getTime() {
		return this.time;
	}

	public String getXpath() {
		return this.xpath;
	}
}
