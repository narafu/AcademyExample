package opgg.entity;

public class RankingList {

	private String item;
	private int sales;
	private String grade;
	private String mfg;
	private String code;
	private int rank;

	public RankingList() {
		// TODO Auto-generated constructor stub
	}

	public RankingList(String item, int sales, String grade, String mfg, String code, int rank) {
		super();
		this.item = item;
		this.sales = sales;
		this.grade = grade;
		this.mfg = mfg;
		this.code = code;
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMfg() {
		return mfg;
	}

	public void setMfg(String mfg) {
		this.mfg = mfg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "RankingList [item=" + item + ", sales=" + sales + ", grade=" + grade + ", mfg=" + mfg + ", code=" + code
				+ ", rank=" + rank + "]";
	}

}
